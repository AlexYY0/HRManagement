package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.EmployeeMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/18 14:49
 * @Description: 员工管理服务层
 **/
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
    public final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

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

    public Integer addEmp(Employee employee) {
        int result = employeeMapper.insertSelective(employee);
        if (result == 1) {
            Employee emp = employeeMapper.getEmployeeById(employee.getWorkid());
            logger.info(emp.toString());
            //rabbitTemplate.convertAndSend("javaboy.mail.welcome", emp);
        }
        return result;
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer workid) {
        return employeeMapper.deleteByPrimaryKey(workid);
    }

    public Integer deleteEmps(List<Employee> emps){
        return employeeMapper.deleteEmps(emps);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }
}
