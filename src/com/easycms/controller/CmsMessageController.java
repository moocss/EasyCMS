package com.easycms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.easycms.service.CmsLogService;
import com.easycms.service.CmsMessageService;
import com.easycms.service.CmsReMessageService;

@Controller
@RequestMapping("/message")
public class CmsMessageController {
	private static final Logger logger = Logger.getLogger(CmsUserController.class);
	@Resource(name = "cmsMessageServiceImpl")
	private CmsMessageService ms;
	@Resource(name = "cmsReMessageServiceImpl")
	private CmsReMessageService rms;
	@Resource(name = "cmsLogServiceImpl")
	private CmsLogService ls;
	
	/**
	 * 列表
	 * @param req
	 * @param type 信件邮箱 0收件箱 1发件箱 2草稿箱 3垃圾箱
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_list.do")
	public String list(HttpServletRequest req,ModelMap model) {
		return "message/showMessage";
	}
	/**
	 * 发送站内信
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_add.do")
	public String messageAdd(HttpServletRequest req,ModelMap model){
		return "message/addMessage";
	}
	/**
	 * 回复
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_reply.do")
	public String messageReply(HttpServletRequest req,ModelMap model){
		return "message/ReplyMessage";
	}
	
	/**
	 * 直接发送
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_send.do")
	public String messageSend(HttpServletRequest req,ModelMap model){
		return "";
	}
	
	/**
	 * 存草稿
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_save.do")
	public String messageSave(HttpServletRequest req,ModelMap model){
		return "";
	}
	
	/**
	 * 发送
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_tosend.do")
	public String messageTosend(HttpServletRequest req,ModelMap model){
		return "";
	}
	
	/**
	 * 修改
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_edit.do")
	public String messageEdit(HttpServletRequest req,ModelMap model){
		return "";
	}
	
	/**
	 * 更新
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_update.do")
	public String messageUpdate(HttpServletRequest req,ModelMap model){
		return "";
	}
	
	/**
	 * 阅读
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_read.do")
	public String messageRead(HttpServletRequest req,ModelMap model){
		return "";
	}
	
	/**
	 * 转发
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_forward.do")
	public String messageForward(HttpServletRequest req,ModelMap model){
		return "";
	}

	/**
	 * 清空信息到垃圾箱
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_trash.do")
	public String messageTrash(HttpServletRequest req,ModelMap model){
		return "";
	}
	
	/**
	 * 还原垃圾箱信息
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_revert.do")
	public String messageRevert(HttpServletRequest req,ModelMap model){
		return "";
	}
	
	/**
	 * 清空垃圾箱信息
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/v_empty.do")
	public String messageEmpty(HttpServletRequest req,ModelMap model){
		return "";
	}
	

	// 查找未读信息条数
	@RequestMapping("/v_unread.do")
	public void findUnreadMessagesByUser(HttpServletRequest req,ModelMap model){
		
	}
}
