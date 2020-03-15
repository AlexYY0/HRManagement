package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Workingschedule;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Workingschedule)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-15 12:41:47
 */
public interface WorkingscheduleMapper {
    int deleteByPrimaryKey(Integer wsid);

    int insert(Workingschedule record);

    int insertSelective(Workingschedule record);

    Workingschedule selectByPrimaryKey(Integer wsid);

    int updateByPrimaryKeySelective(Workingschedule record);

    int updateByPrimaryKey(Workingschedule record);

    List<Map<String,Object>> getWorkingscheduleByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("monthday") Date[] monthday, @Param("array") String[] allmonnthdays);

    Long getTotal(@Param("emp") Employee employee, @Param("monthday") Date[] monthday);

    Integer updateWorkingschedule(@Param("wss") List<Workingschedule> workingschedules, @Param("workid") Integer workid);

    Integer deleteWorkingschedules(@Param("wss") List<Map<String,Object>> workingschedules);

    Integer autoSchedule(@Param("emps") List<Employee> employees, @Param("monthday") Date[] monthday);

    List<Workingschedule> getAllWorkingscheduleByDate(@Param("workid") Integer workid,@Param("daterange") Date[] daterange);

    Integer updateWorkingscheduleSelf(@Param("workid") Integer workid,@Param("daterange") Date[] daterange);
}
