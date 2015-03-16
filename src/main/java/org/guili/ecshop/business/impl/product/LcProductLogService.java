package org.guili.ecshop.business.impl.product;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.LcProduct;
import org.guili.ecshop.bean.spider.LcProductYinHang;
import org.guili.ecshop.bean.spider.yinhang.Graph;
import org.guili.ecshop.bean.spider.yinhang.LcPageParam;
import org.guili.ecshop.business.product.ILcProductLogService;
import org.guili.ecshop.dao.spider.ILcProductLogDao;
import org.guili.ecshop.dao.spider.ILcProductYinHangDao;
import org.guili.ecshop.util.common.Validator;

/**
 * 理财产品服务类
 * @author jumbo
 */
public class LcProductLogService implements ILcProductLogService {
	
	private static Logger logger=Logger.getLogger(LcProductLogService.class);
	private ILcProductLogDao lcProductLogDao;
	private ILcProductYinHangDao lcProductYinHangDao;
	
	@Override
	public int addLcProductLog(LcProduct lcProduct) {
		try {
			return lcProductLogDao.addLcProductLog(lcProduct);
		} catch (Exception e) {
			logger.error("addProduct is error:"+lcProduct.getProductName());
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 批量插入理财产品日志(带事物的插入)
	 */
	@Override
	public void saveLcProductLogList(List<LcProduct> lcProductList) {
		 if(lcProductList==null || lcProductList.isEmpty()){
			 return ;
		 }
		 for(LcProduct lcProduct:lcProductList){
			 if(lcProduct!=null){
				 //防止重复插入。
				if(this.selectLcProductByName(lcProduct.getProductName(),lcProduct.getStartTime(),lcProduct.getDays())>0){
					 continue;
				 }
				 try {
					 lcProduct.setVersion(new Date());
					 lcProductLogDao.addLcProductLog(lcProduct);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
		 }
	}

	/**
	 * 批量更新理财产品日志(带事物的更新 )
	 */
	@Override
	public void updateLcProductLogList(List<LcProduct> lcProductList) {
		 if(lcProductList==null || lcProductList.isEmpty()){
			 return ;
		 }
		 for(LcProduct lcProduct:lcProductList){
			 if(lcProduct!=null){
				 try {
					 lcProductLogDao.updateLcUpdateProduct(lcProduct);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
		 }
	}
	
	public void setLcProductLogDao(ILcProductLogDao lcProductLogDao) {
		this.lcProductLogDao = lcProductLogDao;
	}

	
	@Override
	public int selectProductCount(LcPageParam pageParam) {
		try {
			return lcProductLogDao.selectLcProductCount(pageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<LcProduct> selectProductPage(int start, int end,
			LcPageParam pageParam) {
		try {
			return lcProductLogDao.selectLcProductPage(start, end, pageParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据理财产品名称查询理财产品数量
	 */
	@Override
	public int selectLcProductByName(String productName,Date startTime,int days) {
		LcPageParam pageParam =new LcPageParam();
		pageParam.setProductName(productName);
		pageParam.setStartTime(startTime);
		pageParam.setDays(days);
		try {
			return lcProductLogDao.selectLcProductByName(pageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 根据理财产品名称查询理财产品数量
	 */
	@Override
	public LcProduct selectLcProductById(String lcid) {
		//验证传入是否是数字
		if(!Validator.isNumber(lcid)){
			return null;
		}
		LcPageParam pageParam =new LcPageParam();
		pageParam.setId(Long.parseLong(lcid));
		try {
			return lcProductLogDao.selectLcProductById(pageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据理财产品名称查询理财产品数量
	 */
	@Override
	public List<LcProduct> selectLcProductByCompanyName(String companyName,int size) {
		//验证传入是否是数字
//		if(!Validator.isNumber(companyName)){
//			return null;
//		}
		LcPageParam pageParam =new LcPageParam();
		pageParam.setYinhang(companyName);
		pageParam.setSize(size);
		try {
			return lcProductLogDao.selectLcProductByCompanyName(pageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 查询在售理财产品
	 */
	@Override
	public List<LcProduct> selectLcProductByOnSale(int size) {
		LcPageParam pageParam =new LcPageParam();
		pageParam.setSize(size);
		try {
			return lcProductLogDao.selectLcProductByOnSale(pageParam);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 查询同银行同期限理财产品
	 */
	@Override
	public List<Graph> selectLcProductByTime(String yinhang,String days,String size)
			throws Exception {
		LcPageParam pageParam =new LcPageParam();
//		pageParam.setSize(size);
//		pageParam.setYinhang(yinhang);
		pageParam.settingLcPageParamDays(yinhang, "", "", days, "", size);
		try {
			List<LcProduct> lcProductList=lcProductLogDao.selectLcProductByTime(pageParam);
			//回显当前对象列表
			Iterator<LcProduct> iter=lcProductList.iterator();
			List<LcProduct> removeList=new ArrayList<LcProduct>();
			while(iter.hasNext()){
				if(iter.next().getIncome()<=2.0){
					removeList.add(iter.next());
				}
			}
			lcProductList.removeAll(removeList);
			return this.getMap(lcProductList);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private List<Graph> getMap(List<LcProduct> lcProductList){
		if(lcProductList==null || lcProductList.isEmpty()){
			return null;
		}
		TreeMap<String, Double> mymap=new TreeMap<String, Double>();
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");
		DecimalFormat    df   = new DecimalFormat("######0.000");
		for(LcProduct lcProduct:lcProductList){
			String date=sdf.format(lcProduct.getStartTime());
			if(mymap.containsKey(date)){
				Double inner=mymap.get(date);
				inner=(inner+lcProduct.getIncome())/2;
				mymap.put(date, Double.parseDouble(df.format(inner)));
			}else{
				mymap.put(date,lcProduct.getIncome());
			}
		}
		List<Graph> graphList=new ArrayList<Graph>();
		Iterator it = mymap.entrySet().iterator();
		while (it.hasNext()) {
			Graph graph=new Graph();
			Map.Entry entry =(Map.Entry) it.next();
			 Object key = entry.getKey();
			 Double value=(Double)entry.getValue();
			 graph.setTime(key.toString());
			 graph.setIncome(value);
			 graphList.add(graph);
			 graph=null;
		}
		return graphList;
	}

	@Override
	public LcProductYinHang selectLcProductYinHangById(Long id)
			throws Exception {
		return lcProductYinHangDao.selectLcProductYinHangById(id);
	}

	@Override
	public List<LcProductYinHang> selectLcProductYinHang() throws Exception {
		return lcProductYinHangDao.selectLcProductYinHang();
	}

	
	public void setLcProductYinHangDao(ILcProductYinHangDao lcProductYinHangDao) {
		this.lcProductYinHangDao = lcProductYinHangDao;
	}
	//测试理财seo
	public static void main(String[] args) {
		System.out.println("理财么,理财，自助理财,理财产品，银行理财，银行理财产品,互联网理财产品,理财知识,理财经验,理财产品排行榜".length());
	}

	@Override
	public List<LcProduct> selectLcUpdateProductByCompanyName(int start,
			int size, LcPageParam pageParam) throws Exception {
		return lcProductLogDao.selectLcUpdateProductByCompanyName(start, size, pageParam);
	}

	@Override
	public int updateLcUpdateProduct(LcProduct lcProduct) throws Exception {
		return lcProductLogDao.updateLcUpdateProduct(lcProduct);
	}
}
