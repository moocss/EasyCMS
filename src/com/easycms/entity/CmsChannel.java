package com.easycms.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * 栏目实体
 * @author fuxin
 *
 */
public class CmsChannel implements Serializable{
	//关系
	private CmsSite site;// 站点
	private CmsModel model;// 模板
	private CmsChannel parent;// 栏目
	//关系
	private Set<CmsChannel> child;// 栏目
	private Set<CmsUserGroup> userGroup;// 会员组
	private Set<CmsUser> users;//用户
	private Set<CmsChannelTxt> channelTxtSet;//栏目文本
	private Set<CmsChannelExt> channelExtSet;//栏目内容
	
	//属性
	private Integer id;
	private String path; // 访问路径
	private Integer lft; // 树左边
	private Integer rgt;// 树右边
	private Integer priority;// 排列顺序
	private boolean display;// 是否显示
	private boolean hasContent;// 是否有内容
	
	public CmsSite getSite() {
		return site;
	}
	public void setSite(CmsSite site) {
		this.site = site;
	}
	public CmsModel getModel() {
		return model;
	}
	public void setModel(CmsModel model) {
		this.model = model;
	}
	public CmsChannel getParent() {
		return parent;
	}
	public void setParent(CmsChannel parent) {
		this.parent = parent;
	}
	public Set<CmsChannel> getChild() {
		return child;
	}
	public void setChild(Set<CmsChannel> child) {
		this.child = child;
	}
	public Set<CmsUserGroup> getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(Set<CmsUserGroup> userGroup) {
		this.userGroup = userGroup;
	}
	public Set<CmsUser> getUsers() {
		return users;
	}
	public void setUsers(Set<CmsUser> users) {
		this.users = users;
	}
	public Set<CmsChannelTxt> getChannelTxtSet() {
		return channelTxtSet;
	}
	public void setChannelTxtSet(Set<CmsChannelTxt> channelTxtSet) {
		this.channelTxtSet = channelTxtSet;
	}
	public Set<CmsChannelExt> getChannelExtSet() {
		return channelExtSet;
	}
	public void setChannelExtSet(Set<CmsChannelExt> channelExtSet) {
		this.channelExtSet = channelExtSet;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getLft() {
		return lft;
	}
	public void setLft(Integer lft) {
		this.lft = lft;
	}
	public Integer getRgt() {
		return rgt;
	}
	public void setRgt(Integer rgt) {
		this.rgt = rgt;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public boolean isHasContent() {
		return hasContent;
	}
	public void setHasContent(boolean hasContent) {
		this.hasContent = hasContent;
	}
	
}
