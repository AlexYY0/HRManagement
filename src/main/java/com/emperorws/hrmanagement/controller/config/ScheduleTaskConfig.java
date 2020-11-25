package com.emperorws.hrmanagement.controller.config;

import com.emperorws.hrmanagement.exception.ExceptionEnum;
import com.emperorws.hrmanagement.exception.TaskException;
import com.emperorws.hrmanagement.service.AttelogdayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/22 13:14
 * @Description: 定时任务
 **/
@Component
@EnableScheduling
public class ScheduleTaskConfig {
    private static final Logger log = LoggerFactory.getLogger(ScheduleTaskConfig.class);
    @Autowired
    AttelogdayService attelogdayService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void autoExecCreatAttenlogday(){
        log.info("开始执行定时任务：自动生成每日员工打卡签到任务");
        if(!attelogdayService.autoExecCreatDate()){
            throw new TaskException(ExceptionEnum.TASK_EXEC_EXCEPTION);
        }
    }
}
