package com.emperorws.hrmanagement.exception;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/22 13:38
 * @Description: 自定义任务执行异常
 **/
public class TaskException extends BasicException {
    public TaskException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
