package com.json.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.json.web.entity.CarCity;
import com.json.web.service.impl.CarCityService;

@Controller
@RequestMapping("/car")
public class CarCityController {

	/**
	 * localhost:8081/jsondemo/car/findAll
	 */
	
	
	@Autowired
	private  CarCityService  carCityService;
	
	@GetMapping("/findAll")
	@ResponseBody
	public List<CarCity>  find() {
		List<CarCity> list =  null;
		try {
			list = carCityService.find();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return list;
	}
 	
}
