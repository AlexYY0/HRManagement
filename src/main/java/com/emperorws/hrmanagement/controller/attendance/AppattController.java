package com.emperorws.hrmanagement.controller.attendance;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.*;
import com.emperorws.hrmanagement.service.AppattService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/5 14:18
 * @Description: 考勤事务申请管理控制层
 **/
@RestController
@RequestMapping("/attendance/transactionapp")
public class AppattController {
    @Autowired
    AppattService appattService;

    @GetMapping("/uncommittedappatt")
    @SystemControllerLog(description="获取员工本人未提交的考勤事务申请")
    public RespPageBean getUncommittedAppattByWorkid(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Authentication authentication) {
        User user=(User) authentication.getPrincipal();
        return appattService.getAppattByWorkid(page, size, false, null, user.getWorkid());
    }

    @GetMapping("/inhandappatt")
    @SystemControllerLog(description="获取员工本人流程中的考勤事务申请")
    public RespPageBean getInhandAppattByWorkidAndPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Authentication authentication) {
        User user=(User) authentication.getPrincipal();
        return appattService.getAppattByWorkid(page, size, true, null, user.getWorkid());
    }

    @GetMapping("/overappatt")
    @SystemControllerLog(description="获取员工本人已完成的考勤事务申请")
    public RespPageBean getOverAppattByWorkidAndPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Authentication authentication) {
        User user=(User) authentication.getPrincipal();
        return appattService.getAppattByWorkid(page, size, true, true, user.getWorkid());
    }

    @DeleteMapping("/{aatid}")
    @SystemControllerLog(description="删除员工本人未提交的考勤事务申请")
    public RespBean deleteUncommittedAppattById(@PathVariable Integer aatid,Authentication authentication){
        User user=(User) authentication.getPrincipal();
        if (appattService.deleteUncommittedAppattById(aatid,user.getWorkid()) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/deleteappatts")
    @SystemControllerLog(description="批量删除员工本人未提交的考勤事务申请")
    public RespBean deleteUncommittedAppatts(@RequestBody List<Appatt> appatts,Authentication authentication){
        User user=(User) authentication.getPrincipal();
        if(appattService.deleteUncommittedAppatts(appatts,user.getWorkid())==appatts.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/")
    @SystemControllerLog(description="添加员工本人未提交的考勤事务申请")
    public RespBean addUncommittedAppatt(@RequestBody Appatt appatt,Authentication authentication){
        User user=(User) authentication.getPrincipal();
        appatt.setWorkid(user.getWorkid());
        if (appattService.addUncommittedAppatt(appatt) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    @SystemControllerLog(description="更新员工本人未提交的考勤事务申请")
    public RespBean updateUncommittedAppatt(@RequestBody Appatt appatt,Authentication authentication){
        User user=(User) authentication.getPrincipal();
        appatt.setWorkid(user.getWorkid());
        if (appattService.updateUncommittedAppatt(appatt) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/calcappatttime")
    @SystemControllerLog(description="计算员工本人考勤事务申请的时间")
    public double calcAppattTime(@RequestParam(defaultValue = " ",value = "leavedaterange", required = false) Date[] leavedaterange,Authentication authentication) throws ParseException {
        User user=(User) authentication.getPrincipal();
        return appattService.calcAppattTime(user.getWorkid(),leavedaterange);
    }
}
