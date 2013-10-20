package com.easycms.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycms.common.Pager;
import com.easycms.entity.CmsLog;
import com.easycms.service.CmsLogService;

@Controller
@RequestMapping("/log")
public class CmsLogController {
	private static final Logger logger = Logger.getLogger(CmsLogController.class);
	@Resource(name = "cmsLogServiceImpl")
	private CmsLogService ls;

	// 显示后台操作
	@RequestMapping("/v_list_log.do")
	public String listOperating(HttpServletRequest req, ModelMap model) {
		int pageSize = 10;
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
	public String listLoginSuccess(HttpServletRequest req, ModelMap model) {
		int pageSize = 10;
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
	public String listLoginFailure(HttpServletRequest req, ModelMap model) {
		int pageSize = 10;
		int pageNo = 0;
		String sPageNo = req.getParameter("pager.offset");
		if (sPageNo != null) {
			pageNo = Integer.parseInt(sPageNo);
		}
		Pager<CmsLog> logPager = ls.findByPage(pageNo, pageSize, CmsLog.LOGIN_FAILURE_LOG);
		model.addAttribute("logPager", logPager);
		return "log/list_login_failure";
	}
	
	//删除后台操作日志
	@RequestMapping("/o_delete_operating.do")
	public String deleteOperating(HttpServletRequest req,ModelMap model,Integer id){
		ls.delete(id);
		return listOperating(req, model);
	}
	//批量删除后台操作日志
	@RequestMapping("/o_delete_operating_in.do")
	public String deleteOperatingIn(HttpServletRequest req,ModelMap model,String[] ids){
		List<String> list = new ArrayList<String>();
		for (String id : ids) {
			list.add(id);
		}
		ls.deleteIn(list);
		return listOperating(req, model);
	}
	
	//登陆成功日志的删除
	@RequestMapping("/o_delete_login_success.do")
	public String deleteLoginSuccess(HttpServletRequest req,ModelMap model,Integer id){
		ls.delete(id);
		return listLoginSuccess(req, model);
	}
	//登陆成功日志的批量删除
	@RequestMapping("/o_delete_login_success_in.do")
	public String deleteLoginSuccessIn(HttpServletRequest req,ModelMap model,String[] ids){
		List<String> list = new ArrayList<String>();
		for (String id : ids) {
			list.add(id);
		}
		ls.deleteIn(list);
		return listLoginSuccess(req, model);
	}
	
	//登陆失败日志的删除
	@RequestMapping("/o_delete_login_failure.do")
	public String deleteLoginFailure(HttpServletRequest req,ModelMap model,Integer id){
		ls.delete(id);
		return listLoginFailure(req, model);
	}
	//登陆失败日志的批量删除
	@RequestMapping("/o_delete_login_failure_in.do")
	public String deleteLoginFailureIn(HttpServletRequest req,ModelMap model,String[] ids){
		List<String> list = new ArrayList<String>();
		for (String id : ids) {
			list.add(id);
		}
		ls.deleteIn(list);	
		return listLoginFailure(req, model);
	}
	
	//后台日志查询
	@RequestMapping("/find_log.do")
	public String queryLog(HttpServletRequest req, ModelMap model, String username, String ip, String title){
		findLog(req, model, CmsLog.ALL_LOG, username, ip, title);
		return "log/list_log";
		
	}
	//登录成功日志查询
	@RequestMapping("/find_log_success.do")
	public String queryLogSuccess(HttpServletRequest req, ModelMap model, String username, String ip){
		findLog(req, model, CmsLog.LOGIN_SUCCESS_LOG, username, ip, null);
		return "log/list_login_success"; 
	}
	//登录失败日志查询
	@RequestMapping("/find_log_failure.do")
	public String queryLogFailure(HttpServletRequest req, ModelMap model,String ip){
		findLog(req, model, CmsLog.LOGIN_FAILURE_LOG, null, ip, null);
		return "log/list_login_failure"; 
	}
	
	//组合查询公共方法
	private void findLog(HttpServletRequest req, ModelMap model, Integer category, String username, String ip, String title){
		int pageSize = 10;
		int pageNo = 0;
		String sPageNo = req.getParameter("pager.offset");
		if (sPageNo != null) {
			pageNo = Integer.parseInt(sPageNo);
		}
		Pager<CmsLog> logPager = ls.findByKey(category,username, ip, title, pageNo, pageSize);
		model.addAttribute("username",username);
		model.addAttribute("ip", ip);
		model.addAttribute("title", title);
		model.addAttribute("logPager", logPager);
	}
}
