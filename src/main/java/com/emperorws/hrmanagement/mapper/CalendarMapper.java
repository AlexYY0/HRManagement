package com.emperorws.hrmanagement.mapper;


import com.emperorws.hrmanagement.model.Calendar;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CalendarMapper {
    int deleteByPrimaryKey(Integer caleid);

    int insert(Calendar record);

    int insertSelective(Calendar record);

    Calendar selectByPrimaryKey(Integer caleid);

    int updateByPrimaryKeySelective(Calendar record);

    int updateByPrimaryKey(Calendar record);

    Integer addCalendars(@Param("calendars") List<Calendar> calendars);

    List<Integer> getHolidays(@Param("daterange")Date[] daterange);
}
