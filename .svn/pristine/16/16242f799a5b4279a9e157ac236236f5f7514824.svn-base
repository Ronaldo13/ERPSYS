package com.hqyj.controller.xsh;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.service.xsh.OrderMannagementService;
import com.hqyj.service.xsh.SellOrderMannagementService;

@Controller
@RequestMapping("/SellOrderMannagementController")
public class SellOrderMannagementController {

	@Resource
	private SellOrderMannagementService soms;

	
	@Resource
	private OrderMannagementService oms;
	
	@RequestMapping("/queryAllSellOrderByOrderType")
	public String queryAllBuyOrderByOrderType(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		
		soms.queryAllSellOrder(request);

		System.out.println("ooo");

		return "xsh/SellOrderMannagement2";

	}
	
	@RequestMapping("/deleteSellOrderByBuyLogId")
	public String deleteSellOrderByBuyLogId(HttpServletRequest request){
		
		soms.deleteSellOrderByBuyLogId(request);
		
		return "redirect:/SellOrderMannagementController/queryAllSellOrderByOrderType";
	}

	@RequestMapping("/querySellOrderByOrderId")
	public String querySellOrderByOrderId(HttpServletRequest request){
		soms.querySellOrderByOrderId(request);
		
		return "xsh/OrderMannagement3";
		
	}
	
	@RequestMapping("/queryUpdateSellOrderByOrderId")
	public String queryUpdateSellOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		soms.queryUpdateSellOrderByOrderId(request);
		
		return "xsh/updateOrder3";
		
		
	}
	
	@RequestMapping("/updateSellOrderByOrderId")
	public String updateSellOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		oms.updateOrderByOrderId(request);
		return "forward:/SellOrderMannagementController/queryAfterUpdateSellOrderByOrderId";
		
		
	}
	
	@RequestMapping("/queryAfterUpdateSellOrderByOrderId")
	public String queryAfterUpdateSellOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		oms.queryOrderByOrderId(request);
		
		return "xsh/OrderMannagement3";
		
	}
	
	@RequestMapping("/deleteSellOrderByOrderId")
	public String deleteSellOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		oms.deleteOrderByOrderId(request);
		return "redirect:/SellOrderMannagementController/queryAllSellOrderByOrderType";
		
		
	}
}
