package com.emperorws.hrmanagement.controller.attendance;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.*;
import com.emperorws.hrmanagement.service.AttelogmonService;
import com.emperorws.hrmanagement.utils.AttelogmonPOIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/10 16:51
 * @Description: 考勤月度统计控制层
 **/
@RestController
@RequestMapping("/attendance/managementofmonth")
public class AttelogmonController {
    @Autowired
    AttelogmonService attelogmonService;

    @GetMapping("/")
    @SystemControllerLog(description="获取员工的历史月度考勤统计数据")
    public RespPageBean getAttelogmonByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] caldate) {
        return attelogmonService.getAttelogmonByPage(page, size, employee, caldate);
    }

    @DeleteMapping("/{attelogmonid}")
    @SystemControllerLog(description="删除旧的员工历史月度考勤统计数据")
    public RespBean deleteAttelogmonById(@PathVariable Integer attelogmonid){
        if (attelogmonService.deleteAttelogmonById(attelogmonid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    @SystemControllerLog(description="修改旧的员工历史月度考勤统计数据")
    public RespBean updateAttelogmon(@RequestBody Attelogmon attelogmon){
        if (attelogmonService.updateAttelogmon(attelogmon) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/deleteattemons")
    @SystemControllerLog(description="批量删除旧的员工历史月度考勤统计数据")
    public RespBean deleteAttelogmons(@RequestBody List<Attelogmon> attelogmons){
        if(attelogmonService.deleteAttelogmons(attelogmons)==attelogmons.size()){
            return RespBean.ok("批量删除成功!");
        }
        return RespBean.error("批量删除失败!");
    }

    @GetMapping("/calcall")
    @SystemControllerLog(description="自动统计所有员工的上月考勤数据")
    public RespBean statisticsAll(Date[] monthday){
        if(attelogmonService.statisticsAll(monthday)){
            return RespBean.ok("统计所有员工的考勤数据成功!");
        }
        return RespBean.error("统计所有员工的考勤数据失败!");
    }

    @GetMapping("/calcbydepid")
    @SystemControllerLog(description="自动统计所选部门的所有员工的上月考勤数据")
    public RespBean statisticsByDepid(Integer depid,Date[] monthday){
        if(attelogmonService.statisticsByDepid(depid,monthday)){
            return RespBean.ok("统计所选部门的所有员工的考勤数据成功!");
        }
        return RespBean.error("统计所选部门的所有员工的考勤数据失败!");
    }

    @PostMapping("/calcbyworkid")
    @SystemControllerLog(description="自动统计所选部门的所有员工的上月考勤数据")
    public RespBean statisticsByWorkid(@RequestParam  Date[] monthday,@RequestBody List<Employee> employees){
        if(attelogmonService.statisticsByWorkid(employees,monthday)){
            return RespBean.ok("统计所选员工的考勤数据成功!");
        }
        return RespBean.error("统计所选员工的考勤数据失败!");
    }

    @PostMapping("/export")
    @SystemControllerLog(description="批量导出员工的考勤月度统计信息")
    public ResponseEntity<byte[]> exportData(@RequestBody List<Attelogmon> list) {
        return AttelogmonPOIUtils.attelogmon2Excel(list);
    }
}
