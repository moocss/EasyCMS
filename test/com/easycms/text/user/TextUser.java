package com.easycms.text.user;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easycms.common.Pager;
import com.easycms.entity.CmsUser;
import com.easycms.service.CmsUserService;

public class TextUser {
	private static CmsUserService cs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");
		cs = (CmsUserService)context.getBean("cmsUserServiceImpl");
	}

	@Test
	public void testAdd() {

	}
	@Test
	public void testDelete() {
	
	}
	@Test
	public void testDeleteIn() {

	}
	@Test
	public void testFindById() {

	}
	@Test
	public void testFindAll() {

	}
	@Test
	public void testFindByPage() {
		Pager<CmsUser> pager = cs.findByPage(0, 5);
		System.out.println(pager.getTotal());
		for(CmsUser cu : pager.getPageList()) {
			System.out.println(cu.getId()+"="+cu.getUsername());
		}
	}

}
