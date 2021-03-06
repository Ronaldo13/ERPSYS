package com.hqyj.aspect.zx;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.hqyj.mapper.zx.ErpsysLoginLogMapper;
import com.hqyj.model.zx.ErpsysLoginLog;

@Aspect
@Component
public class LoginAOP {
	@Resource
	private ErpsysLoginLogMapper logmapper;
	
	@AfterReturning(value="execution(* com.hqyj.controller.zx.DoLogin.dologin(javax.servlet.http.HttpServletRequest))",returning="page")
	public void doLoginAOP(JoinPoint jp,String page) {
		Object []ob=jp.getArgs();//得到被切方法中的参数列表
		HttpServletRequest request;
		String username=null;
		for (Object object : ob) {
			request=(HttpServletRequest) object;
			username=request.getParameter("username");
		}
		ErpsysLoginLog ell=new ErpsysLoginLog();
		ell.setErpsysLoginAccountId(username);
		ell.setErpsysLoginDate(new Date());
		if("home/index".equals(page)) {
			ell.setErpsysLoginState("success");
		}else {
			ell.setErpsysLoginState("false");
		}
		logmapper.insert(ell);
	}

}
