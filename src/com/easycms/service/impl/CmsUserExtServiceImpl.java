package com.easycms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycms.base.AbstractBaseDao;
import com.easycms.entity.CmsUserExt;
import com.easycms.service.CmsUserExtService;

@Service
@Transactional
public class CmsUserExtServiceImpl extends AbstractBaseDao<CmsUserExt, Integer> implements CmsUserExtService{

}
