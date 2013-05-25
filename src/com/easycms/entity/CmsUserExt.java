package com.easycms.entity;

import java.io.Serializable;
/**
 * 用户内容扩展实体
 * @author fuxin
 *
 */
public class CmsUserExt implements Serializable{
	private int id;
	private String realname;//真实姓名
	private boolean gender;//性别
	private String intro;//自我介绍
	private String comefrom;//来自地方
	private String qq;
	private String msn;
	private String phone;//电话
	private String mobile;//手机
	private String userAvatar;//用户头像
	private String userSignature;//用户个性签名
	
}
