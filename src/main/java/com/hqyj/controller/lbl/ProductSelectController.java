package com.hqyj.controller.lbl;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.service.lbl.ProductMaterialService;
import com.hqyj.service.lbl.ProductOutLogService;
import com.hqyj.service.lbl.ProductingService;

@Controller
@RequestMapping("/select")
public class ProductSelectController {

	
	@Autowired
	private ProductingService pis;
	@Autowired
	private ProductMaterialService pms;
	@Autowired
	private ProductOutLogService pols;

	
	
	/**
	 * .查询生产表信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="selectProductTable",produces="text/html; charset=UTF-8")
	@ResponseBody
	public String selectProductTable(HttpServletRequest request) {
		return pis.selectProductTableByJson(request);
	}
	/**
	 * .获取生产表分页信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/getProductPageInfo")
	@ResponseBody
	public String getProductPageInfo(HttpServletRequest request) {
		return pis.getPageInfo(request);
	}
	/**
	 * .将上面数据整合
	 * @param request
	 * @return
	 */
	@RequestMapping("/doProductSreach")
	public String doSreach(HttpServletRequest request) {
		String sendSreachName=request.getParameter("sendSreachName");
		request.setAttribute("sendSreachName", sendSreachName);
		return "lbl/producting";
	}

	
	/**
	 * .查询生产材料表信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="selectProductMaterialTable",produces="text/html; charset=UTF-8")
	@ResponseBody
	public String selectProductMaterialTable(HttpServletRequest request) {
		return pms.selectProductMaterialTableByJson(request);
	}
	/**
	 * .获取生产材料表分页信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/getProductMaterialPageInfo")
	@ResponseBody
	public String getProductMaterialPageInfo(HttpServletRequest request) {
		return pms.getPageInfo(request);
	}
	/**
	 * .将上面数据整合
	 * @param request
	 * @return
	 */
	@RequestMapping("/doProductMaterialSreach")
	public String doProductMaterialSreach(HttpServletRequest request) {
		String sendSreachName=request.getParameter("sendSreachName");
		request.setAttribute("sendSreachName", sendSreachName);
		return "lbl/productmaterial";
	}
	/**
	 * .通过原材料表里面的出库日志编号查到该编号在出库日志表里的详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectOutWareHouseLog")
	public String selectOutWareHouseLog(HttpServletRequest request) {
		pms.selectOutWareHouseLog(request);
		return "lbl/outwarehouselog";
	}
	/**
	 * .通过原材料表里面的产品库存编号查询到该产品在仓库表中的详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectWareHouseDate")
	public String selectWareHouseDate(HttpServletRequest request) {
		pms.selectWareHouseDate(request);
		return "lbl/warehouse";
	}
	
	/**
	 * .查询出货日志表信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="selectProductOutLogTable",produces="text/html; charset=UTF-8")
	@ResponseBody
	public String selectProductOutLogTable(HttpServletRequest request) {
		return pols.selectProductOutLogTableByJson(request);
	}
	/**
	 * .获取出货日志表分页信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/getProductOutLogPageInfo")
	@ResponseBody
	public String getProductOutLogPageInfo(HttpServletRequest request) {
		return pols.getPageInfo(request);
	}
	/**
	 * .将上面数据整合
	 * @param request
	 * @return
	 */
	@RequestMapping("/doProductOutLogSreach")
	public String doProductOutLogSreach(HttpServletRequest request) {
		String sendSreachName=request.getParameter("sendSreachName");
		request.setAttribute("sendSreachName", sendSreachName);
		return "lbl/productoutlog";
	}
	/**
	 * .通过出货日志表里面的出货日志编号查询到该编号在入库日志表中的详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectInWareHouseLog")
	public String selectInWareHouseLog(HttpServletRequest request) {
		pols.selectInWareHouseLog(request);
		return "lbl/inwarehouselog";
	}
	
}
