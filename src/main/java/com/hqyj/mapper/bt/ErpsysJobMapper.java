package com.hqyj.mapper.bt;

import java.util.List;
import java.util.Map;


import com.hqyj.model.bt.ErpsysJob;

public interface ErpsysJobMapper {
    int deleteByPrimaryKey(Integer jobId);

    int insert(ErpsysJob record);

    int insertSelective(ErpsysJob record);

    ErpsysJob selectByPrimaryKey(Integer jobId);

    int updateByPrimaryKeySelective(ErpsysJob record);

    int updateByPrimaryKey(ErpsysJob record);

	List<ErpsysJob> getAll();

	int getAllCounts();

	List<ErpsysJob> getAllLimit(Map<String, Object> map);
}