package com.hqyj.mapper.zx;

import com.hqyj.model.zx.ErpsysAuthority;

public interface ErpsysAuthorityMapper {
    int deleteByPrimaryKey(Integer authorityId);

    int insert(ErpsysAuthority record);

    int insertSelective(ErpsysAuthority record);

    ErpsysAuthority selectByPrimaryKey(Integer authorityId);

    int updateByPrimaryKeySelective(ErpsysAuthority record);

    int updateByPrimaryKey(ErpsysAuthority record);
}