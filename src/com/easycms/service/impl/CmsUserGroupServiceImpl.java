package com.easycms.service.impl;

import org.springframework.stereotype.Service;

import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.CmsUserGroup;
import com.easycms.service.CmsUserGroupService;
@Service
public class CmsUserGroupServiceImpl extends AbstractBaseDao<CmsUserGroup,Integer> implements CmsUserGroupService{

	@Override
	public void updatePriority(Integer id, Integer priority) {
		CmsUserGroup cug = findById(id);
		cug.setPriority(priority);
		updateOrder(cug);
	}

}
