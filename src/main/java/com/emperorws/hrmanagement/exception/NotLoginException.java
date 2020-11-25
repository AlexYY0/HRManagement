package com.emperorws.hrmanagement.exception;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 14:30
 * @Description: 自定义没有登录异常
 **/
public class NotLoginException extends BasicException {
    public NotLoginException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
