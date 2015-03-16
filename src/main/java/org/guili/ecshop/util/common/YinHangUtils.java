package org.guili.ecshop.util.common;

import java.util.ResourceBundle;

import org.guili.ecshop.util.ResourceUtil;

/**
 * 
 * @author zhengdong.xiao
 */
public class YinHangUtils {
	public static ResourceBundle	platform			= ResourceBundle.getBundle("config/platform");
	public static  String		isIncrement		= ResourceUtil.getValue(platform, "isIncrement");
	public static  String		myPageNum		= ResourceUtil.getValue(platform, "pageNum");
	/**
	 * 获取页数(如果是增量更新，返回增量更新的页数)
	 * @param pageNum
	 * @return
	 */
	public static int getPageNum(int pageNum){
		if(isIncrement.equals("true")){
			if(pageNum<=Integer.parseInt(myPageNum)){
				return pageNum;
			}
			return Integer.parseInt(myPageNum);
		}
		return pageNum;
	}
	public static void main(String[] args) {
		System.out.println(YinHangUtils.getPageNum(10));
	}
}
