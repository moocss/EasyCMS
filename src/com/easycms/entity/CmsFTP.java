package com.easycms.entity;

import java.io.Serializable;
/**
 * FTP实体
 * @author fuxin
 *
 */
public class CmsFTP implements Serializable{
	private Integer id;
	private String ftpName;//FTP名称
	private String ftpIP;//FTP的IP
	private Integer ftpPort;//FTP的端口号
	private String ftpUsername;//FTP的用户名
	private String ftpPassword;//FTP的密码
	private String ftpEncoding;//FTP的编码
	private String ftpPath;//FTP的路径
	private String ftpUrl;//FTP的Url
	private Integer timeout;//结束时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFtpName() {
		return ftpName;
	}
	public void setFtpName(String ftpName) {
		this.ftpName = ftpName;
	}
	public String getFtpIP() {
		return ftpIP;
	}
	public void setFtpIP(String ftpIP) {
		this.ftpIP = ftpIP;
	}
	public Integer getFtpPort() {
		return ftpPort;
	}
	public void setFtpPort(Integer ftpPort) {
		this.ftpPort = ftpPort;
	}
	public String getFtpUsername() {
		return ftpUsername;
	}
	public void setFtpUsername(String ftpUsername) {
		this.ftpUsername = ftpUsername;
	}
	public String getFtpPassword() {
		return ftpPassword;
	}
	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}
	public String getFtpEncoding() {
		return ftpEncoding;
	}
	public void setFtpEncoding(String ftpEncoding) {
		this.ftpEncoding = ftpEncoding;
	}
	public String getFtpPath() {
		return ftpPath;
	}
	public void setFtpPath(String ftpPath) {
		this.ftpPath = ftpPath;
	}
	public String getFtpUrl() {
		return ftpUrl;
	}
	public void setFtpUrl(String ftpUrl) {
		this.ftpUrl = ftpUrl;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
}
