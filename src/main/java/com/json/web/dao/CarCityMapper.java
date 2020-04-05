package com.json.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.json.web.entity.CarCity;

public interface CarCityMapper {

	/**
	 * 方法名称与mapper.xml中的id对应
	 * @return
	 */
	List<CarCity> findAll();

	int insertData(CarCity carCity);

	CarCity findByNameAndCode(@Param("cityname") String cityName, @Param("cityCode")  String cityCode);

	List<CarCity> likeEngineNum(@Param("enginenum") String engineNum);

	int updateById(CarCity carCity);

	int removeIds(String[] ids);

	List<CarCity> findIds(String[] ids);

	int addObject(@Param("rty") CarCity carCity);

}
