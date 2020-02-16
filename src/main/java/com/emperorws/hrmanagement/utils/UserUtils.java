package com.emperorws.hrmanagement.utils;

import com.emperorws.hrmanagement.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/14 13:44
 * @Description: 获取当前登录用户的工具类
 **/
public class UserUtils {
    public static User getCurrentUser() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
