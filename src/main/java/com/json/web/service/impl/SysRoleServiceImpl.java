package com.json.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.json.web.dao.SysRoleDao;
import com.json.web.entity.SysRole;
import com.json.web.enums.ResultEnum;
import com.json.web.exception.ServiceException;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private SysRoleDao sysRoleDao;
	
	/** 查询所有角色信息 */
	public List<SysRole> findPageObjects() {
		List<SysRole> listRole = sysRoleDao.findPageObjects();
		return listRole;
	}

	/** 向表中写入数据 */
	public int insertObject(SysRole entity) {
		// 判断ID
		SysRole entity1 = sysRoleDao.findObjectById(entity.getId());
		if (StringUtils.isEmpty(entity1)) {
			throw new ServiceException(ResultEnum.ID_NULL_SYSROLE_ERROR);
		}
		int num = sysRoleDao.insertObject(entity);
		return num;
	}

	/** 修改角色信息 */
	public int updateObject(SysRole entity) {
		// 判断ID
		SysRole entity1 = sysRoleDao.findObjectById(entity.getId());
		if (StringUtils.isEmpty(entity1)) {
			throw new ServiceException(ResultEnum.ID_NULL_SYSROLE_ERROR);
		}
		return sysRoleDao.updateObject(entity);
	}

	/** 根据id查询角色信息 */
	public SysRole findObjectById(Integer id) {
		// 判断ID
		if (id == 0) {
			throw new ServiceException(ResultEnum.ID_NULL_SYSROLE_ERROR);
		}
		SysRole sysRole = sysRoleDao.findObjectById(id);
		return sysRole;
	}

}
