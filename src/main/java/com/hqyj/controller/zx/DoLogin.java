package com.hqyj.controller.zx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoLogin {
	
	@RequestMapping("/dologin")
	public String dologin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 登录逻辑
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			// UsernamePasswordToken用于存放当前的账号和密码
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
				currentUser.login(token);
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
			} catch (AuthenticationException ae) {
				return "redirect:login.jsp";
			}
		}

		return "home/index";
	}
}
