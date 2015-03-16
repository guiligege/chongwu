package org.guili.ecshop.controller.member;

import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.common.ScopeConstants;
import org.guili.ecshop.business.member.ILcMemberService;
import org.guili.ecshop.business.member.Member;
import org.guili.ecshop.business.product.ILcProductLogService;
import org.guili.ecshop.controller.common.BaseProfileController;
import org.guili.ecshop.util.common.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户登录注册Controller
 * @ClassName:   MemberLoginController 
 * @author:      guilige 
 * @date         2014-08-03
 */
@Controller
public class MemberLoginController extends BaseProfileController{
	private Logger logger=Logger.getLogger(MemberLoginController.class);
	@Resource(name="lcMemberService")
	private ILcMemberService lcMemberService;
	@Resource(name="lcProductLogService")
	private ILcProductLogService lcProductLogService;
	
	/**
	 * 跳转到登录页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/toLogin.htm")
	public String toLogin(HttpServletRequest request,HttpServletResponse response){
		return "member/licai_login";
	}

	/**
	 * 跳转到注册页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/toRegister.htm")
	public String toRegister(HttpServletRequest request,HttpServletResponse response){
		return "member/licai_register";
	}
	
	@RequestMapping(value={ "/member/register.htm"},method={RequestMethod.GET})
	public String registerGet(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "nickName", required = false) String nickName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "passwordAgain", required = false) String passwordAgain,
			@RequestParam(value = "validateNum", required = false) String validateNum
			)throws Exception{
		return "member/licai_register";
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @return
	 */
//	@RequestMapping(value = "/member/register.htm")
	@RequestMapping(value={ "/member/register.htm"},method={RequestMethod.POST})
	public String register(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "nickName", required = false) String nickName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "passwordAgain", required = false) String passwordAgain,
			@RequestParam(value = "validateNum", required = false) String validateNum
			)throws Exception{
		String retrunStr="member/licai_register";
		//验证
		if(!validate(email,password,passwordAgain,validateNum)){
			request.setAttribute("validateresult", "error");
			return retrunStr;
		}
		//构造用户对象
		Member member=new Member();
		member.setEmail(email);
		member.setNickName(nickName);
		member.setPassword(password);
		member.setCreateTime(new Date());
		//保存用户信息
		int i=lcMemberService.saveLcMember(member);
		//设置回显信息
		String username=email;
		if(nickName!=null && nickName.isEmpty()){
			username=nickName;
		}
		//设置session和cookie
		CookieUtil.setCookieValue(ScopeConstants.COOKIE_USER_CONTEXT, username, response,CookieUtil.SECONDS_PER_WEEK);
		HttpSession session=request.getSession();
//		session.setAttribute(ScopeConstants.USER_CONTEXT, username);
		//设置session的数据
		this.getUserDetails().setMember(member);
		return "redirect:/index.htm";
	}
	
	/**
	 * 用户登陆
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param email
	 * @param password
	 * @param validateNum
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/member/login.htm"},method={RequestMethod.POST})
	public String login(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "validateNum", required = false) String validateNum
			)throws Exception{
		String retrunStr="member/licai_login";
		//验证
		if(!validateLogin(email,password,validateNum)){
			request.setAttribute("validateresult", "error");
			return retrunStr;
		}
		//验证邮箱是否存在
		Member member=lcMemberService.selectLcMemberByEmailAndPw(email, password);
		if(member==null){
			request.setAttribute("validateresult", "error");
			return retrunStr;
		}
		//设置回显信息
		String username=email;
		if(member.getNickName()!=null && member.getNickName().isEmpty()){
			username=member.getNickName();
		}
		//设置session和cookie
		CookieUtil.setCookieValue(ScopeConstants.COOKIE_USER_CONTEXT, username, response,CookieUtil.SECONDS_PER_WEEK);
		this.getUserDetails().setMember(member);
		return "redirect:/index.htm";
	}
	
	/**
	 * 用户登陆
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param email
	 * @param password
	 * @param validateNum
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/member/update.htm"},method={RequestMethod.POST})
	public String update(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam(value = "oldpassword", required = false) String oldpassword,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "passwordAgain", required = false) String passwordAgain
			)throws Exception{
		String retrunStr="member/licai_update";
		//验证邮箱是否存在
		Member member=this.getUserDetails().getMember();
		if(member==null || !member.getPassword().equals(oldpassword) || !password.equals(passwordAgain)){
			request.setAttribute("validateresult", "error");
			return retrunStr;
		}
		//更新密码
		
		//设置回显信息
		String username=member.getEmail();
		if(member.getNickName()!=null && member.getNickName().isEmpty()){
			username=member.getNickName();
		}
		//设置session和cookie
		CookieUtil.setCookieValue(ScopeConstants.COOKIE_USER_CONTEXT, username, response,CookieUtil.SECONDS_PER_WEEK);
		this.getUserDetails().setMember(member);
		return "redirect:/index.htm";
	}
	
	@RequestMapping(value={ "/member/update.htm"},method={RequestMethod.GET})
	public String updateGet(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam(value = "oldpassword", required = false) String oldpassword,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "passwordAgain", required = false) String passwordAgain
			)throws Exception{
		return "member/licai_update";
	}
	@RequestMapping(value={ "/member/login.htm"},method={RequestMethod.GET})
	public String loginGet(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "nickName", required = false) String nickName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "passwordAgain", required = false) String passwordAgain,
			@RequestParam(value = "validateNum", required = false) String validateNum
			)throws Exception{
		return "member/licai_login";
	}
	
	@RequestMapping(value={ "/member/loginout.htm"},method={RequestMethod.GET})
	public String loginout(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String retrunStr="member/licai_register";
		//设置session和cookie
		CookieUtil.clearCookieValue(ScopeConstants.COOKIE_USER_CONTEXT, response);
		HttpSession session=request.getSession();
		session.removeAttribute(ScopeConstants.USER_CONTEXT);
		return "redirect:/index.htm";
	}
	/**
	 * 验证数据是否正常
	 * @param email
	 * @param password
	 * @param passwordAgain
	 * @param validateNum
	 * @return
	 */
	private boolean validate(String email,String password,String passwordAgain,String validateNum)throws Exception{
		//非空验证
		if(email==null ||email.isEmpty() 
				|| password==null || password.isEmpty()
				|| passwordAgain==null || passwordAgain.isEmpty()
				|| validateNum==null || validateNum.isEmpty()){
			return false;
		}
		//验证邮箱是否已使用
		Member member=lcMemberService.selectLcMemberByEmail(email);
		if(member!=null){
			return false;
		}
		return true;
	}
	
	/**
	 * 登陆验证
	 * @param email
	 * @param password
	 * @param validateNum
	 * @return
	 * @throws Exception
	 */
	private boolean validateLogin(String email,String password,String validateNum)throws Exception{
		//非空验证
		if(email==null ||email.isEmpty() 
				|| password==null || password.isEmpty()
				|| validateNum==null || validateNum.isEmpty()){
			return false;
		}
		return true;
	}
	/**
	 * 验证邮件是否存在
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param email
	 * @throws Exception
	 */
	@RequestMapping(value="/member/validateEmail.htm",method={RequestMethod. GET})
	public void  validateEmail(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam(value = "email", required = false) String email) throws Exception{
		if(email==null || email.isEmpty()){
			response.getWriter().write(new JSONObject().toString());
		}
		//获取具体实现类
		Member member=lcMemberService.selectLcMemberByEmail(email);
		if(member!=null){
			modelMap.put("result", "false");
		}else{
			modelMap.put("result", "true");
		}
		//计算并获得商品评论信息
		if(modelMap!=null && modelMap.size()>0){
			JSONObject jsonobj=JSONObject.fromObject(modelMap);
			response.getWriter().write(jsonobj.toString());
		}else{
			response.getWriter().write(new JSONObject().toString());
		}
		//return ;
	}
	
	@RequestMapping(value={ "/member/userinfo.htm"},method={RequestMethod.GET})
	public String userinfo(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		//登录用户信息
		Member user= this.getUserDetails().getMember();
		request.setAttribute("user", user);
		//今日银行理财信息
//		String startTime=new SimpleDateFormat("yyyy-MM-dd").format(TimeUtils.AddDays(new Date(), -1));
//		List<LcProduct> onSaleTopList=lcProductTongjiService.findOnSaleOneDayTopNum(10);
//		request.setAttribute("onSaleTopList", onSaleTopList);
		return "member/licai_userinfo";
	}
	
}
