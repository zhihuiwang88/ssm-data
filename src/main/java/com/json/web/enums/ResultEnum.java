package com.json.web.enums;

public enum ResultEnum {

	
	
	ID_NULL_ERROR(101,"id is null"),
	CITYID_NULL_ERROR(102,"city_id is null"),
	CITYID_EXIT_ERROR(103,"city_id exit"),
	IDS_NULL_ERROR(104,"ids is null"),
	CITY_NAME_NULL_ERROR(105,"CITY_NAME_NULL"),
	CITY_CODE_NULL_ERROR(106,"CITY_CODE_NULl"),
	ABBR_NULL_ERROR(107,"ABBR_NULL"),
	ID_NULL_SYSROLE_ERROR(108,"id is null"),
	ID_EXIT_SYSROLE_ERROR(109,"id exit"),
	
	;
	
	private Integer code;
	private String msg;
	
	ResultEnum(Integer code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	
	
	
}
