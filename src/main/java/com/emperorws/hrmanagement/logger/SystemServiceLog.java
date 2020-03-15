package com.emperorws.hrmanagement.logger;

import java.lang.annotation.*;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/15 15:41
 * @Description: 自定义Service注解切入点
 **/

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String description() default "";
}
