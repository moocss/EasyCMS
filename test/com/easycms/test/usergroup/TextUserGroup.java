package com.easycms.test.usergroup;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easycms.common.Pager;
import com.easycms.entity.CmsUser;
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
	public void testDeleteIn() {
		List<String> list= new ArrayList<String>();
		list.add("1");
		list.add("2");
        cs.deleteIn(list);
	}
	@Test
	public void testFindById() {
		CmsUserGroup cug = cs.findById(2);
		//一个用户组拥有多个用户
		List<CmsUser> users = cug.getUsers();
		for(CmsUser user : users){
			System.out.println(user.getUsername());
		}
		System.out.println(cug.getName());
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
		Pager<CmsUserGroup> pager = cs.findByPage(2, 5);
		System.out.println(pager.getTotal());
		for(CmsUserGroup cug : pager.getPageList()) {
			System.out.println(cug.getId()+"="+cug.getName());
		}
	}

}
