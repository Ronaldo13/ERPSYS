package com.hqyj.mapper.hth;

import java.util.List;
import java.util.Map;

import com.hqyj.model.hth.ErpsysFinanceLog;

public interface ErpsysFinanceLogMapper {
    int deleteByPrimaryKey(Integer financeLogId);

    int insert(ErpsysFinanceLog record);

    int insertSelective(ErpsysFinanceLog record);

    ErpsysFinanceLog selectByPrimaryKey(Integer financeLogId);

    int updateByPrimaryKeySelective(ErpsysFinanceLog record);

    int updateByPrimaryKey(ErpsysFinanceLog record);

	List<ErpsysFinanceLog> selectByCondition(Map<String, Object> map);

	int selectByConditionCount(Map<String, Object> map);
}