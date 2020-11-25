package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Employeesalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeesalaryMapper {
    int deleteByPrimaryKey(Integer esId);

    int insert(Employeesalary record);

    int insertSelective(Employeesalary record);

    Employeesalary selectByPrimaryKey(Integer esId);

    int updateByPrimaryKeySelective(Employeesalary record);

    int updateByPrimaryKey(Employeesalary record);

    List<Employeesalary> getEmployeesalaryByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee);

    Long getTotal(@Param("emp") Employee employee);

    Employeesalary getEmpSalByWorkid(Integer workid);

    Integer addEmpSals(@Param("list") List<Employeesalary> list);

    Integer deleteEmpSals(@Param("empsals") List<Employeesalary> empsals);

    List<Map<String,Object>> getEmpsalVisual();
}
