package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
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

    @SystemServiceLog(description="获取所有的班次信息")
    public List<Businesshours> getAllBusinesshours(){
        return businesshoursMapper.getAllBusinesshours();
    }

    @SystemServiceLog(description="删除班次信息")
    public Integer deleteBusinesshoursById(Integer busihoursid){
        return businesshoursMapper.deleteByPrimaryKey(busihoursid);
    }

    @SystemServiceLog(description="添加新的班次信息")
    public Integer addBusinesshours(Businesshours businesshours){
        return businesshoursMapper.insertSelective(businesshours);
    }

    @SystemServiceLog(description="修改已有的班次信息")
    public Integer updateBusinesshours(Businesshours businesshours){
        return businesshoursMapper.updateByPrimaryKeySelective(businesshours);
    }

    @SystemServiceLog(description="批量删除班次信息")
    public Integer deleteBusinesshours(List<Businesshours> businesshours){
        return businesshoursMapper.deleteBusinesshours(businesshours);
    }
}
