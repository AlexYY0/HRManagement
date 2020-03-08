package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Appatt;
import com.emperorws.hrmanagement.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AppattMapper {
    int deleteByPrimaryKey(@Param("aatid") Integer aatid,@Param("workid") Integer workid);

    int insert(Appatt record);

    int insertSelective(Appatt record);

    Appatt selectByPrimaryKey(Integer aatid);

    int updateByPrimaryKeySelective(Appatt record);

    int updateByPrimaryKey(Appatt record);

    List<Appatt> getAppattByWorkidAndPage(@Param("workid") Integer workid, @Param("page") Integer page, @Param("size") Integer size, @Param("issubmit") Boolean issubmit, @Param("isapprove") Boolean isapprove);

    Long getTotal(@Param("workid") Integer workid, @Param("issubmit") Boolean issubmit, @Param("isapprove") Boolean isapprove);

    Integer deleteAppatts(@Param("appatts") List<Appatt> appatts,@Param("workid") Integer workid);

    List<Appatt> getManaAppByWorkidAndPage(@Param("workid") Integer workid, @Param("page") Integer page, @Param("size") Integer size, @Param("isapprove") Boolean isapprove);

    Long getManaAppTotal(@Param("workid") Integer workid, @Param("isapprove") Boolean isapprove);

    Long checkManaApp(@Param("workid") Integer workid,@Param("leaderid") Integer leaderid);

    List<Appatt> getTransactioninfoByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, Date[] appdata);

    Long getTransactioninfoTotal(@Param("emp") Employee employee, Date[] appdata);
}
