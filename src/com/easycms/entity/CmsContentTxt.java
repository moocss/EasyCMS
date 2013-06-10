package com.easycms.entity;

import java.io.Serializable;
/**
 * 内容文本实体
 * @author fuxin
 *
 */
public class CmsContentTxt implements Serializable{
	//属性
	private Integer id;
	private String txt; // 文章内容
	private String txt1;// 扩展内容1
	private String txt2;// 扩展内容2
	private String txt3;// 扩展内容3
	private CmsContent content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public String getTxt1() {
		return txt1;
	}
	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}
	public String getTxt2() {
		return txt2;
	}
	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}
	public String getTxt3() {
		return txt3;
	}
	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}
	public CmsContent getContent() {
		return content;
	}
	public void setContent(CmsContent content) {
		this.content = content;
	}
}
