package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.EmployeesalaryMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Employeesalary;
import com.emperorws.hrmanagement.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/1 18:48
 * @Description: 员工薪资配置服务层
 **/
@Service
public class EmployeesalaryService {
    @Autowired
    EmployeesalaryMapper employeesalaryMapper;

    public RespPageBean getEmployeesalaryByPage(Integer page, Integer size, Employee employee) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employeesalary> data = employeesalaryMapper.getEmployeesalaryByPage(page, size, employee);
        Long total = employeesalaryMapper.getTotal(employee);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Boolean getEmpSalByWorkid(Integer workid){
        Employeesalary result = employeesalaryMapper.getEmpSalByWorkid(workid);
        if(result==null)
            return false;
        return true;
    }

    public Integer addEmpSal(Employeesalary employeesalary){
        return employeesalaryMapper.insertSelective(employeesalary);
    }

    public Integer updateEmpSal(Employeesalary employeesalary){
        return employeesalaryMapper.updateByPrimaryKeySelective(employeesalary);
    }

    public Integer deleteEmpSalById(Integer esid){
        return employeesalaryMapper.deleteByPrimaryKey(esid);
    }

    public Integer deleteEmpSals(List<Employeesalary> empsals){
        return employeesalaryMapper.deleteEmpSals(empsals);
    }

    public Integer addEmpSals(List<Employeesalary> list){
        return employeesalaryMapper.addEmpSals(list);
    }
}
