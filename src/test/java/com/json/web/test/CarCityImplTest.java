package com.json.web.test;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.json.web.entity.CarCity;
import com.json.web.service.impl.CarCityServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class CarCityImplTest {

	@Autowired
	private CarCityServiceImpl carCityServiceImpl;
	private static final Logger log = Logger.getLogger(CarCityImplTest.class);
	
	@Test
	public void testRemoveIds() {
		String[] ids = {"5","11","12"};
		int num = carCityServiceImpl.removeIds(ids);
		assertNotEquals(0, num);
		
	}
	@Test
	public void testFindIds() {
		String[] ids = {"6","7","9"};
		List<CarCity> num = carCityServiceImpl.findIds(ids);
		for (CarCity carCity : num) {
			log.info("name:" + carCity.getCityName());
		}
		assertNotEquals(0, num.size());
		
	}
	
	@Test
	public void testUpdateId() {
		CarCity carCity = new CarCity();
		carCity.setCityId(5);
		carCity.setCityName("wer");
		carCity.setCityCode("35");
		carCity.setClassNum("12");
		carCity.setRegistNum("98");
		int num = carCityServiceImpl.updateById(carCity);
		assertNotEquals(0, num);
	}
	
	
	/**
	 * 新增数据
	 */
//	@Test
	public void testInset() {
		CarCity carCity1 = new CarCity();
		carCity1.setAbbr("89");
		carCity1.setCityName("北京4");
		carCity1.setCityCode("100");
		carCity1.setClassnoNum("147");
		
		int carCity2 = carCityServiceImpl.insertData(carCity1);
		assertNotEquals(0, carCity2);
	}
	/**
	 * 新增数据@Param
	 */
	@Test
	public void testAddData() {
		CarCity carCity1 = new CarCity();
		/*carCity1.setAbbr("89");
		carCity1.setCityName("北京3");
		carCity1.setCityCode("100");
		carCity1.setClassnoNum("147");*/
		
		int carCity2 = carCityServiceImpl.addObject(carCity1);
		assertNotEquals(0, carCity2);
	}
	/**
	 * 2个参数查询
	 */
	@Test
	public void testTwoParram() {
		String cityName = "浙江";
		String cityCode = "6";
		CarCity carCity = carCityServiceImpl.findByNameAndCode(cityName, cityCode);
		log.info("testTwoParram:" + carCity.getCityName());
		assertNotEquals(null, carCity);
	}

	/**
	 * 模糊查询
	 */
	@Test
	public void testLikeParam() {
		String engineNum = "5";
		List<CarCity> list = carCityServiceImpl.likeEngineNum(engineNum);
		for (CarCity carCity : list) {
			log.info("testLikeParam:" + carCity.getCityName());
		}
		assertNotEquals(0,list.size());
	}

	/**
	 * 
	 */
	@Test
	public void testFindAll() {
		List<CarCity> list = carCityServiceImpl.find();
		for (CarCity carCity : list) {
			log.info("name:" +  carCity.getAbbr());
		}
		assertNotEquals(0,list.size());
	}

	/**
	 * 
	 */
	@Test
	public void testInset1() {

	}
}
