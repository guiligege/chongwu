package org.guili.ecshop.dao.pet;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
/**
 * 宠物售卖信息
 * @author guili
 */
public interface IPetDetailDao {
	/**
	 * 添加宠物售卖信息
	 * @param lcProduct
	 * @return
	 * @throws Exception
	 */
	public int addPetSaleInfo(PetSaleInfo petSaleInfo);
	
	/**
	 * 根据Id查询宠物售卖信息
	 * @param pageParam
	 * @return
	 */
	public PetSaleInfo selectPetSaleInfoById(Long id) throws Exception;
	
	/**
	 * 根据title的hash值，查询商品数量
	 * @param Hash
	 * @return
	 */
	public Integer selectPetSaleInfoByHash(Long titlehash);
	
}
