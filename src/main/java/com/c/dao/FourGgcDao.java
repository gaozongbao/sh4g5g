package com.c.dao;

import com.c.model.FourGgc;

public interface FourGgcDao {
    int deleteByPrimaryKey(Integer id);

    int insert(FourGgc record);

    int insertSelective(FourGgc record);

    FourGgc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FourGgc record);

    int updateByPrimaryKey(FourGgc record);
}