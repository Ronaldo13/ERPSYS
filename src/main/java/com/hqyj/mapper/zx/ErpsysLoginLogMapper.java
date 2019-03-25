package com.hqyj.mapper.zx;

import java.util.List;

import com.hqyj.model.zx.ErpsysLoginLog;

public interface ErpsysLoginLogMapper {
    int deleteByPrimaryKey(Integer erpsysLoginlogId);

    int insert(ErpsysLoginLog record);

    int insertSelective(ErpsysLoginLog record);

    ErpsysLoginLog selectByPrimaryKey(Integer erpsysLoginlogId);

    int updateByPrimaryKeySelective(ErpsysLoginLog record);

    int updateByPrimaryKey(ErpsysLoginLog record);

	List<ErpsysLoginLog> selectAll();
}