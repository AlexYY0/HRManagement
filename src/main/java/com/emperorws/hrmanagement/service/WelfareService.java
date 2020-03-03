package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.WelfareMapper;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Welfare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/29 14:00
 * @Description: 福利表服务层
 **/
@Service
public class WelfareService {
    @Autowired
    WelfareMapper welfareMapper;

    public RespPageBean getAllWelfareByPage(Integer page, Integer size, Welfare welfare){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Welfare> data=welfareMapper.getAllWelfareByPage(page, size, welfare);
        Long total = welfareMapper.getTotal(welfare);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer deleteWelfareById(Integer welid){
        return welfareMapper.deleteByPrimaryKey(welid);
    }

    public Integer addWelfare(Welfare welfare){
        return welfareMapper.insertSelective(welfare);
    }

    public Integer updateWelfare(Welfare welfare){
        return welfareMapper.updateByPrimaryKeySelective(welfare);
    }

    public Integer deleteWelfares(List<Welfare> welfares){
        return welfareMapper.deleteWelfares(welfares);
    }
}
