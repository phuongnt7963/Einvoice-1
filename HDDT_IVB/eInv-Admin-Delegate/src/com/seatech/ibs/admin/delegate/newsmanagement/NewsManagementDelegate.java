package com.seatech.ibs.admin.delegate.newsmanagement;

import java.util.List;
import java.util.Map;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.admin.delegate.base.DelegateBase;
import com.seatech.ibs.admin.pojo.newsmanagement.NewsCategories;
import com.seatech.ibs.admin.pojo.newsmanagement.NewsContents;
import com.seatech.ibs.admin.service.account.BKAccountInfoService;
import com.seatech.ibs.admin.service.newsmanagement.NewsManagementService;

public class NewsManagementDelegate extends DelegateBase {
	
	private NewsManagementService getNewsManagementService() {
		return (NewsManagementService) WebApplicationContextUtils
				.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession()
								.getServletContext()).getBean("newsManagementService");
	}
	
	public List<NewsContents> queryNewsContent(Map map) throws Exception {
		return this.getNewsManagementService().queryNewsContent(map);
	}
	
	public int countNewsContentsRecords(Map map) throws Exception {
		return this.getNewsManagementService().countNewsContentsRecords(map);
	}
	
	public int countNewsCategoryRecords(Map map) throws Exception {
		return this.getNewsManagementService().countNewsCategoryRecords(map);
	}
	
	public List<NewsCategories> queryNewsCategory(Map map) throws Exception {
		return this.getNewsManagementService().queryNewsCategory(map);
	}
	
	public List<NewsCategories> queryListNewsCategory(Map map) throws Exception {
		return this.getNewsManagementService().queryListNewsCategory(map);
	}
	
	public void insertNewsCategory(NewsCategories obj) throws Exception {
		this.getNewsManagementService().insertNewsCategory(obj);
	}
	
	public void insertNewsContent(NewsContents obj) throws Exception {
		this.getNewsManagementService().insertNewsContent(obj);
	}
	
	public void deleteNewsCategory(NewsCategories obj) throws Exception {
		this.getNewsManagementService().deleteNewsCategory(obj);
	}
	
	public void updateNewsCategory(Map map) throws Exception {
		this.getNewsManagementService().updateNewsCategory(map);
	}
	
	public void updateNewsContent(Map map) throws Exception {
		this.getNewsManagementService().updateNewsContent(map);
	}
	
	public void modifyNewsContent(Map map) throws Exception {
		this.getNewsManagementService().modifyNewsContent(map);
	}
}
