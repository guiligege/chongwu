package org.guili.ecshop.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.guili.ecshop.bean.spider.LcProduct;
import org.guili.ecshop.bean.spider.LcProductYinHang;
import org.guili.ecshop.bean.spider.PageParam;
import org.guili.ecshop.bean.spider.yinhang.LcPageParam;
import org.guili.ecshop.business.product.ILcProductLogService;
import org.guili.ecshop.business.product.IProductService;
import org.guili.ecshop.util.common.UrlHelper;
import org.guili.ecshop.util.common.XmlUtils;
import org.guili.ecshop.util.common.page.Pager;
import org.guili.ecshop.util.common.page.PagerHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BatController {
	@Resource(name="productService")
	private IProductService productService;
	@Resource(name="lcProductLogService")
	private ILcProductLogService lcProductLogService;
	
	private static final int pagesize=10;
	private static final int sitemapsize=45000;
	private static final int lcpagesize=15;
	/**
	 * 设置参数和设置回显数据
	 * @param shortStore	//商家短链接
	 * @param activityId	//活动id
	 * @param zhekou		//折扣
	 * @param categoryId	//类别id
	 * @param pageNum		//当前页码
	 */
	private String setStoreParams(String activityId,String zhekou,String categoryId,PageParam pageParam){
		StringBuffer urlParam=new StringBuffer();
		//"s-"+shortStore+"-"+activityId+"-"+zhekou+"-"+categoryId+"-"
		urlParam.append("sps-");
        if(StringUtils.isNotEmpty(activityId)){
        	pageParam.setActivityId(Long.parseLong(activityId));
        	urlParam.append(activityId+"-");
        }else{
			urlParam.append("-");
		}
        if(StringUtils.isNotEmpty(zhekou)){
        	pageParam.setZhekou((Double.parseDouble(zhekou)));
        	urlParam.append(zhekou+"-");
        }else{
			urlParam.append("-");
		}
        if(StringUtils.isNotEmpty(categoryId)){
        	pageParam.setCategoryId(Long.parseLong(categoryId));
        	urlParam.append(categoryId+"-");
        }else{
			urlParam.append("-");
		}
        
        return urlParam.toString();
	}
	/**
	 * 创建sitemap
	 */
	@RequestMapping(value={ "/product/createSitemap.htm"},method={RequestMethod.GET})
	public String createSitemap(){
		Document document=XmlUtils.createSitemap();
	    Element urlsetElement = document.addElement("urlset");
        //商品sitemap
//	    storeSitemap(urlsetElement);
	    //商品sitemap
//	    productSiteMap(urlsetElement);
	    //写入文件
	    XmlUtils.generateXmlFile(document);
	    return "help/success";
	}
	
	//理财产品sitemap
	/**
     * 刷新sitemap
     */
    @RequestMapping(value = "/lcsitemap.htm")
    public String refreshLcSitemap() {
    	Document document=XmlUtils.createSitemap();
    	Element urlsetElement = document.addElement("urlset", "http://www.sitemaps.org/schemas/sitemap/0.9");
    	urlsetElement.addNamespace("xsi","http://www.w3.org/2001/XMLSchema-instance");
    	urlsetElement.addAttribute("xsi:schemaLocation","http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd");
        //类别和标签sitemap
	    storeLcSitemap(urlsetElement);
	    //商品sitemap
	    productLcSiteMap(urlsetElement);
	    //写入文件
	    XmlUtils.generateXmlFile(document);
        return "json";
    }
    
    //类别sitemap
    private void storeLcSitemap(Element urlsetElement){
    	//银行信息
    	try {
    		XmlUtils.addOneElement(urlsetElement, "http://www.licaime.com/", XmlUtils.CHANGEFREQ);
    		XmlUtils.addOneElement(urlsetElement, "http://www.licaime.com/index.htm", XmlUtils.CHANGEFREQ);
    		XmlUtils.addOneElement(urlsetElement, "http://www.licaime.com/help/lclianxi.htm", XmlUtils.CHANGEFREQ);
    		XmlUtils.addOneElement(urlsetElement, "http://www.licaime.com/help/aboutus.htm", XmlUtils.CHANGEFREQ);
    		XmlUtils.addOneElement(urlsetElement, "http://www.licaime.com/help/lc.htm", XmlUtils.CHANGEFREQ);
			List<LcProductYinHang> lcProductYinHangList=lcProductLogService.selectLcProductYinHang();
			System.out.println("store..........");
			//银行sitemap
			for(LcProductYinHang lcProductYinHang:lcProductYinHangList){
				LcPageParam pageParam=new LcPageParam();
				pageParam.setYinhang(lcProductYinHang.getName());
				int totalRow=lcProductLogService.selectProductCount(pageParam);
				int pageNum=totalRow%lcpagesize==0?totalRow/lcpagesize:(totalRow/lcpagesize+1);
				for(int i=1;i<=pageNum;i++){
					
					XmlUtils.addOneElement(urlsetElement, "http://www.licaime.com/lc-"+lcProductYinHang.getId()+"----0-"+i+".htm", XmlUtils.CHANGEFREQ);
				}
			}
			System.out.println("store..2........");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    //商品详细sitemap
    private void productLcSiteMap(Element urlsetElement){
    	List<LcProduct> goodProductList=new ArrayList<LcProduct>();
    	LcPageParam pageParam=new LcPageParam();
		//用于回显的url部分
		int totalRow=lcProductLogService.selectProductCount(pageParam);
		int pageNum=totalRow%lcpagesize==0?totalRow/lcpagesize:(totalRow/lcpagesize+1);
		for(int i=1;i<=pageNum;i++){
			goodProductList=lcProductLogService.selectProductPage((i-1)*lcpagesize, lcpagesize, pageParam);
			System.out.println(i+"----------------");
			if(goodProductList!=null && !goodProductList.isEmpty()){
//				http://www.licaime.com/detail-27.htm
				for(LcProduct lcProduct:goodProductList){
					XmlUtils.addOneElement(urlsetElement, "http://www.licaime.com/detail-"+lcProduct.getId()+".htm", XmlUtils.CHANGEFREQ);
				}
			}
		}
		System.out.println("store..3........");
    }
}
