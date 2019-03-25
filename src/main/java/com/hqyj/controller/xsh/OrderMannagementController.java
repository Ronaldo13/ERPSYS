package com.hqyj.controller.xsh;


import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.service.xsh.OrderMannagementService;

@Controller
@RequestMapping("/OrderMannagementController")
public class OrderMannagementController {

	@Resource
	private  OrderMannagementService bms;
	
	
	@RequestMapping("/buy")
	public String BuyOrderMannagement() {
		
		System.out.println("pp");
		
		return "xsh/OrderMannagement";
		
	}
	
	@RequestMapping("/increase")
	public String IncreaseOrder() {
		
		
		
		return "xsh/Increase";
		
	}
	
	@RequestMapping("/IncreaseOrder")
	public String IncreaseOrderMannagement(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		bms.addOrder(request);
		
		return "redirect:/OrderMannagementController/queryAlltOrder";
		
	}
	@RequestMapping("/deleteOrder")
	public String deleteOrder(HttpServletRequest request){
		
		bms.deleteOrderByOrderId(request);
		System.out.println("aa");
		return "redirect:/OrderMannagementController/queryAlltOrder";
	
	}
	@RequestMapping(value="/queryAlltOrder",produces="text/html; charset=UTF-8")
	public String queryAlltOrder(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		bms.queryAllOrder(request);
		
		return "xsh/OrderMannagement";
		
	}
	
	@RequestMapping(value="/queryOrderByOrderId",produces="text/html; charset=UTF-8")
	public String queryOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		bms.queryOrderByOrderId(request);
		
		return "xsh/updateOrder";
		
	}
	
	@RequestMapping(value="/updateOrderByOrderId",produces="text/html; charset=UTF-8")
	public String updateOrderByOrderId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//设置UTF-8的显示页面的类型和字符集
		request.setCharacterEncoding("utf-8");
		bms.updateOrderByOrderId(request);
		System.out.println("aaaaaaaaa");
		return "redirect:/OrderMannagementController/queryAlltOrder";
		
	}
}
