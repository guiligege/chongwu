package org.guili.ecshop.controller.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.bean.spider.LcProduct;
import org.guili.ecshop.bean.spider.LcProductYinHang;
import org.guili.ecshop.bean.spider.yinhang.Graph;
import org.guili.ecshop.bean.spider.yinhang.LcPageParam;
import org.guili.ecshop.bean.spider.yinhang.OrderConstants;
import org.guili.ecshop.bean.spider.yinhang.PingGu;
import org.guili.ecshop.bean.spider.yinhang.SearchConstants;
import org.guili.ecshop.bean.spider.yinhang.SeoConstants;
import org.guili.ecshop.business.product.ILcProductLogService;
import org.guili.ecshop.business.product.IPetDetailService;
import org.guili.ecshop.business.product.IProductService;
import org.guili.ecshop.controller.common.BaseProfileController;
import org.guili.ecshop.util.common.UrlHelper;
import org.guili.ecshop.util.common.page.Pager;
import org.guili.ecshop.util.common.page.PagerHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 产品控制controller
 * @author guili
 *
 */
@Controller
public class licaiController extends BaseProfileController{
	@Resource(name="productService")
	private IProductService productService;
	@Resource(name="lcProductLogService")
	private ILcProductLogService lcProductLogService;
	@Resource(name="petDetailService")
	private IPetDetailService petDetailService;
	//58抓取类
	@Resource(name="wubaPetSpider")
	private IProductService wubaPetSpider;
	private static final int pagesize=15;
	private static final int companyPageSize=10;
	
