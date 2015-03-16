package org.guili.ecshop.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.guili.ecshop.bean.common.ScopeConstants;
import org.guili.ecshop.business.impl.member.UserDetailImpl;
import org.guili.ecshop.business.member.Member;
import org.guili.ecshop.business.member.UserDetails;
import org.guili.ecshop.business.member.UserDetailsAware;
import org.guili.ecshop.util.common.CookieUtil;
import org.guili.ecshop.util.common.Validator;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 访问任意页面加载用户登录信息Interceptor
 * @author jumbo
 */
public class UserDetailsInterceptor extends HandlerInterceptorAdapter implements
		ServletContextAware {

	private ServletContext		servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext;
	}
	
	/**
	 * 覆盖默认方法，在访问任何页面的时候加载用户登录信息等。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		    throws Exception {
			// session 里面设置游客 信息
			HttpSession session = request.getSession();
			UserDetails userDetails = (UserDetails) session.getAttribute(ScopeConstants.USER_CONTEXT);
			// 设置cookie 登录名
			setCookieLoginName(request, response);
			// session 里面如果没有登陆信息就设置游客
			userDetails = validateGuestAndSetSession(request, response ,session, userDetails);
			
			// 将 userDetails 注入到 相应的 handler
			//回显登陆名
			setHandlerUserDetails(handler, userDetails);
			String username=userDetails.getMember().getEmail();
			request.setAttribute("username", username);
			this.setMainMenu(request, response, session);
			return true;
	}
	
	/**
	 * session 里面设置游客 信息<br>
	 * 取出cookie中的购物车信息，并加载到session中
	 * @param request
	 * @param session
	 * @param userDetails
	 */
	private UserDetails validateGuestAndSetSession(HttpServletRequest request,HttpServletResponse response,HttpSession session,UserDetails userDetails){
		boolean isFirst = (null == userDetails || userDetails.getMember() == null);
		if (isFirst){
            // set new UserDetailImpl
			userDetails = new UserDetailImpl();
			Member member=new Member();
			member.setEmail("guest");
			userDetails.setMember(member);
			session.setAttribute(ScopeConstants.USER_CONTEXT, userDetails);
		}
		return userDetails;
	}
	
	/**
	 * session 里面设置游客 信息<br>
	 * 取出cookie中的购物车信息，并加载到session中
	 * @param request
	 * @param session
	 * @param userDetails
	 */
	private void  setMainMenu(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String url=request.getServletPath();
		//设置列表页的情况
		String listMenu="/index.htm,/lc.htm,/detail.htm";
		if(listMenu.contains(url)){
			request.setAttribute("menu", "list");
		}
		System.out.println("url:"+url);
		String tongjiMenu="/createtongji.htm,/tongjidetail.htm,/tongji.htm";
		if(tongjiMenu.contains(url) && !url.equals("/")){
			request.setAttribute("menu", "tongji");
		}
		String userMenu="/member/userinfo.htm,/member/login.htm,/member/register.htm,/member/toRegister.htm,/member/toLogin.htm";
		if(userMenu.contains(url) && !url.equals("/")){
			request.setAttribute("menu", "user");
		}
	}
	
	/**
	 * 设置游客 loginname 登录名
	 * 
	 * @param request
	 * @param response
	 */
	private void setCookieLoginName(HttpServletRequest request,HttpServletResponse response){
		String loginName = CookieUtil.getCookieValue(ScopeConstants.COOKIE_USER_CONTEXT, request);
		if (Validator.isNullOrEmpty(loginName)){
			CookieUtil.setCookieValue(ScopeConstants.COOKIE_USER_CONTEXT, loginName, response,CookieUtil.SECONDS_PER_WEEK);
		}
	}
	
	/**
	 * 将 userDetails 注入到 相应的 handler
	 * @param handler
	 * @param userDetails
	 */
	private void setHandlerUserDetails(Object handler,UserDetails userDetails){
		if (handler instanceof UserDetailsAware){
			UserDetailsAware userDetailsAware = (UserDetailsAware) handler;
			userDetailsAware.setUserDetails(userDetails);
		}
	}

}
