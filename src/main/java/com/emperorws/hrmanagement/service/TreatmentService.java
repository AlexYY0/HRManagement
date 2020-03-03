package com.emperorws.hrmanagement.service;

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

    public List<Treatment> getAllTreatment(){
        return treatmentMapper.getAllTreatment();
    }

    public Integer deleteTreatmentById(Integer tretid){
        return treatmentMapper.deleteByPrimaryKey(tretid);
    }

    public Integer addTreatment(Treatment treatment){
        return treatmentMapper.insertSelective(treatment);
    }

    public Integer updateTreatment(Treatment treatment){
        return treatmentMapper.updateByPrimaryKeySelective(treatment);
    }

    public Integer deleteTreatments(List<Treatment> treatment){
        return treatmentMapper.deleteTreatments(treatment);
    }
}
