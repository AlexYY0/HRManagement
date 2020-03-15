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

    List<Salaryinfo> getSalaryinfoByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("payoffdate") Date[] payoffdate);

    Long getTotal(@Param("emp") Employee employee, @Param("payoffdate") Date[] payoffdate);

    Integer salarycheckAll(@Param("emps") List<Employee> employees, @Param("timerange") Date[] timerange,@Param("overtimesal") double overtimesal,@Param("businesssal") double businesssal);

    Integer yearSalarycheckAll(@Param("emps") List<Employee> employees, @Param("timerange") Date[] timerange,@Param("n") Integer n);
}
