package org.guili.ecshop.bean.spider;

import java.util.Date;

/**
 * 用于分页查询的参数
 * @author guili
 */
public class PageParam {
	private int start;
	private int size;
	//查询条件
	private String resourceStore;	//来源商城		
	private String type;			//商品类型
	private Double zhekou;			//折扣
	private String goodsFee;		//邮费
	private Date createTime;		//创建时间
	private String isSoldout;		//商品状态
	private String shortStore;		//商家段链接
	private Long activityId;		//活动id
	private Long categoryId;		//类别id
	private Long storeId;			//商家id
	private Double minzhekou;		//折扣区间大
	private Double maxzhekou;		//折扣区间小
	
	public Double getMinzhekou() {
		return minzhekou;
	}
	public void setMinzhekou(Double minzhekou) {
		this.minzhekou = minzhekou;
	}
	public Double getMaxzhekou() {
		return maxzhekou;
	}
	public void setMaxzhekou(Double maxzhekou) {
		this.maxzhekou = maxzhekou;
	}
	public Double getZhekou() {
		return zhekou;
	}
	public void setZhekou(Double zhekou) {
		this.zhekou = zhekou;
	}
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
	public String getResourceStore() {
		return resourceStore;
	}
	public void setResourceStore(String resourceStore) {
		this.resourceStore = resourceStore;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGoodsFee() {
		return goodsFee;
	}
	public void setGoodsFee(String goodsFee) {
		this.goodsFee = goodsFee;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getIsSoldout() {
		return isSoldout;
	}
	public void setIsSoldout(String isSoldout) {
		this.isSoldout = isSoldout;
	}
	public String getShortStore() {
		return shortStore;
	}
	public void setShortStore(String shortStore) {
		this.shortStore = shortStore;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
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
