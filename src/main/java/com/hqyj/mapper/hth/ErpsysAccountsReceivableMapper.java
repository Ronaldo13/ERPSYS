package com.hqyj.mapper.hth;

import java.util.List;
import java.util.Map;

import com.hqyj.model.hth.ErpsysAccountsReceivable;

public interface ErpsysAccountsReceivableMapper {
    int deleteByPrimaryKey(Integer accountsReceivableId);

    int insert(ErpsysAccountsReceivable record);

    int insertSelective(ErpsysAccountsReceivable record);

    ErpsysAccountsReceivable selectByPrimaryKey(Integer accountsReceivableId);

    int updateByPrimaryKeySelective(ErpsysAccountsReceivable record);

    int updateByPrimaryKey(ErpsysAccountsReceivable record);

	Integer selectAccountsReceivableByReceiverAndEndCount(Map<String, Object> map);

	List<ErpsysAccountsReceivable> selectAccountsReceivableByReceiverAndEnd(Map<String, Object> map);
}