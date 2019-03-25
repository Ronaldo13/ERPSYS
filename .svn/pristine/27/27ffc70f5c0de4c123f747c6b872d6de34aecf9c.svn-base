package com.hqyj.controller.xsh;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.service.xsh.BuyOrderMannagementService;
import com.hqyj.service.xsh.OrderMannagementService;

@Controller
@RequestMapping("/BuyOrderMannagementController")
public class BuyOrderMannagementController {

	@Resource
	private BuyOrderMannagementService boms;
	
	@Resource
	private  OrderMannagementService bms;
	@RequestMapping("/queryAllBuyOrderByOrderType")
	public String queryAllBuyOrderByOrderType(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		
		boms.queryAllBuyOrder(request);

		

		return "xsh/BuyOrderMannagement";

	}
	
	@RequestMapping("/deleteBuyOrderByBuyLogId")
	public String deleteBuyOrderByBuyLogId(HttpServletRequest request){
		
		boms.deleteBuyOrderByBuyLogId(request);
		
		return "redirect:/BuyOrderMannagementController/queryAllBuyOrderByOrderType";
		
	}
	
	@RequestMapping("/queryBuyOrderByOrderId")
	public String queryBuyOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		boms.queryBuyOrderByOrderId(request);
		
		return "xsh/OrderMannagement2";
		
		
	}
	
	@RequestMapping("/queryUpdateBuyOrderByOrderId")
	public String queryUpdateBuyOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		boms.queryUpdateBuyOrderByOrderId(request);
		
		return "xsh/updateOrder2";
		
		
	}
	
	@RequestMapping("/updateBuyOrderByOrderId")
	public String updateBuyOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		bms.updateOrderByOrderId(request);
		
		return "forward:/BuyOrderMannagementController/queryAfterUpdateBuyOrderByOrderId";
		
		
	}
	
	@RequestMapping("/queryAfterUpdateBuyOrderByOrderId")
	public String queryAfterUpdateBuyOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		bms.queryOrderByOrderId(request);
		
		return "xsh/OrderMannagement2";
		
	}
	

	@RequestMapping("/deleteBuyOrderByOrderId")
	public String deleteBuyOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		bms.deleteOrderByOrderId(request);
		return "redirect:/BuyOrderMannagementController/queryAllBuyOrderByOrderType";
		
	}
}
