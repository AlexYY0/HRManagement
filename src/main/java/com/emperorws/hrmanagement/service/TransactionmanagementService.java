package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.AppattMapper;
import com.emperorws.hrmanagement.model.Appatt;
import com.emperorws.hrmanagement.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/5 22:13
 * @Description: 考勤事务申请管理服务层
 **/
@Service
public class TransactionmanagementService {
    @Autowired
    AppattMapper appattMapper;

    public RespPageBean getManaAppByWorkidAndPage(Integer page, Integer size, Boolean isapprove, Integer workid){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Appatt> data=appattMapper.getManaAppByWorkidAndPage(workid,page,size,isapprove);
        Long total = appattMapper.getManaAppTotal(workid,isapprove);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer updateManaApp(Appatt appatt,Integer workid){
        if(appattMapper.checkManaApp(appatt.getWorkid(),workid)!=1)
            return -1;
        return appattMapper.updateByPrimaryKeySelective(appatt);
    }
}
