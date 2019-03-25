package com.hqyj.controller.hth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.model.hth.ErpsysRecord;
import com.hqyj.service.hth.FinancialManagementRecordBillService;

/**
 * @author 黄泰华
 * 
 *         最后更新:2019年2月20日上午9:19:51
 */
@Controller
public class FinancialManagementRecordBillController {

	// 账务管理Service
	@Resource
	private FinancialManagementRecordBillService fms;
	

	/**
	 * 账务管理页面初始化控制器
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/financialManagementRecordBill")
	public String initFinancialManagementRecordBillPage(HttpServletRequest request) {
		request = fms.initFinancialManagementPage(request);
		return "hth/financialManagementRecordBill";
	}

	/**
	 * 编辑入账账单控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editRecordBill")
	public String initEditBillPage(HttpServletRequest request) {
		request = fms.initEditRecordBillPage(request);
		return "/hth/editRecordBill";
	}
	
	/**
	 * 编辑入账账单提交 控制器
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/editRecordBillSubmit")
	public @ResponseBody String editRecordBillSubmit(ErpsysRecord record) {
//		System.out.println(record.toString());
		if(fms.updateRecordBill(record)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	/**
	 * 增加新账单 控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertRecordBill")
	public String initInsertBillPage(HttpServletRequest request) {
		request = fms.initInsertRecordBillPage(request);
		return "/hth/insertRecordBill";
	}
	
	/**
	 * 增加新入账账单提交 控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertRecordBillSubmit")
	public @ResponseBody String initInsertBillSubmitPage(ErpsysRecord record) {
		if(fms.insertRecordBill(record)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	/**
	 * 删除入账账单控制器
	 * @param recordId
	 * @return
	 */
	@RequestMapping(value="/deleteRecordBillSubmit")
	public @ResponseBody String deleteRecordBillSubmit(int recordId){
		if(fms.deleteRecordBill(recordId)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	@RequestMapping(value="/PLdeleteRecordBillSubmit")
	public @ResponseBody String PLdeleteRecordBillSubmit(HttpServletRequest request){
		if(fms.PLdeleteRecordBill(request)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
}
