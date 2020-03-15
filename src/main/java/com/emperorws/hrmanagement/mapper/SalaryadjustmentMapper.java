package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Salaryadjustment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SalaryadjustmentMapper {
    int deleteByPrimaryKey(Integer said);

    int insert(Salaryadjustment record);

    int insertSelective(Salaryadjustment record);

    Salaryadjustment selectByPrimaryKey(Integer empcid);

    int updateByPrimaryKeySelective(Salaryadjustment record);

    int updateByPrimaryKey(Salaryadjustment record);

    List<Salaryadjustment> getSalaryadjustmentByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("sa") Salaryadjustment salaryadjustment, @Param("sadate") Date[] sadate);

    Long getTotal(@Param("sa") Salaryadjustment employeechange, @Param("sadate") Date[] sadate);
}
