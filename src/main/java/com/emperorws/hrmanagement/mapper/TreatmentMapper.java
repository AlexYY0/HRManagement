package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Treatment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreatmentMapper {
    int deleteByPrimaryKey(Integer tretid);

    int insert(Treatment record);

    int insertSelective(Treatment record);

    Treatment selectByPrimaryKey(Integer tretid);

    int updateByPrimaryKeySelective(Treatment record);

    int updateByPrimaryKey(Treatment record);

    List<Treatment> getAllTreatment();

    Integer deleteTreatments(@Param("trets") List<Treatment> treatments);
}
