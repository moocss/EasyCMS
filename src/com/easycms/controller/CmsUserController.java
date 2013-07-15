package com.easycms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycms.common.Pager;
import com.easycms.entity.CmsUser;
import com.easycms.entity.CmsUserGroup;
import com.easycms.service.CmsUserGroupService;
import com.easycms.service.CmsUserService;

@Controller
@RequestMapping("/member")
public class CmsUserController {
	@Resource(name = "cmsUserServiceImpl")
	private CmsUserService us;
	@Resource(name = "cmsUserGroupServiceImpl")
	private CmsUserGroupService cus;
	// 分页显示列表
	@RequestMapping("/v_list.do")
	public String list(HttpServletRequest req, ModelMap model) {
		 int pageSize = 3;
		 int pageNo = 0;
		 String sPageNo = req.getParameter("pager.offset");
		 if(sPageNo!=null) {
			   pageNo = Integer.parseInt(sPageNo);
		   }
		 Pager<CmsUser> userPager = us.findByPage(pageNo, pageSize);
		 model.addAttribute("userPager", userPager);
		return "user/showUser";
	}
	//显示添加
	@RequestMapping("/v_add.do")
	public String showAdd(){
		return "user/showAddUser";
	}
	
	//添加数据
	@RequestMapping("/o_add.do")
	public String add(HttpServletRequest req, ModelMap model, CmsUser cg){

		return list(req, model);
	}
	
	//删除数据
	@RequestMapping("/o_delete.do")
	public String delete(HttpServletRequest req, ModelMap model, Integer id){

		return list(req, model);
	}

	//显示修改
	@RequestMapping("/v_update.do")
	public String showUpdate(HttpServletRequest req, ModelMap model, Integer id){

		return "user/updateUser";
	}
	
	//修改
	@RequestMapping("/o_update.do")
	public String update(HttpServletRequest req, ModelMap model, CmsUser cu){

		return list(req, model);
	}
}
