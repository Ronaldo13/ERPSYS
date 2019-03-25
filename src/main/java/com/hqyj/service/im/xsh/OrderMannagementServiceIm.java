package com.hqyj.service.im.xsh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hqyj.mapper.xsh.ErpsysBuyLogMapper;
import com.hqyj.mapper.xsh.ErpsysOrderMapper;
import com.hqyj.mapper.xsh.ErpsysSellLogMapper;
import com.hqyj.model.xsh.ErpsysBuyLog;
import com.hqyj.model.xsh.ErpsysOrder;
import com.hqyj.model.xsh.ErpsysSellLog;
import com.hqyj.service.xsh.OrderMannagementService;

@Service
public class OrderMannagementServiceIm implements OrderMannagementService{

	@Resource
	private ErpsysOrderMapper ErpsysOrderMapper ;
	@Resource
	private ErpsysBuyLogMapper ErpsysBuyLogMapper;
	
	@Resource
	private ErpsysSellLogMapper ErpsysSellLogMapper;
		
	
	@Override
	public void addOrder(HttpServletRequest request) {
		
//		将从界面接受的String类型数据转换为data类型
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date= sdf.parse(request.getParameter("orderTime")+" 00:00:00");
			String date2= sdf.format(date);
			System.out.println(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		

//	将界面的数据放入model层中	
		ErpsysOrder eo=new ErpsysOrder();
		
		eo.setSeller(request.getParameter("seller"));
		eo.setBuyer(request.getParameter("buyer"));
		eo.setOrderLocahost(request.getParameter("orderLocahost"));
		
		
		eo.setOrderType(Integer.parseInt(request.getParameter("orderType")));
		
		
		eo.setProductUnitPrice(Double.parseDouble(request.getParameter("productUnitPrice")));
		eo.setProductionTotalPrice(Double.parseDouble(request.getParameter("productionTotalPrice")));
		eo.setProductionName(request.getParameter("productionName"));
		eo.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
		eo.setProductionType(request.getParameter("productionType"));
		
		
		eo.setProductionWarehouseId(Integer.parseInt(request.getParameter("productionWarehouseId")));
		
		
		String orderAuditStatus=request.getParameter("orderAuditStatus");
		if("0".equals(orderAuditStatus)){
			eo.setOrderAuditStatus(orderAuditStatus);
		}else if("1".equals(orderAuditStatus)){
			eo.setOrderAuditStatus(orderAuditStatus);
		}
		
		
		eo.setOrderTime(date);
		ErpsysOrderMapper.insert(eo);
		request.setAttribute("gaveorderid", eo.getOrderId());
		
		
		
		
		if (eo.getOrderType()==1) {
			ErpsysBuyLog ErpsysBuyLog=new ErpsysBuyLog();
			ErpsysBuyLog.setOrderId(eo.getOrderId());
			ErpsysBuyLog.setSeller(eo.getSeller());
			ErpsysBuyLog.setBuyTime(date);
			ErpsysBuyLog.setBuyNumber(eo.getProductionNumber());
			ErpsysBuyLogMapper.addBuyOrder(ErpsysBuyLog);
		}
		else if(eo.getOrderType()==0){
			ErpsysSellLog ErpsysSellLog=new ErpsysSellLog();
			ErpsysSellLog.setOrderId(eo.getOrderId());
			ErpsysSellLog.setBuyer(eo.getBuyer());
			ErpsysSellLog.setSellTime(eo.getOrderTime());
			ErpsysSellLog.setSellNumber(eo.getProductionNumber());
			ErpsysSellLogMapper.insert(ErpsysSellLog);
		}
		
		
		
		System.out.println(eo.getOrderId());
		
		
	
		
	}


	@Override
	public int deleteOrderByOrderId(HttpServletRequest request) {
		
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		return ErpsysOrderMapper.deleteOrderByOrderId(orderId);
	}


	@Override
	public void queryAllOrder(HttpServletRequest request) {
		List<ErpsysOrder> a=ErpsysOrderMapper.queryAllOrder();
		
//		for (ErpsysOrder erpsysOrder : a) {
//			System.out.println(erpsysOrder);
//		}
		request.setAttribute("ErpsysOrderList", a);
		
	}


	


	@Override
	public void queryOrderByOrderId(HttpServletRequest request) {
		
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		ErpsysOrder aeo=ErpsysOrderMapper.queryOrderByOrderId(orderId);
		request.setAttribute("ErpsysOrder", aeo);
		
	}


	@Override
	public void updateOrderByOrderId(HttpServletRequest request) {
		
//		将从界面接受的String类型数据转换为data类型
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date= sdf.parse(request.getParameter("orderTime")+" 00:00:00");
			String date2= sdf.format(date);
			System.out.println(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ErpsysOrder eo=new ErpsysOrder();
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		eo.setOrderId(orderId);
		eo.setSeller(request.getParameter("seller"));
		eo.setBuyer(request.getParameter("buyer"));
		eo.setOrderLocahost(request.getParameter("orderLocahost"));
		eo.setOrderType(Integer.parseInt(request.getParameter("orderType")));
		eo.setProductUnitPrice(Double.parseDouble(request.getParameter("productUnitPrice")));
		eo.setProductionTotalPrice(Double.parseDouble(request.getParameter("productionTotalPrice")));
		eo.setProductionName(request.getParameter("productionName"));
		eo.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
		eo.setProductionType(request.getParameter("productionType"));
		eo.setProductionWarehouseId(Integer.parseInt(request.getParameter("productionWarehouseId")));
		eo.setOrderAuditStatus(request.getParameter("orderAuditStatus"));
		eo.setOrderTime(date);
		ErpsysOrderMapper.updateByPrimaryKey(eo);
		
		System.out.println(orderId);
	}


	@Override
	public void updateProductionWarehouseIdByOrderid(int orderid, Integer productionWarehouseId) {
		Map<String, Integer> upMap=new HashMap<>();
		upMap.put("id", orderid);
		upMap.put("productionWarehouseId", productionWarehouseId);
		ErpsysOrderMapper.updateProductionWarehouseIdByOrderid(upMap);
		ErpsysBuyLogMapper.updateProductionWarehouseIdByOrderid(upMap);
		ErpsysSellLogMapper.updateProductionWarehouseIdByOrderid(upMap);
	}


	


	
	
	

}
