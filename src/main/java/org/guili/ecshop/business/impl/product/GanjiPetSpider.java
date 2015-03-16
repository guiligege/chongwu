package org.guili.ecshop.business.impl.product;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.exception.RemoteServiceException;
import org.guili.ecshop.util.AbstractResponseHandler;
import org.guili.ecshop.util.FileTools;
import org.guili.ecshop.util.HttpComponent;
import org.guili.ecshop.util.SpiderRegex;
import org.guili.ecshop.util.chongwu.PetUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 赶集，宠物抓取
 * @author Administrator
 */
public class GanjiPetSpider extends PetSpiderParent{

	private static Logger logger=Logger.getLogger(GanjiPetSpider.class);
	private static final String USER_AGENT="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36";
	//http请求组件封装
	private HttpComponent httpComponent;
	
	//pet信息列表handler
	private final PetInfoListHandler petInfoListHandler = new PetInfoListHandler();
	//pet信息详细handler
	private final PetInfoDetailHandler petInfoDetailHandler = new PetInfoDetailHandler();
	//58list
	private class PetInfoListHandler extends AbstractResponseHandler<List<PetSaleInfo>> {
        @Override
        public List<PetSaleInfo> handle(HttpEntity entity) throws IOException {
            String entityStr = EntityUtils.toString(entity);

            if (StringUtils.isBlank(entityStr)) {
                throw new RemoteServiceException();
            }
//            FileTools.write("E:/spiderfile/58testlist.txt", entityStr);
            //解析
            SpiderRegex regex = new SpiderRegex();
            //正则解析宠物资源列表
            String reg = "<table class=\"tbimg\" cellpadding=\"0\" cellspacing=\"0\">(.*?)</table>";
            String[] clcontent = regex.htmlregex(entityStr,reg,true);
            if(clcontent==null || clcontent.length==0){
    			return null;
    		}
            String regcity = "province=(.*?);";
            String[] citys = regex.htmlregex(entityStr,regcity,true);
            String regtr = "<tr(.*?)</tr>";
            //解析多个单独的宠物资源
            String[] trs = regex.htmlregex(clcontent[0],regtr,true);
            if(trs==null || trs.length==0){
    			return null;
    		}
            //获取url的所有宠物信息
            List<PetSaleInfo> petSaleInfoList=new ArrayList<PetSaleInfo>();
            for(int i=0;i<trs.length;i++){
            	PetSaleInfo petSaleInfo=new PetSaleInfo();
            	String reg_detailurl = "<td class=\"t\"><a href=\"(.*?)\"";
            	String reg_title = "target=\"_blank\" class=\"t\">(.*?)</a>";
            	String reg_address = "<p class=\"pet-post-detail clearfix\">(.*?)<span>";
            	String[] detailurl = regex.htmlregex(trs[i],reg_detailurl,true);
            	String[] title = regex.htmlregex(trs[i],reg_title,true);
            	String[] address = regex.htmlregex(trs[i],reg_address,false);
            	try {
            		logger.info("detail url-->"+detailurl[0]);
            		//跳过风控
//					Thread.sleep(2000);
            		//调用单个抓取
            		petSaleInfo=petDetailHttp(detailurl[0]);
				} catch (URISyntaxException e) {
					logger.error("detail url crawal error:"+e.getStackTrace());
				} 
//            	catch (InterruptedException e) {
//					logger.error("InterruptedException:"+e.getStackTrace());
//				}
            	logger.debug(citys[0]+"--"+detailurl[0]+"--"+title[0]+"--"+address[1]);
            	petSaleInfo.setAdress(address[1].trim());
            	petSaleInfo.setCity(citys[0].trim());
            	petSaleInfo.setAdressId(PetUtil.getPetAddressId(citys[0],address[1]));
            	petSaleInfoList.add(petSaleInfo);
            }
            return petSaleInfoList;
        }
    }
	
