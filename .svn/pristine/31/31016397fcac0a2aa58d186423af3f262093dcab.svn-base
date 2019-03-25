package com.hqyj.controller.hth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.model.hth.ErpsysAccountsPayable;
import com.hqyj.service.hth.FinancialManagementAccountsPayableService;

/**
 * @author 黄泰华
 * 
 *         最后更新:2019年2月20日上午9:19:51
 */
@Controller
public class FinancialManagementAccountsPayableController {

	// 账务管理Service
	@Resource
	private FinancialManagementAccountsPayableService fms;
	

	/**
	 * 账务管理页面初始化控制器
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/financialManagementAccountsPayable")
	public String initFinancialManagementAccountsPayablePage(HttpServletRequest request) {
		request = fms.initFinancialManagementPage(request);
		return "hth/financialManagementAccountsPayable";
	}

	/**
	 * 编辑入账账单控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editAccountsPayable")
	public String initEditPage(HttpServletRequest request) {
		request = fms.initEditAccountsPayablePage(request);
		return "/hth/editAccountsPayable";
	}
	
	/**
	 * 编辑入账账单提交 控制器
	 * @param accountsPayable
	 * @return
	 */
	@RequestMapping(value = "/editAccountsPayableSubmit")
	public @ResponseBody String editAccountsPayableSubmit(ErpsysAccountsPayable accountsPayable) {
//		System.out.println(accountsPayable.toString());
		if(fms.updateAccountsPayable(accountsPayable)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	/**
	 * 增加新账单 控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertAccountsPayable")
	public String initInsertPage(HttpServletRequest request) {
		request = fms.initInsertAccountsPayablePage(request);
		return "/hth/insertAccountsPayable";
	}
	
	/**
	 * 增加新入账账单提交 控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertAccountsPayableSubmit")
	public @ResponseBody String initInsertSubmitPage(ErpsysAccountsPayable accountsPayable) {
		if(fms.insertAccountsPayable(accountsPayable)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	/**
	 * 删除入账账单控制器
	 * @param accountsPayableId
	 * @return
	 */
	@RequestMapping(value="/deleteAccountsPayableSubmit")
	public @ResponseBody String deleteAccountsPayableSubmit(int accountsPayableId){
		if(fms.deleteAccountsPayable(accountsPayableId)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	@RequestMapping(value="/PLdeleteAccountsPayableSubmit")
	public @ResponseBody String PLdeleteAccountsPayableSubmit(HttpServletRequest request){
		if(fms.PLdeleteAccountsPayable(request)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
}
