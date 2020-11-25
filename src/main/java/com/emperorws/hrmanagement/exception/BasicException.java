package com.emperorws.hrmanagement.exception;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 14:27
 * @Description: 自定义基础异常
 **/
public class BasicException extends RuntimeException {
    private Integer status;
    private String type;

    public BasicException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.status = exceptionEnum.getStatus();
        this.type = exceptionEnum.getType();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
