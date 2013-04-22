package com.easycms.service.impl;

import org.springframework.stereotype.Service;

import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.Account;
import com.easycms.service.AccountService;

@Service
public class AccountServiceImpl extends AbstractBaseDao<Account,Integer> implements AccountService{

}
