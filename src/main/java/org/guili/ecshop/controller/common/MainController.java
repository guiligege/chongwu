package org.guili.ecshop.controller.common;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.PageParam;
import org.guili.ecshop.business.product.IProductService;
import org.guili.ecshop.util.common.UrlHelper;
import org.guili.ecshop.util.common.page.Pager;
import org.guili.ecshop.util.common.page.PagerHelper;
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
public class MainController extends BaseProfileController {
	private Logger logger=Logger.getLogger(MainController.class);
	@Resource(name="productService")
	private IProductService productService;
	
	/**
	 * 首页跳转
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/redirect.htm"})
	public void redirect(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
		response.sendRedirect("http://detail.tmall.com/item.htm?spm=a1z10.5.w4011-2637950499.97.iRCubC&id=36043850502&rn=d9e00c3c53f71224502461ebe41761ca");
	}
	
	@RequestMapping(value = "/errors/404.htm")
	public String error404(HttpServletRequest request,HttpServletResponse response){
		return "error/404error";
	}
	@RequestMapping(value = "/errors/500.htm")
	public String error500(HttpServletRequest request,HttpServletResponse response){
		return "error/404error";
	}
	

}
