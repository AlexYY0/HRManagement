package com.emperorws.hrmanagement.controller.attendance;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.*;
import com.emperorws.hrmanagement.service.AttelogdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/12 21:21
 * @Description: 每日考勤管理控制层
 **/
@RestController
@RequestMapping("/attendance/managementofday")
public class AttelogdayController {
    @Autowired
    AttelogdayService attelogdayService;

    @GetMapping("/")
    @SystemControllerLog(description="获取员工的每日考勤数据")
    public RespPageBean getAttelogdayByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] clockinday) {
        return attelogdayService.getAttelogdayByPage(page, size, employee, clockinday);
    }

    @PutMapping("/")
    @SystemControllerLog(description="修改旧的员工每日考勤数据")
    public RespBean updateAttelogday(@RequestBody Attelogday attelogday){
        if (attelogdayService.updateAttelogday(attelogday) == 1) {
            return RespBean.ok("修改成功!");
        }
        return RespBean.error("修改失败!");
    }

    @DeleteMapping("/{attelogdayid}")
    @SystemControllerLog(description="删除旧的员工每日考勤数据")
    public RespBean deleteAttelogdayById(@PathVariable Integer attelogdayid){
        if (attelogdayService.deleteAttelogdayById(attelogdayid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/deleteattedays")
    @SystemControllerLog(description="批量删除旧的员工每日考勤数据")
    public RespBean deleteAttelogdays(@RequestBody List<Attelogday> attelogdays){
        if(attelogdayService.deleteAttelogdays(attelogdays)==attelogdays.size()){
            return RespBean.ok("批量删除成功!");
        }
        return RespBean.error("批量删除失败!");
    }
}
