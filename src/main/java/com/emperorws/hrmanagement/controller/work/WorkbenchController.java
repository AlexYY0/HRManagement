package com.emperorws.hrmanagement.controller.work;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.Appatt;
import com.emperorws.hrmanagement.model.Calendar;
import com.emperorws.hrmanagement.model.Employeesalary;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/12 0:33
 * @Description: 公司日历节假日表控制层
 **/
@RestController
@RequestMapping("/work/bench")
public class WorkbenchController {
    @Autowired
    CalendarService calendarService;
    @Autowired
    AttelogdayService attelogdayService;
    @Autowired
    TransactioninfoService transactioninfoService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeesalaryService employeesalaryService;

    @PostMapping("/addcalendars")
    @SystemControllerLog(description="插入新的节假日表数据")
    public RespBean addCalendars(@RequestBody List<Calendar> calendars){
        if(calendarService.addCalendars(calendars)==calendars.size()){
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @GetMapping("/getholidays")
    @SystemControllerLog(description="获取节假日数据，用于前端显示")
    public List<Integer> getHolidays(Date[] daterange){
        return calendarService.getHolidays(daterange);
    }

    @GetMapping("/clockinvisual")
    @SystemControllerLog(description="获取今日的打卡数据，用于前端数据可视化")
    public List<Map<String,Object>> getClockinVisual(){
        return attelogdayService.getClockinVisual();
    }

    @GetMapping("/appattvisual")
    @SystemControllerLog(description="获取今日的考勤事务申请数据，用于前端数据可视化")
    public List<Map<String,Object>> getAppattVisual(){
        return transactioninfoService.getAppattVisual();
    }

    @GetMapping("/empstavisual")
    @SystemControllerLog(description="获取员工的任职状态，用于前端数据可视化")
    public List<Map<String,Object>> getEmpstaVisual(){
        return employeeService.getEmpstaVisual();
    }

    @GetMapping("/empsalvisual")
    @SystemControllerLog(description="获取员工的薪资水平状况，用于前端数据可视化")
    public List<Map<String,Object>> getEmpsalVisual(){
        return employeesalaryService.getEmpsalVisual();
    }
}
