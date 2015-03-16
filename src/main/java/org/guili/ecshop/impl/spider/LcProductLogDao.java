package org.guili.ecshop.impl.spider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.LcProduct;
import org.guili.ecshop.bean.spider.yinhang.LcPageParam;
import org.guili.ecshop.dao.spider.ILcProductLogDao;
import org.guili.ecshop.util.BasicSqlSupport;

/**
 * 理财产品dao
 * @author guilige
 *
 */
public class LcProductLogDao extends BasicSqlSupport implements ILcProductLogDao {

	private static Logger logger=Logger.getLogger(LcProductLogDao.class);
	
	@Override
	public int addLcProductLog(LcProduct lcProduct){
		int count=0;
		count=this.session.insert("org.guili.ecshop.dao.spider.ILcProductLogDao.addLcProductLog", lcProduct);
		return count;
	}

	/**
	 * 查询理财产品数量
	 */
	@Override
	public int selectLcProductCount(LcPageParam pageParam) throws Exception {
		int count=0;
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("yinhang", pageParam.getYinhang());
		paramMap.put("income", pageParam.getIncome());
		paramMap.put("saleType", pageParam.getSaleType());
		paramMap.put("orderType", pageParam.getOrderType());
		paramMap.put("days", pageParam.getDays());
		paramMap.put("daysmin", pageParam.getDaysMin());
		paramMap.put("daysmax", pageParam.getDaysMax());
		paramMap.put("incomemin", pageParam.getIncomeMin());
		paramMap.put("incomemax", pageParam.getIncomeMax());
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductCount", paramMap);
		if(list!=null && list.size()>0){
			count=(Integer)list.get(0);
		}
		logger.debug("success!");
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LcProduct> selectLcProductPage(int start, int end,
			LcPageParam pageParam) throws Exception {
		List<LcProduct> goodsList=new ArrayList<LcProduct>();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("size", end);
		paramMap.put("yinhang", pageParam.getYinhang());
		paramMap.put("income", pageParam.getIncome());
		paramMap.put("saleType", pageParam.getSaleType());
		paramMap.put("days", pageParam.getDays());
		paramMap.put("orderType", pageParam.getOrderType());
		paramMap.put("daysmin", pageParam.getDaysMin());
		paramMap.put("daysmax", pageParam.getDaysMax());
		paramMap.put("incomemin", pageParam.getIncomeMin());
		paramMap.put("incomemax", pageParam.getIncomeMax());
		goodsList=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductPage", paramMap);
		logger.debug("success!size is:"+goodsList.size());
		return goodsList;
	}

	/**
	 * 查询理财产品数量
	 */
	@Override
	public int selectLcProductByName(LcPageParam pageParam) throws Exception {
		int count=0;
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("productName", pageParam.getProductName());
		paramMap.put("startTime", pageParam.getStartTime());
		if(pageParam.getDays()!=null){
			paramMap.put("days", pageParam.getDays());
		}
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductByName", paramMap);
		if(list!=null && list.size()>0){
			count=(Integer)list.get(0);
		}
		logger.debug("success!");
		return count;
	}
	
	/**
	 * 根据id查询商品查询理财产品数量
	 */
	@Override
	public LcProduct selectLcProductById(LcPageParam pageParam) throws Exception {
		LcProduct lcProduct=new LcProduct();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", pageParam.getId());
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductById", paramMap);
		if(list!=null && list.size()>0){
			lcProduct=(LcProduct)list.get(0);
		}else{
			lcProduct=null;
		}
		logger.debug("success!");
		return lcProduct;
	}
	
	/**
	 * 根据银行查询商品查询理财产品数量(查询银行最新的理财产品)
	 */
	@Override
	public List<LcProduct> selectLcProductByCompanyName(LcPageParam pageParam) throws Exception {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("yinhang", pageParam.getYinhang());
		paramMap.put("size", pageParam.getSize());
		@SuppressWarnings("unchecked")
		List<LcProduct> list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductByCompanyName", paramMap);
		logger.debug("success!");
		return list;
	}
	
	/**
	 * <!-- 根据银行名称查询最新理财产品10个-->
	 */
	@Override
	public List<LcProduct> selectLcProductByOnSale(LcPageParam pageParam) throws Exception {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("size", pageParam.getSize());
		@SuppressWarnings("unchecked")
		List<LcProduct> list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductByOnSale", paramMap);
		logger.debug("success!");
		return list;
	}
	
	/**
	 * <!--查询同一时间段同一银行最新理财产品10个-->
	 */
	@Override
	public List<LcProduct> selectLcProductByTime(LcPageParam pageParam) throws Exception {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		
		paramMap.put("yinhang", pageParam.getYinhang());
		paramMap.put("size", pageParam.getSize());
		paramMap.put("daysmin", pageParam.getDaysMin());
		paramMap.put("daysmax", pageParam.getDaysMax());
		@SuppressWarnings("unchecked")
		List<LcProduct> list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductByTime", paramMap);
		logger.debug("success!");
		return list;
	}
	
	/**
	 * 查询需要更新的理财产品
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LcProduct> selectLcUpdateProductByCompanyName(int start, int size,LcPageParam pageParam) throws Exception {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("yinhang", pageParam.getYinhang());
		paramMap.put("start", start);
		paramMap.put("size", size);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcUpdateProductByCompanyName", paramMap);
		logger.debug("success!");
		return list;
	}
	
	/**
	 * 更新的理财产品
	 */
	@Override
	public int updateLcUpdateProduct(LcProduct lcProduct) throws Exception {
		int count=0;
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("productDetailUrl",lcProduct.getProductDetailUrl());
		paramMap.put("income", lcProduct.getIncome());
		paramMap.put("incomeType", lcProduct.getIncomeType());
		count=this.session.update("org.guili.ecshop.dao.spider.ILcProductLogDao.updateLcUpdateProduct", lcProduct);
		return count;
	}
	
	/**
	 * 查询时间段内的理财产品top num
	 * @param start
	 * @param end
	 * @param num   取各各银行在售利率高的前几个
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LcProduct> selectLcProductByDate(Date start, Date end,int num) throws Exception{
		
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("end", end);
		paramMap.put("num", num);
		@SuppressWarnings("unchecked")
		List<LcProduct> list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductByDate", paramMap);
		logger.debug("success!");
		return list;
	}

	/**
	 * 查询时间段内的理财产品top num
	 * @param start
	 * @param end
	 * @param num   取各各银行在售利率高的前几个
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LcProduct> selectLcProductByOneDay(int num) throws Exception{
		
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("num", num);
		@SuppressWarnings("unchecked")
		List<LcProduct> list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductByOneDay", paramMap);
		logger.debug("success!");
		return list;
	}
	@Override
	public List<LcProduct> selectLcProductTopByDate(Date start, Date end,
						String type, String fengxian, int num) throws Exception {
		
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("end", end);
		paramMap.put("saleType", type);
		if(fengxian!=null && !fengxian.isEmpty()){
			paramMap.put("fengxian", fengxian);
		}
		paramMap.put("num", num);
		@SuppressWarnings("unchecked")
		List<LcProduct> list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductLogDao.selectLcProductTopByDate", paramMap);
		logger.debug("success!");
		return list;
	}
	
	
}
