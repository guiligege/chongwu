package org.guili.ecshop.business.member;

public interface ILcMemberService {
	/**
	 * 添加用户信息
	 * @param lcProduct
	 * @return
	 * @throws Exception
	 */
	public int saveLcMember(Member member);
	
	/**
	 * 根据名字查询用户信息
	 * @param pageParam
	 * @return
	 */
	public  Member selectLcMemberByNickName(String nickName)throws Exception;
	
	/**
	 * 根据email查询用户信息
	 * @param pageParam
	 * @return
	 */
	public  Member selectLcMemberByEmail(String email)throws Exception;
	
	/**
	 * 根据email和密码查询用户信息
	 * @param pageParam
	 * @return
	 */
	public  Member selectLcMemberByEmailAndPw(String email,String password)throws Exception;
	
	/**
	 * 根据Id查询用户信息
	 * @param pageParam
	 * @return
	 */
	public  Member selectLcMemberById(Long id) throws Exception;
}
