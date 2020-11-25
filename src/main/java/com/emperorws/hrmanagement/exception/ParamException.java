package com.emperorws.hrmanagement.exception;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 14:30
 * @Description: 自定义没有参数异常
 **/
public class ParamException extends BasicException {
    public ParamException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
