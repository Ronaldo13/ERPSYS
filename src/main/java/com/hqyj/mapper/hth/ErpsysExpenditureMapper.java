package com.hqyj.mapper.hth;

import java.util.List;
import java.util.Map;

import com.hqyj.model.hth.ErpsysExpenditure;

public interface ErpsysExpenditureMapper {
    int deleteByPrimaryKey(Integer expenditureId);

    int insert(ErpsysExpenditure record);

    int insertSelective(ErpsysExpenditure record);

    ErpsysExpenditure selectByPrimaryKey(Integer expenditureId);

    int updateByPrimaryKeySelective(ErpsysExpenditure record);

    int updateByPrimaryKey(ErpsysExpenditure record);

	Integer selectExpenditureBetweenStartAndEndCount(Map<String, Integer> map);

	List<ErpsysExpenditure> selectExpenditureBetweenStartAndEnd(Map<String, Integer> map);
}