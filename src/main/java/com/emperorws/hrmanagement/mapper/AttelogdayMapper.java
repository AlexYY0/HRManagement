package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Attelogday;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Workingschedule;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AttelogdayMapper {
    int deleteByPrimaryKey(Integer attelogdayid);

    int insert(Attelogday record);

    int insertSelective(Attelogday record);

    Attelogday selectByPrimaryKey(Integer attelogdayid);

    int updateByPrimaryKeySelective(Attelogday record);

    int updateByPrimaryKey(Attelogday record);

    List<Attelogday> getAttelogdayByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("clockinday") Date[] clockinday);

    Long getTotal(@Param("emp") Employee employee, @Param("clockinday") Date[] clockinday);

    Integer deleteAttelogdays(@Param("attelogdays") List<Attelogday> attelogdays);

    Attelogday selectByOpenidAndDay(@Param("openid") String openid,@Param("today") Date today);

    Integer autoExecCreatDate(@Param("workingschedules") List<Workingschedule> workingschedules);

    List<Map<String,Object>> getClockinVisual();
}
