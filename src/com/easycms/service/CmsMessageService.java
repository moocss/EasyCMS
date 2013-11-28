package com.easycms.service;

import org.springframework.stereotype.Service;

import com.easycms.base.BaseDao;
import com.easycms.common.Pager;
import com.easycms.entity.CmsMessage;
@Service
public interface CmsMessageService extends BaseDao<CmsMessage, Integer>{
	public Pager<CmsMessage> findByBox(Integer msgBox,Integer msgSendUserId,int showPages,int pageSize);
}
