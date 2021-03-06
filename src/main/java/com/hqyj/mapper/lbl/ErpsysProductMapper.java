package com.hqyj.mapper.lbl;

import java.util.List;
import java.util.Map;

import com.hqyj.model.lbl.ErpsysProduct;

public interface ErpsysProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(ErpsysProduct record);

    int insertSelective(ErpsysProduct record);

    ErpsysProduct selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ErpsysProduct record);

    int updateByPrimaryKey(ErpsysProduct record);

    List<ErpsysProduct> selectProductDateByPage(Map<String, Object> map);

   	int selectCount(String sreachKey);
}