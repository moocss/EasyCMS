package com.easycms.entity;

import java.io.Serializable;
/**
 * 内容附件实体
 * @author fuxin
 *
 */
public class CmsContentAttachment implements Serializable{
	//属性
	private Integer id;
	private String path;// 附件路径
	private String name;// 附件名称
	private String filename;// 文件名
	private Integer count;// 下载次数
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
