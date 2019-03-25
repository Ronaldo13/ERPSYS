package com.hqyj.service.lbl;

import javax.servlet.http.HttpServletRequest;


public interface ProductMaterialService {

	int insert(HttpServletRequest request);

	int deleteByPrimaryKey(HttpServletRequest request);

	String selectProductMaterialTableByJson(HttpServletRequest request);

	String getPageInfo(HttpServletRequest request);
	
	int updateByPrimaryKey(HttpServletRequest request);

	HttpServletRequest initUpdateproductmaterialsdatePage(HttpServletRequest request);

	int PLdeleteproductmaterialdate(HttpServletRequest request);

	void selectOutWareHouseLog(HttpServletRequest request);

	void selectWareHouseDate(HttpServletRequest request);
	
	
}
