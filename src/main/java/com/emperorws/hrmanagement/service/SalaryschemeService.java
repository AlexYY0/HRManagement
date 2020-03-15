package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.SalaryschemeMapper;
import com.emperorws.hrmanagement.model.Salaryscheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/14 12:05
 * @Description: 薪资方案管理服务层
 **/
@Service
public class SalaryschemeService {
    @Autowired
    SalaryschemeMapper salaryschemeMapper;

    @SystemServiceLog(description="获取所有的薪资计算方案信息")
    public List<Salaryscheme> getAllSalaryscheme(){
        return salaryschemeMapper.getAllSalaryscheme();
    }

    @SystemServiceLog(description="删除旧的薪资计算方案信息")
    public Integer deleteSalaryschemeById(Integer ssid){
        return salaryschemeMapper.deleteByPrimaryKey(ssid);
    }

    @SystemServiceLog(description="添加新的薪资计算方案信息")
    public Integer addSalaryscheme(Salaryscheme salaryscheme){
        return salaryschemeMapper.insertSelective(salaryscheme);
    }

    @SystemServiceLog(description="修改旧的薪资计算方案信息")
    public Integer updateSalaryscheme(Salaryscheme salaryscheme){
        return salaryschemeMapper.updateByPrimaryKeySelective(salaryscheme);
    }

    @SystemServiceLog(description="批量删除旧的薪资计算方案信息")
    public Integer deleteSalaryschemes(List<Salaryscheme> salaryschemes){
        return salaryschemeMapper.deleteSalaryschemes(salaryschemes);
    }
}
