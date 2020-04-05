package com.json.web.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.json.web.entity.SysRole;
import com.json.web.service.impl.SysRoleService;
import com.json.web.test.SysRoleImplTest;

@Controller
@RequestMapping("/sys")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;
	private static final Logger log = Logger.getLogger(SysRoleController.class);
	
	/**
	 * 角色信息
	 * localhost:8081/ssm-demo/sys/findAll
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public List<SysRole> findAll() {
		List<SysRole> list = null;
		try {
			list = sysRoleService.findPageObjects();
		} catch (Exception e) {
			log.error("findAll:" + list);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 *  localhost:8081/ssm-demo/sys/show
	 * 显示信息
	 * @return
	 */
	@RequestMapping("/show")
	public String show() {
		return "sys/roles";
	}
	
}
