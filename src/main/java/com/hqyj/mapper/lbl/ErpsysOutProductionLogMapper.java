package com.hqyj.mapper.lbl;

import java.util.List;
import java.util.Map;

import com.hqyj.model.lbl.ErpsysOutProductionLog;

public interface ErpsysOutProductionLogMapper {
    int deleteByPrimaryKey(Integer productionOutLogId);

    int insert(ErpsysOutProductionLog record);

    int insertSelective(ErpsysOutProductionLog record);

    ErpsysOutProductionLog selectByPrimaryKey(Integer productionOutLogId);

    int updateByPrimaryKeySelective(ErpsysOutProductionLog record);

    int updateByPrimaryKey(ErpsysOutProductionLog record);

    List<ErpsysOutProductionLog> selectProductOutLogDateByPage(Map<String, Object> map);

	int selectCount(String sreachKey);
}