package com.easycms.entity;

import java.io.Serializable;

/**
 * 角色实体
 * @author fuxin
 *
 */
public class CmsRole implements Serializable{
	// 关系
	private CmsSite site; // 站点
	private Integer siteId;
	
	private Integer id;
	private String name; // 角色名称
	private int priority;// 排列顺序
	private boolean m_super; // 拥有所有权限
	
	public CmsSite getSite() {
		return site;
	}
	public void setSite(CmsSite site) {
		this.site = site;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean isM_super() {
		return m_super;
	}
	public void setM_super(boolean m_super) {
		this.m_super = m_super;
	}
}
