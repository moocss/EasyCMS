package com.easycms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.CmsUser;
import com.easycms.service.CmsUserService;
@Service
public class CmsUserServiceImpl extends AbstractBaseDao<CmsUser, Integer> implements CmsUserService{

	@Override
	public CmsUser findByName(String name) {
		String operate = ".findByName";
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("username", name);
		return findByParam(maps, operate);
	}
	
}
