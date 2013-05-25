package com.easycms.entity;
/**
 * 栏目内容实体
 * @author fuxin
 *
 */
public class CmsChannelExt {
	// 关系
	private CmsChannel channel;
	//属性
	private Integer id;
	private String name;// 栏目名称
	private Byte finalStep;// 终审级别
	private Byte afterCheck;// 审核后 1 不能修改删除 2 修改返回 3 修改后不变
	private boolean staticChanne; // 是否栏目静态化
	private boolean staticContent;// 是否内容静态化
	private boolean accessByDir;// 是否使用目录访问
	private boolean listChild;// 是否使用子栏目列表
	private Integer pageSize;// 每页显示多少条记录
	private String channelRule;// 栏目页生成规则
	private String contentRule;// 内容页生成规则
	private String link;// 外部链接
	private String tplChannel;// 栏目页模板
	private String tplContent;// 内容模板
	private String titleImg;// 缩略图
	private boolean contentImg; // 内容图
	private boolean hasTitleImg;// 内容是否有缩略图
	private Integer titleImgWidth;// 内容标题宽度
	private Integer titleImgHeight;// 内容标题高度
	private Integer contentImgWidth;// 内容内容图宽度
	private Integer contentImgHeight;// 内容内容图高度
	private Integer commentControl;// 评论
	private boolean allowUpDown;// 顶踩
	private boolean blank;// 是否新窗口打开
	private String title; //SEO title
	private String keywords; //SEO keywords
	private String description; //SEO description
	
	public CmsChannel getChannel() {
		return channel;
	}
	public void setChannel(CmsChannel channel) {
		this.channel = channel;
	}
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
	public Byte getFinalStep() {
		return finalStep;
	}
	public void setFinalStep(Byte finalStep) {
		this.finalStep = finalStep;
	}
	public Byte getAfterCheck() {
		return afterCheck;
	}
	public void setAfterCheck(Byte afterCheck) {
		this.afterCheck = afterCheck;
	}
	public boolean isStaticChanne() {
		return staticChanne;
	}
	public void setStaticChanne(boolean staticChanne) {
		this.staticChanne = staticChanne;
	}
	public boolean isStaticContent() {
		return staticContent;
	}
	public void setStaticContent(boolean staticContent) {
		this.staticContent = staticContent;
	}
	public boolean isAccessByDir() {
		return accessByDir;
	}
	public void setAccessByDir(boolean accessByDir) {
		this.accessByDir = accessByDir;
	}
	public boolean isListChild() {
		return listChild;
	}
	public void setListChild(boolean listChild) {
		this.listChild = listChild;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getChannelRule() {
		return channelRule;
	}
	public void setChannelRule(String channelRule) {
		this.channelRule = channelRule;
	}
	public String getContentRule() {
		return contentRule;
	}
	public void setContentRule(String contentRule) {
		this.contentRule = contentRule;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTplChannel() {
		return tplChannel;
	}
	public void setTplChannel(String tplChannel) {
		this.tplChannel = tplChannel;
	}
	public String getTplContent() {
		return tplContent;
	}
	public void setTplContent(String tplContent) {
		this.tplContent = tplContent;
	}
	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	public boolean isContentImg() {
		return contentImg;
	}
	public void setContentImg(boolean contentImg) {
		this.contentImg = contentImg;
	}
	public boolean isHasTitleImg() {
		return hasTitleImg;
	}
	public void setHasTitleImg(boolean hasTitleImg) {
		this.hasTitleImg = hasTitleImg;
	}
	public Integer getTitleImgWidth() {
		return titleImgWidth;
	}
	public void setTitleImgWidth(Integer titleImgWidth) {
		this.titleImgWidth = titleImgWidth;
	}
	public Integer getTitleImgHeight() {
		return titleImgHeight;
	}
	public void setTitleImgHeight(Integer titleImgHeight) {
		this.titleImgHeight = titleImgHeight;
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
	public Integer getCommentControl() {
		return commentControl;
	}
	public void setCommentControl(Integer commentControl) {
		this.commentControl = commentControl;
	}
	public boolean isAllowUpDown() {
		return allowUpDown;
	}
	public void setAllowUpDown(boolean allowUpDown) {
		this.allowUpDown = allowUpDown;
	}
	public boolean isBlank() {
		return blank;
	}
	public void setBlank(boolean blank) {
		this.blank = blank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
