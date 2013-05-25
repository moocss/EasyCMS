package com.easycms.entity;

import java.io.Serializable;
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
	private boolean needCaptcha;// 是否需要验证码
	private boolean needCheck;// 是否需要审核
	private boolean regDef;// 是否默认会员组
	
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
	public boolean isNeedCaptcha() {
		return needCaptcha;
	}
	public void setNeedCaptcha(boolean needCaptcha) {
		this.needCaptcha = needCaptcha;
	}
	public boolean isNeedCheck() {
		return needCheck;
	}
	public void setNeedCheck(boolean needCheck) {
		this.needCheck = needCheck;
	}
	public boolean isRegDef() {
		return regDef;
	}
	public void setRegDef(boolean regDef) {
		this.regDef = regDef;
	}
	
}
