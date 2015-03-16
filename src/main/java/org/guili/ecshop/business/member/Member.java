package org.guili.ecshop.business.member;

import java.util.Date;

/**
 * 用户信息
 * @author jumbo
 */
public class Member {
	private Long id;		 //主键
	private String email;	 //邮箱
	private String nickName; //选填，如果没有就拿email当nickname
	private String password; //密码
	private Date createTime; //创建时间
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
