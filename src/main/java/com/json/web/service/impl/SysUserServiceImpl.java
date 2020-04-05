package com.json.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.json.web.dao.SysUserDao;
import com.json.web.entity.SysUser;
import com.json.web.enums.ResultEnum;
import com.json.web.exception.ServiceException;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	
	/**
	 * 查询所有数据
	 */
	public List<Map<String, Object>> findUsers() {
		List<Map<String, Object>> list = sysUserDao.findUsers();
		return list;
	}

	/**
	 * 根据ID查询数据
	 */
	public Map<String, Object> findById(Integer id) {
		if (StringUtils.isEmpty(id)) {
			throw new ServiceException(ResultEnum.ID_NULL_ERROR);
		}
		Map<String, Object> map = sysUserDao.findById(id);
		return map;
	}

	/**
	 * 插入一条数据
	 */
	public int insertObject(SysUser sysUser) {
		int num = sysUserDao.insertObject(sysUser);
		return num;
	}

	/**
	 * ids={1,2,3,4}
	 * 删除多条数据
	 */
	public int removeByIds(String[] ids) {
		if (ids.length == 0) {
			throw new ServiceException(ResultEnum.IDS_NULL_ERROR);
		}
		return sysUserDao.removeByIds(ids);
	}

}
