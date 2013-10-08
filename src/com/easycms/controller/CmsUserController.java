package com.easycms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easycms.common.CaptchaServlet;
import com.easycms.common.MD5;
import com.easycms.common.Pager;
import com.easycms.entity.CmsUser;
import com.easycms.entity.CmsUserExt;
import com.easycms.entity.CmsUserGroup;
import com.easycms.service.CmsLogService;
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
	@Resource(name = "cmsLogServiceImpl")
	private CmsLogService ls;
	
	// 分页显示列表
	@RequestMapping("/v_list.do")
	public String list(HttpServletRequest req, ModelMap model) {
		 int pageSize = 10;
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
		user.setPassword(MD5.MD5Encode(user.getPassword()));
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
		user.setPassword(MD5.MD5Encode(user.getPassword()));
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
	
	//登陆
	@RequestMapping("/login.do")
	public String login(HttpServletRequest req, ModelMap model,CmsUser user, String verifyCode) {
		String captcha = CaptchaServlet.getStoredCaptchaString(req);
		if(StringUtils.isNotBlank(captcha)){
			if(captcha.equalsIgnoreCase(verifyCode)) {
				CmsUser cu = us.findByName(user.getUsername());
				if(cu != null){
					if(cu.getPassword().equals(MD5.MD5Encode(user.getPassword()))){
						//CmsUser cus = us.login(user);
						logger.info("登录密码："+cu.getUsername() +"用户名：" +cu.getPassword());
						HttpSession session = req.getSession();
						session.setAttribute("user", cu);
						ls.loginSucssessLog(req, "登录成功！");
						return "index";
					}else{
						ls.loginFailureLog(req, "登录失败！","登录密码："+user.getUsername() +"用户名：" +user.getPassword());
						return "login";
					}
				}else{
					ls.loginFailureLog(req, "登录失败！","登录密码："+user.getUsername() +"用户名：" +user.getPassword());
					return "login";
				}
				
			}else{
				ls.loginFailureLog(req, "登录失败！","登录密码："+user.getUsername() +"用户名：" +user.getPassword());
				return "login";
			}
		}else{
			ls.loginFailureLog(req, "登录失败！","登录密码："+user.getUsername() +"用户名：" +user.getPassword());
			return "login";
		}



		//验证码不能为空
		/*if(StringUtils.isNotBlank(captcha)){
			if(captcha.equalsIgnoreCase(verifyCode)) {
				user.setPassword(MD5.MD5Encode(user.getPassword()));
				user.setUsername(user.getUsername());
				CmsUser cu = us.login(user);
				logger.info("登录密码："+cu.getUsername() +"用户名：" +cu.getPassword());
				HttpSession session = req.getSession();
				session.setAttribute("user", cu);
				//设置session超时时间
				//session.setMaxInactiveInterval(100);
				return "index";
			}else{
				return "login";
			}
		}*/
		//return "login";
	}
	

	@RequestMapping(value="/logoutpage",method=RequestMethod.GET)
	public String logoutpage(){
		return "login";
	}
	
	//注销
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, ModelMap model){
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/member/logoutpage";
	}
	
	//注册跳转链接
	@RequestMapping("/register")
	public String register(HttpServletRequest req, ModelMap model){
		return "register";
	}
	//用户注册操作
	@RequestMapping("/register.do")
	public String registerOperating(HttpServletRequest req, ModelMap model, CmsUser user, CmsUserExt userExt, Integer gid, String verifyCode){
		String captcha = CaptchaServlet.getStoredCaptchaString(req);
		if(StringUtils.isNotBlank(captcha)){
			if(captcha.equalsIgnoreCase(verifyCode)) {
				user.setGroup_id(gid);
				user.setPassword(MD5.MD5Encode(user.getPassword()));
				us.saveUser(user, userExt);
				logger.info("有用户注册了 name={"+ user.getUsername() +"}");
				return "login";
			}else{
				return "register";
			}
		}else{
			return "register";
		}
	}
	
	//找回密码跳转链接
	@RequestMapping("/forgot")
	public String forgot(HttpServletRequest req, ModelMap model){
		return "forgot";
	}
	
	//找回密码操作
	@RequestMapping("/forgot.do")
	public String forgotOperating(HttpServletRequest req, ModelMap model){
		return null;
	}
}
