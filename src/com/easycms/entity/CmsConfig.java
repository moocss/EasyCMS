package com.easycms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 配置实体
 * @author fuxin
 *
 */
public class CmsConfig implements Serializable{
	//关系
	private Set<CmsMarkConfig>  markConfig;
	private Set<CmsEmailConfig> emailConfig;
	//属性
	private Integer id;
	private String contextPath;// 部署路径
	private String servletPoint;// servlet挂载点
	private Integer port;// 端口
	private String dbFileUri;// 数据库附件访问地址
	private boolean uploadToDb;// 上传附件至数据库
	private boolean defImg;// 图片不存时默认图片
	private String loginUrl;// 登陆地址
	private String processUrl;// 登陆后处理地址
	private Date countClearTime;// 计数器清除时间
	private Date countCopyTime;// 计数器拷贝时间
	private Date downloadTime;// 下载的有效时间
	public Set<CmsMarkConfig> getMarkConfig() {
		return markConfig;
	}
	public void setMarkConfig(Set<CmsMarkConfig> markConfig) {
		this.markConfig = markConfig;
	}
	public Set<CmsEmailConfig> getEmailConfig() {
		return emailConfig;
	}
	public void setEmailConfig(Set<CmsEmailConfig> emailConfig) {
		this.emailConfig = emailConfig;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public String getServletPoint() {
		return servletPoint;
	}
	public void setServletPoint(String servletPoint) {
		this.servletPoint = servletPoint;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getDbFileUri() {
		return dbFileUri;
	}
	public void setDbFileUri(String dbFileUri) {
		this.dbFileUri = dbFileUri;
	}
	public boolean isUploadToDb() {
		return uploadToDb;
	}
	public void setUploadToDb(boolean uploadToDb) {
		this.uploadToDb = uploadToDb;
	}
	public boolean isDefImg() {
		return defImg;
	}
	public void setDefImg(boolean defImg) {
		this.defImg = defImg;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getProcessUrl() {
		return processUrl;
	}
	public void setProcessUrl(String processUrl) {
		this.processUrl = processUrl;
	}
	public Date getCountClearTime() {
		return countClearTime;
	}
	public void setCountClearTime(Date countClearTime) {
		this.countClearTime = countClearTime;
	}
	public Date getCountCopyTime() {
		return countCopyTime;
	}
	public void setCountCopyTime(Date countCopyTime) {
		this.countCopyTime = countCopyTime;
	}
	public Date getDownloadTime() {
		return downloadTime;
	}
	public void setDownloadTime(Date downloadTime) {
		this.downloadTime = downloadTime;
	}
	
}
