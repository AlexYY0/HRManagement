package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.EmployeeMapper;
import com.emperorws.hrmanagement.mapper.WorkingscheduleMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Workingschedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @SystemServiceLog(description="获取所有员工的本月排班信息")
    public RespPageBean getWorkingscheduleByPage(Integer page, Integer size, Employee employee, Date[] monthday, Integer numofday){
        String[] allmonnthdays;
        if(numofday==28)
            allmonnthdays=new String[]{"d1","d2","d3","d4","d5","d6","d7","d8","d9","d10","d11","d12","d13","d14","d15","d16","d17","d18","d19","d20","d21","d22","d23","d24","d25","d26","d27","d28"};
        else if(numofday==29)
            allmonnthdays=new String[]{"d1","d2","d3","d4","d5","d6","d7","d8","d9","d10","d11","d12","d13","d14","d15","d16","d17","d18","d19","d20","d21","d22","d23","d24","d25","d26","d27","d28","d29"};
        else if(numofday==30)
            allmonnthdays=new String[]{"d1","d2","d3","d4","d5","d6","d7","d8","d9","d10","d11","d12","d13","d14","d15","d16","d17","d18","d19","d20","d21","d22","d23","d24","d25","d26","d27","d28","d29","d30"};
        else
            allmonnthdays=new String[]{"d1","d2","d3","d4","d5","d6","d7","d8","d9","d10","d11","d12","d13","d14","d15","d16","d17","d18","d19","d20","d21","d22","d23","d24","d25","d26","d27","d28","d29","d30","d31"};
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Map<String,Object>> data=workingscheduleMapper.getWorkingscheduleByPage(page,size,employee,monthday,allmonnthdays);
        Long total=workingscheduleMapper.getTotal(employee,monthday);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @SystemServiceLog(description="修改员工的排班信息")
    public Boolean updateWorkingschedule(Map<String,Object> oneMonData) throws ParseException {
        List<Workingschedule> workingschedules=new ArrayList<Workingschedule>();
        SimpleDateFormat all = new SimpleDateFormat("yyyy-MM-dd");
        String year=((String) oneMonData.get("firstofmonth")).substring(0,4);
        String month=((String) oneMonData.get("firstofmonth")).substring(5,7);
        String day=((String) oneMonData.get("lastofmonth")).substring(8,10);
        Integer workid=(Integer) oneMonData.get("workid");
        oneMonData.remove("depname");
        oneMonData.remove("firstofmonth");
        oneMonData.remove("lastofmonth");
        oneMonData.remove("empname");
        oneMonData.remove("workid");
        if(Integer.parseInt(day)==28){
            oneMonData.remove("d29");
            oneMonData.remove("d30");
            oneMonData.remove("d31");
        }else if(Integer.parseInt(day)==29){
            oneMonData.remove("d30");
            oneMonData.remove("d31");
        } else if(Integer.parseInt(day)==30){
            oneMonData.remove("d31");
        }
        for (Map.Entry<String, Object> entry : oneMonData.entrySet()){
            Date today=all.parse(year+"-"+month+"-"+entry.getKey().substring(1));
            Workingschedule workingschedule=new Workingschedule(workid,today,(Integer)entry.getValue());
            workingschedules.add(workingschedule);
        }
        if(workingscheduleMapper.updateWorkingschedule(workingschedules,workid)==workingschedules.size()){
            return true;
        }
        return false;
    }

    @SystemServiceLog(description="批量删除员工的排班信息")
    public Boolean deleteWorkingschedules(List<Map<String,Object>> workingschedules) throws ParseException {
        if(workingschedules==null){
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Date firstofmonth=df.parse((String) workingschedules.get(0).get("firstofmonth"));
        //Date lastofmonth=df.parse((String) workingschedules.get(0).get("lastofmonth"));
        Integer day=Integer.parseInt(((String) workingschedules.get(0).get("lastofmonth")).substring(8,10));
        Integer result=workingscheduleMapper.deleteWorkingschedules(workingschedules);
        if(result==day*workingschedules.size())
            return true;
        else
            return false;
    }

    @SystemServiceLog(description="本周员工自动排班")
    public Boolean autoSchedule(Date[] monthday){
        SimpleDateFormat sf= new SimpleDateFormat("dd");
        Integer day=Integer.parseInt(sf.format(monthday[1]));
        List<Employee> employees=employeeMapper.getEmployeeByPage(null,null,null,null,null,null);
        if(workingscheduleMapper.autoSchedule(employees,monthday)==employees.size()*day)
            return true;
        return false;
    }
}
