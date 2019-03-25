package com.hqyj.service.im.xsh;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hqyj.mapper.xsh.ErpsysOrderMapper;
import com.hqyj.mapper.xsh.ErpsysSellLogMapper;
import com.hqyj.service.xsh.SellOrderMannagementService;
import com.hqyj.model.xsh.ErpsysOrder;
import com.hqyj.model.xsh.ErpsysSellLog;

@Service
public class SellOrderMannagementServiceIm implements SellOrderMannagementService {

	@Resource
	private ErpsysSellLogMapper ErpsysSellLogMapper;
	
	@Resource
	private ErpsysOrderMapper eom;

	@Override
	public void queryAllSellOrder(HttpServletRequest request) {

		List<ErpsysSellLog> ErpsysSellLog = ErpsysSellLogMapper.queryAllSellOrder();

		request.setAttribute("ErpsysSellLog", ErpsysSellLog);
	}

	@Override
	public void deleteSellOrderByBuyLogId(HttpServletRequest request) {

		int sellLogId = Integer.parseInt(request.getParameter("sellLogId"));
		ErpsysSellLogMapper.deleteSellOrderByBuyLogId(sellLogId);

	}

	@Override
	public void querySellOrderByOrderId(HttpServletRequest request) {

		int orderId = Integer.parseInt(request.getParameter("orderId"));
		ErpsysOrder ErpsysOrder = eom.queryOrderByOrderId(orderId);

		System.out.println(ErpsysOrder.getProductionName());
		
		request.setAttribute("ErpsysOrder", ErpsysOrder);

	}

	@Override
	public void queryUpdateSellOrderByOrderId(HttpServletRequest request) {

		int orderId=Integer.parseInt(request.getParameter("orderId"));
		ErpsysOrder ErpsysOrder=eom.queryOrderByOrderId(orderId);
		
		request.setAttribute("ErpsysOrder", ErpsysOrder);
		
	}

	

}
