package com.easycms.service.impl;

import org.springframework.stereotype.Service;

import com.easycms.entity.Account;
import com.easycms.service.AccountService;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	@Override
	public void addAccount(Account account) {
		System.out.println("用户名："+ account.getUsername());
	}

}
