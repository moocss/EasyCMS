package com.easycms.service;
import com.easycms.base.BaseDao;
import com.easycms.entity.CmsUserGroup;

public interface CmsUserGroupService extends BaseDao<CmsUserGroup,Integer>{
	//排序
	public void updatePriority(Integer id, Integer priority);
}
