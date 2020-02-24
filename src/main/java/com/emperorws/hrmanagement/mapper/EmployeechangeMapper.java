package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Employeechange;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/21 15:53
 * @Description:
 **/
public interface EmployeechangeMapper {
    int deleteByPrimaryKey(Integer empcid);

    int insert(Employeechange record);

    int insertSelective(Employeechange record);

    Employeechange selectByPrimaryKey(Integer empcid);

    int updateByPrimaryKeySelective(Employeechange record);

    int updateByPrimaryKey(Employeechange record);

    List<Employeechange> getEmployeechangeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("empc") Employeechange employeechange, @Param("empchandata") Date[] empchandata);

    Long getTotal(@Param("empc") Employeechange employeechange, @Param("empchandata") Date[] empchandata);
}
