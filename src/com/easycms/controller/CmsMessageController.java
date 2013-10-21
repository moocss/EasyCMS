package com.easycms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycms.service.CmsLogService;
import com.easycms.service.CmsMessageService;
import com.easycms.service.CmsReMessageService;

@Controller
@RequestMapping("/message")
public class CmsMessageController {
	private static final Logger logger = Logger.getLogger(CmsUserController.class);
	@Resource(name = "cmsMessageServiceImpl")
	private CmsMessageService ms;
	@Resource(name = "cmsReMessageServiceImpl")
	private CmsReMessageService rms;
	@Resource(name = "cmsLogServiceImpl")
	private CmsLogService ls;
	// 分页显示列表
	@RequestMapping("/v_list.do")
	public String list(HttpServletRequest req, ModelMap model) {
		return "";
	}
	//删除数据
	@RequestMapping("/o_delete.do")
	public String delete(HttpServletRequest req, ModelMap model, Integer id){
		return list(req, model);
	}
}
