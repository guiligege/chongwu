package org.guili.ecshop.dao.spider;
import java.util.List;

import org.guili.ecshop.bean.spider.LcProductYinHang;
/**
 * 商品日志
 * @author guili
 */
public interface ILcProductYinHangDao {
	
	public LcProductYinHang selectLcProductYinHangById(Long id) throws Exception;
	
	public List<LcProductYinHang> selectLcProductYinHang();
	
}
