package org.guili.ecshop.bean.spider;

/**
 * 购物经验查询对象
 * @author guili
 */
public class PageExperienceParam {
	private int start;
	private int size;
	//查询条件
	private Long categoryId;		//类别id
	private Long storeId;			//商家id
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

}