	//测试银行抓取
	@RequestMapping(value={ "/petadd.htm"},method={RequestMethod. GET})
	public void testyinhang(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
		String url="http://sh.58.com/dog/pn2/";
//		spiderService.getPageXMLByUrl(url, 30000);
		wubaPetSpider.batCrawlPet(url);
//		PetSaleInfo petSaleInfo=new PetSaleInfo();
//		petSaleInfo.setAdress("aa");
//		petSaleInfo.setAdressId(1L);
//		petSaleInfo.setAge("test");
//		petSaleInfo.setCategory("aa");
//		petSaleInfo.setCategoryId(1L);
//		petSaleInfo.setCity("bb");
//		petSaleInfo.setCreateTime(new Date());
//		petSaleInfo.setDescrip("est");
//		petSaleInfo.setImageDetail1("aa");
//		petSaleInfo.setImageDetail2("bb");
//		petSaleInfo.setImageDetail3("cc");
//		petSaleInfo.setImageDetail4("dd");
//		petSaleInfo.setNickName("test");
//		petSaleInfo.setPrice(1000);
//		petSaleInfo.setQq("tet");
//		petSaleInfo.setSex("dfd");
//		petSaleInfo.setTelephone("1231");
//		petSaleInfo.setTitle("abc");
//		petSaleInfo.setTitlehash(new Long("abc".hashCode()));
//		petSaleInfo.setYimiao("aa");
//		petDetailService.addPetSaleInfo(petSaleInfo);
		return ;
	}			
	/**
	 * 理财产品首页
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/index.htm", "/" })
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam(value = "yinhang", required = false) String yinhang,
			@RequestParam(value = "income", required = false) String income,
			@RequestParam(value = "saleType", required = false) String saleType,
			@RequestParam(value = "days", required = false) String days,
			@RequestParam(value = "orderType", required = false) String orderType,
			@RequestParam(value = "pageNum", required = false) String pageNum
			) throws Exception{
		saleType="0";
		orderType="1";
		List<LcProduct> goodProductList=new ArrayList<LcProduct>();
		LcPageParam pageParam=new LcPageParam();
		//用于回显的url部分
		String urlParam=this.setParams(yinhang, income, saleType, days,orderType, pageParam);
		int totalRow=lcProductLogService.selectProductCount(pageParam);  
		Pager pager=null;
		String basePath=UrlHelper.getRealPath(request); 			  //基础绝对路径
		if(StringUtils.isNotEmpty(pageNum)){
			pager = PagerHelper.getPager(pageNum, totalRow,pagesize); //初始化分页对象  
		}else{
			pager = PagerHelper.getPager("1", totalRow,pagesize); 	  //初始化分页对象  
		}
		pager.setLinkUrl(basePath+request.getRequestURI()); 		  //设置跳转路径  
		request.setAttribute("pager", pager); 						  //将分页信息保存在Request对象  
		////获得请求的url参数
		//UrlHelper.getAllParamsAndValuesToString(request);
		////获得请求的url参数,去除某个参数
		//UrlHelper.getAllParamsAndValuesEscapekey(request,"test");
		//分页参数
		request.setAttribute("urlParam", urlParam);
		goodProductList=lcProductLogService.selectProductPage(pager.getStartRow(), pager.getPageSize(), pageParam);
		//pageParam.setYinhang(yinhang);
		
		List<LcProduct> newLcProductList=lcProductLogService.selectLcProductByOnSale(licaiController.companyPageSize);
		
		List<LcProductYinHang> lcProductYinHangList=lcProductLogService.selectLcProductYinHang();
		
		if(pageParam.getYinhang()==null ||pageParam.getYinhang().isEmpty()){
			request.setAttribute("seoYinhang", pageParam.getYinhang());
			request.setAttribute("from", SeoConstants.FROMHOME);
		}else{
			request.setAttribute("seoYinhang", pageParam.getYinhang());
			request.setAttribute("from", SeoConstants.FROMLIST);
		}
		pageParam.setYinhang(yinhang);
		//商品列表信息回显
		request.setAttribute("bList", goodProductList);
		request.setAttribute("lcProductYinHangList", lcProductYinHangList);
		request.setAttribute("newLcProductList", newLcProductList);
		request.setAttribute("pageParam", pageParam);
		return "licai_product_list";
	}
	
	/**
	 * 设置参数和设置回显数据
	 * @param shortStore	//商家短链接
	 * @param activityId	//活动id
	 * @param zhekou		//折扣
	 * @param categoryId	//类别id
	 * @param pageNum		//当前页码
	 */
	//setParams(yinhang, income, saleType, days,orderType, pageParam)
	private String setParams(String yinhang,String income,String saleType,String days,String orderType,LcPageParam pageParam){
		StringBuffer urlParam=new StringBuffer();
		urlParam.append("lc-");
		if(StringUtils.isNotEmpty(yinhang)){
//			pageParam.setYinhang(yinhang);
			if(yinhang!=null && !yinhang.isEmpty()){
				try {
					LcProductYinHang lcProductYinHang=lcProductLogService.selectLcProductYinHangById(Long.parseLong(yinhang));
					pageParam.setYinhang(lcProductYinHang.getName()+"");
				}  catch (Exception e) {
					e.printStackTrace();
				}
			}
			urlParam.append(yinhang+"-");
		}else{
			urlParam.append("-");
		}
		if(StringUtils.isNotEmpty(income)){
			pageParam.setIncome(Double.parseDouble(income));
			//0-3%
			if(pageParam.getIncome()>SearchConstants.INCOMEONE && pageParam.getIncome()<SearchConstants.INCOMETWO){
				pageParam.setIncomeMin(SearchConstants.INCOMEONE);
				pageParam.setIncomeMax(SearchConstants.INCOMETWO);
			}
			//3-6%
			if(pageParam.getIncome()>SearchConstants.INCOMETWO && pageParam.getIncome()<SearchConstants.INCOMETHREE){
				pageParam.setIncomeMin(SearchConstants.INCOMETWO);
				pageParam.setIncomeMax(SearchConstants.INCOMETHREE);
			}
			//6-8%
			if(pageParam.getIncome()>SearchConstants.INCOMETHREE && pageParam.getIncome()<SearchConstants.INCOMEFOUR){
				pageParam.setIncomeMin(SearchConstants.INCOMETHREE);
				pageParam.setIncomeMax(SearchConstants.INCOMEFOUR);
			}
			//大于8%
			if(pageParam.getIncome()>SearchConstants.INCOMEFOUR){
				pageParam.setIncomeMin(SearchConstants.INCOMEFOUR);
				pageParam.setIncomeMax(20.0);
			}
			urlParam.append(income+"-");
		}else{
			urlParam.append("-");
		}
		if(StringUtils.isNotEmpty(saleType)){
			urlParam.append(saleType+"-");
			//设置回显数据
			if(saleType.equals(LcPageParam.SALETYPESALE)){
				pageParam.setSaleType("在售");
				pageParam.setSaleTypeId(LcPageParam.SALETYPESALE);
			} else 
			if(saleType.equals(LcPageParam.SALETYPEPRESALE)){
				pageParam.setSaleType("待售");
				pageParam.setSaleTypeId(LcPageParam.SALETYPEPRESALE);
			}else 
			if(saleType.equals(LcPageParam.SALETYPEUNSALE)){
				pageParam.setSaleType("已售完");
				pageParam.setSaleTypeId(LcPageParam.SALETYPEUNSALE);
			}
		}else{
			urlParam.append("-");
		}
		if(StringUtils.isNotEmpty(days)){
			pageParam.setDays(Integer.parseInt(days));
			//设置时间段查询
			//3个月以下
			if(pageParam.getDays()==SearchConstants.DAYSONE){
				pageParam.setDaysMin(0);
				pageParam.setDaysMax(SearchConstants.DAYSONE);
			}
			//3个月-6个月
			if(pageParam.getDays()>SearchConstants.DAYSONE && pageParam.getDays()<SearchConstants.DAYSTWO){
				pageParam.setDaysMin(SearchConstants.DAYSONE);
				pageParam.setDaysMax(SearchConstants.DAYSTWO);
			}
			//6-9
			if(pageParam.getDays()>SearchConstants.DAYSTWO && pageParam.getDays()<SearchConstants.DAYSTHREE){
				pageParam.setDaysMin(SearchConstants.DAYSTWO);
				pageParam.setDaysMax(SearchConstants.DAYSTHREE);
			}
			//9-12
			if(pageParam.getDays()>SearchConstants.DAYSTHREE && pageParam.getDays()<SearchConstants.DAYSFOUR){
				pageParam.setDaysMin(SearchConstants.DAYSTHREE);
				pageParam.setDaysMax(SearchConstants.DAYSFOUR);
			}
			//12以上
			if(pageParam.getDays()==SearchConstants.DAYSFIVE){
				pageParam.setDaysMin(SearchConstants.DAYSFIVE);
				pageParam.setDaysMax(3000);
			}
			urlParam.append(days+"-");
		}else{
			urlParam.append("-");
		}
		if(StringUtils.isNotEmpty(orderType)){
			pageParam.setOrderType(orderType);
			urlParam.append(orderType+"-");
		}else{
			//设置默认排序
			pageParam.setOrderType(OrderConstants.INCOME);
			urlParam.append("-");
		}
		/*//转换页面传递参数
		if(StringUtils.isNotEmpty(storeId)){
			pageParam.setStoreId(Long.parseLong(storeId));
			urlParam.append(storeId+"-");
		}else{
			urlParam.append("-");
		}
        if(StringUtils.isNotEmpty(activityId)){
        	pageParam.setActivityId(Long.parseLong(activityId));
        	urlParam.append(activityId+"-");
        }else{
			urlParam.append("-");
		}
        if(StringUtils.isNotEmpty(zhekou)){
        	//防止折扣注入小数
        	Double zhekoudou=Double.parseDouble(zhekou);
        	pageParam.setZhekou(new Double(zhekoudou.intValue()));
        	pageParam.setMaxzhekou(pageParam.getZhekou());
        	//防止折扣最小值小于0
        	if(zhekoudou.intValue()==0){
        		pageParam.setMinzhekou(new Double(zhekoudou.intValue()));
        	}else{
        		pageParam.setMinzhekou(new Double(zhekoudou.intValue()-1));
        	}
        	urlParam.append(zhekou+"-");
        }else{
			urlParam.append("-");
		}
        if(StringUtils.isNotEmpty(categoryId)){
        	pageParam.setCategoryId(Long.parseLong(categoryId));
        	urlParam.append(categoryId+"-");
        }else{
			urlParam.append("-");
		}*/
        
        return urlParam.toString();
	}
	
