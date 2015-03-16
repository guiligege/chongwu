package org.guili.ecshop.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.*;

public class StoreClassSpider {
	//抓取的列数
//	private static int COLUMS=25;
	private static String PRICESPLIT="-";
	private static Logger log=Logger.getLogger(StoreClassSpider.class);
	//抓取网站所有类别
	public List<String> classesContent() {
		SpiderRegex regex = new SpiderRegex();
		List<String> classlist = new ArrayList<String>();
		StringBuffer csb = new StringBuffer();
		//通过网址获取网页内容
		String htmltext = regex.gethtmlContent("http://www.360buy.com/allSort.aspx","gbk");
		//匹配需要的那部分网页
		String reg = "<div class=\"mt\".*?>(.*?)<div class=\"m\".*?>";
		String[] clcontent = regex.htmlregex(htmltext,reg,true);
		//具体内容部分的拆分
		for(int i =0;i<clcontent.length;i++){
			reg = "<h2>(.*?)<\\/h2>";
			String[] class1 = regex.htmlregex(clcontent[i],reg,false);
			if(class1 == null&& class1.length ==0){
				return null;
			}
			reg = "<dl.*?>(.*?)<\\/dl>";
			String[] cl2content =regex.htmlregex(clcontent[i],reg,true);
			if(cl2content!=null&& cl2content.length>0){
				for(int j = 0;j<cl2content.length;j++){
					reg = "<dt>(.*?)<\\/dt>";
					String[] class2 = regex.htmlregex(cl2content[j],reg,false);
					if(class2!=null&& class2.length>0){
						for(int k = 0;k<class2.length;k++){
							reg = "<em>(.*?)<\\/em>";
							String[] class3 = regex.htmlregex(cl2content[j],reg,false);
							if(class3!=null&& class3.length>0){
								for(int m = 0;m<class3.length;m++){
									csb.append(class1[0]).append("$$");
									csb.append(class2[k]).append("$$");
									csb.append(class3[m]);
									classlist.add(csb.toString());
									csb = new StringBuffer();
									
								}
							}
						}
					}
				}
			}
		}
		for(int i =0;i<classlist.size();i++){
			log.debug(classlist.get(i));
		}
		return classlist;
	}
	
	//插入到数据库
	public void insertToDB(List<String> classlist){
		//todo
	}
	
	/**
	 * 抓取百度手机软件
	 * @return
	 */
	public String getBaiDuSoft(){
		SpiderRegex regex = new SpiderRegex();
		List<String> classlist = new ArrayList<String>();
		StringBuffer csb = new StringBuffer();
		String htmltext = regex.gethtmlContent("http://as.baidu.com/a/item?docid=2547668&pre=web_am_rank&pos=rank_3000_4&f=web_alad%40next%40rank_3000_4","utf-8");
		log.debug(htmltext);
		String reg = "<div class=\"com\">(.*?)<div class=\"info-middle\">";
		String[] clcontent = regex.htmlregex(htmltext,reg,true);
		csb.append(clcontent[0].toString());
		return csb.toString();
	}
	
	//抓取网站所有类别
	public List<String> digikeyContent() {
		SpiderRegex regex = new SpiderRegex();
		List<String> classlist = new ArrayList<String>();
		StringBuffer csb = new StringBuffer();
		//通过网址获取网页内容
		String htmltext = regex.gethtmlContent("http://www.digikey.cn/product-search/zh/sensors-transducers/irda-transceiver-modules/1966896?stock=1","UTF-8");
		//匹配需要的那部分网页
		String reg = "<tbody>(.*?)<\\/table>";
		String[] clcontent = regex.htmlregex(htmltext,reg,true);
		//具体内容部分的拆分
		for(int i =0;i<clcontent.length;i++){
			reg = "<tr itemscope(.*?)<\\/tr>";
			String[] cl2content =regex.htmlregex(clcontent[i],reg,true);
			if(cl2content!=null&& cl2content.length>0){
				for(int j = 0;j<cl2content.length;j++){
					reg = "<td.*?>(.*?)<\\/td>";
					String[] class2 = regex.htmlregex(cl2content[j],reg,false);
					if(class2!=null&& class2.length>0){
						for(int k = 0;k<class2.length;k++){
							csb.append(class2[k]).append("--");
						}
						classlist.add(csb.toString());
						csb = new StringBuffer();
					}
				}
			}
		}
		for(int i =0;i<classlist.size();i++){
			log.debug(classlist.get(i));
		}
		return classlist;
	}
	
	/**
	 * 获取规格(digikey)
	 * @param basehtml
	 * @return
	 */
	public String getguige(String basehtml,SpiderRegex regex){
		String reg = "<a href=(.*?) target=";
		String[] guiges=regex.htmlregex(basehtml,reg,false);
		String guige="";
		if(guiges!=null && guiges.length>0){
			guige=guiges[0].replaceAll("\"", "");
			log.debug("guige--->"+guige);
		}
		return guige;
	}
	/**
	 * 获得图片链接(digikey)
	 * @param basehtml
	 * @return
	 */
	public String getImageUrl(String basehtml,SpiderRegex regex){
		String reg = "<img border=0 height=64 src=(.*?) alt=";
		String[] imagepaths=regex.htmlregex(basehtml,reg,false);
		String imageurl="";
		if(imagepaths!=null && imagepaths.length>0){
			imageurl=imagepaths[0].replaceAll("\"", "");
		}
		return imageurl;
	}
	/**
	 * 获得价格链接(digikey)
	 * @param basehtml
	 * @return
	 */
	public String getPriceUrl(String basehtml,SpiderRegex regex){
		String reg="href=\"(.*?)\">";
		String[] priceurls=regex.htmlregex(basehtml,reg,false);
		String priceurl="";
		if(priceurls!=null && priceurls.length>0){
			priceurl=priceurls[0];
			log.debug("priceurl--->"+priceurl);
		}
		return priceurl;
	}
	public int getPageCount(String basehtml,SpiderRegex regex){
		String regpag="页面 1/(.*?) ";
		String[] pagecounts = regex.htmlregex(basehtml,regpag,false);
		int pagecount=1;
		if(pagecounts!=null && pagecounts.length>0){
			pagecount=Integer.parseInt(pagecounts[0]);
		}
		return pagecount;
	}
		
	public static void main(String[] args) throws Exception {
		Date start=new Date();
		StoreClassSpider scs = new StoreClassSpider();
//		List<String> classlist = scs.classesContent();
//		log.debug(classlist);
		//String content=scs.getBaiDuSoft();
//		log.debug(content);
//		scs.insertToDB(classlist);
		log.debug("总耗时:"+(new Date().getTime()-start.getTime())/1000);
	}
}
