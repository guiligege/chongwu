package org.guili.ecshop.bean.common;

public class TestBean {
	private String tId;
	private String tName;
	private String tAge;
	private String tEmail;
	
	
	public TestBean(String tId, String tName, String tAge, String tEmail) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.tAge = tAge;
		this.tEmail = tEmail;
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettAge() {
		return tAge;
	}
	public void settAge(String tAge) {
		this.tAge = tAge;
	}
	public String gettEmail() {
		return tEmail;
	}
	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}
	
}
