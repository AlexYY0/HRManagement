package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.TreatmentMapper;
import com.emperorws.hrmanagement.model.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/29 13:14
 * @Description: 保障性待遇表服务层
 **/
@Service
public class TreatmentService {
    @Autowired
    TreatmentMapper treatmentMapper;

    @SystemServiceLog(description="获取所有的保障性待遇信息")
    public List<Treatment> getAllTreatment(){
        return treatmentMapper.getAllTreatment();
    }

    @SystemServiceLog(description="删除旧的保障性待遇信息")
    public Integer deleteTreatmentById(Integer tretid){
        return treatmentMapper.deleteByPrimaryKey(tretid);
    }

    @SystemServiceLog(description="添加新的保障性待遇信息")
    public Integer addTreatment(Treatment treatment){
        return treatmentMapper.insertSelective(treatment);
    }

    @SystemServiceLog(description="修改保障性待遇信息")
    public Integer updateTreatment(Treatment treatment){
        return treatmentMapper.updateByPrimaryKeySelective(treatment);
    }

    @SystemServiceLog(description="批量删除保障性待遇信息")
    public Integer deleteTreatments(List<Treatment> treatment){
        return treatmentMapper.deleteTreatments(treatment);
    }
}
