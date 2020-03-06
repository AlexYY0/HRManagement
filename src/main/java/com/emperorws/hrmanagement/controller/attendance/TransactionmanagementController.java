package com.emperorws.hrmanagement.controller.attendance;

import com.emperorws.hrmanagement.model.Appatt;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.User;
import com.emperorws.hrmanagement.service.TransactionmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/5 22:04
 * @Description: 考勤事务申请管理控制层
 **/
@RestController
@RequestMapping("/attendance/transactionmanagement")
public class TransactionmanagementController {
    @Autowired
    TransactionmanagementService transactionmanagementService;

    @GetMapping("/readydoapp")
    public RespPageBean getReadyDoAppByWorkidAndPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Authentication authentication) {
        User user=(User) authentication.getPrincipal();
        return transactionmanagementService.getManaAppByWorkidAndPage(page, size, null ,user.getWorkid());
    }

    @GetMapping("/finishedapp")
    public RespPageBean getFinishedAppByWorkidAndPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Authentication authentication) {
        User user=(User) authentication.getPrincipal();
        return transactionmanagementService.getManaAppByWorkidAndPage(page, size, true, user.getWorkid());
    }

    @PutMapping("/")
    public RespBean updateManaApp(@RequestBody Appatt appatt, Authentication authentication){
        User user=(User) authentication.getPrincipal();
        if (transactionmanagementService.updateManaApp(appatt,user.getWorkid()) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
