package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.EmployeeMapper;
import com.emperorws.hrmanagement.mapper.EmployeechangeMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Employeechange;
import com.emperorws.hrmanagement.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/21 16:31
 * @Description: 人事调动管理服务层
 **/
@Service
public class EmployeechangeService {
    @Autowired
    EmployeechangeMapper employeechangeMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    public RespPageBean getEmployeechangeByPage(Integer page, Integer size, Employeechange employeechange, Date[] empchandata){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employeechange> data=employeechangeMapper.getEmployeechangeByPage(page,size,employeechange,empchandata);
        Long total=employeechangeMapper.getTotal(employeechange,empchandata);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmpChange(Employeechange employeechange){
        Employee emp=new Employee(employeechange.getWorkid(),employeechange.getAfterdepid());
        return (employeechangeMapper.insertSelective(employeechange))+(employeeMapper.updateByPrimaryKeySelective(emp));
    }
}
