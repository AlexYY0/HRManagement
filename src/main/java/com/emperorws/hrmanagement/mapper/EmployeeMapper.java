package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer workid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer workid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee,@Param("politic") String politic,@Param("nation") String nation,@Param("workstate") String workstate);

    Long getTotal(@Param("emp") Employee employee,@Param("politic") String politic,@Param("nation") String nation,@Param("workstate") String workstate);

    Integer maxWorkID();

    Integer addEmps(@Param("list") List<Employee> list);

    Integer deleteEmps(@Param("emps") List<Employee> emps);

    Employee getEmployeeById(Integer workid);
}
