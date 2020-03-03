package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Taxrate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaxrateMapper {
    int deleteByPrimaryKey(Integer trid);

    int insert(Taxrate record);

    int insertSelective(Taxrate record);

    Taxrate selectByPrimaryKey(Integer trid);

    int updateByPrimaryKeySelective(Taxrate record);

    int updateByPrimaryKey(Taxrate record);

    List<Taxrate> getAllTaxrate();

    Integer deleteTaxrates(@Param("trs") List<Taxrate> taxrates);
}
