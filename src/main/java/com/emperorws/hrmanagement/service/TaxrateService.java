package com.emperorws.hrmanagement.service;

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

    public List<Taxrate> getAllTaxrate(){
        return taxrateMapper.getAllTaxrate();
    }

    public Integer deleteTaxrateById(Integer trid){
        return taxrateMapper.deleteByPrimaryKey(trid);
    }

    public Integer addTaxrate(Taxrate taxrate){
        return taxrateMapper.insertSelective(taxrate);
    }

    public Integer updateTaxrate(Taxrate taxrate){
        return taxrateMapper.updateByPrimaryKeySelective(taxrate);
    }

    public Integer deleteTaxrates(List<Taxrate> taxrates){
        return taxrateMapper.deleteTaxrates(taxrates);
    }
}
