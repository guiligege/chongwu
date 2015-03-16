package org.guili.ecshop.impl.spider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.guili.ecshop.business.member.Member;
import org.guili.ecshop.dao.spider.ILcMemberDao;
import org.guili.ecshop.util.BasicSqlSupport;

/**
 * 用户注册登录dao
 * @author jumbo
 */
public class LcMemberDao extends BasicSqlSupport  implements ILcMemberDao {

	private static Logger logger=Logger.getLogger(LcMemberDao.class);
	
	/**
	 * 添加新用户
	 */
	@Override
	public int addLcMember(Member member) {
		int count=0;
		count=this.session.insert("org.guili.ecshop.dao.spider.ILcMemberDao.addLcMember", member);
		return count;
	}

	/**
	 * 根据昵称查询用户
	 */
	@Override
	public Member selectLcMemberByNickName(String nickName) throws Exception {
		Member member=new Member();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("nickName", nickName);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcMemberDao.selectLcMemberByNickName", paramMap);
		if(list!=null && list.size()>0){
			member=(Member)list.get(0);
		}else{
			member=null;
		}
		logger.debug("success!");
		return member;
	}

	/**
	 * 根据id查询用户信息
	 */
	@Override
	public Member selectLcMemberById(Long id) throws Exception {
		Member member=new Member();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcMemberDao.selectLcMemberById", paramMap);
		if(list!=null && list.size()>0){
			member=(Member)list.get(0);
		}else{
			member=null;
		}
		logger.debug("success!");
		return member;
	}

	@Override
	public Member selectLcMemberByEmail(String email) throws Exception {
		Member member=new Member();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("email", email);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcMemberDao.selectLcMemberByEmail", paramMap);
		if(list!=null && list.size()>0){
			member=(Member)list.get(0);
		}else{
			member=null;
		}
		logger.debug("success!");
		return member;
	}

	@Override
	public Member selectLcMemberByEmailAndPw(String email, String password)
			throws Exception {
		Member member=new Member();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcMemberDao.selectLcMemberByEmailAndPw", paramMap);
		if(list!=null && list.size()>0){
			member=(Member)list.get(0);
		}else{
			member=null;
		}
		logger.debug("success!");
		return member;
	}

}
