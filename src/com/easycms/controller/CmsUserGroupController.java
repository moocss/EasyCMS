package com.easycms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycms.entity.CmsUserGroup;
import com.easycms.service.CmsUserGroupService;

@Controller
@RequestMapping("/group")
public class CmsUserGroupController {
	@Resource(name="cmsUserGroupServiceImpl")
	private CmsUserGroupService cus;
	
	//查询
	@RequestMapping("/v_list.do")
	public String list(HttpServletRequest req, ModelMap model){
		List<CmsUserGroup> groups = cus.findAll();
		model.addAttribute("groups", groups);
		return "user/showUserGroup";
	}
	
	//显示添加
	@RequestMapping("/v_add.do")
	public String showAdd(){
		return "user/showAddUserGroup";
	}
	
	//添加数据
	@RequestMapping("/o_add.do")
	public String add(HttpServletRequest req, ModelMap model, CmsUserGroup cgu){
		cus.save(cgu);
		return list(req, model);
	}
	
	//删除数据
	@RequestMapping("/o_delete.do")
	public String delete(HttpServletRequest req, ModelMap model, Integer id){
		cus.delete(id);
		return list(req, model);
	}
	
	//显示修改
	@RequestMapping("/v_update.do")
	public String showUpdate(HttpServletRequest req, ModelMap model, Integer id){
		CmsUserGroup cug = cus.findById(id);
		model.addAttribute("group", cug);
		return "user/updateUserGroup";
	}
	
	//修改
	@RequestMapping("/o_update.do")
	public String update(HttpServletRequest req, ModelMap model, CmsUserGroup cug){
		cus.update(cug);
		return list(req, model);
	}
	
	//排序
	@RequestMapping("/o_priority.do")
	public String groupOrder(HttpServletRequest req, ModelMap model, Integer id,Integer priority){
		cus.updatePriority(id, priority);
		List<CmsUserGroup> groups = cus.findAll();
		model.addAttribute("groups", groups);
		return list(req, model);
	}
	
}
