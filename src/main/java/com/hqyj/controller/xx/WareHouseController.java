package com.hqyj.controller.xx;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.model.xx.WareHouseModel;
import com.hqyj.service.xx.WareHouseService;

@Controller
@RequestMapping("/ware")
public class WareHouseController {
	@Resource
	WareHouseService whs;

	@RequestMapping("/getAllWare.do")
	@RequiresRoles(value= {"admin","godown"},logical=Logical.OR)
	public String SelectAllWare(HttpServletRequest request) {
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null){
			try {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
				int totalnumber=(pageNo-1)*5;
				List<WareHouseModel> wareHouseModels = whs.SelectAllWare(totalnumber);
				request.setAttribute("warelist", wareHouseModels);
				request.setAttribute("pageNo", pageNo);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			List<WareHouseModel> wareHouseModels = whs.SelectAllWare(0);	
			request.setAttribute("warelist", wareHouseModels);
			request.setAttribute("pageNo", pageNo);
		}
		Integer totalInventory= whs.SelectAllTotal();
		request.setAttribute("totalInventory", totalInventory);
		return "xx/warelist";
	}


	@RequestMapping("/addware")
	public String AddWare() {
		return "xx/addware";
	}

	@RequestMapping("/addware/do")
	public String AddWareDo(HttpServletRequest request, WareHouseModel wareHouseModel) {
		whs.AddWareDo(request, wareHouseModel);
		if ("success".equals(request.getAttribute("warning"))) {
			return "forward:/ware/getAllWare.do";
		} else {
			return "forward:/ware/addware";
		}
	}
	@RequestMapping("/delete")
	public String Delete(HttpServletRequest request){
		whs.Delete(request);
		return "forward:/ware/getAllWare.do";
	}
	@RequestMapping("/batchdelete")
	public String batchDelete(HttpServletRequest request){
		whs.batchDelete(request);
		return "forward:/ware/getAllWare.do";
	}
	@RequestMapping("/change")
	public String chang(HttpServletRequest request ){
		whs.showwareByproductionWarehouseId(request);
		return "xx/change";
	}
	@RequestMapping("/subchange")
	public @ResponseBody String subchange(WareHouseModel wareHouseModel,HttpServletRequest request){
		if(whs.updateWareByWareId(wareHouseModel)!=0){
			return "SUCCESS";
		}else{
		return "FAIL";
		}
	}
	@RequestMapping("/getAllInware")
	public String getAllInware(HttpServletRequest request){
		whs.selectAllInware(request);
		return "xx/inwarelist";
	}
	@RequestMapping("/getAlloutware")
	public String getAlloutware(HttpServletRequest request){
		whs.selectAllOutware(request);
		return "xx/outwarelist";
	}
}
