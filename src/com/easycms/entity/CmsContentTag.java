package com.easycms.entity;

import java.io.Serializable;
/**
 * 内容标记实体
 * @author fuxin
 *
 */
public class CmsContentTag implements Serializable{
	//属性
	private Integer id;
	private String name;// tag名称
	private Integer count;// 被引用的次数
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
