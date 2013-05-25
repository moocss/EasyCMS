package com.easycms.entity;
import java.io.Serializable;
import java.util.Date;
/**
 * 用户实体实体
 * @author fuxin
 *
 */
public class CmsUser implements Serializable{
	private int id;
	private String username;//用户名
	private String email;//邮箱
	private Date registerTime;//注册时间
	private String registerIP;//注册IP
	private Date lastLoginTime;//最后登录时间
	private String lastLoginIP;//最后登录IP
	private int loginCount;//登录次数
	private int rank;//管理员级别
	private int uploadSize;//上传总大小
	private Date uploadDate;//上传日期
	private boolean admin;//是否是管理员
	private boolean viewonlyAdmin;//是否只读管理员
	private boolean selfAdmin;//是否管理自己的数据
	private boolean disabled;//是否禁用
}
