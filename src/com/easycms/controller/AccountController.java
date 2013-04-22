package com.easycms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycms.entity.Account;
import com.easycms.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController{
	@Resource(name="accountServiceImpl")
	private AccountService as;
	@RequestMapping("/add")
	public String addAccount(HttpServletRequest req){
		Account acc = new Account();
		acc.setUsername(req.getParameter("username"));
		acc.setPassword(req.getParameter("password"));
		as.save(acc);
		
		req.setAttribute("name", req.getParameter("username"));
		return "login";	
	}
}
