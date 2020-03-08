package com.emperorws.hrmanagement.controller.attendance.workingschedule;

import com.emperorws.hrmanagement.model.*;
import com.emperorws.hrmanagement.service.WorkingscheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    public RespPageBean getWorkingscheduleByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date firstofweek) {
        return workingscheduleService.getWorkingscheduleByPage(page, size, employee,firstofweek);
    }

    @PutMapping("/")
    public RespBean updateWorkingschedule(@RequestBody Workingschedule workingschedule){
        if (workingscheduleService.updateWorkingschedule(workingschedule) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/batchupdate")
    public RespBean updateWorkingschedules(@RequestBody List<Workingschedule> workingschedules){
        if(workingscheduleService.updateWorkingschedules(workingschedules)==workingschedules.size()){
            return RespBean.ok("所有的更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/batchdelete")
    public RespBean deleteWorkingschedules(@RequestBody List<Workingschedule> workingschedules){
        if(workingscheduleService.deleteWorkingschedules(workingschedules)==workingschedules.size()){
            return RespBean.ok("批量删除成功!");
        }
        return RespBean.error("批量删除失败!");
    }

    @GetMapping("/autodo")
    public RespBean autoSchedule(Date firstofweek) {
        if (workingscheduleService.autoSchedule(firstofweek)) {
            return RespBean.ok("自动排班成功!");
        }
        return RespBean.error("自动排班失败!");
    }
}
