package org.guili.ecshop.bean.common;

/**
 * 二级域名 类型
 * 
 * @author <a href="mailto:venusdrogon@163.com">金鑫</a>
 * @version 1.0 2012-4-13 下午5:49:47
 */
public enum DomainType{
	/**
	 * 样式表
	 */
	CSS,
	/**
	 * js
	 */
	JS,
	/**
	 * 图片
	 */
	IMAGE,
	/**
	 * 资源图片,如PDP商品图片,在测试环境 可能 商品图片使用外部 而Image图片使用内部
	 */
	RESOURCE,
	/**
	 * 商城的网址，一般用于不同环境 第三方数据传递 比如微博等
	 */
	STORE,
	
	CONTEXTPATH
}