package org.guili.ecshop.util.common.jsspider;


import java.net.URL;
import java.util.Date;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Cache;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SpiderTest {
	private static Logger logger=Logger.getLogger(SpiderTest.class);
	private static int HTMLLEN=500;
	
	public static void homePage() throws Exception {
		Date start=new Date(); 
	    final WebClient wc = new WebClient(BrowserVersion.CHROME);
        wc.getOptions().setJavaScriptEnabled(false); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setTimeout(5000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController()); 
	    
	    final HtmlPage page = wc.getPage("http://htmlunit.sourceforge.net");
	    //Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
	    System.out.println(page.getTitleText());
	    final String pageAsXml = page.asXml();
	    System.out.println(pageAsXml.contains("<body class=\"composite\">"));
	    final String pageAsText = page.asText();
//	    Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
	    System.out.println(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
	    wc.closeAllWindows();
	    System.out.println(new Date().getTime()-start.getTime());
	}
	
	/**
	 * 解析url
	 * @param url
	 * @param sleeptime
	 * @return
	 * @throws Exception
	 */
	public static  String getPageXMLByUrl(String url,int sleeptime) throws Exception{
//		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		Date start=new Date(); 
		final WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
        wc.getOptions().setJavaScriptEnabled(false); //启用JS解释器，默认为true  
        wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
        wc.getOptions().setTimeout(5000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        wc.setAjaxController(new NicelyResynchronizingAjaxController());
        wc.waitForBackgroundJavaScript(5000);
		
		String pageXml="";
		WebRequest request = new WebRequest(new URL(url), HttpMethod.GET); 
        request.setCharset("gbk"); 
        HtmlPage page = wc.getPage(request);
//        Thread.sleep(sleeptime);
//        logger.debug("getPageXMLByUrl sleep end");
        pageXml = page.asXml(); //以xml的形式获取响应文本 
//       if(pageXml.length()<HTMLLEN){
//	   	 request.setCharset("iso-8859-1"); 
//	        page = wc.getPage(request);
//	        logger.debug("getPageXMLByUrl sleep end");
//	        pageXml = page.asXml(); //以xml的形式获取响应文本
//	   }
//	   //如果没抓到数据，用utf-8
//	   if(pageXml.length()<HTMLLEN){
//	   	request.setCharset("utf-8");  
//	       page = wc.getPage(request);
//	       logger.debug("getPageXMLByUrl sleep end");
//	       pageXml = page.asXml(); //以xml的形式获取响应文本
//	  }
//	   Cache cache=wc.getCache();
//	   cache.clear();
        wc.closeAllWindows();
        logger.debug("花费时间:"+(new Date().getTime()-start.getTime()));
        logger.debug("返回html长度:"+pageXml.length());
        return pageXml;
	}
	
	public static void main(String[] args) {
		try {
			SpiderTest.homePage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
