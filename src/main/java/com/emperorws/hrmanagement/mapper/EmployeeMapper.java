package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer workid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer workid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}
