package com.easycms.service;

import javax.servlet.http.HttpServletRequest;

import com.easycms.base.BaseDao;
import com.easycms.entity.CmsLog;

public interface CmsLogService extends BaseDao<CmsLog,Integer>{
	/**
	 * 插入后台日志操作
	 * @param request
	 * @param title
	 * @param content
	 * @return
	 */
	 public void operating(HttpServletRequest request, String title, String content);
}
