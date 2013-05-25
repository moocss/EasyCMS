package com.easycms.entity;

import java.io.Serializable;

/**
 * 用户站点实体
 * @author fuxin
 *
 */
public class CmsUserSite implements Serializable{
	// 关系
	private CmsUser user;
	private CmsSite site;
	
	private Integer id; // 主键
	private byte checkStep;// 审核级别
	private boolean allChannel;// 是否拥有所有栏目的权限
	public CmsUser getUser() {
		return user;
	}
	public void setUser(CmsUser user) {
		this.user = user;
	}
	public CmsSite getSite() {
		return site;
	}
	public void setSite(CmsSite site) {
		this.site = site;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public byte getCheckStep() {
		return checkStep;
	}
	public void setCheckStep(byte checkStep) {
		this.checkStep = checkStep;
	}
	public boolean isAllChannel() {
		return allChannel;
	}
	public void setAllChannel(boolean allChannel) {
		this.allChannel = allChannel;
	}
	
}
