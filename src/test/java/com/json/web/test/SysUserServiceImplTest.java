package com.json.web.test;

import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.json.web.entity.SysUser;
import com.json.web.service.impl.SysUserServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring.xml"})
public class SysUserServiceImplTest {

	@Autowired
	private SysUserServiceImpl sysUserServiceImpl;
	private static final Logger log = Logger.getLogger(SysUserServiceImplTest.class);
	
	/**
	 * 插入数据
	 */
	@Test
	public void testInsertObject(){
		SysUser sysUser = new SysUser();
		sysUser.setUserName("李四7");
		sysUser.setPassWord("lisi");
		sysUser.setPhone("123");
//		sysUser.setCreatedDate(new Date());
//		sysUser.setModifiedDate(new Date());
		int num = sysUserServiceImpl.insertObject(sysUser);
		assertNotEquals(0, num);
	}
	
	/**
	 * 查询ID数据
	 */
	@Test
	public void testFindById(){
		Integer id = 6;
		Map<String, Object> map = sysUserServiceImpl.findById(id);
		assertNotEquals(0, map);
	}
	
	/**
	 * 查询所有数据
	 */
	@Test
	public void testFindAll(){
		List<Map<String, Object>>  list = sysUserServiceImpl.findUsers();
		for (Map<String, Object> map : list) {
			// 方法一
			Set<Entry<String, Object>>  set = map.entrySet();
			for (Entry<String, Object> entry : set) {
				System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
			}
			
			// 方法二
			/*
			Set<String> set1 = map.keySet();
			for (String key : set1) {
				System.out.println(key +"," + map.get(key));
			}*/
			
		}
		assertNotEquals(0, list.size());
	}
	
	/**
	 * 删除多条数据
	 */
	@Test
	public void removeIds() {
		String[] idStrings = {"10","11","12"};
		int num = sysUserServiceImpl.removeByIds(idStrings);
		log.info(num);
		
		assertNotEquals(0, num);
		
	}
	
	
	
}
