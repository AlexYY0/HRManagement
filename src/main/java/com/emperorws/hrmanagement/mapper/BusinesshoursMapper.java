package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Businesshours;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinesshoursMapper {
    int deleteByPrimaryKey(Integer busihoursid);

    int insert(Businesshours record);

    int insertSelective(Businesshours record);

    Businesshours selectByPrimaryKey(Integer busihoursid);

    int updateByPrimaryKeySelective(Businesshours record);

    int updateByPrimaryKey(Businesshours record);

    List<Businesshours> getAllBusinesshours();

    Integer deleteBusinesshours(@Param("bhs") List<Businesshours> businesshours);
}
