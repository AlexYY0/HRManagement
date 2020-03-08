package com.emperorws.hrmanagement.controller.attendance;

import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.service.TransactioninfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/8 14:06
 * @Description: 所有考勤事务申请管理控制层
 **/
@RestController
@RequestMapping("/attendance/transactioninfo")
public class TransactioninfoController {
    @Autowired
    TransactioninfoService transactioninfoService;

    @GetMapping("/")
    public RespPageBean getTransactioninfoByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] appdata){
        return transactioninfoService.getTransactioninfoByPage(page, size, employee, appdata);
    }
}
