package org.guili.ecshop.business.impl.product;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.business.product.IPetDetailService;
import org.guili.ecshop.dao.pet.IPetDetailDao;
import org.guili.ecshop.util.common.Validator;

/**
 * pet详细信息服务类
 * @author Administrator
 *
 */
public class PetDetailService implements IPetDetailService {

	private static Logger logger=Logger.getLogger(PetDetailService.class);
	private IPetDetailDao petDetailDao;
	@Override
	public int addPetSaleInfo(PetSaleInfo petSaleInfo){
		try {
			return petDetailDao.addPetSaleInfo(petSaleInfo);
		} catch (Exception e) {
			logger.error("petSaleInfo is error:"+petSaleInfo.getTitle());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public PetSaleInfo selectPetSaleInfoById(Long id) {
		//验证传入是否是数字
		if(!Validator.isNumber(id+"")){
			return null;
		}
		try {
			return petDetailDao.selectPetSaleInfoById(id);
		} catch (Exception e) {
			logger.error("selectPetSaleInfoById is error id=:"+id);
			return null;
		}
	}
	@Override
	public Integer selectPetSaleInfoByHash(Long titlehash) {
		//验证传入是否是数字
		if(!Validator.isNumber(titlehash+"")){
			return null;
		}
		try {
			return petDetailDao.selectPetSaleInfoByHash(titlehash);
		} catch (Exception e) {
			logger.error("selectPetSaleInfoByHash is error titlehash=:"+titlehash);
			return null;
		}
	}
	
	/**
	 * 批量插入理财产品日志(带事物的插入)
	 */
	@Override
	public void savePetSaleInfoList(List<PetSaleInfo> petSaleInfoList) {
		 if(petSaleInfoList.isEmpty()){
			 return ;
		 }
		 for(PetSaleInfo petSaleInfo:petSaleInfoList){
			 if(petSaleInfo!=null){
				 //防止重复插入。
				 if(this.selectPetSaleInfoByHash(petSaleInfo.getTitlehash())!=null){
					 continue;
				 }
				 try {
					 petSaleInfo.setCreateTime(new Date());
					 petDetailDao.addPetSaleInfo(petSaleInfo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
		 }
	}

	public IPetDetailDao getPetDetailDao() {
		return petDetailDao;
	}

	public void setPetDetailDao(IPetDetailDao petDetailDao) {
		this.petDetailDao = petDetailDao;
	}

}
