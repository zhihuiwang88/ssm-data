package com.json.web.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5213205883369605268L;

	private Integer id;
	private String userName;
	private String passWord;
	private String phone;
	private Date   createdDate;
	private Date   modifiedDate;
	
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", phone=" + phone
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
