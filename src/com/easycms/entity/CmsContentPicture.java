package com.easycms.entity;

import java.io.Serializable;
/**
 * 内容图片实体
 * @author fuxin
 *
 */
public class CmsContentPicture implements Serializable{
	//属性
	private Integer id;
	private String imgPath; // 图片地址
	private String description;// 描述
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
