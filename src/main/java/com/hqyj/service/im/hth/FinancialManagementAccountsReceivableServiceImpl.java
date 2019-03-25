package com.hqyj.service.im.hth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hqyj.mapper.hth.ErpsysAccountsReceivableMapper;
import com.hqyj.model.hth.ErpsysAccountsReceivable;
import com.hqyj.service.hth.FinancialManagementAccountsReceivableService;

@Service
public class FinancialManagementAccountsReceivableServiceImpl implements FinancialManagementAccountsReceivableService {

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	// 应收账务账单Mapper
	@Resource
	private ErpsysAccountsReceivableMapper earm;

	@Override
	public HttpServletRequest initFinancialManagementPage(HttpServletRequest request) {
		// 当起始值和结束值均不为空时
		try {
			String pageEnd = request.getParameter("pageEnd");// 判断是否需要跳转到最后一页
			String searchName = "%%";
			String searchAccountsReceivableName = "%%";
			Integer pageNo = 1;
			Integer pageSize = 10;
			Integer totalRecords = 0;
			if ("".equals(request.getParameter("pageNo")) == false && request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}
			if ("".equals(request.getParameter("searchName")) == false && request.getParameter("searchName") != null) {
				searchName = "%"+request.getParameter("searchName")+"%";
			}
			if ("".equals(request.getParameter("searchAccountsReceivableName")) == false && request.getParameter("searchAccountsReceivableName") != null) {
				searchAccountsReceivableName = "%"+request.getParameter("searchAccountsReceivableName")+"%";
			}
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("pageNo", pageNo);//返回相应页数的页面

			Map<String, Object> map = new HashMap<String, Object>();
			pageNo = (pageNo - 1) * pageSize;// 将pageNo-1乘以pageSize得到数据库查询偏移量
			map.put("pageNo", pageNo);
			map.put("pageSize", pageSize);
			map.put("searchName", searchName);
			map.put("searchAccountsReceivableName", searchAccountsReceivableName);
			request.setAttribute("searchName", request.getParameter("searchName"));
			request.setAttribute("searchAccountsReceivableName", request.getParameter("searchAccountsReceivableName"));
			
			List<ErpsysAccountsReceivable> erpsysAccountsReceivableList = earm.selectAccountsReceivableByReceiverAndEnd(map);// 按需查询
			totalRecords = earm.selectAccountsReceivableByReceiverAndEndCount(map);// 查询按需筛选的总条目数
			request.setAttribute("totalRecords", totalRecords);
			if ("yes".equals(pageEnd)) {
				pageNo = (int)Math.ceil((double)totalRecords/(double)pageSize);//向上取整  另外：向下取整是Math.floor(x)
				request.setAttribute("pageNo", pageNo);
				pageNo = (pageNo - 1) * pageSize;
				map.put("pageNo", pageNo);
				erpsysAccountsReceivableList = earm.selectAccountsReceivableByReceiverAndEnd(map);
			}
			for (ErpsysAccountsReceivable erpsysAccountsReceivable : erpsysAccountsReceivableList) {
				if (erpsysAccountsReceivable.getAccountsRecordTime() != null && "".equals(erpsysAccountsReceivable.getAccountsRecordTime()) == false) {
					String accountsReceivableTimeString = sdf.format(erpsysAccountsReceivable.getAccountsRecordTime());
					erpsysAccountsReceivable.setAccountsRecordTimeString(accountsReceivableTimeString);
				}
				if (erpsysAccountsReceivable.getPaymentTime() != null  && "".equals(erpsysAccountsReceivable.getPaymentTime()) == false) {
					String paymentTimeString = sdf.format(erpsysAccountsReceivable.getPaymentTime());
					erpsysAccountsReceivable.setPaymentTimeString(paymentTimeString);
				}
			}
			request.setAttribute("erpsysAccountsReceivableList", erpsysAccountsReceivableList);// request接收查询出的应收账务账单
		} catch (

		Exception e) {
			e.printStackTrace();
			request.setAttribute("warning", "输入了非数字！");
		}
		return request;
	}
	/**
	 * 初始化应收账务账单编辑页面
	 */
	@Override
	public HttpServletRequest initEditAccountsReceivablePage(HttpServletRequest request) {
		String accountsReceivableIdString = request.getParameter("accountsReceivableId");
		if (accountsReceivableIdString != null) {
			try {
				int accountsReceivableId = Integer.parseInt(accountsReceivableIdString);
				ErpsysAccountsReceivable accountsReceivable = earm.selectByPrimaryKey(accountsReceivableId);
				if (accountsReceivable.getAccountsRecordTime()!=null && "".equals(accountsReceivable.getAccountsRecordTime())==false){
					accountsReceivable.setAccountsRecordTimeString(sdf.format(accountsReceivable.getAccountsRecordTime()));
				}if(accountsReceivable.getPaymentTime()!=null && "".equals(accountsReceivable.getPaymentTime())==false){
					accountsReceivable.setPaymentTimeString(sdf.format(accountsReceivable.getPaymentTime()));
				}
				request.setAttribute("accountsReceivable", accountsReceivable);
			} catch (Exception e) {

			}
		}
		return request;
	}

	/**
	 * 修改应收账务账单信息
	 */
	@Override
	public int updateAccountsReceivable(ErpsysAccountsReceivable accountsReceivable) {
		if(accountsReceivable.getPaymentTimeString()==null || "".equals(accountsReceivable.getPaymentTimeString())==true){
			accountsReceivable.setPaymentTimeString(null);
		}
		return earm.updateByPrimaryKeySelective(accountsReceivable);
	}

	/**
	 * 初始化新增应收账务账单页面 日期
	 */
	@Override
	public HttpServletRequest initInsertAccountsReceivablePage(HttpServletRequest request) {
		Date date = new Date();
		String dateString = sdf.format(date);
		request.setAttribute("NowDatetime", dateString);
		return request;
	}

	/**
	 * 新增应收账务账单信息
	 */
	@Override
	public int insertAccountsReceivable(ErpsysAccountsReceivable accountsReceivable) {
		if(accountsReceivable.getPaymentTimeString()==null || "".equals(accountsReceivable.getPaymentTimeString())==true){
			accountsReceivable.setPaymentTimeString(null);
		}
		return earm.insertSelective(accountsReceivable);
	}

	/**
	 * 删除应收账务账单信息
	 */
	@Override
	public int deleteAccountsReceivable(int accountsReceivableId) {
		return earm.deleteByPrimaryKey(accountsReceivableId);
	}

	/**
	 * 批量删除应收账务账单信息
	 */
	@Override
	public int PLdeleteAccountsReceivable(HttpServletRequest request) {
		int i = 0;
		String[] accountsReceivableIds = request.getParameterValues("accountsReceivableIds");
		// 循环删除所选应收账务账单
		try {
			for (String string : accountsReceivableIds) {
				int accountsReceivableId = Integer.parseInt(string);
				int j = earm.deleteByPrimaryKey(accountsReceivableId);
				i = i + j;
			}
		} catch (Exception e) {
			return 0;
		}
		return i;
	}

}
