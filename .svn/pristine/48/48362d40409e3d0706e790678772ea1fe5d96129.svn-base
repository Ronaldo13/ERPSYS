package com.hqyj.controller.bt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.hqyj.model.bt.ErpsysJob;

import com.hqyj.service.bt.ErpsysJobService;

@Controller
@RequestMapping("/ErpsysJob")
public class ErpsysJobController {
	@Autowired
	private ErpsysJobService erpsysJobService;
	@RequestMapping("/main3") // 处理main3请求
	public String main3(HttpServletRequest request) {

		request = erpsysJobService.main3(request);

		return "bt/main3";
	}

	@RequestMapping("/addEJ") // 处理add请求
	public String addEF(HttpServletRequest request) {

		return "bt/addEJ";

	}

	@RequestMapping("/addEJK")
	public String insert(HttpServletRequest request,ErpsysJob jobId) {
		request = erpsysJobService.insert(request, jobId);
		// System.out.println(accountId.toString());
		return "redirect:main3";
	}

	@RequestMapping("/modifyEJ") // 处理modify请求
	public String modifyEF(HttpServletRequest request) {
		request = erpsysJobService.initmodifyEJPage(request);
		return "bt/modifyEJ";
	}

	@RequestMapping("/modifyEJK") // 处理modify请求
	public String update(HttpServletRequest request, ErpsysJob jobId) {
		
		request = erpsysJobService.update(request,jobId);

		return "redirect:main3";

	}

	@RequestMapping("/deleteEJK")
	public String deleteByID(HttpServletRequest request) {
		request = erpsysJobService.deleteById(request);
		return "redirect:main3";
	}
	
	

	}



