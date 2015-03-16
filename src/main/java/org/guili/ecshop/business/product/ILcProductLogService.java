package org.guili.ecshop.business.product;


import java.util.Date;
import java.util.List;

import org.guili.ecshop.bean.spider.LcProduct;
import org.guili.ecshop.bean.spider.LcProductYinHang;
import org.guili.ecshop.bean.spider.yinhang.Graph;
import org.guili.ecshop.bean.spider.yinhang.LcPageParam;

/**
 * 理财产品数据存储服务接口
 * @author jumbo
 */
public interface ILcProductLogService {

	/**
	 * 添加单个理财产品日志到数据库(无事物)
	 * @param lcProduct
	 * @return
	 */
	public int addLcProductLog(LcProduct lcProduct);
	
	/**
	 * 批量保存理财产品日志
	 * @param lcProductList
	 */
	public void saveLcProductLogList(List<LcProduct> lcProductList);
	
	/**
	 * 查询商品总数
	 * @return
	 */
	public int selectProductCount(LcPageParam pageParam);
	
	/**
	 * 分页查询商品
	 * @param start
	 * @param end
	 * @param pageParam
	 * @return
	 */
	public List<LcProduct> selectProductPage(int start, int end,
			LcPageParam pageParam);
	
	/**
	 * 根据名字查询理财产品
	 * @param pageParam
	 * @return
	 */
	public int selectLcProductByName(String productName,Date startTime,int days);
	
	public LcProduct selectLcProductById(String lcid);
	
	public List<LcProduct> selectLcProductByCompanyName(String companyName,int size) ;
	
	/**
	 * 查询在售的理财产品
	 * @param pageParam
	 * @return
	 */
	public List<LcProduct> selectLcProductByOnSale(int size);
	
	/**
	 * 查询同时间段理财产品
	 * @param pageParam
	 * @return
	 * @throws Exception
	 */
	public List<Graph> selectLcProductByTime(String yinhang,String days,String size) throws Exception  ;
	
	/**
	 * 根据id查询银行信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LcProductYinHang selectLcProductYinHangById(Long id)throws Exception  ;
	
	/**
	 * 查询有效的银行信息
	 * @return
	 * @throws Exception
	 */
	public List<LcProductYinHang> selectLcProductYinHang()throws Exception ;
	
	/**
	 * 查询需要更新的理财产品  
	 * @param start
	 * @param size
	 * @param pageParam
	 * @return
	 * @throws Exception
	 */
	public List<LcProduct> selectLcUpdateProductByCompanyName(int start, int size,LcPageParam pageParam) throws Exception;
	
	/**
	 * 更新理财产品
	 * @param lcProduct
	 * @return
	 * @throws Exception
	 */
	public int updateLcUpdateProduct(LcProduct lcProduct) throws Exception;
	
	/**
	 * 批量更新理财产品日志(带事物的更新 )
	 */
	public void updateLcProductLogList(List<LcProduct> lcProductList);
}
