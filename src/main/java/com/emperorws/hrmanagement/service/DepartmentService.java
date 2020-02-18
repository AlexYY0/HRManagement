package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.DepartmentMapper;
import com.emperorws.hrmanagement.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/16 0:45
 * @Description: 部门组织机构管理服务层
 **/
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    public String getLeadernameByLeaderid(Integer leaderid){
        return departmentMapper.getLeadernameByLeaderid(leaderid);
    }

    public List<Map<String,Object>> getWorkidAndEmpname(){
        return departmentMapper.getWorkidAndEmpname();
    }

    public Integer updateDep(Department dep){
        return departmentMapper.updateByPrimaryKeySelective(dep);
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }

    public void deleteDepById(Department dep) {
        departmentMapper.deleteDepById(dep);
    }

    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }
}
