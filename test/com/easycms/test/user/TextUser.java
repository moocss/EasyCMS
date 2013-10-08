package com.easycms.test.user;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easycms.common.Pager;
import com.easycms.entity.CmsUser;
import com.easycms.entity.CmsUserExt;
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
		CmsUser user = new CmsUser();
		user.setUsername("test");
		user.setGroup_id(1);
		user.setPassword("116518");
		user.setEmail("测试名@163.com");
		CmsUserExt userExt = new CmsUserExt();
		userExt.setRealname("李明");
		userExt.setBirthday("1982-10-1");
		cs.saveUser(user, userExt);
	}
	@Test
	public void testDelete() {
	
	}
	@Test
	public void testDeleteIn() {

	}
	@Test
	public void testFindById() {
		CmsUser user = cs.findById(2);
		System.out.println(user.getUserGroup().getName());
	}
	@Test
	public void testFindAll() {
		List<CmsUser> users = cs.findAll();
		for(CmsUser user : users){
			System.out.println(user.getUsername());
			System.out.println(user.getUserGroup().getName());	
		}
	}
	@Test
	public void testFindByPage() {
		Pager<CmsUser> pager = cs.findByPage(0, 5);
		System.out.println(pager.getTotal());
		for(CmsUser user : pager.getPageList()) {
			System.out.println(user.getUsername());
			System.out.println(user.getUserGroup().getName());	
		}
	}

}
