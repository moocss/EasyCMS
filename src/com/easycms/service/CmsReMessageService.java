package com.easycms.service;

import org.springframework.stereotype.Service;

import com.easycms.base.BaseDao;
import com.easycms.common.Pager;
import com.easycms.entity.CmsReceiverMessage;
@Service
public interface CmsReMessageService extends BaseDao<CmsReceiverMessage, Integer>{
	public Pager<CmsReceiverMessage> findByBox(Integer msgBox,Integer msgReceiverUserId,int showPages,int pageSize);
}
