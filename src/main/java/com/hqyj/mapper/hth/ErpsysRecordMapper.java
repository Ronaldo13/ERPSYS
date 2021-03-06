package com.hqyj.mapper.hth;

import java.util.List;
import java.util.Map;

import com.hqyj.model.hth.ErpsysRecord;

public interface ErpsysRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(ErpsysRecord record);

    int insertSelective(ErpsysRecord record);

    ErpsysRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(ErpsysRecord record);

    int updateByPrimaryKey(ErpsysRecord record);

	List<ErpsysRecord> selectAllRecord();

	List<ErpsysRecord> selectRecordBetweenStartAndEnd(Map<String, Object> map);

	int selectRecordBetweenStartAndEndCount(Map<String, Object> map);
}