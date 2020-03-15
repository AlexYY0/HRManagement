package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.AttelogmonMapper;
import com.emperorws.hrmanagement.mapper.EmployeeMapper;
import com.emperorws.hrmanagement.model.Attelogmon;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/10 16:48
 * @Description: 考勤月度统计服务层
 **/
@Service
public class AttelogmonService {
    @Autowired
    AttelogmonMapper attelogmonMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @SystemServiceLog(description="获取员工的历史月度考勤统计数据")
    public RespPageBean getAttelogmonByPage(Integer page, Integer size, Employee employee, Date[] caldate) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Attelogmon> data = attelogmonMapper.getAttelogmonByPage(page, size, employee,caldate);
        Long total = attelogmonMapper.getTotal(employee,caldate);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @SystemServiceLog(description="删除旧的员工历史月度考勤统计数据")
    public Integer deleteAttelogmonById(Integer attelogmonid){
        return attelogmonMapper.deleteByPrimaryKey(attelogmonid);
    }

    @SystemServiceLog(description="修改旧的员工历史月度考勤统计数据")
    public Integer updateAttelogmon(Attelogmon attelogmon){
        return attelogmonMapper.updateByPrimaryKeySelective(attelogmon);
    }

    @SystemServiceLog(description="批量删除旧的员工历史月度考勤统计数据")
    public Integer deleteAttelogmons(List<Attelogmon> attelogmons){
        return attelogmonMapper.deleteAttelogmons(attelogmons);
    }

    @SystemServiceLog(description="自动统计所有员工的上月考勤数据")
    public Boolean statisticsAll(Date[] monthday){
        List<Employee> employees=employeeMapper.getEmployeeByPage(null,null,null,null,null,null);
        if(attelogmonMapper.statisticsAll(employees,monthday)==employees.size())
            return true;
        return false;
    }

    @SystemServiceLog(description="自动统计所选部门的所有员工的上月考勤数据")
    public Boolean statisticsByDepid(Integer depid,Date[] monthday){
        Employee employee=new Employee();
        employee.setDepid(depid);
        List<Employee> employees=employeeMapper.getEmployeeByPage(null,null,employee,null,null,null);
        if(attelogmonMapper.statisticsAll(employees,monthday)==employees.size())
            return true;
        return false;
    }

    @SystemServiceLog(description="自动统计所选部门的所有员工的上月考勤数据")
    public Boolean statisticsByWorkid(List<Employee> employees,Date[] monthday){
        if(attelogmonMapper.statisticsAll(employees,monthday)==employees.size())
            return true;
        return false;
    }
}
