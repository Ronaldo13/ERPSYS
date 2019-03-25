package com.hqyj.mapper.bt;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hqyj.model.bt.ErpsysBasicInformation;

public interface ErpsysBasicInformationMapper {
    int deleteByPrimaryKey(String record);

    int insert(ErpsysBasicInformation record);

    int insertSelective(ErpsysBasicInformation record);

    ErpsysBasicInformation selectByPrimaryKey(String accountId);

    int updateByPrimaryKeySelective(ErpsysBasicInformation record);

    int updateByPrimaryKey(ErpsysBasicInformation record);

	List<ErpsysBasicInformation> getAllLimit(Map<String,Object> map);
	
	List<ErpsysBasicInformation> getAll();

	ErpsysBasicInformation selectByIdAndPWD(@Param("username")String username, @Param("password")String password);

	int updatePWDByUsername(@Param("npwd")String npwd, @Param("username")String username);


	int getAllCounts();

	


	List<String> selectALLUser();

	int selectCount(@Param("serch")String serch);

	List<String> selectByNumAndPagesiz(@Param("num")int num, @Param("pagesize")int pageSize, @Param("serch")String serch);

	int updateFileByUsername(@Param("username")String username, @Param("url")String url);

}