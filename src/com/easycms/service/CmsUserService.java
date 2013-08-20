package com.easycms.service;
import com.easycms.base.BaseDao;
import com.easycms.entity.CmsUser;
import com.easycms.entity.CmsUserExt;

public interface CmsUserService extends BaseDao<CmsUser, Integer>{
	
	/**
	 * 根据用户名得到对应的对象
	 * @param name 
	 * @return
	 */
	public CmsUser findByName(String name);
	/**
	 * 保存用户信息的同时也要保存用户扩展信息
	 * @param user
	 * @param userExt
	 */
	public void saveUser(CmsUser user, CmsUserExt userExt);
	
	/**
	 * 删除User数据的同时也要把UserExt数据也删除
	 * @param id
	 */
	public void deleteById(Integer id);
	
}
