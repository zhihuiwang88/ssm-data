package com.json.web.test;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

//import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.json.web.entity.CarCity;
import com.json.web.service.impl.CarCityServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring.xml"})
public class MainTest {

	@Autowired
	private CarCityServiceImpl  carCityServiceImpl;
	
	// log4j
//	private static final Logger log = Logger.getLogger(CarCityServiceImpl.class);
	
	// slf4j
	private static final Logger log = LoggerFactory.getLogger(CarCityServiceImpl.class);
	
	
	@Test
	public void find() {
		List<CarCity> list = carCityServiceImpl.find();
		for (CarCity carCity : list) {
			log.info("name:"+ carCity.getCityName());
			assertNotEquals(0, list.size());
			
		}
	}
	
}
