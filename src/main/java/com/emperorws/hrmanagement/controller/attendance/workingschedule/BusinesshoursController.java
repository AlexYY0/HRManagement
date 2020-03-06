package com.emperorws.hrmanagement.controller.attendance.workingschedule;

import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.Businesshours;
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
    public List<Businesshours> getAllBusinesshours(){
        return businesshoursService.getAllBusinesshours();
    }

    @DeleteMapping("/{busihoursid}")
    public RespBean deleteBusinesshoursById(@PathVariable Integer busihoursid){
        if (businesshoursService.deleteBusinesshoursById(busihoursid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/")
    public RespBean addBusinesshours(@RequestBody Businesshours businesshours){
        if (businesshoursService.addBusinesshours(businesshours) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updateBusinesshours(@RequestBody Businesshours businesshours){
        if (businesshoursService.updateBusinesshours(businesshours) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/deletebhs")
    public RespBean deleteBusinesshours(@RequestBody List<Businesshours> businesshours){
        if(businesshoursService.deleteBusinesshours(businesshours)==businesshours.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
