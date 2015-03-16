package org.guili.ecshop.bean.common;

/**
 * 配置系统中常用的cookie，session scope 作用域常量，系统中放在session、application以及cookie中的值的key在这里配置
 * @author jumbo
 *
 */
public class ScopeConstants {
	//用户登录session
	public static final String			USER_CONTEXT					= "session.userdetail";
	public static final String			COOKIE_USER_CONTEXT					= "cookie.userdetail";
	
}
