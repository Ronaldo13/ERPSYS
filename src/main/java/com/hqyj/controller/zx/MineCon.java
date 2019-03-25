package com.hqyj.controller.zx;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hqyj.mapper.zx.ErpsysAccountAuthorityMapper;
import com.hqyj.service.zx.DoSer;

@Controller
@RequestMapping("/MineCon")
public class MineCon {

	@Resource
	private DoSer doser;
	@Resource
	private ErpsysAccountAuthorityMapper eaamapper;

	@RequestMapping("/index")
	public String indexPage() {
		return "home/index";
	}

	@RequestMapping("/welcome")
	public String welcomePage(HttpServletRequest request) {
		doser.doinfo(request);
		return "home/welcome";
	}

	@RequestMapping("/password")
	public String passwordPage(HttpServletRequest request) {
		return "zx/password";
	}

	@RequestMapping(value = "/dopsw", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String dopsw(HttpServletRequest request) {
		if (doser.dopsw(request)) {
			return "修改成功";
		}
		return "修改失败";
	}

	@RequestMapping("/userlist")
	public String userlist(HttpServletRequest request) {
		return "zx/userlist";
	}

	@RequestMapping("/donum")
	@ResponseBody
	public String doNum(HttpServletRequest request) {
		return doser.selectCount(request);
	}

	@RequestMapping("/dolist")
	@ResponseBody
	public String doList(HttpServletRequest request) {
		return doser.doList(request);
	}

	@RequestMapping("/dosearch")
	public String search(HttpServletRequest request) {
		request.setAttribute("search", request.getParameter("search"));
		return "zx/userlist";
	}
	@RequestMapping("/powerpage")
	public String powerpage(HttpServletRequest request) {
		
		return "zx/power";
		
	}
	@RequestMapping("/powerpage2")
	@ResponseBody
	public String powerpage2(HttpServletRequest request) {
		List<String> ids=eaamapper.selectByAccountID(request.getParameter("username"));
		Gson g=new Gson();
		return g.toJson(ids);
		
	}
	@RequestMapping("/dopower")
	public String dopwer(HttpServletRequest request) {
		doser.insertPower(request);
		return "zx/userlist";
		
	}
	@RequestMapping("/logpage")
	public String logpage(HttpServletRequest request) {
		doser.dologlist(request);
		return "zx/loginlog";
		
	}
	@RequestMapping("/deletelog")
	public String deletelog(HttpServletRequest request) {
		doser.dodelete(request);
		return "redirect:/MineCon/logpage";
		
	}
	@RequestMapping("/upfilepage")
	public String upfilepage(HttpServletRequest request) {
		return "zx/upfile";
	}
	@RequestMapping("/upfile")
	public String upfile(HttpServletRequest request) {
		String flag=doser.doupfile(request);
		if("false".equals(flag)) {
			return "zx/fail";
		}
		return "zx/success";
	}
	@RequestMapping("/infopage")
	public String infopage(HttpServletRequest request) {
		doser.doinfopage(request);
		return "zx/personinfo";
	}
}
