package com.hqyj.mapper.xsh;

import java.util.List;
import java.util.Map;

import com.hqyj.model.xsh.ErpsysOrder;

public interface ErpsysOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(ErpsysOrder record);

    int insertSelective(ErpsysOrder record);

    ErpsysOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(ErpsysOrder record);

    int updateByPrimaryKey(ErpsysOrder record);

	int deleteOrderByOrderId(Integer orderId);

	List<ErpsysOrder> queryAllOrder();

	ErpsysOrder queryOrderByOrderId(Integer orderId);

	List<ErpsysOrder> queryAllBuyOrderByOrderType(Integer orderType);

	int queryOrderId();

	void updateProductionWarehouseIdByOrderid(Map<String, Integer> upMap);

	

}