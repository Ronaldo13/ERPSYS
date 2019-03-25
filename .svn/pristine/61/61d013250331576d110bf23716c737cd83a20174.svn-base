package com.hqyj.aspect.zx;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.hqyj.mapper.bt.ErpsysDepartmentMapper;
import com.hqyj.mapper.zx.ErpsysAccountAuthorityMapper;
import com.hqyj.model.bt.ErpsysBasicInformation;
import com.hqyj.model.bt.ErpsysDepartment;
import com.hqyj.model.zx.ErpsysAccountAuthority;


@Aspect
@Component
public class PartmentAOP {
	@Resource
	private ErpsysDepartmentMapper edmapper;
	@Resource
	private ErpsysAccountAuthorityMapper eaamapper;
	
	@After(value="execution(* com.hqyj.controller.bt.ErpsysBasicInformationController.insert(javax.servlet.http.HttpServletRequest,com.hqyj.model.bt.ErpsysBasicInformation))")
	public void addPartmentPower(JoinPoint jp) {
		Object []ob=jp.getArgs();
		ErpsysBasicInformation ebi=null;
		for(int i=1;i<ob.length;i++) {
			ebi=(ErpsysBasicInformation) ob[i];
		}
		ErpsysDepartment ed=edmapper.selectByJobID(ebi.getAccountJobId());//查询部门对应的权限
		//授权过程
		eaamapper.deleteByaccount_id(ebi.getAccountId());
		ErpsysAccountAuthority eaa=new ErpsysAccountAuthority();
		eaa.setAccountId(ebi.getAccountId());
		eaa.setAuthorityId(Integer.parseInt(ed.getDepartmentAuthorityId()));
		eaamapper.insert(eaa);
		
	}
	@AfterReturning(value="execution(* com.hqyj.service.im.bt.ErpsysBasicInformationServiceImpl.deleteById(*))",returning="request")
	public void deletePartmentPower(HttpServletRequest request) {
		String accountid= request.getParameter("accountId");
		eaamapper.deleteByaccount_id(accountid);
	}
	@After(value="execution(* com.hqyj.service.im.bt.ErpsysBasicInformationServiceImpl.update(javax.servlet.http.HttpServletRequest,com.hqyj.model.bt.ErpsysBasicInformation))")
	public void updatePartmentPower(JoinPoint jp) {
		Object []ob=jp.getArgs();
		ErpsysBasicInformation ebi=null;
		for(int i=1;i<ob.length;i++) {
			ebi=(ErpsysBasicInformation) ob[i];
		}
		ErpsysDepartment ed=edmapper.selectByJobID(ebi.getAccountJobId());//查询部门对应的权限
		//授权过程
		eaamapper.deleteByaccount_id(ebi.getAccountId());
		ErpsysAccountAuthority eaa=new ErpsysAccountAuthority();
		eaa.setAccountId(ebi.getAccountId());
		eaa.setAuthorityId(Integer.parseInt(ed.getDepartmentAuthorityId()));
		eaamapper.insert(eaa);
		
	}
	
}
