package com.easycms.entity;

import java.io.Serializable;
/**
 * 内容审核实体
 * @author fuxin
 *
 */
public class CmsContentCheck implements Serializable{
	// 关系
	private CmsContent content;
	
	//属性
	private Integer id;
	private byte checkStep;// 审核步骤
	private String checkOption;// 审核意见
	private boolean rejected;// 是否退回
	public CmsContent getContent() {
		return content;
	}
	public void setContent(CmsContent content) {
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public byte getCheckStep() {
		return checkStep;
	}
	public void setCheckStep(byte checkStep) {
		this.checkStep = checkStep;
	}
	public String getCheckOption() {
		return checkOption;
	}
	public void setCheckOption(String checkOption) {
		this.checkOption = checkOption;
	}
	public boolean isRejected() {
		return rejected;
	}
	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}
}
