package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Attelogmon;
import com.emperorws.hrmanagement.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AttelogmonMapper {
    int deleteByPrimaryKey(Integer attelogmonid);

    int insert(Attelogmon record);

    int insertSelective(Attelogmon record);

    Attelogmon selectByPrimaryKey(Integer attelogmonid);

    int updateByPrimaryKeySelective(Attelogmon record);

    int updateByPrimaryKey(Attelogmon record);

    List<Attelogmon> getAttelogmonByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("caldate") Date[] caldate);

    Long getTotal(@Param("emp") Employee employee, @Param("caldate") Date[] caldate);

    Integer deleteAttelogmons(@Param("attelogmons") List<Attelogmon> attelogmons);

    Integer statisticsAll(@Param("emps") List<Employee> employees, @Param("monthday") Date[] monthday);
}
