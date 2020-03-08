package com.emperorws.hrmanagement.mapper;


import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Workingschedule;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WorkingscheduleMapper {
    int deleteByPrimaryKey(Integer wsid);

    int insert(Workingschedule record);

    int insertSelective(Workingschedule record);

    Workingschedule selectByPrimaryKey(Integer wsid);

    int updateByPrimaryKeySelective(Workingschedule record);

    int updateByPrimaryKey(Workingschedule record);

    List<Workingschedule> getWorkingscheduleByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("firstofweek") Date firstofweek);

    Long getTotal(@Param("emp") Employee employee, @Param("firstofweek") Date firstofweek);

    Integer updateWorkingschedules(@Param("wss") List<Workingschedule> workingschedules);

    Integer deleteWorkingschedules(@Param("wss") List<Workingschedule> workingschedules);

    Integer autoSchedule(@Param("emps") List<Employee> employees, @Param("firstofweek") Date firstofweek);
}
