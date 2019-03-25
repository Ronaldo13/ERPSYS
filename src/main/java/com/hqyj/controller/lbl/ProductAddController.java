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
@RequestMapping("/add")
public class ProductAddController {

	@Autowired
	private ProductingService pis;

	@Autowired
	private ProductMaterialService pms;

	@Autowired
	private ProductOutLogService pols;
	

	/**
	 * .增加生产信息
	 * @return
	 */
	@RequestMapping("/addproductingdate")
	@ResponseBody
	public String addproductingdate(HttpServletRequest request) {
		int i = pis.insert(request);
		if (i != 0) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}
	
	/**
	 * .增加材料表信息
	 * @return
	 */
	@RequestMapping("/addproductmaterialdate")
	@ResponseBody
	public String addproductmaterialdate(HttpServletRequest request) {
		int i = pms.insert(request);
		if (i != 0) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	/**
	 * .增加出货日志表信息
	 * @return
	 */
	@RequestMapping("/addproductoutlogdate")
	@ResponseBody
	public String addproductoutlogdate(HttpServletRequest request) {
		int i = pols.insert(request);
		if (i != 0) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}
	
}
