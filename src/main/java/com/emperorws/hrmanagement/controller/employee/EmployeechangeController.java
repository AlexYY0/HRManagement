package com.emperorws.hrmanagement.controller.employee;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.Employeechange;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.service.EmployeechangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/21 16:41
 * @Description: 员工人事调动控制层
 **/
@RestController
@RequestMapping("/employee/basic/change")
public class EmployeechangeController {
    @Autowired
    EmployeechangeService employeechangeService;

    @GetMapping("/")
    @SystemControllerLog(description="获取员工的人事调动信息")
    public RespPageBean getEmployeechangeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employeechange employeechange, Date[] empchandate){
        return employeechangeService.getEmployeechangeByPage(page,size,employeechange,empchandate);
    }

    @PostMapping("/")
    @SystemControllerLog(description="添加员工的人事调动信息")
    public RespBean addEmpChange(@RequestBody Employeechange employeechange) {
        if (employeechangeService.addEmpChange(employeechange) == 2) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
}
