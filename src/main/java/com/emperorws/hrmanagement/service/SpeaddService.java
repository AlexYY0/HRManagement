package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.SpeaddMapper;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Speadd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/29 18:04
 * @Description: 专项附加扣除服务层
 **/
@Service
public class SpeaddService {
    @Autowired
    SpeaddMapper speaddMapper;

    @SystemServiceLog(description="获取所有的专扣信息")
    public RespPageBean getAllSpeaddByPage(Integer page, Integer size, Speadd speadd){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Speadd> data=speaddMapper.getAllSpeaddByPage(page, size, speadd);
        Long total = speaddMapper.getTotal(speadd);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @SystemServiceLog(description="删除旧的专扣信息")
    public Integer deleteSpeaddById(Integer welid){
        return speaddMapper.deleteByPrimaryKey(welid);
    }

    @SystemServiceLog(description="添加新的专扣信息")
    public Integer addSpeadd(Speadd speadd){
        return speaddMapper.insertSelective(speadd);
    }

    @SystemServiceLog(description="修改旧的专扣信息")
    public Integer updateSpeadd(Speadd speadd){
        return speaddMapper.updateByPrimaryKeySelective(speadd);
    }

    @SystemServiceLog(description="批量删除旧的专扣信息")
    public Integer deleteSpeadds(List<Speadd> speadds){
        return speaddMapper.deleteSpeadds(speadds);
    }
}
