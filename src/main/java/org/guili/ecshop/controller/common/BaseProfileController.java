package org.guili.ecshop.controller.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.guili.ecshop.bean.common.ScopeConstants;
import org.guili.ecshop.business.member.UserDetails;
import org.guili.ecshop.business.member.UserDetailsAware;

/**
 * 所有controller的基类
 * @author jumbo
 */
public class BaseProfileController implements UserDetailsAware{
	protected ThreadLocal<UserDetails> userDetails = new ThreadLocal<UserDetails>();

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails.set(userDetails);
	}

	protected UserDetails getUserDetails() {
		return this.userDetails.get();
	}

	/**
	 * 更新 MemSession Constants.USER_CONTEXT 属性 <br>
	 * add javadoc by jinxin (2011-5-3 下午02:07:06)
	 * 
	 * @param request
	 * @param response
	 */
	protected void updateUserDetails(HttpServletRequest request,
			HttpServletResponse response) {
		//用户登录成功后会将session进行重置，并将重置前的数据进行复制
		HttpSession session = request.getSession();
		Enumeration<String> s = session.getAttributeNames();
		Map<String, Object> sessionCopy = new HashMap<String, Object>();

		while (s.hasMoreElements()) {
			String key = s.nextElement();
			Object value = session.getAttribute(key);
			sessionCopy.put(key, value);
		}

		session.invalidate();
		session = request.getSession();

		Iterator it = sessionCopy.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String key = entry.getKey().toString();
			Object value = entry.getValue();
			session.setAttribute(key, value);
		}
		session.setAttribute(ScopeConstants.USER_CONTEXT, this.userDetails.get());
	}
}
