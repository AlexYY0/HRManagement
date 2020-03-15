package com.emperorws.hrmanagement.controller.system;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.*;
import com.emperorws.hrmanagement.service.SystemlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/9 18:05
 * @Description: 系统日志控制层
 **/
@RestController
@RequestMapping("/system/log")
public class SystemlogController {
    @Autowired
    SystemlogService systemlogService;

    @GetMapping("/")
    @SystemControllerLog(description="获取所有的系统日志信息")
    public RespPageBean getSystemlogByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] logtime){
        return systemlogService.getSystemlogByPage(page,size,employee,logtime);
    }

    @PostMapping("/deletesystemlogs")
    @SystemControllerLog(description="批量删除旧的系统日志信息")
    public RespBean deleteSystemlogs(@RequestBody List<SystemlogWithBLOBs> systemlogWithBLOBs){
        if(systemlogService.deleteSystemlogs(systemlogWithBLOBs)==systemlogWithBLOBs.size()){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
