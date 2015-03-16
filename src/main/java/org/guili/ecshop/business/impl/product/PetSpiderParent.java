package org.guili.ecshop.business.impl.product;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.business.product.IPetDetailService;
import org.guili.ecshop.business.product.IProductService;

/**
 * 对所有宠物信息抓取的抽象
 * @author Administrator
 *
 */
public abstract class PetSpiderParent implements IProductService {

	private static Logger logger=Logger.getLogger(PetSpiderParent.class);
	private IPetDetailService petDetailService;
	@Override
	public String testHttp(String listurl) throws URISyntaxException,
			IOException {
		return null;
	}
    
	/**
	 * 批量抓取宠物数据
	 * @param listurl
	 */
	@Override
	public void batCrawlPet(String listurl){
		Date start=new Date(); 
		if(listurl.isEmpty()){
			return;
		}
		List<PetSaleInfo>  batPetSaleInfo=new ArrayList<PetSaleInfo>();
		try {
			batPetSaleInfo=this.getPetListInfo(listurl);
		} catch (URISyntaxException e) {
			logger.error("batCrawlPet URISyntaxException listurl is not a url:"+e.getStackTrace());
		} catch (IOException e) {
			logger.error("batCrawlPet IOException :"+e.getStackTrace());
		}
		if(batPetSaleInfo.isEmpty()){
			logger.info("batPetSaleInfo.isEmpty ");
			return;
		}
		//写入宠物数据
		petDetailService.savePetSaleInfoList(batPetSaleInfo);
        logger.debug("花费时间:"+(new Date().getTime()-start.getTime()));
	}

	public IPetDetailService getPetDetailService() {
		return petDetailService;
	}

	public void setPetDetailService(IPetDetailService petDetailService) {
		this.petDetailService = petDetailService;
	}

	
}
