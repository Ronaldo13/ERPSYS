package com.hqyj.mapper.xx;

import java.util.List;

import com.hqyj.model.xx.InWareHouseModel;

public interface InWareHouseModelMapper {
    int deleteByPrimaryKey(Integer inWarehouseLogId);

    int insert(InWareHouseModel record);

    int insertSelective(InWareHouseModel record);

    InWareHouseModel selectByPrimaryKey(Integer inWarehouseLogId);

    int updateByPrimaryKeySelective(InWareHouseModel record);

    int updateByPrimaryKey(InWareHouseModel record);

	void addInwareLog(InWareHouseModel iwhm);

	List<InWareHouseModel> selectAllInware(int totalnumber);

	Integer SelectAllTotal();
}