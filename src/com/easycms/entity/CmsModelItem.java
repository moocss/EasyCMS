package com.easycms.entity;

import java.io.Serializable;

/**
 * 模板项实体
 * @author fuxin
 *
 */
public class CmsModelItem implements Serializable{
	// 关系
	private CmsModel model;
	// 属性
	private Integer id;
	private String field;// 字段
	private Integer priority;// 排列顺序
	private String defValue;// 默认值
	private String optValue;// 可选项
	private String size;// 长度
	private String rows;// 文本行数
	private String cols;// 文本列数
	private String help;// 帮助信息
	private String helpPosition;// 帮助位置
	private Integer dataType;// 数据类型
	private boolean single;// 是否独占一行
	private boolean channel;// 是否为栏目模型项
	private boolean custom;// 是否自定义
	private boolean display;// 是否显示
	public CmsModel getModel() {
		return model;
	}
	public void setModel(CmsModel model) {
		this.model = model;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getDefValue() {
		return defValue;
	}
	public void setDefValue(String defValue) {
		this.defValue = defValue;
	}
	public String getOptValue() {
		return optValue;
	}
	public void setOptValue(String optValue) {
		this.optValue = optValue;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getCols() {
		return cols;
	}
	public void setCols(String cols) {
		this.cols = cols;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public String getHelpPosition() {
		return helpPosition;
	}
	public void setHelpPosition(String helpPosition) {
		this.helpPosition = helpPosition;
	}
	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	public boolean isSingle() {
		return single;
	}
	public void setSingle(boolean single) {
		this.single = single;
	}
	public boolean isChannel() {
		return channel;
	}
	public void setChannel(boolean channel) {
		this.channel = channel;
	}
	public boolean isCustom() {
		return custom;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	
}
