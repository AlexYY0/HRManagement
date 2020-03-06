package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.BusinesshoursMapper;
import com.emperorws.hrmanagement.model.Businesshours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/5 11:05
 * @Description: 班次管理服务层
 **/
@Service
public class BusinesshoursService {
    @Autowired
    BusinesshoursMapper businesshoursMapper;

    public List<Businesshours> getAllBusinesshours(){
        return businesshoursMapper.getAllBusinesshours();
    }

    public Integer deleteBusinesshoursById(Integer busihoursid){
        return businesshoursMapper.deleteByPrimaryKey(busihoursid);
    }

    public Integer addBusinesshours(Businesshours businesshours){
        return businesshoursMapper.insertSelective(businesshours);
    }

    public Integer updateBusinesshours(Businesshours businesshours){
        return businesshoursMapper.updateByPrimaryKeySelective(businesshours);
    }

    public Integer deleteBusinesshours(List<Businesshours> businesshours){
        return businesshoursMapper.deleteBusinesshours(businesshours);
    }
}
