package com.easycms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycms.service.CmsLogService;

@Controller
@RequestMapping("/log")
public class CmsLogController{
	private static final Logger logger = Logger.getLogger(CmsLogController.class);
	@Resource(name="cmsLogServiceImpl")
	private CmsLogService rs;
	// 显示后台操作
	@RequestMapping("/v_list_operating.do")
	public String list(HttpServletRequest req, ModelMap model) {
		return "log/list_operating";
	}

	// 显示登陆成功操作
	@RequestMapping("/v_list_login_success.do")
	public String list_success(HttpServletRequest req, ModelMap model) {
		return "log/list_login_success";
	}

	// 显示登陆失败操作
	@RequestMapping("/v_list_login_failure.do")
	public String list_fail(HttpServletRequest req, ModelMap model) {
		return "log/list_login_failure";
	}
}
