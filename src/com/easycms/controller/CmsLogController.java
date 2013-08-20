package com.easycms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycms.common.Pager;
import com.easycms.entity.CmsLog;
import com.easycms.service.CmsLogService;

@Controller
@RequestMapping("/log")
public class CmsLogController {
	@Resource(name = "cmsLogServiceImpl")
	private CmsLogService ls;

	// 显示后台操作
	@RequestMapping("/v_list_log.do")
	public String list(HttpServletRequest req, ModelMap model) {
		int pageSize = 3;
		int pageNo = 0;
		String sPageNo = req.getParameter("pager.offset");
		if (sPageNo != null) {
			pageNo = Integer.parseInt(sPageNo);
		}
		Pager<CmsLog> logPager = ls.findByPage(pageNo, pageSize, CmsLog.ALL_LOG);
		model.addAttribute("logPager", logPager);
		return "log/list_log";
	}

	// 显示登陆成功操作
	@RequestMapping("/v_list_login_success.do")
	public String list_success(HttpServletRequest req, ModelMap model) {
		int pageSize = 3;
		int pageNo = 0;
		String sPageNo = req.getParameter("pager.offset");
		if (sPageNo != null) {
			pageNo = Integer.parseInt(sPageNo);
		}
		Pager<CmsLog> logPager = ls.findByPage(pageNo, pageSize, CmsLog.LOGIN_SUCCESS_LOG);
		model.addAttribute("logPager", logPager);
		return "log/list_login_success";
	}

	// 显示登陆失败操作
	@RequestMapping("/v_list_login_failure.do")
	public String list_fail(HttpServletRequest req, ModelMap model) {
		int pageSize = 3;
		int pageNo = 0;
		String sPageNo = req.getParameter("pager.offset");
		if (sPageNo != null) {
			pageNo = Integer.parseInt(sPageNo);
		}
		Pager<CmsLog> logPager = ls.findByPage(pageNo, pageSize, CmsLog.LOGIN_FAILURE_LOG);
		model.addAttribute("logPager", logPager);
		return "log/list_login_failure";
	}
}
