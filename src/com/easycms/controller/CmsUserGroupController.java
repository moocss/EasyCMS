package com.easycms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycms.entity.CmsUserGroup;
import com.easycms.service.CmsLogService;
import com.easycms.service.CmsUserGroupService;

@Controller
@RequestMapping("/group")
public class CmsUserGroupController {
	private static final Logger logger = Logger.getLogger(CmsUserGroupController.class);
	@Resource(name="cmsUserGroupServiceImpl")
	private CmsUserGroupService cus;
	@Resource(name="cmsLogServiceImpl")
	private CmsLogService ls;
	//查询
	@RequestMapping("/v_list.do")
	public String list(HttpServletRequest req, ModelMap model){
		List<CmsUserGroup> groups = cus.findAll();
		model.addAttribute("groups", groups);
		return "group/showUserGroup";
	}
	
	//显示添加
	@RequestMapping("/v_add.do")
	public String showAdd(){
		return "group/showAddUserGroup";
	}
	
	//添加数据
	@RequestMapping("/o_add.do")
	public String add(HttpServletRequest req, ModelMap model, CmsUserGroup cgu){
		cus.save(cgu);
		logger.info("add CmsUserGroup name={"+ cgu.getName() +"}");
		ls.operating(req, "添加用户组操作", "添加的 : name=" + cgu.getName());
		return list(req, model);
	}
	
	// 删除数据
	@RequestMapping("/o_delete.do")
	public String delete(HttpServletRequest req, ModelMap model, Integer id) {
		cus.delete(id);
		logger.info("delete CmsUserGroup name={"+ id +"}");
		ls.operating(req, "删除一个用户组操作", "删除的 : id=" + id);
		return list(req, model);
	}
	
	//批量删除
	@RequestMapping("/o_delete_in.do")
	public String deleteIn(HttpServletRequest req, ModelMap model){
		String[] ids = req.getParameterValues("ids");
		if (ids != null) {
			List<String> list= new ArrayList<String>();
			for (String id : ids) {
				list.add(id);
			}
			cus.deleteIn(list);
			logger.info("delete CmsUserGroup name={"+ ids +"}");
			ls.operating(req, "批量删除一些用户组", "删除的 : id=" + ids);
		}
		return list(req, model);
	}
	
	//显示修改
	@RequestMapping("/v_update.do")
	public String showUpdate(HttpServletRequest req, ModelMap model, Integer id){
		CmsUserGroup cug = cus.findById(id);
		model.addAttribute("group", cug);
		return "group/updateUserGroup";
	}
	
	//修改
	@RequestMapping("/o_update.do")
	public String update(HttpServletRequest req, ModelMap model, CmsUserGroup cug){
		cus.update(cug);
		logger.info("update CmsUserGroup id={}."+ cug.getId());
		ls.operating(req, "更新了一个用户组操作", "更新的 : id=" + cug.getId());
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
