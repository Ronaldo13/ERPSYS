package com.hqyj.service.im.hth;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.mapper.hth.ErpsysFinanceLogMapper;
import com.hqyj.model.hth.ErpsysFinanceLog;
import com.hqyj.service.hth.FinancialManagementLogService;

@Service
public class FinancialManagementLogServiceImpl implements FinancialManagementLogService {

	@Autowired
	private ErpsysFinanceLogMapper eflm;

	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

	@Override
	public HttpServletRequest initFinancialManagementLogPage(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageNo = 1;
		int pageSize = 10;
		String operationType = request.getParameter("operationType");
		String billType = request.getParameter("billType");
		String accountId = request.getParameter("accountId");
		request.setAttribute("operationType", operationType);
		request.setAttribute("billType", billType);
		request.setAttribute("accountId", accountId);
		if (operationType == null)
			operationType = "";
		if (billType == null)
			billType = "";
		if (accountId == null)
			accountId = "";
		String operation = "%" + operationType + billType + "%";
		accountId = "%" + accountId + "%";
		map.put("operation", operation);
		map.put("accountId", accountId);
		map.put("pageSize", pageSize);
		if ("".equals(request.getParameter("pageNo")) == false && request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		pageNo = (pageNo - 1) * pageSize;
		map.put("pageNo", pageNo);
		List<ErpsysFinanceLog> erpsysFinanceLogList = eflm.selectByCondition(map);// 查询筛选过后的日志列表
		for (ErpsysFinanceLog erpsysFinanceLog : erpsysFinanceLogList) {// 处理时间格式
			erpsysFinanceLog.setOperationTimeString(sdf.format(erpsysFinanceLog.getOperationTime()));
		}
		int totalRecords = eflm.selectByConditionCount(map);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("erpsysFinanceLogList", erpsysFinanceLogList);
		return request;
	}

}
