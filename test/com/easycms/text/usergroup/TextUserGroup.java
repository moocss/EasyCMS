package com.easycms.text.usergroup;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easycms.entity.CmsUserGroup;
import com.easycms.service.CmsUserGroupService;

public class TextUserGroup {
	private static CmsUserGroupService cs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");
		cs = (CmsUserGroupService)context.getBean("cmsUserGroupServiceImpl");
	}

	@Test
	public void testAdd() {

	}
	@Test
	public void testDelete() {

	}
	@Test
	public void testFindById() {

	}
	@Test
	public void testFindAll() {
      List<CmsUserGroup> ug = cs.findAll();
      for(CmsUserGroup a : ug) {
    	  System.out.println(a.getName());
      }
	}
	@Test
	public void testFindByPage() {

	}

}
