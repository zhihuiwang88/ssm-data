package com.json.web.exception;

import com.json.web.enums.ResultEnum;

public class ServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8102477547133982506L;

	
	public ServiceException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
	}
	
}
