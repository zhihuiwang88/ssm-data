package com.json.web.service.impl;

import java.util.List;

import com.json.web.entity.CarCity;

public interface CarCityService {

	List<CarCity> find();

	int insertData(CarCity carCity);
	int addObject(CarCity carCity);
	CarCity findByNameAndCode(String cityName, String cityCode);

	List<CarCity> likeEngineNum(String engineNum);
	
	int updateById(CarCity carCity);
	
	int removeIds(String[] ids);
	
	List<CarCity> findIds(String[] ids);
	
}
