package org.guili.ecshop.business.impl.product;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.bean.spider.PageParam;
import org.guili.ecshop.business.product.IProductService;
import org.guili.ecshop.exception.RemoteServiceException;
import org.guili.ecshop.util.AbstractResponseHandler;
import org.guili.ecshop.util.FileTools;
import org.guili.ecshop.util.HttpComponent;
import org.guili.ecshop.util.SpiderRegex;
import org.guili.ecshop.util.chongwu.PetUtil;
import org.guili.ecshop.util.common.ShortUrlGenerator;
import org.guili.ecshop.util.common.UrlHelper;

/**
 * 商品服务类
 * @ClassName:   ProductService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2014-1-13 下午4:17:44 
 */
public class ProductService implements IProductService{

	private static Logger logger=Logger.getLogger(ProductService.class);
	private static final int RANDOMSIZE=5;
	private HttpComponent httpComponent;
	
	public HttpComponent getHttpComponent() {
		return httpComponent;
	}

	public void setHttpComponent(HttpComponent httpComponent) {
		this.httpComponent = httpComponent;
	}

	private static final TestHandler testHandler = new TestHandler();
	private final TestListHandler test1Handler = new TestListHandler();
	private final CeListHandler ceHandler = new CeListHandler();
	//58detail
	private static class TestHandler extends AbstractResponseHandler<PetSaleInfo> {
        @Override
        public PetSaleInfo handle(HttpEntity entity) throws IOException {
            String entityStr = EntityUtils.toString(entity);

            if (StringUtils.isBlank(entityStr)) {
                throw new RemoteServiceException();
            }
            FileTools.write("E:/spiderfile/58testdetail.txt", entityStr);
            //解析
            SpiderRegex regex = new SpiderRegex();
            String reg = "<div class=\"gallery\">(.*?)<li class=\"baozhang_t\">";
    		String[] clcontent = regex.htmlregex(entityStr,reg,true);
    		if(clcontent==null || clcontent.length==0){
    			return null;
    		}
    		//对各个信息的正则解析
    		String regtitle = "alt=\"(.*?)\"";
    		String regimgs = "img src=\"(.*?)\"/>";
    		String regprice = "price c_f50\">(.*?)</";
    		String regcategory = "<div class=\"su_con\"><span>(.*?)</span>";
    		String regqq = "\"<img src='(.*?)'";
    		String regmaijia = "<p class=\"c_666\">(.*?)<span class=\"datu-xb\">";
    		String regdetail  = "<article class=\"description_con\">(.*?)</article>";
    		String[] titles = regex.htmlregex(clcontent[0],regtitle,true);
    		String[] images = regex.htmlregex(clcontent[0],regimgs,true);
    		String price = regex.htmlregex(clcontent[0],regprice,true)[0];
    		String category = regex.htmlregex(clcontent[0],regcategory,true)[0];
    		String[] qqs = regex.htmlregex(entityStr,regqq,true);
    		String maijia = regex.htmlregex(entityStr,regmaijia,true)[0];
    		String detail  = regex.htmlregex(entityStr,regdetail,false)[0];
    		String reg1 = "<ul class=\"ulDec clearfix\">(.*?)</ul>";
    		String[] clcontent1 = regex.htmlregex(entityStr,reg1,true);
    		String regmiaoshu = "<span class=\"it_r\">(.*?)</span>";
    		String[] miaoshu = regex.htmlregex(clcontent1[0],regmiaoshu,true);
    		String age=miaoshu[0];
    		String yimiao=miaoshu[1];
    		String sex=miaoshu[4];
    		System.out.println("title:"+titles[0]);
    		System.out.println(images[0]);
    		System.out.println(images[1]);
    		System.out.println(images[2]);
    		System.out.println(images[3]);
    		System.out.println(price);
    		System.out.println(category);
    		if(qqs!=null && qqs.length==2){
    			System.out.println("tel:"+qqs[1]);
    			System.out.println("qq:"+qqs[0]);
    		}
    		System.out.println(maijia);
    		System.out.println("----------------");
    		System.out.println("detail:"+detail);
    		System.out.println("----------------");
    		System.out.println("age:"+age);
    		System.out.println("yimiao:"+yimiao);
    		System.out.println("sex:"+sex);
    		//构造返回对象
    		PetSaleInfo petSaleInfo=new PetSaleInfo();
    		petSaleInfo.setTitle(titles[0]);
    		petSaleInfo.setTitlehash(new Long(titles[0].hashCode()));
    		petSaleInfo.setCategory(category);
    		//设置宠物类别
    		petSaleInfo.setCategoryId(PetUtil.getPetCategory(category));
    		petSaleInfo.setImageDetail1(images[0]);
    		petSaleInfo.setImageDetail2(images[1]);
    		petSaleInfo.setImageDetail3(images[2]);
    		petSaleInfo.setImageDetail4(images[3]);
    		petSaleInfo.setPrice(Integer.parseInt(price.trim()));
    		if(qqs!=null && qqs.length==2){
    			petSaleInfo.setQq(qqs[0]);
        		petSaleInfo.setTelephone(qqs[1]);
    		}
    		if(maijia!=null ){
    			petSaleInfo.setNickName(maijia.replace("卖家：", ""));
    		}
    		petSaleInfo.setDescrip(detail);
    		petSaleInfo.setAge(age);
    		petSaleInfo.setYimiao(yimiao);
    		petSaleInfo.setSex(sex);
            return petSaleInfo;
        }
    }
	
	
	//58list
	private static class TestListHandler extends AbstractResponseHandler<List<PetSaleInfo>> {
        @Override
        public List<PetSaleInfo> handle(HttpEntity entity) throws IOException {
            String entityStr = EntityUtils.toString(entity);

            if (StringUtils.isBlank(entityStr)) {
                throw new RemoteServiceException();
            }
            FileTools.write("E:/spiderfile/58testlist.txt", entityStr);
            //解析
            SpiderRegex regex = new SpiderRegex();
            String reg = "<table class=\"tbimg\" cellpadding=\"0\" cellspacing=\"0\">(.*?)</table>";
            String[] clcontent = regex.htmlregex(entityStr,reg,true);
            if(clcontent==null || clcontent.length==0){
    			return null;
    		}
            String regcity = "province=(.*?);";
            String[] citys = regex.htmlregex(entityStr,regcity,true);
            String regtr = "<tr(.*?)</tr>";
            String[] trs = regex.htmlregex(clcontent[0],regtr,true);
            if(trs==null || trs.length==0){
    			return null;
    		}
            System.out.println(citys[0]+"--");
            List<PetSaleInfo> PetSaleInfoList=new ArrayList<PetSaleInfo>();
            for(int i=0;i<trs.length;i++){
            	PetSaleInfo petSaleInfo=new PetSaleInfo();
            	String reg_detailurl = "<td class=\"t\"><a href=\"(.*?)\"";
            	String reg_title = "target=\"_blank\" class=\"t\">(.*?)</a>";
            	String reg_address = "<p class=\"pet-post-detail clearfix\">(.*?)<span>";
            	String[] detailurl = regex.htmlregex(trs[i],reg_detailurl,true);
            	String[] title = regex.htmlregex(trs[i],reg_title,true);
            	String[] address = regex.htmlregex(trs[i],reg_address,false);
            	try {
            		petSaleInfo=ProductService.testdetailHttp(detailurl[0]);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
            	System.out.println(detailurl[0]+"--");
            	System.out.println(title[0]+"--");
            	System.out.println(address[1]+"--");
            	petSaleInfo.setAdress(address[1]);
            	petSaleInfo.setCity(citys[0]);
            	petSaleInfo.setAdressId(PetUtil.getPetAddressId(citys[0],address[1]));
            }
            return PetSaleInfoList;
        }
    }
	
