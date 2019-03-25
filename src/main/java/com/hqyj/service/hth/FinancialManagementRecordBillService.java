package com.hqyj.service.hth;

import javax.servlet.http.HttpServletRequest;

import com.hqyj.model.hth.ErpsysRecord;

public interface FinancialManagementRecordBillService {

	HttpServletRequest initFinancialManagementPage(HttpServletRequest request);

	HttpServletRequest initEditRecordBillPage(HttpServletRequest request);

	int updateRecordBill(ErpsysRecord record);

	HttpServletRequest initInsertRecordBillPage(HttpServletRequest request);

	int insertRecordBill(ErpsysRecord record);

	int deleteRecordBill(int recordId);

	int PLdeleteRecordBill(HttpServletRequest request);
	
	
	
}
