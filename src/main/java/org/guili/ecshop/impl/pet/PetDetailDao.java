package org.guili.ecshop.impl.pet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.dao.pet.IPetDetailDao;
import org.guili.ecshop.util.BasicSqlSupport;

/**
 * 宠物详细信息dao
 * @author Administrator
 *
 */
public class PetDetailDao extends BasicSqlSupport  implements IPetDetailDao{

	private static Logger logger=Logger.getLogger(PetDetailDao.class);
	@Override
	public int addPetSaleInfo(PetSaleInfo petSaleInfo) {
		int count=0;
		count=this.session.insert("org.guili.ecshop.dao.pet.IPetDetailDao.addPetSaleInfo", petSaleInfo);
		return count;
	}

	@Override
	public PetSaleInfo selectPetSaleInfoById(Long id) throws Exception {
		PetSaleInfo petSaleInfo=new PetSaleInfo();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.pet.IPetDetailDao.selectPetSaleInfoById", paramMap);
		if(list!=null && list.size()>0){
			petSaleInfo=(PetSaleInfo)list.get(0);
		}else{
			petSaleInfo=null;
		}
		logger.debug("success!");
		return petSaleInfo;
	}

	@Override
	public Integer selectPetSaleInfoByHash(Long titlehash) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("titlehash", titlehash);
		List list=this.session.selectList("org.guili.ecshop.dao.pet.IPetDetailDao.selectPetSaleInfoByHash", paramMap);
		if(list!=null && list.size()>0){
			return (Integer)list.get(0);
		}else{
			return null;
		}
	}
	
	

}
