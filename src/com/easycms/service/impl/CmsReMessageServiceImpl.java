package com.easycms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easycms.base.AbstractBaseDao;
import com.easycms.common.Pager;
import com.easycms.entity.CmsReceiverMessage;
import com.easycms.service.CmsReMessageService;
@Service
public class CmsReMessageServiceImpl extends AbstractBaseDao<CmsReceiverMessage, Integer> implements CmsReMessageService {

	@Override
	public Pager<CmsReceiverMessage> findByBox(Integer msgBox, Integer msgReceiverUserId,
			int showPages, int pageSize) {
		String operate = ".findByPage";
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("showPages", showPages);
		maps.put("pageSize", pageSize);
		maps.put("msgBox",msgBox);
		maps.put("msgReceiverUserId", msgReceiverUserId);
		return findByKey(maps, operate);
	}

}
