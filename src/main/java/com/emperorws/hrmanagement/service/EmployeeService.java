package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.EmployeeMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/18 14:49
 * @Description: 员工管理服务层
 **/
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @SystemServiceLog(description="获取所有的员工信息")
    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee,String politic,String nation,String workstate) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee,politic,nation,workstate);
        Long total = employeeMapper.getTotal(employee,politic,nation,workstate);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @SystemServiceLog(description="添加新的员工信息和自动添加系统用户")
    public void addEmpAndUser(Employee employee){
        employeeMapper.addEmpAndUser(employee);
    }

    @SystemServiceLog(description="自动获取新的员工工号")
    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    @SystemServiceLog(description="删除员工信息")
    public Integer deleteEmpByEid(Integer workid) {
        return employeeMapper.deleteByPrimaryKey(workid);
    }

    @SystemServiceLog(description="批量删除员工信息")
    public Integer deleteEmps(List<Employee> emps){
        return employeeMapper.deleteEmps(emps);
    }

    @SystemServiceLog(description="更新员工信息")
    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @SystemServiceLog(description="上传文件批量导入员工信息")
    public Integer addEmpAndUsers(List<Employee> list){
        Integer lastresult=0;
        for(int i=0;i<list.size();i++){
            Employee emp=list.get(i);
            employeeMapper.addEmpAndUser(emp);
            lastresult=lastresult+(emp.getResult()+emp.getResult2());
        }
        return lastresult;
    }

    @SystemServiceLog(description="获取员工的任职状态，用于前端数据可视化")
    public List<Map<String,Object>> getEmpstaVisual(){
        return employeeMapper.getEmpstaVisual();
    }
}
