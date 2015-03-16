package org.guili.ecshop.bean.spider;
import java.util.Date;
/**
 * 理财产品对象
 * @author guili
 */
public class LcProductYinHang {

	private long   id;		 	//主键
	//商品基本信息
	private String code;		//机构code
	private String name; 		//机构名称
	private String englishName;	//英语名称
	private Date createTime; 	//结束时间
	private Date version; 		//版本时间
	private Integer orderid;	//排序
	private Integer status;		//状态
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	//test
	public static void main(String[] args) {
	}
}
