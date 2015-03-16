package org.guili.ecshop.bean.chongwu;

import java.util.Date;

public class PetSaleInfo {
//	`id` int(18) NOT NULL AUTO_INCREMENT,
//	  `title` varchar(50) DEFAULT NULL,				#标题
//		`titlehash` int(18) DEFAULT '0',	      #标题hash（用来快速查找title是否重复,防止重复抓取）
//		`nickName` varchar(20) DEFAULT NULL,		#发布者称呼
//	  `qq` varchar(20) DEFAULT NULL,					#发布者qq
//		`telephone` varchar(100) DEFAULT NULL,  #发布者手机
//	  `city` varchar(50) DEFAULT NULL,        #发布者城市
//	  `adress` varchar(50) DEFAULT NULL,			#地址
//	  `adressId` int(18) DEFAULT '0',		      #地址id
//	  `createTime` datetime DEFAULT NULL,			#创建时间
//	  `age` varchar(20) DEFAULT NULL,					#宠物年龄
//	  `yimiao` varchar(30) DEFAULT NULL,		  #疫苗情况
//	  `category` varchar(50) DEFAULT NULL,		#品种
//	  `categoryId` int(18) DEFAULT '0',		    #品种id
//	  `price` int(10) DEFAULT NULL,						#售价
//	  `sex` varchar(50) DEFAULT NULL,					 #宠物性别
//	  `desc` varchar(500) DEFAULT NULL,				 #宠物信息描述
//	  `imageDetail1` varchar(200) DEFAULT NULL,#宠物信息图片
//	  `imageDetail2` varchar(200) DEFAULT NULL,#宠物信息图片
//	  `imageDetail3` varchar(200) DEFAULT NULL,#宠物信息图片
//	  `imageDetail4` varchar(200) DEFAULT NULL,#宠物信息图片
//		`status` int(2) DEFAULT '1', 						#信息状态 1为可用，0为不可用
	private Long id;
	private String title;
	private Long titlehash;
	private String nickName;
	private String qq;
	private String telephone;
	private String city;
	private String adress;
	private Long adressId;
	private Date createTime;
	private String age;
	private String yimiao;
	private String category;
	private Long categoryId;
	private int  price;
	private String sex;
	private String descrip;
	private String imageDetail1;
	private String imageDetail2;
	private String imageDetail3;
	private String imageDetail4;
	private int status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getYimiao() {
		return yimiao;
	}
	public void setYimiao(String yimiao) {
		this.yimiao = yimiao;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getImageDetail1() {
		return imageDetail1;
	}
	public void setImageDetail1(String imageDetail1) {
		this.imageDetail1 = imageDetail1;
	}
	public String getImageDetail2() {
		return imageDetail2;
	}
	public void setImageDetail2(String imageDetail2) {
		this.imageDetail2 = imageDetail2;
	}
	public String getImageDetail3() {
		return imageDetail3;
	}
	public void setImageDetail3(String imageDetail3) {
		this.imageDetail3 = imageDetail3;
	}
	public String getImageDetail4() {
		return imageDetail4;
	}
	public void setImageDetail4(String imageDetail4) {
		this.imageDetail4 = imageDetail4;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getTitlehash() {
		return titlehash;
	}
	public void setTitlehash(Long titlehash) {
		this.titlehash = titlehash;
	}
	public Long getAdressId() {
		return adressId;
	}
	public void setAdressId(Long adressId) {
		this.adressId = adressId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
}
