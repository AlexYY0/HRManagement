package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Contractinfo;
import com.emperorws.hrmanagement.model.Employeechange;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ContractinfoMapper {
    int deleteByPrimaryKey(Integer empcid);

    int insert(Contractinfo record);

    int insertSelective(Contractinfo record);

    Contractinfo selectByPrimaryKey(Integer empcid);

    int updateByPrimaryKeySelective(Contractinfo record);

    int updateByPrimaryKey(Contractinfo record);

    List<Employeechange> getContractinfoByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("con") Contractinfo contractinfo, @Param("signdate") Date[] signdate);

    Long getTotal(@Param("con") Contractinfo contractinfo, @Param("signdate") Date[] signdate);
}
