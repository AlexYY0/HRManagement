package com.emperorws.hrmanagement.controller.work;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
import com.emperorws.hrmanagement.model.Calendar;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/12 0:33
 * @Description: 公司日历节假日表控制层
 **/
@RestController
@RequestMapping("/work/bench")
public class CalendarController {
    @Autowired
    CalendarService calendarService;

    @PostMapping("/adds")
    @SystemControllerLog(description="插入新的节假日表数据")
    public RespBean addCalendars(@RequestBody List<Calendar> calendars){
        if(calendarService.addCalendars(calendars)==calendars.size()){
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
}
