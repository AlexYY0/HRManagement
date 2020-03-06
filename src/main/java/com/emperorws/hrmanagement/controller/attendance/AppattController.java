package com.emperorws.hrmanagement.controller.attendance;

import com.emperorws.hrmanagement.model.*;
import com.emperorws.hrmanagement.service.AppattService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    public RespPageBean getUncommittedAppattByWorkid(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Authentication authentication) {
        User user=(User) authentication.getPrincipal();
        return appattService.getAppattByWorkid(page, size, false, null, user.getWorkid());
    }

    @GetMapping("/inhandappatt")
    public RespPageBean getInhandAppattByWorkidAndPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Authentication authentication) {
        User user=(User) authentication.getPrincipal();
        return appattService.getAppattByWorkid(page, size, true, null, user.getWorkid());
    }

    @GetMapping("/overappatt")
    public RespPageBean getOverAppattByWorkidAndPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Authentication authentication) {
        User user=(User) authentication.getPrincipal();
        return appattService.getAppattByWorkid(page, size, true, true, user.getWorkid());
    }

    @DeleteMapping("/{aatid}")
    public RespBean deleteUncommittedAppattById(@PathVariable Integer aatid,Authentication authentication){
        User user=(User) authentication.getPrincipal();
        if (appattService.deleteUncommittedAppattById(aatid,user.getWorkid()) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/deleteappatts")
    public RespBean deleteUncommittedAppatts(@RequestBody List<Appatt> appatts,Authentication authentication){
        User user=(User) authentication.getPrincipal();
        if(appattService.deleteUncommittedAppatts(appatts,user.getWorkid())==appatts.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/")
    public RespBean addUncommittedAppatt(@RequestBody Appatt appatt,Authentication authentication){
        User user=(User) authentication.getPrincipal();
        appatt.setWorkid(user.getWorkid());
        if (appattService.addUncommittedAppatt(appatt) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updateUncommittedAppatt(@RequestBody Appatt appatt,Authentication authentication){
        User user=(User) authentication.getPrincipal();
        appatt.setWorkid(user.getWorkid());
        if (appattService.updateUncommittedAppatt(appatt) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