	/**
	 * 理财产品首页
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={"/lc.htm"},method={RequestMethod. GET})
	public String licai(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
					@RequestParam(value = "yinhang", required = false) String yinhang,
					@RequestParam(value = "income", required = false) String income,
					@RequestParam(value = "saleType", required = false) String saleType,
					@RequestParam(value = "days", required = false) String days,
					@RequestParam(value = "orderType", required = false) String orderType,
					@RequestParam(value = "pageNum", required = false) String pageNum
					) throws Exception{
		
		List<LcProduct> goodProductList=new ArrayList<LcProduct>();
		LcPageParam pageParam=new LcPageParam();
		//用于回显的url部分
		String urlParam=this.setParams(yinhang, income, saleType, days,orderType, pageParam);
        int totalRow=lcProductLogService.selectProductCount(pageParam);  
        Pager pager=null;
        String basePath=UrlHelper.getRealPath(request); 			  //基础绝对路径
        if(StringUtils.isNotEmpty(pageNum)){
        	pager = PagerHelper.getPager(pageNum, totalRow,pagesize); //初始化分页对象  
        }else{
        	pager = PagerHelper.getPager("1", totalRow,pagesize); 	  //初始化分页对象  
        }
        pager.setLinkUrl(basePath+request.getRequestURI()); 		  //设置跳转路径  
        request.setAttribute("pager", pager); 						  //将分页信息保存在Request对象  
//        //获得请求的url参数
//        UrlHelper.getAllParamsAndValuesToString(request);
//        //获得请求的url参数,去除某个参数
//        UrlHelper.getAllParamsAndValuesEscapekey(request,"test");
        //分页参数
        request.setAttribute("urlParam", urlParam);
        goodProductList=lcProductLogService.selectProductPage(pager.getStartRow(), pager.getPageSize(), pageParam);
//        pageParam.setYinhang(yinhang);
        
        List<LcProduct> newLcProductList=lcProductLogService.selectLcProductByOnSale(licaiController.companyPageSize);
        
        List<LcProductYinHang> lcProductYinHangList=lcProductLogService.selectLcProductYinHang();
        
        if(pageParam.getYinhang()==null ||pageParam.getYinhang().isEmpty()){
        	request.setAttribute("seoYinhang", pageParam.getYinhang());
        	request.setAttribute("from", SeoConstants.FROMHOME);
        }else{
        	request.setAttribute("seoYinhang", pageParam.getYinhang());
        	request.setAttribute("from", SeoConstants.FROMLIST);
        }
        pageParam.setYinhang(yinhang);
        //商品列表信息回显
        request.setAttribute("bList", goodProductList);
        request.setAttribute("lcProductYinHangList", lcProductYinHangList);
        request.setAttribute("newLcProductList", newLcProductList);
        request.setAttribute("pageParam", pageParam);
		return "licai_product_list";
	}
	
	/**
	 * 理财产品首页
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={"/detail.htm"},method={RequestMethod. GET})
	public String detail(HttpServletRequest request,HttpServletResponse response,
					ModelMap modelMap,@RequestParam(value = "lcid", required = false) String lcid 
					) throws Exception{
		//该理财产品
		LcProduct lcProduct=lcProductLogService.selectLcProductById(lcid);
		//同一银行其他理财产品
		List<LcProduct> lcProductList=lcProductLogService.selectLcProductByCompanyName(lcProduct.getCompanyName(), licaiController.companyPageSize);
		//最新的理财产品
		List<LcProduct> newLcProductList=lcProductLogService.selectLcProductByOnSale(licaiController.companyPageSize);
		//去除同一商品
		if(lcProductList!=null && !lcProductList.isEmpty() && lcProductList.contains(lcProduct)){
			lcProductList.remove(lcProduct);
		}
		PingGu pingGu=new PingGu(lcProduct.getIncome(), lcProduct.getDays(), lcProduct.getIncomeType(), lcProduct.getFengxian());
		//风险评估
		request.setAttribute("pingGu", pingGu);
		request.setAttribute("lcProduct", lcProduct);
		request.setAttribute("lcProductList", lcProductList);
		request.setAttribute("newLcProductList", newLcProductList);
		request.setAttribute("from", SeoConstants.FROMDETAIL);
		return "licai_product_detail";
	}
	
	
	/**
	 * 商品评论分析
	 * @param request
	 * @param modelMap
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/graph.htm",method={RequestMethod. GET})
	public void  graph(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,@RequestParam(value = "lcid", required = false) String lcid) throws Exception{
		LcProduct lcProduct=lcProductLogService.selectLcProductById(lcid);
		List<Graph> graphList=lcProductLogService.selectLcProductByTime(lcProduct.getCompanyName(),lcProduct.getDays()+"", licaiController.companyPageSize*3+"");
		modelMap.put("graphList", graphList);
		if(graphList!=null && graphList.size()>0){
			JSONObject jsonobj=JSONObject.fromObject(modelMap);
//			JSONArray jsonobj=JSONArray.fromObject(graphList);
			response.getWriter().write(jsonobj.toString());
		}else{
			response.getWriter().write(new JSONObject().toString());
		}
		return;
	}
	
}
