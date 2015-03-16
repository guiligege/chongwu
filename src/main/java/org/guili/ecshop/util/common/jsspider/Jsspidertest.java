package org.guili.ecshop.util.common.jsspider;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.LcProduct;
/**
 * 带js加载的抓取
 * @ClassName:   Jsspider 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2014-1-9 下午3:24:38 
 *
 */
public class Jsspidertest extends JsSpiderParent{

	private static Logger logger=Logger.getLogger(Jsspidertest.class);
	//test
	public static void main(String[] args) {
		try {
//			getPageXMLByUrl3("http://www.abchina.com/cn/FinancialService/ABCWealth/Products/AllProdcts/?t=%E5%AE%89%E5%BF%83%E5%BE%97%E5%88%A9",8000);
			Jsspidertest jsspider1=new Jsspidertest();
			jsspider1.getPageXMLByUrl("http://www.abchina.com/cn/FinancialService/ABCWealth/Products/AllProdcts/?t=%E5%AE%89%E5%BF%83%E5%BE%97%E5%88%A9", 8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//最简单的获取页面信息的方法
	@Override
	public List<String> getPageInfo(String url, int sleeptime) throws Exception{
		
//		WebRequest request = new WebRequest(new URL(url), HttpMethod.GET); 
//        request.setCharset("gbk");
//        HtmlPage page = wc.getPage(request);
//        //如果自带的sleep不起作用，可以放开下面注释。
//        //Thread.sleep(sleeptime);
//        wc.waitForBackgroundJavaScript(sleeptime);
//	    //以xml的形式获取响应文本
//	    return  page.asXml(); 
		List<String> lcProductList=new ArrayList<String>();
		return lcProductList;
	}

	@Override
	public LcProduct getPageDetailInfo(String url, int sleeptime)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> analyzeOnePage(String pageXml) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
