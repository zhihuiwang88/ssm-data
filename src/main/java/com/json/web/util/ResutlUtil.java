package com.json.web.util;

public class ResutlUtil<T> {

	private Integer code;
	private String msg;
	private T resultData;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getResultData() {
		return resultData;
	}
	public void setResultData(T resultData) {
		this.resultData = resultData;
	}
	
	
}
