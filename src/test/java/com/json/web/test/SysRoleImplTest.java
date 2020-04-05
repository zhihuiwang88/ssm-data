package com.json.web.test;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.json.web.entity.SysRole;
import com.json.web.service.impl.SysRoleServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class SysRoleImplTest {

	@Autowired
	private SysRoleServiceImpl sysRoleServiceImpl;
	private static final Logger log = Logger.getLogger(SysRoleImplTest.class);

	/** 查询所有角色信息 */
	@Test
	public void findPageObjects() {
		List<SysRole> list = sysRoleServiceImpl.findPageObjects();
		for (SysRole sysRole : list) {
			log.info("findPageObjects:" + sysRole.getName());
		}
		assertNotEquals(0, list.size());

	}

	/** 向表中写入数据 */
	@Test
	public void insertObject() {
		SysRole entity = new SysRole();
		entity.setName("王五");
		entity.setNote("23");
		entity.setModifiedUser("56");
		entity.setCreatedUser("87");
		int num = sysRoleServiceImpl.insertObject(entity);
		assertNotEquals(0, num);
	}

	/** 修改角色信息 */
	@Test
	public void updateObject() {
		SysRole entity = new SysRole();
		entity.setId(1);
		entity.setName("王2");
		entity.setNote("23");
		entity.setModifiedUser("56");
		entity.setCreatedUser("87");
		int num = sysRoleServiceImpl.updateObject(entity);
		assertNotEquals(0, num);
	}

	/** 根据id查询角色信息 */
	@Test
	public void findObjectById() {
		Integer id = 5;
		SysRole entity = sysRoleServiceImpl.findObjectById(id);
		log.info("=======findObjectById:" + entity);
		assertNotEquals(null, entity);
	}

}
