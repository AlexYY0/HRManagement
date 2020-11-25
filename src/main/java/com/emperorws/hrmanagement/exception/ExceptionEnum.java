package com.emperorws.hrmanagement.exception;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 14:28
 * @Description: 自定义异常合集
 **/
public enum ExceptionEnum {
    PARAM_EXCEPTION(40001, "param exception", "Wrong request parameter"),
    NOT_LOGIN(40301, "authentication exception", "not log in"),
    ACCESS_DENIED(40302, "authentication exception", "access denied, insufficient permission"),
    SIGN_INVALID(403004, "authentication exception", "can't find user,not bind"),
    JWT_EXCEPTION(40305, "authentication exception", "jwt exception"),
    SERVER_EXCEPTION(50000, "server exception", "Please define your own exception information"),
    WX_AUTH_FAILED(50002, "wx auth exception", "wx auth failed"),
    JSON_PARSE_EXCEPTION(50003, "json parse", "json parse failed"),
    TASK_EXEC_EXCEPTION(60001, "task exec", "task exec failed");

    private Integer status;
    private String type;
    private String message;

    private ExceptionEnum(Integer status,String type,String message){
        this.status=status;
        this.type=type;
        this.message=message;
    }

    public ExceptionEnum customMessage(String message){
        this.message = message;
        return this;
    }

    public ExceptionEnum customMessage(String message, Object...args){
        this.message = String.format(message, args);
        return this;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
