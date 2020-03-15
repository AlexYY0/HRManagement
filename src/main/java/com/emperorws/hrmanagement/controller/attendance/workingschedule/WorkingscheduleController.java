package com.emperorws.hrmanagement.controller.attendance.workingschedule;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.*;
import com.emperorws.hrmanagement.service.WorkingscheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/7 14:48
 * @Description: 员工排班管理控制层
 **/
@RestController
@RequestMapping("/attendance/workingschedule/schedule")
public class WorkingscheduleController {
    @Autowired
    WorkingscheduleService workingscheduleService;

    @GetMapping("/")
    @SystemControllerLog(description="获取所有员工的本月排班信息")
    public RespPageBean getWorkingscheduleByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee,Date[] monthday,@RequestParam Integer numofday){
        return workingscheduleService.getWorkingscheduleByPage(page,size,employee,monthday,numofday);
    }

    @PutMapping("/")
    @SystemControllerLog(description="修改员工的排班信息")
    public RespBean updateWorkingschedule(@RequestBody Map<String,Object> oneMonData) throws ParseException {
        if (workingscheduleService.updateWorkingschedule(oneMonData)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/batchdelete")
    @SystemControllerLog(description="批量删除员工的排班信息")
    public RespBean deleteWorkingschedules(@RequestBody List<Map<String,Object>> workingschedules) throws ParseException {
        if(workingscheduleService.deleteWorkingschedules(workingschedules)){
            return RespBean.ok("批量删除成功!");
        }
        return RespBean.error("批量删除失败!");
    }

    @GetMapping("/autodo")
    @SystemControllerLog(description="本周员工自动排班")
    public RespBean autoSchedule(Date[] monthday) {
        if (workingscheduleService.autoSchedule(monthday)) {
            return RespBean.ok("自动排班成功!");
        }
        return RespBean.error("自动排班失败!");
    }
}
