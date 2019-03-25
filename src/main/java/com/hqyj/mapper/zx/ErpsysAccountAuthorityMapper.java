package com.hqyj.mapper.zx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.model.zx.ErpsysAccountAuthority;
import com.hqyj.model.zx.ErpsysAuthority;

public interface ErpsysAccountAuthorityMapper {
    int deleteByPrimaryKey(Integer aaId);

    int insert(ErpsysAccountAuthority record);

    int insertSelective(ErpsysAccountAuthority record);

    ErpsysAccountAuthority selectByPrimaryKey(Integer aaId);

    int updateByPrimaryKeySelective(ErpsysAccountAuthority record);

    int updateByPrimaryKey(ErpsysAccountAuthority record);

	List<ErpsysAuthority> queryByID(@Param("username")String username);

	int deleteByaccount_id(@Param("username")String username);

	List<String> selectByAccountID(@Param("username")String parameter);
}