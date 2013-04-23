package com.easycms.common;

import java.util.List;

public class Pager<T> {
	//总记录数
	private int total;
	/*//每页显示的记录数
	private int pegeSize;
	//要显示的号码数
	private int showPages;
	//当前分页的样式类
	private String currentPageStyle;*/
	//每页显示的具体内容
	private List<T> pageList;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	/*public int getPegeSize() {
		return pegeSize;
	}
	public void setPegeSize(int pegeSize) {
		this.pegeSize = pegeSize;
	}
	public int getShowPages() {
		return showPages;
	}
	public void setShowPages(int showPages) {
		this.showPages = showPages;
	}
	public String getCurrentPageStyle() {
		return currentPageStyle;
	}
	public void setCurrentPageStyle(String currentPageStyle) {
		this.currentPageStyle = currentPageStyle;
	}*/
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
}
