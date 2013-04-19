package com.easycms.mapper;

import com.easycms.entity.Account;

public interface AccountMapper extends SqlMapper {
	/**
	 * 添加操作
	 * @param account
	 */
	public void add(Account account);
	/**
	 * 删除操作
	 * @param id
	 */
	public void delete(int id);
}
