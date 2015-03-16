package org.guili.ecshop.util.common;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;  
 
/**
 * encode tag
 * @author zhengdong.xiao
 */
public class EncodeTag {  
	/**
	 * urlencode tag
	 * @param variableName
	 * @return
	 */
	public static String filterUrlTag(String variableName) {  
        String encodeval="";
		try {
			encodeval = URLEncoder.encode(variableName,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		return encodeval;  
    }  
} 
