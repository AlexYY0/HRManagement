package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
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

    @SystemServiceLog(description="获取所有的福利信息")
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

    @SystemServiceLog(description="删除旧的福利信息")
    public Integer deleteWelfareById(Integer welid){
        return welfareMapper.deleteByPrimaryKey(welid);
    }

    @SystemServiceLog(description="添加新的福利信息")
    public Integer addWelfare(Welfare welfare){
        return welfareMapper.insertSelective(welfare);
    }

    @SystemServiceLog(description="修改福利信息")
    public Integer updateWelfare(Welfare welfare){
        return welfareMapper.updateByPrimaryKeySelective(welfare);
    }

    @SystemServiceLog(description="批量删除旧的福利信息")
    public Integer deleteWelfares(List<Welfare> welfares){
        return welfareMapper.deleteWelfares(welfares);
    }
}
