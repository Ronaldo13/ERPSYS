package com.hqyj.controller.hth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.service.hth.FinancialManagementLogService;

@Controller
public class FinancialManagementLogController {
	
	@Autowired
	private FinancialManagementLogService fmls;
	
	@RequestMapping(value="/financialManagementLog")
	public String initFinancialManagementLogPage(HttpServletRequest request){
		request = fmls.initFinancialManagementLogPage(request);
		return "hth/financialManagementLog";
	}
	
}
