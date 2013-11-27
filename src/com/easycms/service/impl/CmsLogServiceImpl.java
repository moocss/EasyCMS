package com.easycms.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UrlPathHelper;

import com.easycms.base.AbstractBaseDao;
import com.easycms.common.Pager;
import com.easycms.common.RequestUtils;
import com.easycms.entity.CmsLog;
import com.easycms.entity.CmsUser;
import com.easycms.service.CmsLogService;

@Service
public class CmsLogServiceImpl extends AbstractBaseDao<CmsLog, Integer> implements CmsLogService{
	private static final Logger logger = Logger.getLogger(CmsLogServiceImpl.class);
	@Override
	public void operating(HttpServletRequest request, String title, String content) {
		//String ip = request.getRemoteAddr();
		//反向代理获取ip
		String ip = RequestUtils.getIpAddr(request);
		CmsUser user = (CmsUser) request.getSession().getAttribute("user");
		String username = user.getUsername();
		UrlPathHelper helper = new UrlPathHelper();
		String url =helper.getOriginatingQueryString(request);
		Date date = new Date();
		saveLog(CmsLog.ALL_LOG,username,url,ip,date,title,content);
	}

	@Override
	public void loginSucssessLog(HttpServletRequest request, String title) {
		//反向代理获取ip
		String ip = RequestUtils.getIpAddr(request);
		CmsUser user = (CmsUser) request.getSession().getAttribute("user");
		String username = user.getUsername();
		Date date = new Date();
		saveLog(CmsLog.LOGIN_SUCCESS_LOG,username,null,ip,date,title,null);
	}

	@Override
	public void loginFailureLog(HttpServletRequest request, String title,
			String content) {
		//反向代理获取ip
		String ip = RequestUtils.getIpAddr(request);
		UrlPathHelper helper = new UrlPathHelper();
		String url =helper.getOriginatingQueryString(request);
		Date date = new Date();
		saveLog(CmsLog.LOGIN_FAILURE_LOG,null,url,ip,date,title,content);
	}

	@Override
	public void saveLog(Integer category, String username, String url, String ip, Date date, String title, String content) {
		
		CmsLog log = new CmsLog();
		log.setCategory(category);
		log.setIp(ip);
		log.setUsername(username);
		log.setUrl(url);
		log.setTime(date);
		log.setTitle(title);
		log.setContent(content);
		
		save(log);
		
	}

	@Override
	public Pager<CmsLog> findByKey(Integer category, String username,
			String ip, String title, int showPages, int pageSize) {
		String operate = ".findByKey";
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("showPages", showPages);
		maps.put("pageSize", pageSize);
		maps.put("category", category);

		maps.put("username",username);
		maps.put("ip", ip);
		maps.put("title", title);

		return findByKey(maps, operate);
		
	}

}
