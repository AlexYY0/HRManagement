package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.CalendarMapper;
import com.emperorws.hrmanagement.model.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/12 0:29
 * @Description: 公司日历节假日表服务层
 **/
@Service
public class CalendarService {
    @Autowired
    CalendarMapper calendarMapper;

    @SystemServiceLog(description="插入新的节假日表数据")
    public Integer addCalendars(List<Calendar> calendars){
        return calendarMapper.addCalendars(calendars);
    }
}
