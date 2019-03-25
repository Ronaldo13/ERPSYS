package com.hqyj.mapper.bt;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hqyj.model.bt.ErpsysDepartment;

public interface ErpsysDepartmentMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(ErpsysDepartment record);

    int insertSelective(ErpsysDepartment record);

    ErpsysDepartment selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(ErpsysDepartment record);

    int updateByPrimaryKey(ErpsysDepartment record);

	List<ErpsysDepartment> getAll();

	int getAllCounts();
	
	List<ErpsysDepartment> getAllLimit(Map<String,Object> map);

	ErpsysDepartment selectByJobID(@Param("accountJobId")Integer accountJobId);



	


}