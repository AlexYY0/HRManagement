package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.SalaryinfoMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Salaryinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/3 17:06
 * @Description: 员工历史薪资信息服务层
 **/
@Service
public class SalaryinfoService {
    @Autowired
    SalaryinfoMapper salaryinfoMapper;

    public RespPageBean getSalaryinfoByPage(Integer page, Integer size, Employee employee, Date[] payoffdata) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Salaryinfo> data = salaryinfoMapper.getSalaryinfoByPage(page, size, employee,payoffdata);
        Long total = salaryinfoMapper.getTotal(employee,payoffdata);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }
}
