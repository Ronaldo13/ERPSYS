package com.hqyj.aspect.xx;

import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


import com.hqyj.model.xx.InWareHouseModel;
import com.hqyj.model.xx.OutWareHouseModel;
import com.hqyj.model.xx.WareHouseModel;
import com.hqyj.service.xx.WareHouseService;

@Aspect
@Component
public class wareHouseAop {
	@Autowired
	WareHouseService whs;
	//切面个人增加库存方法
	static 		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@AfterReturning(value="execution(* com.hqyj.controller.xx.WareHouseController.AddWareDo(..))",returning="page")
	public void AddWareDoAop(JoinPoint jp,String page) {
		Date date=new Date();
		Object[] jP=jp.getArgs();
		@SuppressWarnings("unused")
		HttpServletRequest request =(HttpServletRequest)jP[0];
		WareHouseModel whm=(WareHouseModel)jP[1];
		InWareHouseModel iwhm=new InWareHouseModel();
		iwhm.setProductionWarehouseId(whm.getProductionWarehouseId());
		iwhm.setInWarehouseNumber(whm.getProductionNumber());
		iwhm.setInWarehouseReason("库存系统内部增加");
		iwhm.setInWarehouseTime(date);
		try {
			whs.addInwareLog(iwhm);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("日志增加出错");
		}
	}//切面个人增加出库方法
	@Before(value="execution(* com.hqyj.controller.xx.WareHouseController.Delete(..))")
	public void DeleteAop(JoinPoint jp){
		Date date = new Date();
		Object[] jps= jp.getArgs();
		HttpServletRequest request=(HttpServletRequest)jps[0];
		int productionWarehouseId=Integer.parseInt(request.getParameter("id"));
		WareHouseModel wareHouseModel=whs.selectByProductionWarehouseId(productionWarehouseId);
		OutWareHouseModel outWareHouseModel=new OutWareHouseModel();
		outWareHouseModel.setOutWarehouseTime(date);
		outWareHouseModel.setProductionWarehouseId(wareHouseModel.getProductionWarehouseId());
		outWareHouseModel.setOutWarehouseNumber(wareHouseModel.getProductionNumber());
		outWareHouseModel.setOutWarehouseReason("仓库个人出库");
	    try {
			whs.addOutLog(outWareHouseModel);
		} catch (Exception e) {
			System.out.println("增加出库日志错误");
		}
		
	}//切面订单，库存表切订单增加方法
	@After(value="execution(* com.hqyj.controller.xsh.OrderMannagementController.IncreaseOrderMannagement(..))")
	public void addwareAop(JoinPoint jp){
	Object[] jps=jp.getArgs();
	HttpServletRequest request= (HttpServletRequest)jps[0];
	WareHouseModel wareHouseModel = new WareHouseModel();
	wareHouseModel.setProductionName(request.getParameter("productionName"));
	wareHouseModel.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
	wareHouseModel.setProductionType(request.getParameter("productionType"));
	whs.AddWareFromOrder(request, wareHouseModel);
	}//切面仓库，入库和出库日志切入库增加方法
	@After(value="execution(* com.hqyj.service.im.xx.WareHouseServiceImpl.AddWareFromOrder(..))")
	public void AddWareFromOrderAop(JoinPoint jp){
		Object[] jps=jp.getArgs();
		Date date=new Date();
		HttpServletRequest request = (HttpServletRequest)jps[0];
		WareHouseModel whm=(WareHouseModel)jps[1];
		if (1==(Integer.parseInt(request.getParameter("orderType")))) {
			InWareHouseModel inWareHouseModel= new InWareHouseModel();
			inWareHouseModel.setProductionWarehouseId(whm.getProductionWarehouseId());
			inWareHouseModel.setOrderId(Integer.parseInt(request.getAttribute("gaveorderid")+""));
			inWareHouseModel.setInWarehouseTime(date);
			inWareHouseModel.setInWarehouseNumber(Integer.parseInt(request.getParameter("productionNumber")));
			inWareHouseModel.setInWarehouseReason("采购订单");
			try {
				whs.addInwareLog(inWareHouseModel);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("日志增加出错");
			}
		}else if(0==Integer.parseInt(request.getParameter("orderType"))){
			OutWareHouseModel outWareHouseModel =new OutWareHouseModel();
			outWareHouseModel.setOutWarehouseNumber(Integer.parseInt(request.getParameter("productionNumber")));
			outWareHouseModel.setOutWarehouseTime(date);
			outWareHouseModel.setProductionWarehouseId(whm.getProductionWarehouseId());
			outWareHouseModel.setOrderId(Integer.parseInt(request.getAttribute("gaveorderid")+""));
			outWareHouseModel.setOutWarehouseReason("销售订单");
		    try {
				whs.addOutLog(outWareHouseModel);
			} catch (Exception e) {
				System.out.println("增加出库日志错误");
			}
		}else {
			System.out.println("订单类型错误--xx--aop--AddWareFromOrderAop");
		}

	}//切面仓库，切生产消耗
	@After(value="execution(* com.hqyj.service.im.lbl.ProductMaterialServiceImpl.insert(javax.servlet.http.HttpServletRequest))")
	public void insertFromProduction(JoinPoint jp){
		Date date =new Date();
		Object[] jps=jp.getArgs();
		HttpServletRequest request=(HttpServletRequest)jps[0];
		WareHouseModel wareHouseModel = new WareHouseModel();
		wareHouseModel.setProductionWarehouseId(Integer.parseInt(request.getParameter("production_warehouse_id")));
		wareHouseModel.setProductionName(request.getParameter("product_name"));
		wareHouseModel.setProductionNumber(Integer.parseInt(request.getParameter("product_number")));
		wareHouseModel.setProductionType(request.getParameter("product_type"));
		WareHouseModel ware=whs.selectByProductionWarehouseId(wareHouseModel.getProductionWarehouseId());
		if (ware.getProductionWarehouseId()!=null && request.getParameter("product_name").equals(ware.getProductionName()) && ware.getProductionNumber()>=Integer.parseInt(request.getParameter("product_number"))  ) {
				int number = ware.getProductionNumber()-Integer.parseInt(request.getParameter("product_number"));
				try {
					whs.updateProductNumberByProductionWarehouseId(wareHouseModel.getProductionWarehouseId(),number);
				} catch (Exception e) {
					e.printStackTrace();
				}
				OutWareHouseModel outWareHouseModel = new OutWareHouseModel();
				outWareHouseModel.setOutWarehouseNumber(Integer.parseInt(request.getParameter("product_number")));
				outWareHouseModel.setOutWarehouseReason("生产部门原材料出库:已出库生产部门原材料部已获取");
				outWareHouseModel.setOutWarehouseStatus("1");
				outWareHouseModel.setOutWarehouseTime(date);
				outWareHouseModel.setProductionWarehouseId(wareHouseModel.getProductionWarehouseId());
			    try {
					whs.addOutLog(outWareHouseModel);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("增加出库日志错误");
				}
			
		} else {
			OutWareHouseModel outWareHouseModel = new OutWareHouseModel();
			outWareHouseModel.setOutWarehouseStatus("0");
			outWareHouseModel.setOutWarehouseTime(date);
			outWareHouseModel.setOutWarehouseReason("生产部门原材料出库但未能出库:生产部门尝试获取库存部门未能存在请申请订单");
		    try {
				whs.addOutLog(outWareHouseModel);
			} catch (Exception e) {
				System.out.println("增加出库日志错误");
			}
		}
	}
	@After(value="execution(* com.hqyj.service.im.lbl.ProductingServiceImpl.insert(..))")
	public void insertFromProduct(JoinPoint jp){
		Date date =new Date();
		Object[] jps = jp.getArgs();
		HttpServletRequest request =(HttpServletRequest)jps[0];
		WareHouseModel wareHouseModel = new WareHouseModel();
		wareHouseModel.setProductionName(request.getParameter("product_name"));
		wareHouseModel.setProductionNumber(Integer.parseInt(request.getParameter("product_number")));
		wareHouseModel.setProductionType(request.getParameter("product_type"));
		whs.AddWareFromProduct(wareHouseModel);
		InWareHouseModel inWareHouseModel = new InWareHouseModel();
		inWareHouseModel.setInWarehouseTime(date);
		inWareHouseModel.setInWarehouseReason("生产部门入库");
		inWareHouseModel.setInWarehouseNumber(Integer.parseInt(request.getParameter("product_number")));
		inWareHouseModel.setProductionWarehouseId(wareHouseModel.getProductionWarehouseId());
		whs.addInwareLog(inWareHouseModel);
	}
	
}
