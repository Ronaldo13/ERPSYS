package com.hqyj.service.hth;

import javax.servlet.http.HttpServletRequest;

import com.hqyj.model.hth.ErpsysExpenditure;

public interface FinancialManagementExpenditureBillService {

	HttpServletRequest initFinancialManagementPage(HttpServletRequest request);

	HttpServletRequest initEditExpenditureBillPage(HttpServletRequest request);

	int updateExpenditureBill(ErpsysExpenditure expenditure);

	HttpServletRequest initInsertExpenditureBillPage(HttpServletRequest request);

	int insertExpenditureBill(ErpsysExpenditure expenditure);

	int deleteExpenditureBill(int expenditureId);

	int PLdeleteExpenditureBill(HttpServletRequest request);
	
	
	
}
