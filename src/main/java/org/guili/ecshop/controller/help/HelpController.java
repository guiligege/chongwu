package org.guili.ecshop.controller.help;

import javax.servlet.http.HttpServletRequest;

import org.guili.ecshop.controller.common.BaseProfileController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 首页跳转和首页需要信息的跳转
 * @ClassName:   MainController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2013-11-19 下午7:09:51 
 *
 */
@Controller
public class HelpController extends BaseProfileController{
	/**
	 * 联系方式
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/help/lianxi.htm"})
	public String lianxi(HttpServletRequest request,ModelMap modelMap) throws Exception{
		return "help/lianxi";
	}
	/**
	 * 联系方式
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/help/lc_aboutus.htm"})
	public String aboutus(HttpServletRequest request,ModelMap modelMap) throws Exception{
		return "help/lc_aboutus";
	}
	
	@RequestMapping(value={ "/help/lclianxi.htm"})
	public String lclianxi(HttpServletRequest request,ModelMap modelMap) throws Exception{
		return "help/lc_lianxi";
	}
	
	@RequestMapping(value={ "/help/youlian.htm"})
	public String lcyoulian(HttpServletRequest request,ModelMap modelMap) throws Exception{
		return "help/lc_youlian";
	}
	/**
	 * 联系方式
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/help/lcabout.htm"})
	public String lcabout(HttpServletRequest request,ModelMap modelMap) throws Exception{
		return "help/lc_about";
	}
	/**
	 * 维护页面
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/error/weihu.htm"})
	public String weihu(HttpServletRequest request,ModelMap modelMap) throws Exception{
		return "error/weihu";
	}
	
	/**
	 * 维护页面
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/help/weihu.htm"})
	public String lcweihu(HttpServletRequest request,ModelMap modelMap) throws Exception{
		return "error/lc_weihu";
	}
}
