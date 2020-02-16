package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer depid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer depid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();
}
