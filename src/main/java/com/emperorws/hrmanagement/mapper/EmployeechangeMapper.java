package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Employeechange;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeechangeMapper {
    int deleteByPrimaryKey(Integer empcid);

    int insert(Employeechange record);

    int insertSelective(Employeechange record);

    Employeechange selectByPrimaryKey(Integer empcid);

    int updateByPrimaryKeySelective(Employeechange record);

    int updateByPrimaryKey(Employeechange record);

    List<Employeechange> getEmployeechangeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("empc") Employeechange employeechange, @Param("empchandate") Date[] empchandate);

    Long getTotal(@Param("empc") Employeechange employeechange, @Param("empchandate") Date[] empchandate);
}
