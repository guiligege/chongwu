package org.guili.ecshop.business.impl.member;

import org.guili.ecshop.business.member.Member;
import org.guili.ecshop.business.member.UserDetails;

/**
 * 用户信息详细
 * @author jumbo
 */
public class UserDetailImpl implements UserDetails {

	/** 该用户. */
	private Member					member;
	
	/** memberid. */
	private Long					memberId;
	
	/** 邮箱. */
	@SuppressWarnings("unused")
	private String					email;

	@Override
	public Member getMember() {
		return member;
	}

	@Override
	public void setMember(Member member) {
		this.member=member;
	}

	@Override
	public void setMemberId(Long memberId) {
		this.memberId=memberId;
	}

	@Override
	public void setEmail(String email) {
		this.email=email;
	}

	@Override
	public Long getMemberId() {
		return memberId;
	}
	
	
}
