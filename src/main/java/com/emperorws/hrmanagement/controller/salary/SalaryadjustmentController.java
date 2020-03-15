package com.emperorws.hrmanagement.controller.salary;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Salaryadjustment;
import com.emperorws.hrmanagement.service.SalaryadjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/3 15:38
 * @Description: 员工薪资调整服务层
 **/
@RestController
@RequestMapping("/salary/employee/saladj")
public class SalaryadjustmentController {
    @Autowired
    SalaryadjustmentService salaryadjustmentService;

    @GetMapping("/")
    @SystemControllerLog(description="获取员工的薪资调整信息")
    public RespPageBean getEmployeechangeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Salaryadjustment salaryadjustment, Date[] sadate){
        return salaryadjustmentService.getSalaryadjustmentByPage(page,size,salaryadjustment,sadate);
    }

    @PostMapping("/")
    @SystemControllerLog(description="调整员工的薪资，并存储薪资调整记录")
    public RespBean addEmpChange(@RequestBody Salaryadjustment salaryadjustment) {
        if (salaryadjustmentService.addEmpSalAdj(salaryadjustment) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
}
