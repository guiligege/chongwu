package org.guili.ecshop.bean.spider.yinhang;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 用于分页查询的参数
 * @author guili
 */
public class LcPageParam {
	//查询条件
	//	1.按银行筛选，
	//  2.按收益率筛选。
	//  3.按销售状态查询。
	//  4.按理财周期查询。
	//	（即主流银行理财产品排序优先，地方银行理财产品其次）
	//	1.默认排序（银行顺序+利率顺序+销售状态+售罄时间）银行在数据库中设置不同银行的排序值。
	//	2.利率高低排序   （即利率顺序+销售状态+售罄时间）
	//	3.按投资期限排序  （即投资周期顺序+销售状态+售罄时间）
	public static final String SALETYPESALE="0";
	public static final String SALETYPEPRESALE="1";
	public static final String SALETYPEUNSALE="2";
	
	//筛选条件
	private String productName;//产品名称
	private String yinhang;//银行
	private Double income; //收益率
	private String saleType;//0.售罄，1.在售 2.待售
	private Integer days;		//理财周期
	//排序条件
	private String orderType=OrderConstants.DEFAULT;//排序类型
	//分页查询
	private int start;
	private int size;
	private Double incomeMin;//最低收益
	private Double incomeMax;//最高收益
	private Integer daysMin;//最低周期
	private Integer daysMax;//最高周期
	private Long id;
	private String companyId; //银行id
	private String saleTypeId;//销售类型id
	private String productDetailUrl;//商品详细链接
	private Date startTime;	  //开始时间
	
	public String getYinhang() {
		return yinhang;
	}
	public void setYinhang(String yinhang) {
		this.yinhang = yinhang;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Double getIncomeMin() {
		return incomeMin;
	}
	public void setIncomeMin(Double incomeMin) {
		this.incomeMin = incomeMin;
	}
	public Double getIncomeMax() {
		return incomeMax;
	}
	public void setIncomeMax(Double incomeMax) {
		this.incomeMax = incomeMax;
	}
	public Integer getDaysMin() {
		return daysMin;
	}
	public void setDaysMin(Integer daysMin) {
		this.daysMin = daysMin;
	}
	public Integer getDaysMax() {
		return daysMax;
	}
	public void setDaysMax(Integer daysMax) {
		this.daysMax = daysMax;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 设置理财参数
	 * @param yinhang
	 * @param days
	 * @param size
	 * @param income
	 * @return
	 */
	public  LcPageParam settingLcPageParamDays(String yinhang,String income,String saleType,String days,String orderType,String size){
		if(StringUtils.isNotEmpty(yinhang)){
			this.setYinhang(yinhang);
		}
		if(StringUtils.isNotEmpty(income)){
			this.setIncome(Double.parseDouble(income));
			//0-3%
			if(this.getIncome()>SearchConstants.INCOMEONE && this.getIncome()<SearchConstants.INCOMETWO){
				this.setIncomeMin(SearchConstants.INCOMEONE);
				this.setIncomeMax(SearchConstants.INCOMETWO);
			}
			//3-6%
			if(this.getIncome()>SearchConstants.INCOMETWO && this.getIncome()<SearchConstants.INCOMETHREE){
				this.setIncomeMin(SearchConstants.INCOMETWO);
				this.setIncomeMax(SearchConstants.INCOMETHREE);
			}
			//6-8%
			if(this.getIncome()>SearchConstants.INCOMETHREE && this.getIncome()<SearchConstants.INCOMEFOUR){
				this.setIncomeMin(SearchConstants.INCOMETHREE);
				this.setIncomeMax(SearchConstants.INCOMEFOUR);
			}
			//大于8%
			if(this.getIncome()>SearchConstants.INCOMEFOUR){
				this.setIncomeMin(SearchConstants.INCOMEFOUR);
				this.setIncomeMax(20.0);
			}
		}
		if(StringUtils.isNotEmpty(saleType)){
			this.setSaleType(saleType);
		}
		if(StringUtils.isNotEmpty(days)){
			this.setDays(Integer.parseInt(days));
			//设置时间段查询
			//3个月以下
			if(this.getDays()<=SearchConstants.DAYSONE){
				this.setDaysMin(0);
				this.setDaysMax(SearchConstants.DAYSONE);
			}
			//3个月-6个月
			if(this.getDays()>SearchConstants.DAYSONE && this.getDays()<SearchConstants.DAYSTWO){
				this.setDaysMin(SearchConstants.DAYSONE);
				this.setDaysMax(SearchConstants.DAYSTWO);
			}
			//6-9
			if(this.getDays()>SearchConstants.DAYSTWO && this.getDays()<SearchConstants.DAYSTHREE){
				this.setDaysMin(SearchConstants.DAYSTWO);
				this.setDaysMax(SearchConstants.DAYSTHREE);
			}
			//9-12
			if(this.getDays()>SearchConstants.DAYSTHREE && this.getDays()<SearchConstants.DAYSFOUR){
				this.setDaysMin(SearchConstants.DAYSTHREE);
				this.setDaysMax(SearchConstants.DAYSFOUR);
			}
			//12以上
			if(this.getDays()>=SearchConstants.DAYSFIVE){
				this.setDaysMin(SearchConstants.DAYSFIVE);
				this.setDaysMax(3000);
			}
		}
		if(StringUtils.isNotEmpty(orderType)){
			this.setOrderType(orderType);
		}
		if(StringUtils.isNotEmpty(size)){
			this.setSize(Integer.parseInt(size));
		}
		return this;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getSaleTypeId() {
		return saleTypeId;
	}
	public void setSaleTypeId(String saleTypeId) {
		this.saleTypeId = saleTypeId;
	}
	public String getProductDetailUrl() {
		return productDetailUrl;
	}
	public void setProductDetailUrl(String productDetailUrl) {
		this.productDetailUrl = productDetailUrl;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
}
