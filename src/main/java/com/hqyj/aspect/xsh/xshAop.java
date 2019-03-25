package com.hqyj.aspect.xsh;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hqyj.model.xx.WareHouseModel;
import com.hqyj.service.xsh.OrderMannagementService;

@Aspect
@Component
public class xshAop {
	@Autowired
	OrderMannagementService oms;

	@After(value = "execution(* com.hqyj.service.im.xx.WareHouseServiceImpl.AddWareFromOrder(javax.servlet.http.HttpServletRequest, com.hqyj.model.xx.WareHouseModel))")
	public void add(JoinPoint jp) {
		Object[] jps = jp.getArgs();
		HttpServletRequest request = (HttpServletRequest) jps[0];
		WareHouseModel wareHouseModel = (WareHouseModel) jps[1];
		int orderid = Integer.parseInt(request.getAttribute("gaveorderid") + "");
		System.out.println(orderid+"%%%%%%"+wareHouseModel.getProductionWarehouseId());
		oms.updateProductionWarehouseIdByOrderid(orderid, wareHouseModel.getProductionWarehouseId());
	}

}
