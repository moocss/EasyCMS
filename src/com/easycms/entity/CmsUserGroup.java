package com.easycms.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 会员组实体
 * @author fuxin
 *
 */
public class CmsUserGroup implements Serializable{
	// 关系
	private Set<CmsChannel> viewChannels; // 只读
	private Set<CmsChannel> controlChannels; // 可操作
	
	private Integer id; // 主键
	private String name; // 组名称
	private Integer priority;// 排列顺序
	private Integer allowPerDay;// 允许每日上传KB
	private Integer allowMaxFile;// 每个文件的最大KB
	private String allowSuffix;// 允许上传的后缀
	private Integer needCaptcha;// 是否需要验证码
	private Integer needCheck;// 是否需要审核
	private Integer regDef;// 是否默认会员组
	
	//一个用户组多个用户
	private List<CmsUser> users;
	
	public Set<CmsChannel> getViewChannels() {
		return viewChannels;
	}
	public void setViewChannels(Set<CmsChannel> viewChannels) {
		this.viewChannels = viewChannels;
	}
	public Set<CmsChannel> getControlChannels() {
		return controlChannels;
	}
	public void setControlChannels(Set<CmsChannel> controlChannels) {
		this.controlChannels = controlChannels;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getAllowPerDay() {
		return allowPerDay;
	}
	public void setAllowPerDay(Integer allowPerDay) {
		this.allowPerDay = allowPerDay;
	}
	public Integer getAllowMaxFile() {
		return allowMaxFile;
	}
	public void setAllowMaxFile(Integer allowMaxFile) {
		this.allowMaxFile = allowMaxFile;
	}
	public String getAllowSuffix() {
		return allowSuffix;
	}
	public void setAllowSuffix(String allowSuffix) {
		this.allowSuffix = allowSuffix;
	}
	public Integer getNeedCaptcha() {
		return needCaptcha;
	}
	public void setNeedCaptcha(Integer needCaptcha) {
		this.needCaptcha = needCaptcha;
	}
	public Integer getNeedCheck() {
		return needCheck;
	}
	public void setNeedCheck(Integer needCheck) {
		this.needCheck = needCheck;
	}
	public Integer getRegDef() {
		return regDef;
	}
	public void setRegDef(Integer regDef) {
		this.regDef = regDef;
	}
	public List<CmsUser> getUsers() {
		return users;
	}
	public void setUsers(List<CmsUser> users) {
		this.users = users;
	}
}
