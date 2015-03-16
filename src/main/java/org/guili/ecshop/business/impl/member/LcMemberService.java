package org.guili.ecshop.business.impl.member;

import org.apache.log4j.Logger;
import org.guili.ecshop.business.member.ILcMemberService;
import org.guili.ecshop.business.member.Member;
import org.guili.ecshop.dao.spider.ILcMemberDao;

/**
 * 用户服务类
 * @author guili
 */
public class LcMemberService implements ILcMemberService {
	private static Logger logger=Logger.getLogger(LcMemberService.class);
	//用户信息dao
	private ILcMemberDao lcMemberDao;
	
	/**
	 * 保存用户信息
	 */
	@Override
	public int saveLcMember(Member member) {
		try {
			return lcMemberDao.addLcMember(member);
		} catch (Exception e) {
			logger.error("addProduct is error:"+member.getEmail());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Member selectLcMemberByNickName(String nickName) throws Exception {
		try {
			return lcMemberDao.selectLcMemberByNickName(nickName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member selectLcMemberById(Long id) throws Exception {
		try {
			return lcMemberDao.selectLcMemberById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setLcMemberDao(ILcMemberDao lcMemberDao) {
		this.lcMemberDao = lcMemberDao;
	}

	@Override
	public Member selectLcMemberByEmail(String email) throws Exception {
		try {
			return lcMemberDao.selectLcMemberByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member selectLcMemberByEmailAndPw(String email, String password)
			throws Exception {
		try {
			return lcMemberDao.selectLcMemberByEmailAndPw(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
