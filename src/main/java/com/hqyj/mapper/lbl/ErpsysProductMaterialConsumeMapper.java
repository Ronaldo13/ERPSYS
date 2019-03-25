package com.hqyj.mapper.lbl;

import java.util.List;
import java.util.Map;

import com.hqyj.model.lbl.ErpsysProductMaterialConsume;

public interface ErpsysProductMaterialConsumeMapper {
    int deleteByPrimaryKey(String productBatch);

    int insert(ErpsysProductMaterialConsume record);

    int insertSelective(ErpsysProductMaterialConsume record);

    ErpsysProductMaterialConsume selectByPrimaryKey(String productBatch);

    int updateByPrimaryKeySelective(ErpsysProductMaterialConsume record);

    int updateByPrimaryKey(ErpsysProductMaterialConsume record);

    List<ErpsysProductMaterialConsume> selectProductMaterialDateByPage(Map<String, Object> map);

   	int selectCount(String sreachKey);
    
}