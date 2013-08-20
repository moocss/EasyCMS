package com.easycms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycms.entity.CmsRole;
import com.easycms.service.CmsRoleService;

@Controller
@RequestMapping("/role")
public class CmsRoleController{
	@Resource(name="cmsRoleServiceImpl")
	private CmsRoleService rs;
	// 分页显示列表
	@RequestMapping("/v_list.do")
	public String list(HttpServletRequest req, ModelMap model) {
		 List<CmsRole> roles = rs.findAll();
		 model.addAttribute("roles", roles);
		 return "role/showRole";
	}
	//显示添加
	@RequestMapping("/v_add.do")
	public String showAdd(HttpServletRequest req, ModelMap model){
		return "role/showAddRole";
	}
	//添加数据
	@RequestMapping("/o_add.do")
	public String add(HttpServletRequest req, ModelMap model,CmsRole role){
		rs.save(role);
		return list(req, model);
	}
	//删除数据
	@RequestMapping("/o_delete.do")
	public String delete(HttpServletRequest req, ModelMap model, Integer id){
		rs.delete(id);
		return list(req, model);
	}
	//显示修改
	@RequestMapping("/v_update")
	public String showUpdate(HttpServletRequest req, ModelMap model, Integer id){
		CmsRole role = rs.findById(id);
		model.addAttribute("role", role);
		return "role/updateRole";
	}
	//修改
	@RequestMapping("/o_update.do")
	public String update(HttpServletRequest req, ModelMap model, CmsRole role){
		rs.update(role);
		return list(req, model);
	}
}
