package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.SalaryadjustmentMapper;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Salaryadjustment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/3 15:34
 * @Description: 员工薪资调整服务层
 **/
@Service
public class SalaryadjustmentService {
    @Autowired
    SalaryadjustmentMapper salaryadjustmentMapper;

    public RespPageBean getSalaryadjustmentByPage(Integer page, Integer size, Salaryadjustment salaryadjustment, Date[] sadata){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Salaryadjustment> data=salaryadjustmentMapper.getSalaryadjustmentByPage(page,size,salaryadjustment,sadata);
        Long total=salaryadjustmentMapper.getTotal(salaryadjustment,sadata);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmpSalAdj(Salaryadjustment salaryadjustment){
        return salaryadjustmentMapper.insertSelective(salaryadjustment);
    }
}
