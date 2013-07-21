package com.easycms.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户内容扩展实体
 * @author fuxin
 *
 */
public class CmsUserExt implements Serializable{
	//关系
	//private CmsUser user;
	private Integer uid;
	
	private Integer id;
	private String realname;//真实姓名
	private Integer gender;//性别
	private String birthday; //出生年月
	private String intro;//自我介绍
	private String comefrom;//来自地方
	private String qq;
	private String msn;
	private String phone;//电话
	private String mobile;//手机
	private String userAvatar;//用户头像
	private String userSignature;//用户个性签名
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/*public CmsUser getUser() {
		return user;
	}
	public void setUser(CmsUser user) {
		this.user = user;
	}*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getComefrom() {
		return comefrom;
	}
	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public String getUserSignature() {
		return userSignature;
	}
	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}
}
