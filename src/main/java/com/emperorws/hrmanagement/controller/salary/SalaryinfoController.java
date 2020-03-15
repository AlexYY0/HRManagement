package com.emperorws.hrmanagement.controller.salary;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Salaryinfo;
import com.emperorws.hrmanagement.service.SalaryinfoService;
import com.emperorws.hrmanagement.utils.SalInfoPOIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/3 17:15
 * @Description: 员工历史薪资信息控制层
 **/
@RestController
@RequestMapping("/salary/information")
public class SalaryinfoController {
    @Autowired
    SalaryinfoService salaryinfoService;

    @GetMapping("/")
    @SystemControllerLog(description="获取员工的历史薪资结算信息")
    public RespPageBean getSalaryinfoByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] payoffdate) {
        return salaryinfoService.getSalaryinfoByPage(page, size, employee, payoffdate);
    }

    @PostMapping("/export")
    @SystemControllerLog(description="批量导出员工的历史薪资结算信息")
    public ResponseEntity<byte[]> exportData(@RequestBody List<Salaryinfo> list) {
        return SalInfoPOIUtils.salaryinfo2Excel(list);
    }
}
