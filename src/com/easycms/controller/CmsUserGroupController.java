package com.easycms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycms.service.CmsUserGroupService;

@Controller
public class CmsUserGroupController {
	@Resource(name="cmsUserGroupServiceImpl")
	private CmsUserGroupService cus;
	
	//查询
	@RequestMapping("/group/list.do")
	public String list(){
		return "user/showUserGroup";
	}
}
