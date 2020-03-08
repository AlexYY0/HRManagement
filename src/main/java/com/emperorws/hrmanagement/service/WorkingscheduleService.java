package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.EmployeeMapper;
import com.emperorws.hrmanagement.mapper.WorkingscheduleMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Workingschedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/7 14:43
 * @Description: 员工排班管理服务层
 **/
@Service
public class WorkingscheduleService {
    @Autowired
    WorkingscheduleMapper workingscheduleMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    public RespPageBean getWorkingscheduleByPage(Integer page, Integer size, Employee employee, Date firstofweek) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Workingschedule> data = workingscheduleMapper.getWorkingscheduleByPage(page, size, employee,firstofweek);
        Long total = workingscheduleMapper.getTotal(employee,firstofweek);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer updateWorkingschedule(Workingschedule workingschedule){
        return workingscheduleMapper.updateByPrimaryKeySelective(workingschedule);
    }

    public Integer updateWorkingschedules(List<Workingschedule> workingschedules){
        return workingscheduleMapper.updateWorkingschedules(workingschedules);
    }

    public Integer deleteWorkingschedules(List<Workingschedule> workingschedules){
        return workingscheduleMapper.deleteWorkingschedules(workingschedules);
    }

    public Boolean autoSchedule(Date firstofweek){
        List<Employee> employees=employeeMapper.getEmployeeByPage(null,null,null,null,null,null);
        if(workingscheduleMapper.autoSchedule(employees,firstofweek)==employees.size())
            return true;
        return false;
    }
}
