package com.easycms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
/**
 * 内容 实体
 * @author fuxin
 *
 */
public class CmsContent implements Serializable{
	//关系
	private CmsSite site;
	private CmsContentType type;
	//关系
	private Set<CmsChannel> channels; 
	private Set<CmsTopic> topics;
	private Set<CmsUserGroup> userGroups;
	private Set<CmsContentTag> tags;
	private Set<CmsContentPicture> pictures;
	private Set<CmsContentAttachment> attachments;
	private Set<CmsContentTxt> contentTxtSet;
	private	Set<CmsContentCheck> contentCheckSet;
	private Set<CmsUser> collectUsers;
	
	//属性
	private Integer id;
	private Date sortDate;// 日期排序
	private byte topLevel;// 固顶级别
	private boolean hasTitleImg;// 是否有标题图
	private boolean recommend;// 是否推荐
	private byte status;// 状态
	private Integer viewsDay;// 日访问数
	private short commentsDay;// 日评论数
	private short downloadsDay;// 日下载数
	private Short upsDay;// 日顶数
	public CmsSite getSite() {
		return site;
	}
	public void setSite(CmsSite site) {
		this.site = site;
	}
	public CmsContentType getType() {
		return type;
	}
	public void setType(CmsContentType type) {
		this.type = type;
	}
	public Set<CmsChannel> getChannels() {
		return channels;
	}
	public void setChannels(Set<CmsChannel> channels) {
		this.channels = channels;
	}
	public Set<CmsTopic> getTopics() {
		return topics;
	}
	public void setTopics(Set<CmsTopic> topics) {
		this.topics = topics;
	}
	public Set<CmsUserGroup> getUserGroups() {
		return userGroups;
	}
	public void setUserGroups(Set<CmsUserGroup> userGroups) {
		this.userGroups = userGroups;
	}
	public Set<CmsContentTag> getTags() {
		return tags;
	}
	public void setTags(Set<CmsContentTag> tags) {
		this.tags = tags;
	}
	public Set<CmsContentPicture> getPictures() {
		return pictures;
	}
	public void setPictures(Set<CmsContentPicture> pictures) {
		this.pictures = pictures;
	}
	public Set<CmsContentAttachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(Set<CmsContentAttachment> attachments) {
		this.attachments = attachments;
	}
	public Set<CmsContentTxt> getContentTxtSet() {
		return contentTxtSet;
	}
	public void setContentTxtSet(Set<CmsContentTxt> contentTxtSet) {
		this.contentTxtSet = contentTxtSet;
	}
	public Set<CmsContentCheck> getContentCheckSet() {
		return contentCheckSet;
	}
	public void setContentCheckSet(Set<CmsContentCheck> contentCheckSet) {
		this.contentCheckSet = contentCheckSet;
	}
	public Set<CmsUser> getCollectUsers() {
		return collectUsers;
	}
	public void setCollectUsers(Set<CmsUser> collectUsers) {
		this.collectUsers = collectUsers;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getSortDate() {
		return sortDate;
	}
	public void setSortDate(Date sortDate) {
		this.sortDate = sortDate;
	}
	public byte getTopLevel() {
		return topLevel;
	}
	public void setTopLevel(byte topLevel) {
		this.topLevel = topLevel;
	}
	public boolean isHasTitleImg() {
		return hasTitleImg;
	}
	public void setHasTitleImg(boolean hasTitleImg) {
		this.hasTitleImg = hasTitleImg;
	}
	public boolean isRecommend() {
		return recommend;
	}
	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public Integer getViewsDay() {
		return viewsDay;
	}
	public void setViewsDay(Integer viewsDay) {
		this.viewsDay = viewsDay;
	}
	public short getCommentsDay() {
		return commentsDay;
	}
	public void setCommentsDay(short commentsDay) {
		this.commentsDay = commentsDay;
	}
	public short getDownloadsDay() {
		return downloadsDay;
	}
	public void setDownloadsDay(short downloadsDay) {
		this.downloadsDay = downloadsDay;
	}
	public Short getUpsDay() {
		return upsDay;
	}
	public void setUpsDay(Short upsDay) {
		this.upsDay = upsDay;
	}
}
