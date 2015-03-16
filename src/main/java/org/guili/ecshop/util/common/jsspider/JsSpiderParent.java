package org.guili.ecshop.util.common.jsspider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.LcProduct;
import org.guili.ecshop.business.product.ILcProductLogService;
/**
 * 数据抓取的抽象父类别，需要htmlunit抓取的类，需要继承此类，或者自己实现接口(支持不同银行网站的抓取)
 * @author guili
 */
public abstract class JsSpiderParent implements IJsSpiderService {
	
	private static Logger logger=Logger.getLogger(Jsspider.class);
	public ILcProductLogService  lcProductLogService;
	private String localUrl;
	private int sleepingTime;
	/**
	 * 默认加入的数据抓取方法，子类可以重写该方法，以覆盖该方法。
	 */
	@Override
	public  List<LcProduct> getPageXMLByUrl(String url,int sleeptime) throws Exception{
		Date start=new Date(); 
		//单个理财产品url
		List<String> urlList=new ArrayList<String>();
		urlList=this.getPageInfo(url, sleeptime);
		//理财产品列表
		List<LcProduct> lcProductList=new ArrayList<LcProduct>();
		if(urlList!=null && urlList.size()>0){
			for(String detailurl:urlList){
				//获取理财产品信息
				try {
					lcProductList.add(this.getPageDetailInfo(detailurl,5000));
				} catch (Exception e) {
				}
			}
		}
		System.out.println("inserting...............");
		//保存产品日志
		if(lcProductList!=null){
			lcProductLogService.saveLcProductLogList(lcProductList);
		}
        //写入文本记录数据
        logger.debug("花费时间:"+(new Date().getTime()-start.getTime()));
        return lcProductList;
	}
	
	@Override
	public void crawlLicaiInfo(){
		try {
			System.out.println("crawlLicaiInfo-------------");
			//重置链接
			this.resetting();
			this.getPageXMLByUrl(this.localUrl, this.sleepingTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//重置链接
	private void resetting(){
		//浦发
		if(this.localUrl.equals("pf00")){
			this.localUrl="http://ebank.spdb.com.cn/net/finnaceMoreInfo.do?_viewReferer=finance%2FmoreInfo&_PagableInfor.PageSize=11&num=11&FinanceType=[Ljava.lang.String%3B%4018bb9df&ftype=0&ispage=2&_PagableInfor.PageNo=1";
		}
		if(this.localUrl.equals("pf01")){
			this.localUrl="http://ebank.spdb.com.cn/net/finnaceMoreInfo.do?_viewReferer=finance%2FmoreInfo&_PagableInfor.PageSize=11&num=11&FinanceType=%5BLjava.lang.String%3B%40f950b7&ftype=1&ispage=1&_PagableInfor.PageNo=1";
		}
		if(this.localUrl.equals("pf02")){
			this.localUrl="http://ebank.spdb.com.cn/net/finnaceMoreInfo.do?ftype=A&num=11&ispage=1";
		}
		if(this.localUrl.equals("pf03")){
			this.localUrl="http://ebank.spdb.com.cn/net/finnaceMoreInfo.do?_viewReferer=finance%2FmoreInfo&_PagableInfor.PageSize=11&num=11&FinanceType=%5BLjava.lang.String%3B%40a41c64&ftype=8&ispage=1&_PagableInfor.PageNo=1";
		}
		if(this.localUrl.equals("pf04")){
			this.localUrl="http://ebank.spdb.com.cn/net/finnaceMoreInfo.do?_viewReferer=finance%2FmoreInfo&_PagableInfor.PageSize=11&num=11&FinanceType=%5BLjava.lang.String%3B%40b240d7&ftype=2&ispage=1&_PagableInfor.PageNo=1";
		}
		//招商
		if(this.localUrl.equals("zhaohang")){
			this.localUrl="http://www.cmbchina.com/CFWEB/svrajax/product.ashx?op=search&type=m&series=01&pagesize=2000&orderby=ord1&pageindex=1";
		}
		//民生
		if(this.localUrl.equals("minSheng")){
			this.localUrl="http://www.cmbc.com.cn/cs/Satellite?cid=1356495590851&currentId=1356495507925&pagename=cmbc%2FPage%2FTP_PersonalProductSelLayOut";
		}
		//光大
		if(this.localUrl.equals("guangda")){
			this.localUrl="http://www.cebbank.com/jsp/include/newsun/moreproduct_n.jsp?cid=/Channel/59547038&isSale=1";
		}
		//平安
		if(this.localUrl.equals("pingAn")){
			this.localUrl="http://chaoshi.pingan.com/bankListIframe.shtml?&npage=1";
		}
	}
	/**
	 * 抽象的获取合适的url
	 * @param wc
	 * @param url
	 * @param sleeptime
	 * @return
	 * @throws Exception
	 */
	public abstract List<String> getPageInfo(String url,int sleeptime) throws Exception;
	
	/**
	 * 抽象的获取合适的url
	 * @param wc
	 * @param url
	 * @param sleeptime
	 * @return
	 * @throws Exception
	 */
	public abstract LcProduct getPageDetailInfo(String url,int sleeptime) throws Exception;

	public ILcProductLogService getLcProductLogService() {
		return lcProductLogService;
	}
	public void setLcProductLogService(ILcProductLogService lcProductLogService) {
		this.lcProductLogService = lcProductLogService;
	}
	
	public abstract List<String> analyzeOnePage(String pageXml);
	
	@Override
	public void updateAllLcProduct(String yinhang){
		
	}

	public String getLocalUrl() {
		return localUrl;
	}

	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

	public int getSleepingTime() {
		return sleepingTime;
	}

	public void setSleepingTime(int sleepingTime) {
		this.sleepingTime = sleepingTime;
	}
	
}
