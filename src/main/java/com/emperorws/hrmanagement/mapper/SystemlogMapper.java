package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.SystemlogWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SystemlogMapper {
    int deleteByPrimaryKey(Integer syslogid);

    int insert(SystemlogWithBLOBs record);

    int insertSelective(SystemlogWithBLOBs record);

    SystemlogWithBLOBs selectByPrimaryKey(Integer syslogid);

    int updateByPrimaryKeySelective(SystemlogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemlogWithBLOBs record);

    List<SystemlogWithBLOBs> getSystemlogByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("logtime") Date[] logtime);

    Long getTotal(@Param("emp") Employee employee, @Param("logtime") Date[] logtime);

    Integer deleteSystemlogs(@Param("systemlogs")List<SystemlogWithBLOBs> systemlogWithBLOBs);
}
