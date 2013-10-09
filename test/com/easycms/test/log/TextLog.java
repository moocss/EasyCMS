package com.easycms.test.log;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easycms.common.Pager;
import com.easycms.entity.CmsLog;
import com.easycms.service.CmsLogService;


public class TextLog {
	private static CmsLogService ls;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");
		ls = (CmsLogService)context.getBean("cmsLogServiceImpl");
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
		Pager<CmsLog> pager = ls.findByPage(0, 0,100);
		System.out.println(pager.getTotal());
		for(CmsLog log : pager.getPageList()) {
			System.out.println(log.getUsername());
			System.out.println(log.getCategory());
		}
	}
	
	@Test
	public void testFindByKey() {
		Pager<CmsLog> pager = ls.findByKey(CmsLog.ALL_LOG, "fuxin", "127.0.0.1", "用户", 0, 100);
		System.out.println("有记录："+pager.getTotal());
		for(CmsLog log : pager.getPageList()) {
			System.out.println("title:"+log.getTitle());
			System.out.println("ip:"+log.getIp());
		}
	}

}
