package com.hqyj.mapper.xsh;

import java.util.List;
import java.util.Map;

import com.hqyj.model.xsh.ErpsysSellLog;

public interface ErpsysSellLogMapper {
    int deleteByPrimaryKey(Integer sellLogId);

    int insert(ErpsysSellLog record);

    int insertSelective(ErpsysSellLog record);

    ErpsysSellLog selectByPrimaryKey(Integer sellLogId);

    int updateByPrimaryKeySelective(ErpsysSellLog record);

    int updateByPrimaryKey(ErpsysSellLog record);

	List<ErpsysSellLog> queryAllSellOrder();

	void deleteSellOrderByBuyLogId(Integer sellLogId);

	void updateProductionWarehouseIdByOrderid(Map<String, Integer> upMap);
}