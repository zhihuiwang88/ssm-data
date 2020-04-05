package com.json.web.dao;

import java.util.List;
import java.util.Map;

import com.json.web.entity.SysUser;

public interface SysUserDao {

	List<Map<String, Object>> findUsers();

	Map<String, Object> findById(Integer id);

	int insertObject(SysUser sysUser);

	int removeByIds(String[] ids);

}
