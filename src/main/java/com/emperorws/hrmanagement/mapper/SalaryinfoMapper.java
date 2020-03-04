package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Salaryinfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SalaryinfoMapper {
    int deleteByPrimaryKey(Integer siid);

    int insert(Salaryinfo record);

    int insertSelective(Salaryinfo record);

    Salaryinfo selectByPrimaryKey(Integer siid);

    int updateByPrimaryKeySelective(Salaryinfo record);

    int updateByPrimaryKey(Salaryinfo record);

    List<Salaryinfo> getSalaryinfoByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("payoffdata") Date[] payoffdata);

    Long getTotal(@Param("emp") Employee employee, @Param("payoffdata") Date[] payoffdata);
}
