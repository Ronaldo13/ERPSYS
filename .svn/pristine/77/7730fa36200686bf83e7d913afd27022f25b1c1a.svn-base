package com.hqyj.mapper.xx;

import java.util.List;
import java.util.Map;

import com.hqyj.model.xx.WareHouseModel;

public interface WareHouseModelMapper {
    int deleteByPrimaryKey(Integer productionWarehouseId);

    int insert(WareHouseModel record);

    int insertSelective(WareHouseModel record);

    WareHouseModel selectByPrimaryKey(Integer productionWarehouseId);

    int updateByPrimaryKeySelective(WareHouseModel record);

    int updateByPrimaryKey(WareHouseModel record);

	List<WareHouseModel> SelectAllWare(int totalnumber);

	int AddWareDo(WareHouseModel wareHouseModel);

	void DeleteByProductionWarehouseId(Integer ids);

	WareHouseModel seleByproductionWarehouseId(Integer ids);

	int updateWareByWareId(WareHouseModel wareHouseModel);

	Integer SelectAllTotal();

	void updateProductNumberByProductionWarehouseId(Map<String, Integer> upMap);
    
}