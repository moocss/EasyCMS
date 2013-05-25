package com.easycms.entity;

import java.io.Serializable;
import java.util.Set;
/**
 * 内容 实体
 * @author fuxin
 *
 */
public class CmsContent implements Serializable{
	//关系
	private CmsSite site;
	private CmsContentType type;
	//关系
	private Set<CmsChannel> channels; 
	private Set<CmsTopic> topics;
	private Set<CmsUserGroup> userGroups;
	private Set<CmsContentTag> tags;
	private Set<CmsContentPicture> pictures;
	private Set<CmsContentAttachment> attachments;
	private Set<CmsContentTxt> contentTxtSet;
	private	Set<CmsContentCheck> contentCheckSet;
	private Set<CmsUser> collectUsers;
}
