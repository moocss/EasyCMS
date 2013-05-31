package com.easycms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycms.common.Pager;
import com.easycms.entity.CmsUser;
import com.easycms.service.CmsUserService;

@Controller
@RequestMapping("/member")
public class CmsUserController {
	@Resource(name = "cmsUserServiceImpl")
	private CmsUserService us;
	
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
}
