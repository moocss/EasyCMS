package com.easycms.entity;

import java.io.Serializable;
/**
 * 内容类型实体
 * @author fuxin
 *
 */
public class CmsContentType implements Serializable{
	//属性
	private Integer id;
	private String name;// 名称
	private Integer imgWidth;// 图片宽度
	private Integer imgHeight;// 图片高度
	private boolean hasImage;// 是否有图片
	private boolean disabled;// 是否禁用
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(Integer imgWidth) {
		this.imgWidth = imgWidth;
	}
	public Integer getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(Integer imgHeight) {
		this.imgHeight = imgHeight;
	}
	public boolean isHasImage() {
		return hasImage;
	}
	public void setHasImage(boolean hasImage) {
		this.hasImage = hasImage;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
}
