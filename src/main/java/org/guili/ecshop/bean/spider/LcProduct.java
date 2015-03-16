package org.guili.ecshop.bean.spider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.guili.ecshop.util.common.TimeUtils;
/**
 * 理财产品对象
 * @author guili
 */
public class LcProduct {

	public static final String FENGXIAN_1="1";		//低
	public static final String FENGXIAN_2="2";		//中低
	public static final String FENGXIAN_3="3";		//中高
	public static final String FENGXIAN_4="4";		//高
	public static final String SALETYPE_INIT="1";	//可售
	public static final String SALETYPE_SALEOUT="2";//已售罄
	public static final String SALETYPE_UNSALE="3";	//可售
	private long   id;		 	//产品主键
	//商品基本信息
	private String companyName;	//机构名称
	private String productName; //产品名称
	private Date startTime;		//开始时间
	private Date endTime; 		//结束时间
	private int days;			//投资期限
	private String area;		//发行区域
	private Double price;		//起购金额
	private Double income;		//预期年化收益率
	private String incomeType;  //收益类型 保本浮动收益或者非保本
	private String productType; //产品类型
	private String fengxian;	//投资风险等级    1:低，2，中低，3，中高，4，高
	private String money; 	    //投资币种 
	private String saleType;	//销售状态：是否可售  1,可售，2、已售完，3.还未开售
	private String productDetailUrl; //产品说明书链接地址
	private String productDetail;//产品详细描述
	private int costMoney;		 //最低投资金额
	private String englishName;  
	
	private Double timePercent;
	private String remainTime;
	private boolean soldOut;
	private Date   version;		//版本号
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getFengxian() {
		return fengxian;
	}
	public void setFengxian(String fengxian) {
		this.fengxian = fengxian;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	public String getProductDetailUrl() {
		return productDetailUrl;
	}
	public void setProductDetailUrl(String productDetailUrl) {
		this.productDetailUrl = productDetailUrl;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public int getCostMoney() {
		return costMoney;
	}
	public void setCostMoney(int costMoney) {
		this.costMoney = costMoney;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	
	public Double getTimePercent() {
		long start=0;
		long end=1;
		long now=0;
		if(startTime!=null && this.endTime!=null){
			start=startTime.getTime();
			end=endTime.getTime()+79200000;
			now=new Date().getTime();
			if(now-start>=end-start){
				return 100.00;
			}else if(now-start<0){
				return 0.00;
			}else{
				//计算时间区间
				return Math.ceil(((now-start)/((end-start)*1.0))*10000.0)/100;
			}
		}
		
		return timePercent;
	}
	public void setTimePercent(Double timePercent) {
		this.timePercent = timePercent;
	}
	
	public String getRemainTime() {
		long now=0;
		long end=1;
		if(endTime!=null){
			end=endTime.getTime()+79200000;
			now=new Date().getTime();
			//11 小时 42 分
			if(end-now<=0){
				return "0 小时 0 分";
			}else{
				return TimeUtils.getHoursAndMinitByTime(end-now);
			}
		}else{
			return "0 小时 0 分";
		}
		
	}
	
	public void setRemainTime(String remainTime) {
		this.remainTime = remainTime;
	}
	
	public boolean isSoldOut() {
		Date now=new Date();
		if(now.after(this.startTime) && now.before(TimeUtils.AddDays(this.getEndTime(), 1) )){
			return false;
		}else{
			return true;
		}
	}
	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}
	
	
	public Date getVersion() {
		return version;
	}
	public void setVersion(Date version) {
		this.version = version;
	}
	//test
	public static void main(String[] args) {
		LcProduct lcProduct=new LcProduct();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
//			lcProduct.setStartTime(sdf.parse("2014-06-15"));
			lcProduct.setEndTime(sdf.parse("2014-08-25 00:00:00"));
			System.out.println(lcProduct.getRemainTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
