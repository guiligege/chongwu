package org.guili.ecshop.util.common;

/**
 * <p>
 * 	This software is the confidential and proprietary information of FeiLong Network Technology, Inc. ("Confidential Information").  <br>
 * 	You shall not disclose such Confidential Information and shall use it 
 *  only in accordance with the terms of the license agreement you entered into with FeiLong.
 * </p>
 * <p>
 * 	FeiLong MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, 
 * 	INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * 	PURPOSE, OR NON-INFRINGEMENT. <br> 
 * 	FeiLong SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * 	THIS SOFTWARE OR ITS DERIVATIVES.
 * </p>
 */
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.guili.ecshop.bean.common.DomainConstans;
import org.guili.ecshop.bean.common.DomainType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 二级域名 工具类
 * 
 * @author <a href="mailto:venusdrogon@163.com">金鑫</a>
 * @version 1.0 2012-8-9 下午4:53:55
 */
public final class DomainUtil{

	private static final Logger	log	= LoggerFactory.getLogger(DomainUtil.class);

	/**
	 * 获得二级域名 ,要是Validator.isNull( **),返回 contextPath
	 * 
	 * @param request
	 * @param domainType
	 * @return
	 */
	public static String getDomain(HttpServletRequest request,DomainType domainType){
		ServletContext servletContext = request.getSession().getServletContext();
		return getDomain(servletContext, domainType);
	}

	/**
	 * 获得二级域名 ,要是Validator.isNull( **),返回 contextPath
	 * 
	 * @param servletContext
	 * @param domainType
	 * @return
	 */
	public static String getDomain(ServletContext servletContext,DomainType domainType){
		String domain = getDomain(domainType);
		if (Validator.isNullOrEmpty(domain)){
			String contextPath = servletContext.getContextPath();
			domain = contextPath;
		}
		return domain;
	}

	/**
	 * 直接读取配置的domainType,用于调度等非 Web环境<br>
	 * {@link SkuManagerImpl#createOpenBaiDu()}
	 * 
	 * @param domainType
	 * @return
	 */
	public static String getDomain(DomainType domainType){
		String domain = null;
		switch (domainType) {
			case CSS:// css
				domain = DomainConstans.DOMAIN_CSS;
				break;
			case JS:// js
				domain = DomainConstans.DOMAIN_JS;
				break;
			case IMAGE:// 图片
				domain = DomainConstans.DOMAIN_IMAGE;
				break;
			case RESOURCE:// PDP商品图片
				domain = DomainConstans.DOMAIN_RESOURCE;
				break;
			case STORE:// 商城的网址，一般用于不同环境 第三方数据传递 比如微博等
				domain = DomainConstans.DOMAIN_STORE;
				break;
			case CONTEXTPATH:// 商城的网址，一般用于不同环境 第三方数据传递 比如微博等
				domain = DomainConstans.CONTEXTPATH;
				break;
			default:
				throw new IllegalArgumentException("domainType can't support!");
		}
		return domain;
	}
}
