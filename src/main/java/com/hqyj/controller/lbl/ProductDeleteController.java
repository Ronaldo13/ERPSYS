package com.hqyj.controller.lbl;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.service.lbl.ProductMaterialService;
import com.hqyj.service.lbl.ProductOutLogService;
import com.hqyj.service.lbl.ProductingService;

@Controller
@RequestMapping("/delete")
public class ProductDeleteController {

	@Autowired
	private ProductMaterialService pms;
	@Autowired
	private ProductingService ps;
	@Autowired
	private ProductOutLogService pols;

	/**
	 * .原材料表
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteproductmaterialdate")
	@ResponseBody
	public String deleteproductmaterialdate(HttpServletRequest request) {
		int i = pms.deleteByPrimaryKey(request);
		if (i != 0) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	/**
	 * .批量删除原材料表
	 * @param request
	 * @return
	 */
	@RequestMapping("/PLdeleteproductmaterialdate")
	@ResponseBody
	public String PLdeleteproductmaterialdate(HttpServletRequest request) {
		if (pms.PLdeleteproductmaterialdate(request) != 0) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	/**
	 * .生产表
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteproductdate")
	@RequiresRoles(value= {"admin","produce"},logical=Logical.OR)
	@ResponseBody
	public String deleteproductdate(HttpServletRequest request) {
		int i = ps.deleteByPrimaryKey(request);
		if (i != 0) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	/**
	 * .批量删除生产表信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/PLdeleteproductdate")
	@ResponseBody
	public String PLdeleteproductdate(HttpServletRequest request) {
		if(ps.PLdeleteproductdate(request)!=0) {
			return "SUCCESS";
		}else {
			return "FAIL";
		}
	}


	/**
	 * .出货日志表
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteproductoutlogdate")
	@ResponseBody
	public String deleteproductoutlogdate(HttpServletRequest request) {
		int i = pols.deleteByPrimaryKey(request);
		if (i != 0) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}
	/**
	 * .批量删除出货日志表信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/PLdeleteproductoutlogdate")
	@ResponseBody
	public String  PLdeleteproductoutlogdate(HttpServletRequest request) {
		if(pols.PLdeleteproductoutlogdate(request)!=0) {
			return "SUCCESS";
		}else {
			return "FAIL";
		}
	}
	
	
}