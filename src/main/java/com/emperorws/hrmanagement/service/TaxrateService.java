package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.TaxrateMapper;
import com.emperorws.hrmanagement.model.Taxrate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/28 17:53
 * @Description: 税率表服务层
 **/
@Service
public class TaxrateService {
    @Autowired
    TaxrateMapper taxrateMapper;

    @SystemServiceLog(description="获取所有的个人所得税税率信息")
    public List<Taxrate> getAllTaxrate(){
        return taxrateMapper.getAllTaxrate();
    }

    @SystemServiceLog(description="删除旧的个人所得税税率信息")
    public Integer deleteTaxrateById(Integer trid){
        return taxrateMapper.deleteByPrimaryKey(trid);
    }

    @SystemServiceLog(description="添加新的个人所得税税率信息")
    public Integer addTaxrate(Taxrate taxrate){
        return taxrateMapper.insertSelective(taxrate);
    }

    @SystemServiceLog(description="修改旧的个人所得税税率信息")
    public Integer updateTaxrate(Taxrate taxrate){
        return taxrateMapper.updateByPrimaryKeySelective(taxrate);
    }

    @SystemServiceLog(description="批量删除旧的个人所得税税率信息")
    public Integer deleteTaxrates(List<Taxrate> taxrates){
        return taxrateMapper.deleteTaxrates(taxrates);
    }
}
