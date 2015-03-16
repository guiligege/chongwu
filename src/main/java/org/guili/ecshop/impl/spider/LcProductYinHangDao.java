package org.guili.ecshop.impl.spider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.guili.ecshop.bean.spider.LcProductYinHang;
import org.guili.ecshop.dao.spider.ILcProductYinHangDao;
import org.guili.ecshop.util.BasicSqlSupport;

public class LcProductYinHangDao extends BasicSqlSupport  implements ILcProductYinHangDao{

	/**
	 * 根据银行id查询银行信息
	 */
	@Override
	public LcProductYinHang selectLcProductYinHangById(Long id){
		LcProductYinHang lcProductYinHang=new LcProductYinHang();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductYinHangDao.selectLcProdductYinHangById",paramMap);
		lcProductYinHang=(LcProductYinHang)list.get(0);
		return lcProductYinHang;
	}
	
	/**
	 * 根据银行id查询银行信息
	 */
	@Override
	public List<LcProductYinHang> selectLcProductYinHang(){
		LcProductYinHang lcProductYinHang=new LcProductYinHang();
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.spider.ILcProductYinHangDao.selectLcProdductYinHang");
		return list;
	}

}
