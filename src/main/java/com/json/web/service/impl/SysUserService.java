package com.json.web.service.impl;

import java.util.List;
import java.util.Map;

import com.json.web.entity.SysUser;

public interface SysUserService {

	/**
	 * 查询所有数据，根据ID查询单条，插入数据
	 * 
	 */
	List<Map<String, Object>> findUsers();

	Map<String, Object> findById(Integer id);

	int insertObject(SysUser sysUser);

	int removeByIds(String[] ids);
	
}
