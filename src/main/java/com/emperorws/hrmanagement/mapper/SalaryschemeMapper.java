package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Salaryscheme;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryschemeMapper {
    int deleteByPrimaryKey(Integer ssid);

    int insert(Salaryscheme record);

    int insertSelective(Salaryscheme record);

    Salaryscheme selectByPrimaryKey(Integer ssid);

    int updateByPrimaryKeySelective(Salaryscheme record);

    int updateByPrimaryKey(Salaryscheme record);

    List<Salaryscheme> getAllSalaryscheme();

    Integer deleteSalaryschemes(@Param("salsches") List<Salaryscheme> salaryschemes);
}
