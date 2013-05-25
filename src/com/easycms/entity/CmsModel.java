package com.easycms.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * 模板实体
 * @author fuxin
 *
 */
public class CmsModel implements Serializable{
	//关系
	private Set<CmsModelItem> items;
	//属性
	private String tplName; // 名称
	private String tplPath; // 路径
	private String tplChannelPrefix;// 栏目模板前缀
	private String tplContentPrefix;// 内容模板前缀
	private Integer titleImgHeight;// 栏目标题高度
	private Integer titleImgWidth;// 栏目标题宽度
	private Integer contentImgWidth;// 栏目内容宽度
	private Integer contentImgHeight;// 栏目标题高度
	private Integer priority;// 排列顺序
	private boolean hasContent;// 是否有内容
	private boolean def;// 是否默认模型
	
	public Set<CmsModelItem> getItems() {
		return items;
	}
	public void setItems(Set<CmsModelItem> items) {
		this.items = items;
	}
	public String getTplName() {
		return tplName;
	}
	public void setTplName(String tplName) {
		this.tplName = tplName;
	}
	public String getTplPath() {
		return tplPath;
	}
	public void setTplPath(String tplPath) {
		this.tplPath = tplPath;
	}
	public String getTplChannelPrefix() {
		return tplChannelPrefix;
	}
	public void setTplChannelPrefix(String tplChannelPrefix) {
		this.tplChannelPrefix = tplChannelPrefix;
	}
	public String getTplContentPrefix() {
		return tplContentPrefix;
	}
	public void setTplContentPrefix(String tplContentPrefix) {
		this.tplContentPrefix = tplContentPrefix;
	}
	public Integer getTitleImgHeight() {
		return titleImgHeight;
	}
	public void setTitleImgHeight(Integer titleImgHeight) {
		this.titleImgHeight = titleImgHeight;
	}
	public Integer getTitleImgWidth() {
		return titleImgWidth;
	}
	public void setTitleImgWidth(Integer titleImgWidth) {
		this.titleImgWidth = titleImgWidth;
	}
	public Integer getContentImgWidth() {
		return contentImgWidth;
	}
	public void setContentImgWidth(Integer contentImgWidth) {
		this.contentImgWidth = contentImgWidth;
	}
	public Integer getContentImgHeight() {
		return contentImgHeight;
	}
	public void setContentImgHeight(Integer contentImgHeight) {
		this.contentImgHeight = contentImgHeight;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public boolean isHasContent() {
		return hasContent;
	}
	public void setHasContent(boolean hasContent) {
		this.hasContent = hasContent;
	}
	public boolean isDef() {
		return def;
	}
	public void setDef(boolean def) {
		this.def = def;
	}
}