	//58detail
	private static class PetInfoDetailHandler extends AbstractResponseHandler<PetSaleInfo> {
        @Override
        public PetSaleInfo handle(HttpEntity entity) throws IOException {
            String entityStr = EntityUtils.toString(entity);

            if (StringUtils.isBlank(entityStr)) {
                throw new RemoteServiceException();
            }
//            FileTools.write("E:/spiderfile/ganjitestdetail.txt", entityStr);
            //解析
            Document doc = Jsoup.parse(entityStr);
            Element titleEle =doc.select(".title-name").first();
            Element priceEle =doc.select(".dog-price").first();
            Elements chengnuoEle =doc.select(".cn-items");
            Elements alllis =doc.select(".det-infor li");
            Elements addressA =doc.select(".det-infor li").get(1).getElementsByTag("a");
            Element telEle =doc.select(".phoneNum-style").first();
            Element qqEle =doc.select(".phoneNum-style").last();
            //详细
//            Element detailEle =doc.select(".col-cont");
            //title
            String title = titleEle.text();
            String price = priceEle.text();
            //解析
            SpiderRegex regex = new SpiderRegex();
            String reg = "<i class=\"dog-price\">(.*?)<li>";
            String maijiareg = "class=\"f-gap01\"></i>人：</label>(.*?)<span class=\"fc-orange b-pet-ver\">";
            String[] doginfos = regex.htmlregex(entityStr,reg,false);
            String[] maijia = regex.htmlregex(entityStr,maijiareg,false);
            String[] infos=doginfos[0].split("\\|");
            logger.debug(title+"--"+price+"--");
            logger.debug(infos[0]+"--"+infos[1]+"--"+infos[2]);
            logger.debug(chengnuoEle.get(0).text()+"--"+chengnuoEle.get(1).text()+"--"+chengnuoEle.get(2).text());
            logger.debug(addressA.get(0).text()+"--"+addressA.get(1).text());
            logger.debug(maijia[0]+"--");
            logger.debug(telEle.text()+"--");
            logger.debug(qqEle.text()+"--");
//    		//构造返回对象
    		PetSaleInfo petSaleInfo=new PetSaleInfo();
//    		petSaleInfo.setTitle(titles[0].trim());
//    		petSaleInfo.setTitlehash(new Long(titles[0].hashCode()));
//    		petSaleInfo.setCategory(category.trim());
//    		//设置宠物类别
//    		petSaleInfo.setCategoryId(PetUtil.getPetCategory(category));
//    		petSaleInfo.setImageDetail1(images[0].trim());
//    		petSaleInfo.setImageDetail2(images[1].trim());
//    		petSaleInfo.setImageDetail3(images[2].trim());
//    		petSaleInfo.setImageDetail4(images[3].trim());
//    		petSaleInfo.setPrice(Integer.parseInt(price.trim()));
//    		if(qqs!=null && qqs.length==2){
//    			petSaleInfo.setQq(qqs[0].trim());
//        		petSaleInfo.setTelephone(qqs[1].trim());
//    		}
//    		if(maijia!=null ){
//    			petSaleInfo.setNickName(maijia.replace("卖家：", "").trim());
//    		}
//    		petSaleInfo.setDescrip(detail.length()>1000?detail.substring(0, 999):detail);
//    		petSaleInfo.setAge(age.trim());
//    		petSaleInfo.setYimiao(yimiao.trim());
//    		petSaleInfo.setSex(sex.trim());
            return petSaleInfo;
        }
    }
	
	public PetSaleInfo petDetailHttp(String detailUrl)throws URISyntaxException, IOException {
		httpComponent=new HttpComponent();
		HttpGet httpGet = new HttpGet(detailUrl);
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
		//设置user-Agent
		httpGet.addHeader("User-Agent", USER_AGENT);
		PetSaleInfo petSaleInfo=httpComponent.execute(httpGet, petInfoDetailHandler);
		return petSaleInfo;
	}
	@Override
	public List<PetSaleInfo> getPetListInfo(String listurl)
			throws URISyntaxException, IOException {
		HttpGet httpGet = new HttpGet("http://sh.58.com/dog/pn2/");
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
		//设置user-Agent
		httpGet.addHeader("User-Agent", USER_AGENT);
		return httpComponent.execute(httpGet, petInfoListHandler);
	}
	public HttpComponent getHttpComponent() {
		return httpComponent;
	}
	public void setHttpComponent(HttpComponent httpComponent) {
		this.httpComponent = httpComponent;
	}

	public static void main(String[] args) throws InterruptedException {
		GanjiPetSpider ganjiPetSpider=new GanjiPetSpider();
		try {
//			for(int i=0;i<1000;i++){
//				Thread.sleep(3000);
//				System.out.println("执行第："+i+"次");
//				productService.testHttp("http://sh.58.com/dog/pn2/");
			ganjiPetSpider.petDetailHttp("http://nj.ganji.com/gou/1237818837x.htm");
//			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
