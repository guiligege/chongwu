package org.guili.ecshop.util;

/**
 * 评估
 * @author jumbo
 *
 */
public class PingGuUtil {
	
	private static final Double INCOMEINIT=3.0;
	private static final Double INCOMEPER=0.01;
	private static final int  DAYSINIT=60;
	private static final int  DAYSPER=10;
	/**
	 * 评估收益分数
	 * @param income
	 * @return
	 * 
	 * 计算方式：计算范围3-6.3区间 ，小于3=0 ，每多0.1涨3分， 大于6.3为满分
	 */
	public static int analysisIncome(Double income){
		Double tempincome=income-INCOMEINIT;
		if(tempincome<0){
			return 0;
		}else if(tempincome>3.3){
			return 100;
		}else{
			Double finalincome=Math.ceil(tempincome/INCOMEPER);
			return finalincome.intValue()*30/100;
		}
	}
	
	/**
	 * 时间期限分数
	 * @param income
	 * @return
	 * 
	 * 计算方式：计算范围60-260区间 ，小于60=100 ，每多10少4分， 大于260为满分
	 */
	public static int analysisDays(int days){
		int tempdays=days-DAYSINIT;
		if(tempdays<=0){
			return 100;
		}else if(tempdays>=250){
			return 50;
		}else{
			int finaldays=tempdays/DAYSPER;
			return 100-(finaldays*2);
		}
	}
	
	public static int analysisShouyi(String incomeType){
		if(incomeType==null || incomeType.equals("")  ){
			return 50;
		}
		if(incomeType.contains("不保证")){
			return 50;
		}
		if(incomeType.contains("保证")){
			return 100;
		}
		if(incomeType.contains("非保本")){
			return 50;
		}
		if(incomeType.contains("保本")){
			return 100;
		}
		return 0;
	}
	
	/**
	 * 风险评级
	 * @param fengxian
	 * @return
	 */
	public static int analysisFengxian(String fengxian){
		if(fengxian==null || fengxian.equals("") ){
			return 50;
		}
		if(fengxian.contains("较低")){
			return 80;
		}
		if(fengxian.contains("低")){
			return 100;
		}
		if(fengxian.contains("中")){
			return 50;
		}
		if(fengxian.contains("较高")){
			return 30;
		}
		if(fengxian.contains("高")){
			return 0;
		}
		return 0;
	}
	//test
	public static void main(String[] args) {
		System.out.println(PingGuUtil.analysisDays(300));
	}
}
