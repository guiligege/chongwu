package org.guili.ecshop.business.member;

/**
 * 用户详细接口
 * @author jumbo
 */
public interface UserDetails {
	/**
	 * 如果Member是Guest Member（默认Member）或空时，<br>
	 * memberFavirote中会记录他目前已经收藏的产品列表以用于登录后添加到会员的收藏列表中 如果Member是其他会员时，memberFaviore会清空
	 * 
	 * @return
	 */
	Member getMember();

	void setMember(Member member);

	void setMemberId(Long memberId);

	void setEmail(String email);

	Long getMemberId();
}
