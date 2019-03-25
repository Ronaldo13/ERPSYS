package com.hqyj.service.im.xsh;


import java.util.List;

//import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hqyj.mapper.xsh.ErpsysBuyLogMapper;
import com.hqyj.mapper.xsh.ErpsysOrderMapper;
import com.hqyj.model.xsh.ErpsysBuyLog;
import com.hqyj.model.xsh.ErpsysOrder;
import com.hqyj.service.xsh.BuyOrderMannagementService;

//import static java.util.stream.Collectors.groupingBy;
@Service
public class BuyOrderMannagementServiceIm implements BuyOrderMannagementService {

	@Resource
	private ErpsysOrderMapper eom;
	@Resource
	private ErpsysBuyLogMapper eblm;
	@Override
	public void queryAllBuyOrder(HttpServletRequest request) {


		List<ErpsysBuyLog> ErpsysBuyLog=eblm.queryAllBuyOrder();
		
		request.setAttribute("ErpsysBuyLog", ErpsysBuyLog);
		
		
	}
	@Override
	public void deleteBuyOrderByBuyLogId(HttpServletRequest request) {
		

		int buyLogId=Integer.parseInt(request.getParameter("buyLogId"));
		eblm.deleteBuyOrderByBuyLogId(buyLogId);
		
	}
	
	@Override
	public void queryBuyOrderByOrderId(HttpServletRequest request) {


		int orderId=Integer.parseInt(request.getParameter("orderId"));
		
		ErpsysOrder ErpsysOrder=eom.queryOrderByOrderId(orderId);
		System.out.println(orderId);
		request.setAttribute("ErpsysOrder", ErpsysOrder);
	}
	
	
	@Override
	public void queryUpdateBuyOrderByOrderId(HttpServletRequest request) {
		
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		ErpsysOrder ErpsysOrder=eom.queryOrderByOrderId(orderId);
		request.setAttribute("ErpsysOrder", ErpsysOrder);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public void queryAllBuyOrderByOrderType(HttpServletRequest request) {
//		
//		
////		对map数据进行分组
//////		Map<Integer, List<ErpsysOrder>> ordertype=ErpsysOrderList.stream().collect(groupingBy(ErpsysOrder::getOrderType));
//////		
//////		for (Map.Entry<Integer, List<ErpsysOrder>> entry:ordertype.entrySet()) {
//////			System.out.println(entry.getValue());
//////		}
//////		int orderType=Integer.parseInt(request.getParameter("ordertype"));
//////		
//////		System.out.println(orderType);
//////		List<ErpsysOrder>ErpsysOrder=eom.queryAllBuyOrderByOrderType(orderType);
//////		ErpsysBuyLog ErpsysBuyLog=new ErpsysBuyLog();
//////		for (ErpsysOrder erpsysOrder2 : ErpsysOrder) {
//////			ErpsysBuyLog.setOrderId(erpsysOrder2.getOrderId());
//////			ErpsysBuyLog.setSeller(erpsysOrder2.getSeller());
//////			ErpsysBuyLog.setBuyTime(erpsysOrder2.getOrderTime());
//////			ErpsysBuyLog.setBuyNumber(erpsysOrder2.getProductionNumber());
//////			eblm.addBuyOrder(ErpsysBuyLog);
//////			System.out.println(erpsysOrder2);
//////		}
////		
////		
//		
//		
//	}
//


}
