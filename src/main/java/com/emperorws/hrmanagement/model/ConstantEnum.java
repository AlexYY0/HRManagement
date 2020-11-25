package com.emperorws.hrmanagement.model;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 16:04
 * @Description: 自定义装Token的实体类
 **/
public enum  ConstantEnum {
    DEFAULT_ROLE("employee"), AUTHORIZATION("Authorization");

    private String value;

    private ConstantEnum(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
