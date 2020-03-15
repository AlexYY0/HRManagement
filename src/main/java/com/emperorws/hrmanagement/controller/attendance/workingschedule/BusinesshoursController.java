package com.emperorws.hrmanagement.controller.attendance.workingschedule;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.Businesshours;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.service.BusinesshoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/5 11:11
 * @Description: 班次管理控制层
 **/
@RestController
@RequestMapping("/attendance/workingschedule/busihour")
public class BusinesshoursController {
    @Autowired
    BusinesshoursService businesshoursService;

    @GetMapping("/")
    @SystemControllerLog(description="获取所有的班次信息")
    public List<Businesshours> getAllBusinesshours(){
        return businesshoursService.getAllBusinesshours();
    }

    @DeleteMapping("/{busihoursid}")
    @SystemControllerLog(description="删除班次信息")
    public RespBean deleteBusinesshoursById(@PathVariable Integer busihoursid){
        if (businesshoursService.deleteBusinesshoursById(busihoursid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/")
    @SystemControllerLog(description="添加新的班次信息")
    public RespBean addBusinesshours(@RequestBody Businesshours businesshours){
        if (businesshoursService.addBusinesshours(businesshours) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    @SystemControllerLog(description="修改已有的班次信息")
    public RespBean updateBusinesshours(@RequestBody Businesshours businesshours){
        if (businesshoursService.updateBusinesshours(businesshours) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/deletebhs")
    @SystemControllerLog(description="批量删除班次信息")
    public RespBean deleteBusinesshours(@RequestBody List<Businesshours> businesshours){
        if(businesshoursService.deleteBusinesshours(businesshours)==businesshours.size()){
            return RespBean.ok("批量删除成功!");
        }
        return RespBean.error("批量删除失败!");
    }
}
