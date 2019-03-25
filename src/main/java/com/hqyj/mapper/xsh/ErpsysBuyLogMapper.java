package com.hqyj.mapper.xsh;

import java.util.List;
import java.util.Map;

import com.hqyj.model.xsh.ErpsysBuyLog;

public interface ErpsysBuyLogMapper {
    int deleteByPrimaryKey(Integer buyLogId);

    int insert(ErpsysBuyLog record);

    int insertSelective(ErpsysBuyLog record);

    ErpsysBuyLog selectByPrimaryKey(Integer buyLogId);

    int updateByPrimaryKeySelective(ErpsysBuyLog record);

    int updateByPrimaryKey(ErpsysBuyLog record);

	void addBuyOrder(ErpsysBuyLog erpsysBuyLog);

	List<ErpsysBuyLog> queryAllBuyOrder();

	void deleteBuyOrderByBuyLogId(Integer buyLogId);

	void updateProductionWarehouseIdByOrderid(Map<String, Integer> upMap);
}