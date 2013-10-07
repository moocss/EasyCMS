package com.easycms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志实体
 * @author fuxin
 *
 */
public class CmsLog implements Serializable{
	public static final Integer ALL_LOG = 3;
	public static final Integer LOGIN_SUCCESS_LOG = 1;
	public static final Integer LOGIN_FAILURE_LOG = 2;
	// 关系
	private CmsUser user;
	private CmsSite site;
	
	private String username;
	private Integer siteid;
	
	private Integer id;
	private Integer category;// 日志类型
	private Date time; // 日志时间
	private String ip;
	private String url;
	private String title;
	private String content;// 日志内容
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSiteid() {
		return siteid;
	}
	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
