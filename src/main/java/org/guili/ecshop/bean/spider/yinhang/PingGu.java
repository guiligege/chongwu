package org.guili.ecshop.bean.spider.yinhang;

import org.guili.ecshop.util.PingGuUtil;

/**
 * 评估
 * @author guilige
 *
 */
public class PingGu {
	
	private int income; //收益评分
	private int days;	//时间评分
	private int shouyi; //类型评分
	private int fengxian;//风险评分
	private int total;  //总分
	
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getShouyi() {
		return shouyi;
	}
	public void setShouyi(int shouyi) {
		this.shouyi = shouyi;
	}
	public int getFengxian() {
		return fengxian;
	}
	public void setFengxian(int fengxian) {
		this.fengxian = fengxian;
	}
	public int getTotal() {
		this.total=(this.days+this.income+this.shouyi+this.fengxian)/4;
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	PingGu(){
		
	}
	/*
	 * myincome 当前收益
	 * myincomeType 收益类型
	 * mydays 时间
	 * 
	 * 
	 */
    public  PingGu(Double myincome,int mydays,String myincomeType,String myfengxian){
		this.income=PingGuUtil.analysisIncome(myincome);
		this.days=PingGuUtil.analysisDays(mydays);
		this.shouyi=PingGuUtil.analysisShouyi(myincomeType);
		this.fengxian=PingGuUtil.analysisFengxian(myfengxian);
		this.total=(this.income+this.days+this.shouyi+this.fengxian)/4;
	}
}
