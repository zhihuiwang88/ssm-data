package com.json.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.stereotype.Controller;

import com.json.web.entity.SysUser;
import com.json.web.service.impl.SysUserService;


@Controller
@RequestMapping("/sys")
public class SysUserController {

	@Autowired
	private SysUserService  sysUserService;
	
	/**
	 * 所有数据
	 */
	public List<Map<String, Object>> findAll() {
		List<Map<String, Object>>  list = null;
		try {
			list = sysUserService.findUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 插入数据
	 */
	public int insertSys(SysUser sysUser) {
		int num = 0;
		try {
			num = sysUserService.insertObject(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return    num;
	}
	
	
	/**
	 * 查询ID数据
	 */
	public Map<String, Object> findId(Integer id) {
		Map<String, Object> mapId = null;
		try {
			mapId = sysUserService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapId;
	}
	
}
