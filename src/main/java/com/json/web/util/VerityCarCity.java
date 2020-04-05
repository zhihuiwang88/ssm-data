package com.json.web.util;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.json.web.entity.CarCity;
import com.json.web.enums.ResultEnum;
import com.json.web.exception.ServiceException;

public class VerityCarCity {

	private static final Logger  log = Logger.getLogger(VerityCarCity.class);
	/**
	 * 验证catCity属性
	 * 
	 */
	
	public static void verityParam(CarCity carCity) {
		
		// 判断插入参数
		if (StringUtils.isEmpty(carCity.getCityName())) {
			log.error(" city name is null");
			throw new ServiceException(ResultEnum.CITY_NAME_NULL_ERROR);
		}
		if (StringUtils.isEmpty(carCity.getCityCode())) {
			log.error(" city code is null");
			throw new ServiceException(ResultEnum.CITY_CODE_NULL_ERROR);
		}
		if (StringUtils.isEmpty(carCity.getAbbr())) {
			log.error("  abbr is null");
			throw new ServiceException(ResultEnum.ABBR_NULL_ERROR);
		}
		
	}
	
}
