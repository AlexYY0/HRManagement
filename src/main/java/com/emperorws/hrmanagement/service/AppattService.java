package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.AppattMapper;
import com.emperorws.hrmanagement.model.Appatt;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/5 13:10
 * @Description: 考勤事务申请管理服务层
 **/
@Service
public class AppattService {
    @Autowired
    AppattMapper appattMapper;

    public RespPageBean getAppattByWorkid(Integer page, Integer size, Boolean isSubmit, Boolean isapprove, Integer workid){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Appatt> data=appattMapper.getAppattByWorkidAndPage(workid,page,size,isSubmit,isapprove);
        Long total = appattMapper.getTotal(workid,isSubmit,isapprove);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer deleteUncommittedAppattById(Integer aatid,Integer workid){
        return appattMapper.deleteByPrimaryKey(aatid,workid);
    }

    public Integer deleteUncommittedAppatts(List<Appatt> appatts,Integer workid){
        return appattMapper.deleteAppatts(appatts,workid);
    }

    public Integer addUncommittedAppatt(Appatt appatt){
        return appattMapper.insert(appatt);
    }

    public Integer updateUncommittedAppatt(Appatt appatt){
        return appattMapper.updateByPrimaryKeySelective(appatt);
    }
}
