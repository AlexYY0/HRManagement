package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Speadd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpeaddMapper {
    int deleteByPrimaryKey(Integer sadid);

    int insert(Speadd record);

    int insertSelective(Speadd record);

    Speadd selectByPrimaryKey(Integer sadid);

    int updateByPrimaryKeySelective(Speadd record);

    int updateByPrimaryKey(Speadd record);

    List<Speadd> getAllSpeaddByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("sad") Speadd speadd);

    Long getTotal(@Param("sad") Speadd speadd);

    Integer deleteSpeadds(@Param("sads") List<Speadd> speadds);
}
