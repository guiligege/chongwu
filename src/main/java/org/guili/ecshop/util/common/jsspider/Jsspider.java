package org.guili.ecshop.util.common.jsspider;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;

/**
 * 带js加载的抓取
 * @ClassName:   Jsspider 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2014-1-9 下午3:24:38 
 *
 */
public class Jsspider {

	private static Logger logger=Logger.getLogger(Jsspider.class);
	private static Jsspider jsspider = null;
	private static WebClient wc=null;
	private static int HTMLLEN=500;
	//初始化
    private Jsspider(){
    	wc = new WebClient(BrowserVersion.CHROME);
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setTimeout(50000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController()); 
       
    }   
    public static Jsspider getInstance(){  
        if (jsspider== null)   
        {   
            synchronized (Jsspider.class)   
            {   
                if (jsspider== null)   
                {   
                	jsspider= new Jsspider();   
                }   
            }   
        }   
        return jsspider;   
    }   
	/**
	 * 根据url活动页面xml
	 * @param url	需要解析的url
	 * @return
	 * @throws Exception
	 */
	public  String getPageXMLByUrl(String url,int sleeptime) throws Exception{
		String pageXml="";
		WebRequest request = new WebRequest(new URL(url), HttpMethod.GET); 
        request.setCharset("gbk"); 
        HtmlPage page = wc.getPage(request);
        Thread.sleep(sleeptime);
        logger.debug("getPageXMLByUrl sleep end");
        pageXml = page.asXml(); //以xml的形式获取响应文本 
        //如果没抓到数据，用iso-8859-1
        /*if(pageXml.length()<HTMLLEN){
        	 request.setCharset("iso-8859-1"); 
             page = wc.getPage(request);
             Thread.sleep(sleeptime);
             logger.debug("getPageXMLByUrl sleep end");
             pageXml = page.asXml(); //以xml的形式获取响应文本
        }
        //如果没抓到数据，用utf-8
        if(pageXml.length()<HTMLLEN){
        	request.setCharset("utf-8");  
            page = wc.getPage(request);
            Thread.sleep(sleeptime);
            logger.debug("getPageXMLByUrl sleep end");
            pageXml = page.asXml(); //以xml的形式获取响应文本
       }*/
        //每次完了清除缓存
//        Cache cache=wc.getCache();
//        cache.clear();
        return pageXml;
	}
	
	
	/**
	 * 新版解析url
	 * @param url
	 * @param sleeptime
	 * @return
	 * @throws Exception
	 */
	public static  String getPageXMLByUrl2(String url,int sleeptime) throws Exception{
//		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		Date start=new Date(); 
		final WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
        wc.getOptions().setJavaScriptEnabled(false); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setTimeout(sleeptime); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
		
		String pageXml="";
		WebRequest request = new WebRequest(new URL(url), HttpMethod.GET); 
        request.setCharset("gbk"); 
        HtmlPage page = wc.getPage(request);
//        Thread.sleep(sleeptime);
        wc.waitForBackgroundJavaScript(sleeptime);
        pageXml = page.asXml(); //以xml的形式获取响应文本 
        wc.closeAllWindows();
        logger.debug("花费时间:"+(new Date().getTime()-start.getTime()));
        logger.debug("返回html长度:"+pageXml.length());
        if(pageXml.length()<=HTMLLEN){
        	return "";
        }
        return pageXml;
	}
	
	/**
	 * 农行抓取理财产品
	 * @param url
	 * @param sleeptime
	 * @return
	 * @throws Exception
	 */
	public static String getPageXMLByUrl3(String url,int sleeptime) throws Exception{
		Date start=new Date();
		final WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setTimeout(sleeptime); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
		String pageXml="";
		WebRequest request = new WebRequest(new URL(url), HttpMethod.GET); 
        request.setCharset("gbk"); 
        HtmlPage page = wc.getPage(request);
        //选择产品筛选
        HtmlSelect hs = (HtmlSelect) page.getElementById("selStatus");
        //选择可销售的理财产品
        hs.getOption(3).setSelected(true);  
        //模拟点击Next按钮，跳转到第二个页面  
        System.out.println("正在跳转…");  
        //执行按钮出发的js事件  
        ScriptResult sr = page.executeJavaScript("javascript:QryProdt(1);");  
        wc.waitForBackgroundJavaScript(sleeptime);
        
        //选择在售理财产品
        HtmlPage nowpage = (HtmlPage) sr.getNewPage(); 
        
        pageXml = nowpage.asXml(); 
        //查询下一页理财产品
        ScriptResult sr1 = page.executeJavaScript("javascript:go(2);");
        HtmlPage nextpage = (HtmlPage) sr1.getNewPage(); 
        String pagexml2="";
        pagexml2 = nextpage.asXml();
       	//以xml的形式获取响应文本 
        wc.closeAllWindows();
        logger.debug("花费时间:"+(new Date().getTime()-start.getTime()));
        logger.debug("返回html长度:"+pageXml.length());
        
        return pageXml;
	}
	
	/**
	 * 获得所有classname的div
	 * @param page
	 * @param classname
	 * @return
	 */
	public static List<HtmlElement> htmlunitGetDivByClass(HtmlPage page,String tagname,String attrname,String classname){
		List<HtmlElement> classnameDivs=new ArrayList<HtmlElement>();
		classnameDivs=page.getDocumentElement().getElementsByAttribute(tagname, attrname, classname);
		return classnameDivs;
	}
	
	//test
	public static void main(String[] args) {
		try {
			getPageXMLByUrl3("http://www.abchina.com/cn/FinancialService/ABCWealth/Products/AllProdcts/?t=%E5%AE%89%E5%BF%83%E5%BE%97%E5%88%A9",8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
