package com.emperorws.hrmanagement.logger;

import java.lang.annotation.*;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/8 18:12
 * @Description: 自定义Controller注解切入点
 **/

@Target({ElementType.PARAMETER, ElementType.METHOD})//作用在参数和方法上
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Documented//表明这个注解应该被 javadoc工具记录
public @interface SystemControllerLog {
    String description() default "";
}
