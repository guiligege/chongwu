package org.guili.ecshop.dao.spider;

import org.guili.ecshop.business.member.Member;
/**
 * 用户登录注册dao
 * @author guili
 */
public interface ILcMemberDao {
	/**
	 * 添加理财商品日志
	 * @param lcProduct
	 * @return
	 * @throws Exception
	 */
	public int addLcMember(Member member);
	
	/**
	 * 根据名字查询理财产品
	 * @param pageParam
	 * @return
	 */
	public Member selectLcMemberByNickName(String nickName)throws Exception;
	
	/**
	 * 根据Id查询理财产品
	 * @param pageParam
	 * @return
	 */
	public Member selectLcMemberById(Long id) throws Exception;
	
	/**
	 * 根据email查询理财产品
	 * @param pageParam
	 * @return
	 */
	public  Member selectLcMemberByEmail(String email)throws Exception;
	
	/**
	 * 根据email查询理财产品
	 * @param pageParam
	 * @return
	 */
	public  Member selectLcMemberByEmailAndPw(String email,String password)throws Exception;
	
	/**
	 * 更新理财产品
	 * @param lcProduct
	 * @return
	 * @throws Exception
	 */
//	public int updateLcMember(Member member) throws Exception;
}
