package com.easycms.entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
/**
 * 用户实体
 * @author fuxin
 *
 */
public class CmsUser implements Serializable{
	// 关系
	private CmsUserGroup userGroup; // 用户组，多个用户一个用户组
	private Integer group_id;
	
	private Set<CmsUserExt> userExtSet;// 用户扩展
	private Set<CmsUserSite> userSites;// 用户站点
	private Set<CmsContent> collectContents;// 用户对应的内容

	private Set<CmsMessage> sendMessage; // 发件
	private Set<CmsMessage> receiveMessage;// 收件
	private Set<CmsReceiverMessage> sendReceiverMessage; // 发送站内收信
	private Set<CmsReceiverMessage> receiveReceiverMessage;// 接收站内收信
	
	//属性
	private Integer id;
	private String username;//用户名
	private String password;
	private String email;//邮箱
	private Date registerTime;//注册时间
	private String registerIP;//注册IP
	private Date lastLoginTime;//最后登录时间
	private String lastLoginIP;//最后登录IP
	private Integer loginCount;//登录次数
	private Integer rank;//管理员级别
	private long uploadSize;//上传总大小
	private Date uploadDate;//上传日期
	private boolean admin;//是否是管理员
	private boolean viewonlyAdmin;//是否只读管理员
	private boolean selfAdmin;//是否管理自己的数据
	private boolean disabled;//是否禁用
	
	public CmsUserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(CmsUserGroup userGroup) {
		this.userGroup = userGroup;
	}
	public Set<CmsUserExt> getUserExtSet() {
		return userExtSet;
	}
	public void setUserExtSet(Set<CmsUserExt> userExtSet) {
		this.userExtSet = userExtSet;
	}
	public Set<CmsUserSite> getUserSites() {
		return userSites;
	}
	public void setUserSites(Set<CmsUserSite> userSites) {
		this.userSites = userSites;
	}
	public Set<CmsContent> getCollectContents() {
		return collectContents;
	}
	public void setCollectContents(Set<CmsContent> collectContents) {
		this.collectContents = collectContents;
	}
	public Set<CmsMessage> getSendMessage() {
		return sendMessage;
	}
	public void setSendMessage(Set<CmsMessage> sendMessage) {
		this.sendMessage = sendMessage;
	}
	public Set<CmsMessage> getReceiveMessage() {
		return receiveMessage;
	}
	public void setReceiveMessage(Set<CmsMessage> receiveMessage) {
		this.receiveMessage = receiveMessage;
	}
	public Set<CmsReceiverMessage> getSendReceiverMessage() {
		return sendReceiverMessage;
	}
	public void setSendReceiverMessage(Set<CmsReceiverMessage> sendReceiverMessage) {
		this.sendReceiverMessage = sendReceiverMessage;
	}
	public Set<CmsReceiverMessage> getReceiveReceiverMessage() {
		return receiveReceiverMessage;
	}
	public void setReceiveReceiverMessage(
			Set<CmsReceiverMessage> receiveReceiverMessage) {
		this.receiveReceiverMessage = receiveReceiverMessage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getRegisterIP() {
		return registerIP;
	}
	public void setRegisterIP(String registerIP) {
		this.registerIP = registerIP;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIP() {
		return lastLoginIP;
	}
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}
	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public long getUploadSize() {
		return uploadSize;
	}
	public void setUploadSize(long uploadSize) {
		this.uploadSize = uploadSize;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isViewonlyAdmin() {
		return viewonlyAdmin;
	}
	public void setViewonlyAdmin(boolean viewonlyAdmin) {
		this.viewonlyAdmin = viewonlyAdmin;
	}
	public boolean isSelfAdmin() {
		return selfAdmin;
	}
	public void setSelfAdmin(boolean selfAdmin) {
		this.selfAdmin = selfAdmin;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public Integer getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
}
