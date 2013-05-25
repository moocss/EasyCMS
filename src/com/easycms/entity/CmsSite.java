package com.easycms.entity;

import java.io.Serializable;

/**
 * 站点实体
 * @author fuxin
 *
 */
public class CmsSite implements Serializable{
	//关系
	private CmsFTP ftp;
	private CmsConfig config;
	//属性
	private Integer id;
	private String siteDomain;// 网站域名
	private String sitePath;// 网站路径
	private String siteName;// 网站名称
	private String siteShortName;// 简短名称
	private String protocol;// 协议
	private String dynamicSuffix;// 动态页的后缀
	private String staticSuffix;// 静态页的后缀
	private String staticDir;// 静态页存放目录
	private boolean indexToRoot;// 是否使用将首页放在根目录下
	private boolean staticIndex;// 是否静态化首页
	private String localeAdmin;// 后台本地化
	private String localeFront;// 前台本地化
	private String tplSolution;// 模板方案
	private byte finalStep;// 终审级别
	private byte afterCheck;// 审核后
	private boolean relativePath;// 是否使用相对路径
	private boolean resycleOn;// 是否开启回收站
	private String domainAlias;// 域名别名
	private String domainRedirect;// 域名重定向
	public CmsFTP getFtp() {
		return ftp;
	}
	public void setFtp(CmsFTP ftp) {
		this.ftp = ftp;
	}
	public CmsConfig getConfig() {
		return config;
	}
	public void setConfig(CmsConfig config) {
		this.config = config;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSiteDomain() {
		return siteDomain;
	}
	public void setSiteDomain(String siteDomain) {
		this.siteDomain = siteDomain;
	}
	public String getSitePath() {
		return sitePath;
	}
	public void setSitePath(String sitePath) {
		this.sitePath = sitePath;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteShortName() {
		return siteShortName;
	}
	public void setSiteShortName(String siteShortName) {
		this.siteShortName = siteShortName;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getDynamicSuffix() {
		return dynamicSuffix;
	}
	public void setDynamicSuffix(String dynamicSuffix) {
		this.dynamicSuffix = dynamicSuffix;
	}
	public String getStaticSuffix() {
		return staticSuffix;
	}
	public void setStaticSuffix(String staticSuffix) {
		this.staticSuffix = staticSuffix;
	}
	public String getStaticDir() {
		return staticDir;
	}
	public void setStaticDir(String staticDir) {
		this.staticDir = staticDir;
	}
	public boolean isIndexToRoot() {
		return indexToRoot;
	}
	public void setIndexToRoot(boolean indexToRoot) {
		this.indexToRoot = indexToRoot;
	}
	public boolean isStaticIndex() {
		return staticIndex;
	}
	public void setStaticIndex(boolean staticIndex) {
		this.staticIndex = staticIndex;
	}
	public String getLocaleAdmin() {
		return localeAdmin;
	}
	public void setLocaleAdmin(String localeAdmin) {
		this.localeAdmin = localeAdmin;
	}
	public String getLocaleFront() {
		return localeFront;
	}
	public void setLocaleFront(String localeFront) {
		this.localeFront = localeFront;
	}
	public String getTplSolution() {
		return tplSolution;
	}
	public void setTplSolution(String tplSolution) {
		this.tplSolution = tplSolution;
	}
	public byte getFinalStep() {
		return finalStep;
	}
	public void setFinalStep(byte finalStep) {
		this.finalStep = finalStep;
	}
	public byte getAfterCheck() {
		return afterCheck;
	}
	public void setAfterCheck(byte afterCheck) {
		this.afterCheck = afterCheck;
	}
	public boolean isRelativePath() {
		return relativePath;
	}
	public void setRelativePath(boolean relativePath) {
		this.relativePath = relativePath;
	}
	public boolean isResycleOn() {
		return resycleOn;
	}
	public void setResycleOn(boolean resycleOn) {
		this.resycleOn = resycleOn;
	}
	public String getDomainAlias() {
		return domainAlias;
	}
	public void setDomainAlias(String domainAlias) {
		this.domainAlias = domainAlias;
	}
	public String getDomainRedirect() {
		return domainRedirect;
	}
	public void setDomainRedirect(String domainRedirect) {
		this.domainRedirect = domainRedirect;
	}
	
}
