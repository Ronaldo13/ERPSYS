package com.hqyj.mapper.hth;

import java.util.List;
import java.util.Map;

import com.hqyj.model.hth.ErpsysAccountsPayable;

public interface ErpsysAccountsPayableMapper {
    int deleteByPrimaryKey(Integer accountsPayableId);

    int insert(ErpsysAccountsPayable record);

    int insertSelective(ErpsysAccountsPayable record);

    ErpsysAccountsPayable selectByPrimaryKey(Integer accountsPayableId);

    int updateByPrimaryKeySelective(ErpsysAccountsPayable record);

    int updateByPrimaryKey(ErpsysAccountsPayable record);

	Integer selectAccountsPayableByReceiverAndEndCount(Map<String, Object> map);

	List<ErpsysAccountsPayable> selectAccountsPayableByReceiverAndEnd(Map<String, Object> map);
}