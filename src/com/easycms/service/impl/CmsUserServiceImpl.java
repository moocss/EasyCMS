package com.easycms.service.impl;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.CmsUser;
import com.easycms.entity.CmsUserExt;
import com.easycms.service.CmsUserExtService;
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

	@Resource(name = "cmsUserExtServiceImpl")
	private CmsUserExtService ues;
	
	@Override
	public void saveUser(CmsUser user, CmsUserExt userExt) {
		save(user);
		userExt.setUid(user.getId());
		ues.save(userExt);
	}
	
	@Override
	public void deleteById(Integer id) {
		//先删除关联外键的userExt表中的数据
		ues.delete(id);
		//然后再删除user表中的数据
		delete(id);
	}
}
