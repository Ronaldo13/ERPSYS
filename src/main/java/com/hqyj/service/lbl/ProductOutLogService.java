package com.hqyj.service.lbl;

import javax.servlet.http.HttpServletRequest;

public interface ProductOutLogService {

	int insert(HttpServletRequest request);
	
	String selectProductOutLogTableByJson(HttpServletRequest request);

	String getPageInfo(HttpServletRequest request);
	
	int deleteByPrimaryKey(HttpServletRequest request);
	
	int updateByPrimaryKey(HttpServletRequest request);

	HttpServletRequest initUpdateproductoutlogdatePage(HttpServletRequest request);

	int PLdeleteproductoutlogdate(HttpServletRequest request);

	void selectInWareHouseLog(HttpServletRequest request);
}
