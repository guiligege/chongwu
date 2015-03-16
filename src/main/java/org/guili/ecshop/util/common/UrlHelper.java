package org.guili.ecshop.util.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
/**
 * url工具类
 * @ClassName:   UrlHelper 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2014-1-15 下午3:21:19 
 */
public class UrlHelper {
	/**
	 * 获取url绝对路径
	 * @param request
	 * @return
	 */
	public static String getRealPath(HttpServletRequest request){
		String basePath = request.getScheme()+"://"+request.getServerName()
        		+(request.getServerPort()==80?"":":"+request.getServerPort())+request.getContextPath();
		return basePath;
	}
	
	/**
	 * 获得请求的所有参数
	 * @param request
	 * @return
	 */
	public static String getAllParamsAndValuesToString(HttpServletRequest request){
		StringBuffer urlparams=new StringBuffer();
		Map<String, String[]> params = request.getParameterMap();
        if ((params != null) && (params.size() > 0)) {
            Iterator<Entry<String, String[]>> iter = params.entrySet().iterator();
            String[] valueHolder = new String[1];
            while (iter.hasNext()) {
                Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) iter.next();
                String name = (String) entry.getKey();
               
                Object value = entry.getValue();
                String[] values;
                if (value instanceof String[]) {
                    values = (String[]) value;
                } else {
                    valueHolder[0] = value.toString();
                    values = valueHolder;
                }

                for (int i = 0; i < values.length; i++) {
                    if (values[i] != null) {
//                        System.out.println(name + "=" + values[i]);
                        if(urlparams.length()==0){
                        	urlparams.append(name+"="+values[i]);
                        }else{
                        	urlparams.append("&"+name+"="+values[i]);
                        }
                    }
                }

            }
        }
        System.out.println(urlparams.toString());
        return urlparams.toString();
	}
	/**
	 * 获得请求的参数(排除key以外的所有)
	 * @param request
	 * @return
	 */
	public static String getAllParamsAndValuesEscapekey(HttpServletRequest request,String key){
		StringBuffer urlparams=new StringBuffer();
		Map<String, String[]> params = request.getParameterMap();
        if ((params != null) && (params.size() > 0)) {
            Iterator<Entry<String, String[]>> iter = params.entrySet().iterator();
            String[] valueHolder = new String[1];
            while (iter.hasNext()) {
                Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) iter.next();
                String name = (String) entry.getKey();
                //排除key
                if(name.equals(key)){
                	continue;
                }
                Object value = entry.getValue();
                String[] values;
                if (value instanceof String[]) {
                    values = (String[]) value;
                } else {
                    valueHolder[0] = value.toString();
                    values = valueHolder;
                }

                for (int i = 0; i < values.length; i++) {
                    if (values[i] != null) {
//                        System.out.println(name + "=" + values[i]);
                        if(urlparams.length()==0){
                        	urlparams.append(name+"="+values[i]);
                        }else{
                        	urlparams.append("&"+name+"="+values[i]);
                        }
                    }
                }

            }
        }
        System.out.println(urlparams.toString());
        return urlparams.toString();
	}
	
	/**
	 * 获取网站主信息
	 * @param url
	 * @return
	 */
	public static String getMainUrl(String url){
		if(url==null || url.isEmpty()){
			return "";
		}
		String temp="";
		//如果有http头
		if(url.startsWith("http://")){
			temp=url.substring("http://".length());
		}else if(url.startsWith("https://")){
			temp=url.substring("https://".length());
		}else{
			temp=url;
		}
		if(temp.contains("/")){
			temp=temp.substring(0, temp.indexOf("/"));
		}
//		if(!temp.startsWith("www")){
//			temp="www."+temp;
//		}
		return temp.toLowerCase();
	}
	
	//test
	public static void main(String[] args) {
		String url="converse.com.cn/index.htm";
		System.out.println(getMainUrl(url));
	}
}
