package com.xu.bootweb.mapper;

import com.xu.bootweb.pojo.TToken;
import com.xu.bootweb.pojo.TTokenExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TTokenMapper {
    long countByExample(TTokenExample example);

    int deleteByExample(TTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TToken record);

    int insertSelective(TToken record);

    List<TToken> selectByExample(TTokenExample example);

    TToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TToken record, @Param("example") TTokenExample example);

    int updateByExample(@Param("record") TToken record, @Param("example") TTokenExample example);

    int updateByPrimaryKeySelective(TToken record);

    int updateByPrimaryKey(TToken record);
}