package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
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

    @SystemServiceLog(description="获取所有的部门组织结构信息")
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    @SystemServiceLog(description="获取部门领导姓名和工号")
    public String getLeadernameByLeaderid(Integer leaderid){
        return departmentMapper.getLeadernameByLeaderid(leaderid);
    }

    @SystemServiceLog(description="获取员工的工号和姓名信息，方便提示")
    public List<Map<String,Object>> getWorkidAndEmpname(){
        return departmentMapper.getWorkidAndEmpname();
    }

    @SystemServiceLog(description="更新部门信息")
    public Integer updateDep(Department dep){
        return departmentMapper.updateByPrimaryKeySelective(dep);
    }

    @SystemServiceLog(description="添加新的部门")
    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }

    @SystemServiceLog(description="删除旧的部门")
    public void deleteDepById(Department dep) {
        departmentMapper.deleteDepById(dep);
    }

    @SystemServiceLog(description="以包含的关系获取所有的部门信息")
    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }
}
