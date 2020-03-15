package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
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

    @SystemServiceLog(description="获取员工的薪资调整信息")
    public RespPageBean getSalaryadjustmentByPage(Integer page, Integer size, Salaryadjustment salaryadjustment, Date[] sadate){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Salaryadjustment> data=salaryadjustmentMapper.getSalaryadjustmentByPage(page,size,salaryadjustment,sadate);
        Long total=salaryadjustmentMapper.getTotal(salaryadjustment,sadate);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @SystemServiceLog(description="调整员工的薪资，并存储薪资调整记录")
    public Integer addEmpSalAdj(Salaryadjustment salaryadjustment){
        return salaryadjustmentMapper.insertSelective(salaryadjustment);
    }
}
