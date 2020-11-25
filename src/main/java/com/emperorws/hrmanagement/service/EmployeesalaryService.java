package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.EmployeesalaryMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Employeesalary;
import com.emperorws.hrmanagement.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/1 18:48
 * @Description: 员工薪资配置服务层
 **/
@Service
public class EmployeesalaryService {
    @Autowired
    EmployeesalaryMapper employeesalaryMapper;

    @SystemServiceLog(description="获取所有的员工薪资配置信息")
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

    @SystemServiceLog(description="获取所有的员工工号和姓名信息，方便智能提示")
    public Boolean getEmpSalByWorkid(Integer workid){
        Employeesalary result = employeesalaryMapper.getEmpSalByWorkid(workid);
        if(result==null)
            return false;
        return true;
    }

    @SystemServiceLog(description="添加员工的薪资配置信息")
    public Integer addEmpSal(Employeesalary employeesalary){
        return employeesalaryMapper.insertSelective(employeesalary);
    }

    @SystemServiceLog(description="更新员工的薪资配置信息")
    public Integer updateEmpSal(Employeesalary employeesalary){
        return employeesalaryMapper.updateByPrimaryKeySelective(employeesalary);
    }

    @SystemServiceLog(description="删除员工的薪资配置信息")
    public Integer deleteEmpSalById(Integer esid){
        return employeesalaryMapper.deleteByPrimaryKey(esid);
    }

    @SystemServiceLog(description="批量删除员工的薪资配置信息")
    public Integer deleteEmpSals(List<Employeesalary> empsals){
        return employeesalaryMapper.deleteEmpSals(empsals);
    }

    @SystemServiceLog(description="批量导入员工的薪资配置信息")
    public Integer addEmpSals(List<Employeesalary> list){
        return employeesalaryMapper.addEmpSals(list);
    }

    @SystemServiceLog(description="获取员工的薪资水平状况，用于前端数据可视化")
    public List<Map<String,Object>> getEmpsalVisual(){
        return employeesalaryMapper.getEmpsalVisual();
    }
}
