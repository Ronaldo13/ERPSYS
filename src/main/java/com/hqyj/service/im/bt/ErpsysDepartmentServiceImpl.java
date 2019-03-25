package com.hqyj.service.im.bt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.mapper.bt.ErpsysDepartmentMapper;

import com.hqyj.model.bt.ErpsysDepartment;
import com.hqyj.service.bt.ErpsysDepartmentService;



@Service
public class ErpsysDepartmentServiceImpl implements ErpsysDepartmentService {
	@Autowired
	private ErpsysDepartmentMapper ed;
	@Override
	public HttpServletRequest main2(HttpServletRequest request) {
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (Exception e) {
		}
		int pageSize = 7;
		int pageNoLimit = (pageNo-1)*pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pageSize", pageSize);
		map.put("pageNoLimit", pageNoLimit);
		List<ErpsysDepartment> erpsysDepartments = ed.getAllLimit(map); // 调用业务层方法
		int totalRecords = ed.getAllCounts();
		int totalPage = (int)Math.ceil((double)totalRecords/(double)pageSize);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("erpsysDepartments", erpsysDepartments);// 把从数据库取到的数据放入到model中
		return request;
	}
	@Override
	public HttpServletRequest deleteById(HttpServletRequest request) {
		ed.deleteByPrimaryKey(Integer.parseInt(request.getParameter("departmentId")));
		return request;
	}
	@Override
	public HttpServletRequest update(HttpServletRequest request, ErpsysDepartment departmentId) {
		ed.updateByPrimaryKeySelective(departmentId);
		return request;
	}
	@Override
	public HttpServletRequest insert(HttpServletRequest request, ErpsysDepartment departmentId) {
		ed.insertSelective(departmentId);
		return request;
	}
	@Override
	public HttpServletRequest initmodifyEDPage(HttpServletRequest request) {
	    String dt=request.getParameter("departmentId");
	    int departmentId =Integer.parseInt(dt);
	
		ErpsysDepartment edt = ed.selectByPrimaryKey(departmentId);
		request.setAttribute("erpsysDepartment", edt);
		return request;
	}
	@Override
	public HttpServletRequest modifyBA(HttpServletRequest request) {
		
		return request;
	}
	@Override
	public HttpServletRequest addBA(HttpServletRequest request) {
	
		return request;
	}

}
