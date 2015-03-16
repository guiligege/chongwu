package org.guili.ecshop.util.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * cookie获取和设置类
 * @author jumbo
 *
 */
public class CookieUtil {

	private static final Logger log = LoggerFactory.getLogger(CookieUtil.class);

	public static final int SECONDS_PER_YEAR = 60 * 60 * 24 * 365;
	public static final int SECONDS_PER_MONTH = 60 * 60 * 24 * 30;
	public static final int SECONDS_PER_WEEK = 60 * 60 * 24 * 7;
	public static final int SECONDS_PER_DAY = 60 * 60 * 24;
	public static final int SECONDS_PER_HOUR = 60 * 60;
	
	/**
	 * 获得cookie
	 * @param name
	 * @param request
	 * @return
	 */
	public static String getCookieValue(String name, HttpServletRequest request) {
      log.debug("[get Cookie {}]", name);
      String value = null;
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
          for (Cookie cookie : cookies) {
//              log.info("All Cookies:" + cookie.getName() + "," + cookie.getValue());
              if (cookie.getName().equals(name)) {
                  if (cookie.getValue() != null && !cookie.getValue().equals("")) {
                      value = cookie.getValue();
                      break;
                  }
              }

          }
      }
      log.debug("[Cookie {}] {}", name, value);
      return value;
  }

  /**
   * 设置cookie时间为1年
   * @param name
   * @param value
   * @param response
   */
  public static void setCookieValue(String name,String value, HttpServletResponse response){
      log.debug("[set Cookie {}] {}",name ,value);
      Cookie cookie=new Cookie(name, value);
      cookie.setMaxAge(SECONDS_PER_YEAR);
      response.addCookie(cookie);
  }
  
  /**
   * 随意设置cookie时间
   * @param name
   * @param value
   * @param response
   */
  public static void setCookieValue(String name,String value, HttpServletResponse response, int interval){
      log.debug("[set Cookie {}] {}",name ,value);
      Cookie cookie=new Cookie(name, value);
      cookie.setMaxAge(interval);
      response.addCookie(cookie);
  }
  
  /**
   * 设置会话cookie
   * @param name
   * @param value
   * @param response
   */
  public static void setLocalCookieValue(String name,String value, HttpServletResponse response){
      log.debug("[set Cookie {}] {}",name ,value);
      Cookie cookie=new Cookie(name, value);
      cookie.setMaxAge(-1);
      response.addCookie(cookie);
  }
  
  /**
   * 清除cookie
   * @param name
   * @param value
   * @param response
   */
  public static void clearCookieValue(String name, HttpServletResponse response){
	  Cookie cookie = new Cookie(name, null); 
	  cookie.setMaxAge(-1);
	  response.addCookie(cookie); 
  }
}