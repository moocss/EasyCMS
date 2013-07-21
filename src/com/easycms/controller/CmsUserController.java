package com.easycms.controller;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycms.common.Pager;
import com.easycms.entity.CmsUser;
import com.easycms.entity.CmsUserExt;
import com.easycms.entity.CmsUserGroup;
import com.easycms.service.CmsUserExtService;
import com.easycms.service.CmsUserGroupService;
import com.easycms.service.CmsUserService;

@Controller
@RequestMapping("/member")
public class CmsUserController {
	private static final Logger logger = Logger.getLogger(CmsUserController.class);
	@Resource(name = "cmsUserServiceImpl")
	private CmsUserService us;
	@Resource(name = "cmsUserGroupServiceImpl")
	private CmsUserGroupService ugs;
	@Resource(name = "cmsUserExtServiceImpl")
	private CmsUserExtService ues;
	
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
	public String showAdd(HttpServletRequest req, ModelMap model){
		//获的会员组
		List<CmsUserGroup> groups = ugs.findAll();
		model.addAttribute("groups", groups);
		return "user/showAddUser";
	}
	
	//添加数据
	@RequestMapping("/o_add.do")
	public String add(HttpServletRequest req, ModelMap model, CmsUser user, CmsUserExt userExt, Integer gid){
		user.setGroup_id(gid);
		us.saveUser(user, userExt);
		return list(req, model);
	}
	
	//删除数据
	@RequestMapping("/o_delete.do")
	public String delete(HttpServletRequest req, ModelMap model, Integer id){
		us.deleteById(id);
		return list(req, model);
	}

	//显示修改
	@RequestMapping("/v_update.do")
	public String showUpdate(HttpServletRequest req, ModelMap model, Integer id){
		//获得用户
		CmsUser user = us.findById(id);
		//获得用户扩展
		CmsUserExt userExt = ues.findById(id);
		//获的会员组
		List<CmsUserGroup> groups = ugs.findAll();
		
		model.addAttribute("groups", groups);
		model.addAttribute("user", user);
		model.addAttribute("userExt", userExt);
		return "user/updateUser";
	}
	
	//修改
	@RequestMapping("/o_update.do")
	public String update(HttpServletRequest req, ModelMap model,CmsUser user, CmsUserExt userExt){
		us.update(user);
		ues.update(userExt);
		//System.out.println(user.getId());
		//System.out.println(userExt.getId());
		//System.out.println(user.getGroup_id());

		//log it
		if(logger.isDebugEnabled()){
			logger.debug(model);
		}
		return list(req, model);
	}
}
