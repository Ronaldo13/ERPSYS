package com.hqyj.controller.bt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.model.bt.ErpsysBasicInformation;
import com.hqyj.service.bt.ErpsysBasicInformationService;

@Controller
@RequestMapping("/ErpsysBasicInformation")
public class ErpsysBasicInformationController {

	@Autowired
	private ErpsysBasicInformationService erpsysBasicInformationService;

	@RequestMapping("/main1") // 处理main1请求
	public String main1(HttpServletRequest request) {
		request = erpsysBasicInformationService.main1(request);

		return "bt/main1";
	}

	@RequestMapping("/addEBI") // 处理add请求
	public String addBI(HttpServletRequest request) {
		request = erpsysBasicInformationService.addBI(request);
		return "bt/addEBI";

	}

	@RequestMapping("/addEBIk")
	public String insert(HttpServletRequest request, ErpsysBasicInformation basicInformation) {
		request = erpsysBasicInformationService.insert(request, basicInformation);
		// System.out.println(accountId.toString());
		return "forward:main1";
	}

	@RequestMapping("/modifyEBI") // 处理modify请求
	public String modifyBI(HttpServletRequest request) {
		request = erpsysBasicInformationService.initmodifyEBIPage(request);
		return "bt/modifyEBI";
	}

	@RequestMapping("/modifyEBIk") // 处理modify请求
	public String update(HttpServletRequest request, ErpsysBasicInformation accountId) {
		
		request = erpsysBasicInformationService.update(request,accountId);

		return "redirect:main1";

	}

	@RequestMapping("/deleteEBIk")
	public String deleteByID(HttpServletRequest request) {
		request = erpsysBasicInformationService.deleteById(request);
		return "redirect:main1";
	}
	
	

	}

