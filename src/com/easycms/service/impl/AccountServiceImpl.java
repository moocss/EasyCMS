package com.easycms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easycms.entity.Account;
import com.easycms.mapper.AccountMapper;
import com.easycms.service.AccountService;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	@Resource
	private AccountMapper am;
	@Override
	public void addAccount(Account account) {
		am.add(account);
		System.out.println("密码："+account.getPassword());
		System.out.println("用户名："+ account.getUsername());
	}

}
