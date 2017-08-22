package com.account.dao;

import java.util.List;
import java.util.Map;

import com.account.entity.MaterialSupplier;

public interface MaterialSupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialSupplier record);

    int insertSelective(MaterialSupplier record);

    MaterialSupplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialSupplier record);

    int updateByPrimaryKey(MaterialSupplier record);
    
    void deleteByMaterialNum(String materialNum);
    
    /**
     * 查询物资，供应商关联信息
     * @param Material
     * @return
     */
    List<MaterialSupplier> selectMaterialSupplierByMaterialNum(String materialNum);
    
    List<Map<String,Object>> selectMapByMaterialNum(String materialNum);
}