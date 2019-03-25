package com.hqyj.controller.lbl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.service.lbl.ProductMaterialService;
import com.hqyj.service.lbl.ProductOutLogService;
import com.hqyj.service.lbl.ProductingService;

@Controller
@RequestMapping("/update")
public class ProductUpdateController {

	
	@Autowired
	private ProductMaterialService pms;
	@Autowired
	private ProductingService ps;
	@Autowired
	private ProductOutLogService pols;
	
	
	
	/**
	 * .修改生产信息表
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateproductdate")
	public String updateproductdate(HttpServletRequest request) {
		request = ps.initUpdateproductdatePage(request);
		return "lbl/updateproductdate";
	}
	@RequestMapping("/updateproductdate2")
	public String updateproductdate2(HttpServletRequest request) {
		ps.updateByPrimaryKey(request);
		return "redirect:/select/doProductSreach";
	}
	
	
	/**
	 * .修改原材料信息表
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateproductmaterialdate")
	public String updateproductmaterialdate(HttpServletRequest request) {
		request = pms.initUpdateproductmaterialsdatePage(request);
		return "lbl/updateproductmaterialdate";
	}
	@RequestMapping("/updateproductmaterialdate2")
	public String updateproductmaterialdate2(HttpServletRequest request) {
		pms.updateByPrimaryKey(request);
		return "redirect:/select/doProductMaterialSreach";
	}
	
	/**
	 * .修改出货日志信息表
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateproductoutlogdate")
	public String updateproductoutlogdate(HttpServletRequest request) {
		request = pols.initUpdateproductoutlogdatePage(request);
		return "lbl/updateproductoutlogdate";
	}
	@RequestMapping("/updateproductoutlogdate2")
	public String updateproductoutlogdate2(HttpServletRequest request) {
		pols.updateByPrimaryKey(request);
		return "redirect:/select/doProductOutLogSreach";
	}
	
	
}
