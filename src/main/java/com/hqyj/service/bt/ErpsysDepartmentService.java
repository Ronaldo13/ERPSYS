package com.hqyj.service.bt;

import javax.servlet.http.HttpServletRequest;


import com.hqyj.model.bt.ErpsysDepartment;

public interface ErpsysDepartmentService {

	HttpServletRequest main2(HttpServletRequest request);



	HttpServletRequest deleteById(HttpServletRequest request);

	HttpServletRequest update(HttpServletRequest request, ErpsysDepartment departmentId);

	HttpServletRequest insert(HttpServletRequest request, ErpsysDepartment departmentId);







	HttpServletRequest modifyBA(HttpServletRequest request);



	HttpServletRequest addBA(HttpServletRequest request);



	HttpServletRequest initmodifyEDPage(HttpServletRequest request);

}
