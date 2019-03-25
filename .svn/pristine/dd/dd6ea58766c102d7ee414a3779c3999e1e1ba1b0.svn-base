package com.hqyj.controller.hth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.model.hth.ErpsysAccountsReceivable;
import com.hqyj.service.hth.FinancialManagementAccountsReceivableService;

/**
 * @author 黄泰华
 * 
 *         最后更新:2019年2月20日上午9:19:51
 */
@Controller
public class FinancialManagementAccountsReceivableController {

	// 账务管理Service
	@Resource
	private FinancialManagementAccountsReceivableService fms;
	

	/**
	 * 账务管理页面初始化控制器
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/financialManagementAccountsReceivable")
	public String initFinancialManagementAccountsReceivablePage(HttpServletRequest request) {
		request = fms.initFinancialManagementPage(request);
		return "hth/financialManagementAccountsReceivable";
	}

	/**
	 * 编辑入账账单控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editAccountsReceivable")
	public String initEditPage(HttpServletRequest request) {
		request = fms.initEditAccountsReceivablePage(request);
		return "/hth/editAccountsReceivable";
	}
	
	/**
	 * 编辑入账账单提交 控制器
	 * @param accountsReceivable
	 * @return
	 */
	@RequestMapping(value = "/editAccountsReceivableSubmit")
	public @ResponseBody String editAccountsReceivableSubmit(ErpsysAccountsReceivable accountsReceivable) {
//		System.out.println(accountsReceivable.toString());
		if(fms.updateAccountsReceivable(accountsReceivable)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	/**
	 * 增加新账单 控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertAccountsReceivable")
	public String initInsertPage(HttpServletRequest request) {
		request = fms.initInsertAccountsReceivablePage(request);
		return "/hth/insertAccountsReceivable";
	}
	
	/**
	 * 增加新入账账单提交 控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertAccountsReceivableSubmit")
	public @ResponseBody String initInsertSubmitPage(ErpsysAccountsReceivable accountsReceivable) {
		if(fms.insertAccountsReceivable(accountsReceivable)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	/**
	 * 删除入账账单控制器
	 * @param accountsReceivableId
	 * @return
	 */
	@RequestMapping(value="/deleteAccountsReceivableSubmit")
	public @ResponseBody String deleteAccountsReceivableSubmit(int accountsReceivableId){
		if(fms.deleteAccountsReceivable(accountsReceivableId)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	@RequestMapping(value="/PLdeleteAccountsReceivableSubmit")
	public @ResponseBody String PLdeleteAccountsReceivableSubmit(HttpServletRequest request){
		if(fms.PLdeleteAccountsReceivable(request)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
}
