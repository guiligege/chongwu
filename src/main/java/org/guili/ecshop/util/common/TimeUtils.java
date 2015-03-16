package org.guili.ecshop.util.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
	/**
	04    * 毫秒转日期字符串
	05    * 
	06    * @param str
	07    * @return
	08    */
	  public static String getDateTimeByMillisecond(String str) {
	 
	     Date date = new Date(Long.valueOf(str));
	
	     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	 
	     String time = format.format(date);
	
	     return time;
   }
   /**
    *  时间+ n day
    * @param date
    * @param days
    * @return
    */
   public static Date AddDays(Date date,int days){
        try {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(Calendar.DATE, days);  
            Date temp_date = c.getTime();   
            return temp_date;
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }  
   }
   
   /**
    *  时间+ n month
    * @param date
    * @param months
    * @return
    */
   public static Date AddMonths(Date date,int months){
        try {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(Calendar.MONTH, months);  
            Date temp_date = c.getTime();   
            return temp_date;
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }  
   }
   
   /**
    * 时间+ n year
    * @param date
    * @param years
    * @return
    */
   public static Date AddYears(Date date,int years){
        try {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(Calendar.YEAR, years);  
            Date temp_date = c.getTime();   
            return temp_date;
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }  
   }
   
   
   /**
    *  时间+ n day
    * @param date
    * @param days
    * @return
    */
   public static String AddDaysGetString(Date date,int days){
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        try {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(Calendar.DATE, days);  
            Date temp_date = c.getTime();   
            return format.format(temp_date);
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }  
   }
   
   /**
    *  时间- n day
    * @param date
    * @param days
    * @return
    */
   public static String subDaysGetString(Date date,int days){
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        try {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(Calendar.DATE, -days);  
            Date temp_date = c.getTime();   
            return format.format(temp_date);
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }  
   }
   /**
    *  时间+ n month
    * @param date
    * @param months
    * @return
    */
   public static String AddMonthsGetString(Date date,int months){
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        try {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(Calendar.MONTH, months);  
            Date temp_date = c.getTime();   
            return format.format(temp_date);
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }  
   }
   
   /**
    * 时间+ n year
    * @param date
    * @param years
    * @return
    */
   public static String AddYearsGetString(Date date,int years){
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        try {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(Calendar.YEAR, years);  
            Date temp_date = c.getTime();   
            return format.format(temp_date);
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }  
   }
   /**
    * date + years + months+ days
    * @param date
    * @param years
    * @param months
    * @param days
    * @return
    */
   public static Date AddTime(Date date,int years,int months,int days){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
       try {  
           Calendar c = Calendar.getInstance();  
           c.setTime(date);  
           c.add(Calendar.YEAR, years);
           c.add(Calendar.MONTH, months);
           c.add(Calendar.DATE, days);
           Date temp_date = c.getTime();   
           return temp_date;
       } catch (Exception e) {  
           e.printStackTrace();  
           return null;
       }  
  }
   /**
    * 通过开始结束时间获取销售状态
    * @param startTime
    * @param endTime
    * @return
    */
   public static String getSaleType(Date startTime, Date endTime){
	   String saleType="";
	   if(startTime!=null && endTime!=null){
			if(startTime.after(new Date())){
				saleType="待售";
			}else 
			if(startTime.before(new Date()) && endTime.after(new Date())){
				saleType="在售";
			} else
			if(endTime.before(new Date())){
				saleType="已售完";
			}
		}
	   return saleType;
   }
   
   //11 小时 42 分
   public static String getHoursAndMinitByTime(long time){
	   long hour=time/3600000;
	   long minit=(time%3600000)/60000;
	   return hour+" 小时 "+minit+" 分";
   }
   
   //测试TimeUtils
   public static void main(String[] args) {
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(TimeUtils.AddDays(now, 1)));
		System.out.println(sdf.format(TimeUtils.AddMonths(now, 1)));
		System.out.println(sdf.format(TimeUtils.AddYears(now, 1)));
		System.out.println(sdf.format(TimeUtils.AddTime(now, 1, 1, 1)));
	}
}

