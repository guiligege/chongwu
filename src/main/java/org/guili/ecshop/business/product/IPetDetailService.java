package org.guili.ecshop.business.product;

import java.util.List;

import org.guili.ecshop.bean.chongwu.PetSaleInfo;

public interface IPetDetailService {

	/**
	 * 新增宠物售卖信息
	 * @param petSaleInfo
	 * @return
	 */
	public int addPetSaleInfo(PetSaleInfo petSaleInfo);
	
	/**
	 * 根据信息id查询售卖信息
	 * @param id
	 * @return
	 */
	public PetSaleInfo selectPetSaleInfoById(Long id);
	
	/**
	 * 批量新增宠物售卖信息
	 * @param petSaleInfo
	 * @return
	 */
	public void savePetSaleInfoList(List<PetSaleInfo> petSaleInfoList);
	
	/**
	 * 根据titlehash查询是否重复
	 * @param Hash
	 * @return
	 */
	public Integer selectPetSaleInfoByHash(Long Hash);
	
}
