package com.json.web.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysRole implements Serializable {

	/**
	 * "createdTime":1582785619000
	 * 角色表
	 */
	private static final long serialVersionUID = -3499373387481618488L;
	private Integer id;
	private String name;
	private String note;
	@JsonFormat(pattern="yyyy-MM:dd HH:mm:ss",locale="zh",timezone="GMT+8")
	private Date createdTime;
	@JsonFormat(pattern="yyyy-MM:dd HH:mm:ss",locale="zh",timezone="GMT+8")
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	

}
