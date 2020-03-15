package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.EmployeeMapper;
import com.emperorws.hrmanagement.mapper.SalaryinfoMapper;
import com.emperorws.hrmanagement.mapper.SalaryschemeMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Salaryscheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/13 21:35
 * @Description: 薪资计算核算服务层
 **/
@Service
public class SalarycheckService {
    @Autowired
    SalaryinfoMapper salaryinfoMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SalaryschemeMapper salaryschemeMapper;

    @SystemServiceLog(description="自动计算所有员工的上月薪资")
    public Boolean salarycheckAll(Date[] timerange,double overtimesal,double businesssal){
        List<Employee> employees=employeeMapper.getEmployeeByPage(null,null,null,null,null,null);
        if(salaryinfoMapper.salarycheckAll(employees,timerange,overtimesal,businesssal)==employees.size())
            return true;
        return false;
    }

    @SystemServiceLog(description="自动计算所选部门的所有员工的上月薪资")
    public Boolean salarycheckByDepid(Integer depid,Date[] timerange,double overtimesal,double businesssal){
        Employee employee=new Employee();
        employee.setDepid(depid);
        List<Employee> employees=employeeMapper.getEmployeeByPage(null,null,employee,null,null,null);
        if(salaryinfoMapper.salarycheckAll(employees,timerange,overtimesal,businesssal)==employees.size())
            return true;
        return false;
    }

    @SystemServiceLog(description="自动计算所选员工的上月薪资")
    public Boolean salarycheckByWorkid(List<Employee> employees,Date[] timerange,double overtimesal,double businesssal){
        if(salaryinfoMapper.salarycheckAll(employees,timerange,overtimesal,businesssal)==employees.size())
            return true;
        return false;
    }

    @SystemServiceLog(description="自动计算所有员工的年终奖12+n")
    public Boolean yearSalarycheckAll(Date[] timerange,Integer n){
        Salaryscheme salaryscheme=salaryschemeMapper.selectByPrimaryKey(n);
        if(salaryscheme.getSsname().equals("12+1"))
            n=1;
        else if(salaryscheme.getSsname().equals("12+2"))
            n=2;
        List<Employee> employees=employeeMapper.getEmployeeByPage(null,null,null,null,null,null);
        if(salaryinfoMapper.yearSalarycheckAll(employees,timerange,n)==employees.size())
            return true;
        return false;
    }

    @SystemServiceLog(description="自动计算所选部门的所有员工的年终奖12+n")
    public Boolean yearSalarycheckByDepid(Integer depid,Date[] timerange,Integer n){
        Salaryscheme salaryscheme=salaryschemeMapper.selectByPrimaryKey(n);
        if(salaryscheme.getSsname().equals("12+1"))
            n=1;
        else if(salaryscheme.getSsname().equals("12+2"))
            n=2;
        Employee employee=new Employee();
        employee.setDepid(depid);
        List<Employee> employees=employeeMapper.getEmployeeByPage(null,null,employee,null,null,null);
        if(salaryinfoMapper.yearSalarycheckAll(employees,timerange,n)==employees.size())
            return true;
        return false;
    }

    @SystemServiceLog(description="自动计算所选员工的年终奖12+n")
    public Boolean yearSalarycheckByWorkid(List<Employee> employees,Date[] timerange,Integer n){
        Salaryscheme salaryscheme=salaryschemeMapper.selectByPrimaryKey(n);
        if(salaryscheme.getSsname().equals("12+1"))
            n=1;
        else if(salaryscheme.getSsname().equals("12+2"))
            n=2;
        if(salaryinfoMapper.yearSalarycheckAll(employees,timerange,n)==employees.size())
            return true;
        return false;
    }
}
