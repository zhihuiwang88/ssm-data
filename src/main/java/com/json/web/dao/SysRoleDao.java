package com.json.web.dao;

import java.util.List;

import com.json.web.entity.SysRole;

public interface SysRoleDao {

	 /**查询所有角色信息*/
	 List<SysRole> findPageObjects();
	 /**向表中写入数据*/
    int insertObject(SysRole entity);
	 /**修改角色信息*/
    int updateObject(SysRole entity);
	 /**根据id查询角色信息*/
    SysRole findObjectById(Integer id);
}
