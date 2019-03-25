package com.hqyj.controller.hth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.model.hth.ErpsysExpenditure;
import com.hqyj.service.hth.FinancialManagementExpenditureBillService;

/**
 * @author 黄泰华
 * 
 *         最后更新:2019年2月20日上午9:19:51
 */
@Controller
public class FinancialManagementExpenditureBillController {

	// 账务管理Service
	@Resource
	private FinancialManagementExpenditureBillService fmebs;
	

	/**
	 * 账务管理页面初始化控制器
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/financialManagementExpenditureBill")
	public String initFinancialManagementExpenditureBillPage(HttpServletRequest request) {
		request = fmebs.initFinancialManagementPage(request);
		return "hth/financialManagementExpenditureBill";
	}

	/**
	 * 编辑出账账单控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editExpenditureBill")
	public String initEditBillPage(HttpServletRequest request) {
		request = fmebs.initEditExpenditureBillPage(request);
		return "/hth/editExpenditureBill";
	}
	
	/**
	 * 编辑出账账单提交 控制器
	 * @param expenditure
	 * @return
	 */
	@RequestMapping(value = "/editExpenditureBillSubmit")
	public @ResponseBody String editExpenditureBillSubmit(ErpsysExpenditure expenditure) {
//		System.out.println(expenditure.toString());
		if(fmebs.updateExpenditureBill(expenditure)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	/**
	 * 增加新账单 控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertExpenditureBill")
	public String initInsertBillPage(HttpServletRequest request) {
		request = fmebs.initInsertExpenditureBillPage(request);
		return "/hth/insertExpenditureBill";
	}
	
	/**
	 * 增加新出账账单提交 控制器
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertExpenditureBillSubmit")
	public @ResponseBody String initInsertBillSubmitPage(ErpsysExpenditure expenditure) {
		if(fmebs.insertExpenditureBill(expenditure)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	/**
	 * 删除出账账单控制器
	 * @param expenditureId
	 * @return
	 */
	@RequestMapping(value="/deleteExpenditureBillSubmit")
	public @ResponseBody String deleteExpenditureBillSubmit(int expenditureId){
		if(fmebs.deleteExpenditureBill(expenditureId)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	@RequestMapping(value="/PLdeleteExpenditureBillSubmit")
	public @ResponseBody String PLdeleteExpenditureBillSubmit(HttpServletRequest request){
		if(fmebs.PLdeleteExpenditureBill(request)!=0)
			return "SUCCESS";
		else
			return "FAIL";
	}
}
