package org.guili.ecshop.bean.chongwu;

import java.util.HashMap;
import java.util.Map;

public class PetCategory {
//	 `id` int(18) NOT NULL AUTO_INCREMENT,
//	  `name` varchar(50) DEFAULT NULL,				  #宠物类别名称
//		`parentType` int(5) DEFAULT '1',					#父类型：1.小型犬，2.中型犬，3，大型犬 ，4.猫  5.仓鼠  6.鱼
//	  `status` int(2) DEFAULT '1',							#类型状态 为可用，0为不可用
 	private Long id;
 	private String  name;
 	private Long  parentType;
 	private int   status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParentType() {
		return parentType;
	}
	public void setParentType(Long parentType) {
		this.parentType = parentType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
