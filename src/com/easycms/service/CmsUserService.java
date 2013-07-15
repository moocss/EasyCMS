package com.easycms.service;
import com.easycms.base.BaseDao;
import com.easycms.entity.CmsUser;

public interface CmsUserService extends BaseDao<CmsUser, Integer>{
	
	/**
	 * 根据用户名得到对应的对象
	 * @param name 
	 * @return
	 */
	public CmsUser findByName(String name);
}
