package com.hqyj.service.zx;

import javax.servlet.http.HttpServletRequest;

public interface DoSer {

	void doinfo(HttpServletRequest request);

	boolean dopsw(HttpServletRequest request);

	String selectCount(HttpServletRequest request);

	String doList(HttpServletRequest request);

	void insertPower(HttpServletRequest request);

	void dologlist(HttpServletRequest request);

	void dodelete(HttpServletRequest request);

	String doupfile(HttpServletRequest request);

	void doinfopage(HttpServletRequest request);

}
