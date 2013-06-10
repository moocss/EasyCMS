package com.easycms.entity;

import java.io.Serializable;
/**
 * 内容计数实体
 * @author fuxin
 *
 */
public class CmsContentCount implements Serializable{
	//属性
	private Integer id;
	private Integer views;// 总访问数
	private Integer viewsMonth;// 月访问数
	private Integer viewsWeek;// 周访问数
	private Integer viewsDay;// 日访问数
	private Integer comments;// 总评论数
	private Integer commentsMonth;// 月评论数
	private short commentsWeek;// 周评论数
	private short commentsDay;// 日评论数
	private Integer downloads;// 总下载量
	private Integer downloadsMonth;// 月下载量
	private short downloadsWeek;// 周下载量
	private short downloadsDay;// 日下载量
	private Integer ups;// 总顶数
	private Integer upsMonth;// 月顶数
	private short upsWeek;// 周顶数
	private short upsDay;// 日顶数
	private Integer downs;// 总踩数
	
	//关系
	private CmsContent content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getViewsMonth() {
		return viewsMonth;
	}

	public void setViewsMonth(Integer viewsMonth) {
		this.viewsMonth = viewsMonth;
	}

	public Integer getViewsWeek() {
		return viewsWeek;
	}

	public void setViewsWeek(Integer viewsWeek) {
		this.viewsWeek = viewsWeek;
	}

	public Integer getViewsDay() {
		return viewsDay;
	}

	public void setViewsDay(Integer viewsDay) {
		this.viewsDay = viewsDay;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Integer getCommentsMonth() {
		return commentsMonth;
	}

	public void setCommentsMonth(Integer commentsMonth) {
		this.commentsMonth = commentsMonth;
	}

	public short getCommentsWeek() {
		return commentsWeek;
	}

	public void setCommentsWeek(short commentsWeek) {
		this.commentsWeek = commentsWeek;
	}

	public short getCommentsDay() {
		return commentsDay;
	}

	public void setCommentsDay(short commentsDay) {
		this.commentsDay = commentsDay;
	}

	public Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	public Integer getDownloadsMonth() {
		return downloadsMonth;
	}

	public void setDownloadsMonth(Integer downloadsMonth) {
		this.downloadsMonth = downloadsMonth;
	}

	public short getDownloadsWeek() {
		return downloadsWeek;
	}

	public void setDownloadsWeek(short downloadsWeek) {
		this.downloadsWeek = downloadsWeek;
	}

	public short getDownloadsDay() {
		return downloadsDay;
	}

	public void setDownloadsDay(short downloadsDay) {
		this.downloadsDay = downloadsDay;
	}

	public Integer getUps() {
		return ups;
	}

	public void setUps(Integer ups) {
		this.ups = ups;
	}

	public Integer getUpsMonth() {
		return upsMonth;
	}

	public void setUpsMonth(Integer upsMonth) {
		this.upsMonth = upsMonth;
	}

	public short getUpsWeek() {
		return upsWeek;
	}

	public void setUpsWeek(short upsWeek) {
		this.upsWeek = upsWeek;
	}

	public short getUpsDay() {
		return upsDay;
	}

	public void setUpsDay(short upsDay) {
		this.upsDay = upsDay;
	}

	public Integer getDowns() {
		return downs;
	}

	public void setDowns(Integer downs) {
		this.downs = downs;
	}

	public CmsContent getContent() {
		return content;
	}

	public void setContent(CmsContent content) {
		this.content = content;
	}
	
}