	//测试58同城，什么情况会触发风控。
		private static class CeListHandler extends AbstractResponseHandler<String> {
	        @Override
	        public String handle(HttpEntity entity) throws IOException {
	            String entityStr = EntityUtils.toString(entity);
	            if (StringUtils.isBlank(entityStr)) {
	                throw new RemoteServiceException();
	            }
	            System.out.println("entityStr:-->"+entityStr.length());
	            return null;
	        }
	    }
	@Override
	public String testHttp(String listurl)throws URISyntaxException, IOException {
		HttpComponent httpComponent1=new HttpComponent();
		HttpGet httpGet = new HttpGet("http://sh.58.com/dog/pn2/");
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
		//设置user-Agent
		httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
		httpComponent1.execute(httpGet, test1Handler);
		return null;
	}
	public static PetSaleInfo testdetailHttp(String detailUrl)throws URISyntaxException, IOException {
		HttpComponent httpComponent1=new HttpComponent();
		HttpGet httpGet = new HttpGet(detailUrl);
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
		//设置user-Agent
		httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
		PetSaleInfo petSaleInfo=httpComponent1.execute(httpGet, testHandler);
		return petSaleInfo;
	}
	
	public static void main(String[] args) throws InterruptedException {
		ProductService productService=new ProductService();
		try {
//			for(int i=0;i<1000;i++){
				Thread.sleep(3000);
//				System.out.println("执行第："+i+"次");
//				productService.testHttp("http://sh.58.com/dog/pn2/");
			productService.testdetailHttp("http://sh.58.com/dog/20103282893317x.shtml");
//			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//hash测试
//		System.out.println("全国连锁宠物馆一上海浦东一虹口一闵行店一特价送用品".hashCode());
	}

	@Override
	public List<PetSaleInfo> getPetListInfo(String listurl) throws URISyntaxException,
			IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PetSaleInfo petDetailHttp(String detailUrl)
			throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void batCrawlPet(String listurl) {
		// TODO Auto-generated method stub
		
	}


}
