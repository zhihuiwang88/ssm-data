package com.json.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.json.web.dao.CarCityMapper;
import com.json.web.entity.CarCity;
import com.json.web.enums.ResultEnum;
import com.json.web.exception.ServiceException;
import com.json.web.util.VerityCarCity;

@Service
public class CarCityServiceImpl implements CarCityService {

	@Autowired
	private CarCityMapper carCityMapper;
	
	

	public List<CarCity> find() {
		List<CarCity> list = carCityMapper.findAll();
		return list;
	}


	/**
	 * 插入数据
	 */
	public int insertData(CarCity carCity) {
		if (!StringUtils.isEmpty(carCity.getCityId())) {
			throw new ServiceException(ResultEnum.CITYID_EXIT_ERROR);
		}
		
		int carCity2 = carCityMapper.insertData(carCity);
		return carCity2;
	}


	/**
	 * 查询两个参数
	 */
	public CarCity findByNameAndCode(String cityName, String cityCode) {
		CarCity carCity2 = carCityMapper.findByNameAndCode(cityName,cityCode);
		return carCity2;
	}


	/**
	 * 模块查询
	 */
	public List<CarCity> likeEngineNum(String engineNum) {
		List<CarCity> list = carCityMapper.likeEngineNum(engineNum);
		return list;
	}

	/**
	 * 根据ID更新数据
	 */
	public int updateById(CarCity carCity) {
		if(StringUtils.isEmpty(carCity.getCityId())) {
			throw new ServiceException(ResultEnum.CITYID_NULL_ERROR);
		}
		return carCityMapper.updateById(carCity);
	}


	/**
	 * 删除多条数据
	 */
	public int removeIds(String[] ids) {
		if (ids.length == 0) {
			throw new ServiceException(ResultEnum.IDS_NULL_ERROR);
		}
		return carCityMapper.removeIds(ids);
	}


	/**
	 * 多个ID查询数据
	 */
	public List<CarCity> findIds(String[] ids) {
		if (ids.length == 0) {
			throw new ServiceException(ResultEnum.IDS_NULL_ERROR);
		}
		return carCityMapper.findIds(ids);
	}

	/**
	 * 新增使用@param
	 */
	public int addObject(CarCity carCity) {
		// 判断插入参数
		VerityCarCity.verityParam(carCity);
		return carCityMapper.addObject(carCity);
	}

}
