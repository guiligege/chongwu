package org.guili.ecshop.util.common.jsspider;

import java.util.List;
import org.guili.ecshop.bean.spider.LcProduct;
import com.gargoylesoftware.htmlunit.WebClient;
/**
 * 抓取接口
 * @author guili
 *
 */
public interface IJsSpiderService {

	/**
	 * 通过url获取页面信息，作为分析页面的基础数据
	 * @param url		需要抓取的页面url
	 * @param sleeptime	等待时间
	 * @return
	 * @throws Exception
	 */
	public  List<LcProduct> getPageXMLByUrl(String url,int sleeptime) throws Exception;
	
	public void updateAllLcProduct(String yinhang);
	
	public void crawlLicaiInfo();
	
}
