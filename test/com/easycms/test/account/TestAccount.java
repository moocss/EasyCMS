package com.easycms.test.account;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easycms.entity.Account;
import com.easycms.service.AccountService;


public class TestAccount {
	private static AccountService as;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");
		as = (AccountService)context.getBean("accountServiceImpl");
	}

	@Test
	public void testAdd() {
      Account account = new Account();
      account.setUsername("测试123");
      account.setPassword("123");
      as.save(account);
	}
	@Test
	public void testDelete() {
      as.delete(7);
	}
	@Test
	public void testFindById() {
      Account a = as.findById(3);
      System.out.println(a.getUsername());
	}
	@Test
	public void testFindAll() {
      List<Account> at = as.findAll();
      for(Account a : at) {
    	  System.out.println(a.getUsername());
      }
	}
	

}
