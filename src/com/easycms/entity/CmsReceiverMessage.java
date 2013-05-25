package com.easycms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 站内收信实体
 * @author fuxin
 *
 */
public class CmsReceiverMessage implements Serializable{
	// 关系
	private CmsUser msgReceiverUser;// 收信人
	private CmsUser msgSendUser;// 发信人
	private CmsSite site;// 站点
	private CmsMessage message;// 站内信
	
	private Integer id;
	private String msgTitle;// 站内信标题
	private String msgContent;// 站内信内容
	private Date sendTime;// 发送时间
	private boolean msgStaus;// 消息状态 0 未读 1 已读
	private Integer msgBox;// 0 收件箱 1 发件箱 2 草稿箱 3 垃圾箱
	
	public CmsUser getMsgReceiverUser() {
		return msgReceiverUser;
	}
	public void setMsgReceiverUser(CmsUser msgReceiverUser) {
		this.msgReceiverUser = msgReceiverUser;
	}
	public CmsUser getMsgSendUser() {
		return msgSendUser;
	}
	public void setMsgSendUser(CmsUser msgSendUser) {
		this.msgSendUser = msgSendUser;
	}
	public CmsSite getSite() {
		return site;
	}
	public void setSite(CmsSite site) {
		this.site = site;
	}
	public CmsMessage getMessage() {
		return message;
	}
	public void setMessage(CmsMessage message) {
		this.message = message;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public boolean isMsgStaus() {
		return msgStaus;
	}
	public void setMsgStaus(boolean msgStaus) {
		this.msgStaus = msgStaus;
	}
	public Integer getMsgBox() {
		return msgBox;
	}
	public void setMsgBox(Integer msgBox) {
		this.msgBox = msgBox;
	}
	
}
