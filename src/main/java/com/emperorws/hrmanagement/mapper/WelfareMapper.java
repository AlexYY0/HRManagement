package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Welfare;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WelfareMapper {
    int deleteByPrimaryKey(Integer welid);

    int insert(Welfare record);

    int insertSelective(Welfare record);

    Welfare selectByPrimaryKey(Integer welid);

    int updateByPrimaryKeySelective(Welfare record);

    int updateByPrimaryKey(Welfare record);

    List<Welfare> getAllWelfareByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("wel") Welfare welfare);

    Long getTotal(@Param("wel") Welfare welfare);

    Integer deleteWelfares(@Param("wels") List<Welfare> welfares);
}
