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
		CmsUserGroup cug = new CmsUserGroup();
		cug.setName("某某人3");
		cug.setPriority(2);
		cug.setAllowPerDay(3);
		cug.setAllowMaxFile(1500);
		cug.setAllowSuffix(".png");
		cug.setNeedCaptcha(1);
		cug.setNeedCheck(1);
		cug.setRegDef(0);
		cs.save(cug);
	}
	@Test
	public void testDelete() {
		cs.delete(4);
	}
	@Test
	public void testFindById() {
		CmsUserGroup cug = cs.findById(2);
		System.out.print(cug.getName());
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
