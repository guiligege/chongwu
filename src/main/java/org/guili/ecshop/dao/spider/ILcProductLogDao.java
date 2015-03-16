package org.guili.ecshop.dao.spider;

import java.util.Date;
import java.util.List;

import org.guili.ecshop.bean.spider.LcProduct;
import org.guili.ecshop.bean.spider.yinhang.LcPageParam;
/**
 * 商品日志
 * @author guili
 */
public interface ILcProductLogDao {
	/**
	 * 添加理财商品日志
	 * @param lcProduct
	 * @return
	 * @throws Exception
	 */
	public int addLcProductLog(LcProduct lcProduct);
	
	/**
	 * 条件查询理财产品数量
	 * @param pageParam
	 * @return
	 * @throws Exception
	 */
	public int selectLcProductCount(LcPageParam pageParam) throws Exception;
	/**
	 * 条件查询理财产品分页数据
	 * @param start
	 * @param end
	 * @param pageParam
	 * @return
	 */
	public List<LcProduct> selectLcProductPage(int start,int end,LcPageParam pageParam)throws Exception;
	
	/**
	 * 根据名字查询理财产品
	 * @param pageParam
	 * @return
	 */
	public int selectLcProductByName(LcPageParam pageParam)throws Exception;
	/**
	 * 根据Id查询理财产品
	 * @param pageParam
	 * @return
	 */
	public LcProduct selectLcProductById(LcPageParam pageParam) throws Exception;
	
	/**
	 * 根据银行名称查询理财产品
	 * @param pageParam
	 * @return
	 * @throws Exception
	 */
	public List<LcProduct> selectLcProductByCompanyName(LcPageParam pageParam) throws Exception;
	
	public List<LcProduct> selectLcProductByOnSale(LcPageParam pageParam) throws Exception ;
	
	public List<LcProduct> selectLcProductByTime(LcPageParam pageParam) throws Exception;
	
	/**
	 * 查询需要更新的银行信息
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
	 * 查询在售的不同银行top n理财产品
	 * @param start
	 * @param end
	 * @param type
	 * @param fengxian
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public List<LcProduct> selectLcProductByDate(Date start, Date end,int num) throws Exception;
	
	/**
	 * 根据利率或者风险查询利率最高前n(预售和在售的)
	 * @param start
	 * @param end
	 * @param type
	 * @param fengxian
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public List<LcProduct> selectLcProductTopByDate(Date start, Date end,String type,String fengxian,int num) throws Exception;
	
	public List<LcProduct> selectLcProductByOneDay(int num)throws Exception;
}
