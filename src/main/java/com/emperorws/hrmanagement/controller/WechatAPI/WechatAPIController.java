package com.emperorws.hrmanagement.controller.WechatAPI;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.service.UserService;
import com.emperorws.hrmanagement.service.WechatAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/18 17:02
 * @Description:
 **/
@RestController
@RequestMapping("/wechatapi")
public class WechatAPIController {
    @Autowired
    WechatAPIService wechatAPIService;
    @Autowired
    UserService userService;

    @PostMapping("/bind")
    @SystemControllerLog(description="员工换绑或者开始绑定自己的微信和系统账户")
    public RespBean bind(@RequestBody Map<String, Object> info){
        if(wechatAPIService.bind(info)){
            return RespBean.ok("绑定成功");
        }else{
            return RespBean.error("绑定失败");
        }
    }

    @GetMapping("/getattelogday")
    @SystemControllerLog(description="员工通过微信小程序获取今天的考勤安排,用于打卡")
    public RespBean getTodayAtten(Date today){
        return wechatAPIService.getTodayAtten(today);
    }

    @GetMapping("/signin")
    @SystemControllerLog(description="员工通过微信小程序签到打卡")
    public RespBean signIn(Date signintime,Integer clockinflag) throws ParseException {
        return wechatAPIService.signIn(signintime,clockinflag);
    }

    @GetMapping("/signout")
    @SystemControllerLog(description="员工通过微信小程序签退打卡")
    public RespBean signOut(Date signouttime) throws ParseException {
        return wechatAPIService.signOut(signouttime);
    }
}
