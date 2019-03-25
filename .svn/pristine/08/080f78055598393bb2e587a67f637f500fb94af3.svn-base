package com.hqyj.service.im.bt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.mapper.bt.ErpsysBasicInformationMapper;
import com.hqyj.mapper.bt.ErpsysDepartmentMapper;
import com.hqyj.mapper.bt.ErpsysJobMapper;
import com.hqyj.model.bt.ErpsysBasicInformation;
import com.hqyj.model.bt.ErpsysDepartment;
import com.hqyj.model.bt.ErpsysJob;
import com.hqyj.service.bt.ErpsysBasicInformationService;

@Service
public class ErpsysBasicInformationServiceImpl implements ErpsysBasicInformationService {

	@Autowired
	private ErpsysBasicInformationMapper ebi;
	@Autowired
	private ErpsysDepartmentMapper  ed;
	@Autowired
	private ErpsysJobMapper ej;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

	@Override
	public HttpServletRequest main1(HttpServletRequest request) {
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
		List<ErpsysBasicInformation> erpsysBasicInformations = ebi.getAllLimit(map); // 调用业务层方法
		for (ErpsysBasicInformation erpsysBasicInformation : erpsysBasicInformations) {
			try {
				String dateString = sdf.format(erpsysBasicInformation.getAccountEntryTime());
				erpsysBasicInformation.setAccountEntryTimeString(dateString);
			} catch (Exception e) {
			}
		}
		int totalRecords = ebi.getAllCounts();
		int totalPage = (int)Math.ceil((double)totalRecords/(double)pageSize);
		List<Map<String,Object>> erpsysBasicInformationsList= new ArrayList<Map<String,Object>>();
		for (ErpsysBasicInformation erpsysBasicInformation : erpsysBasicInformations) {
			Map<String,Object> map1 = new HashMap<String, Object>();
			map1.put("erpsysBasicInformation", erpsysBasicInformation);
			try {
				int jobId = erpsysBasicInformation.getAccountJobId();
				ErpsysJob erpsysJob = ej.selectByPrimaryKey(jobId);
				map1.put("erpsysJob", erpsysJob);
				try {
					int departmentId = erpsysJob.getDepartmentId();
					ErpsysDepartment erpsysDepartment = ed.selectByPrimaryKey(departmentId);
					map1.put("erpsysDepartment", erpsysDepartment);
				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			erpsysBasicInformationsList.add(map1);
		}
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("erpsysBasicInformationsList", erpsysBasicInformationsList);// 把从数据库取到的数据放入到model中
		return request;
	}

	@Override
	public HttpServletRequest addBI(HttpServletRequest request) {
		List<ErpsysJob> jobList = ej.getAll();
		request.setAttribute("jobList", jobList);
		request.setAttribute("nowTime", sdf.format(new Date()));
		return request;
	}

	@Override
	public HttpServletRequest insert(HttpServletRequest request, ErpsysBasicInformation basicInformation) {
		String password = new SimpleHash("MD5", new String(basicInformation.getAccountPwd()), basicInformation.getAccountId(), 1024).toString();
		basicInformation.setAccountPwd(password);
		if(ebi.selectByPrimaryKey(basicInformation.getAccountId())!=null){
			request.setAttribute("warning", "新增员工失败！员工id不能重复！");
		}else{
			ebi.insertSelective(basicInformation);
		}
		return request;
	}

	@Override
	public HttpServletRequest modifyBI(HttpServletRequest request) {

		return request;
	}

	@Override
	public HttpServletRequest update(HttpServletRequest request, ErpsysBasicInformation accountId) {
		ebi.updateByPrimaryKeySelective(accountId);
		return request;
	}

	@Override
	public HttpServletRequest deleteById(HttpServletRequest request) {
		ebi.deleteByPrimaryKey(request.getParameter("accountId"));
		return request;
	}

	@Override
	public HttpServletRequest initmodifyEBIPage(HttpServletRequest request) {
		String accountId = request.getParameter("accountId");
		ErpsysBasicInformation ebf = ebi.selectByPrimaryKey(accountId);
		try {
			ebf.setAccountEntryTimeString(sdf.format(ebf.getAccountEntryTime()));
		} catch (Exception e) {
			
		}
		request.setAttribute("erpsysBasicInformation", ebf);
		List<ErpsysJob> jobList = ej.getAll();
		request.setAttribute("jobList", jobList);
		return request;
	}



}
