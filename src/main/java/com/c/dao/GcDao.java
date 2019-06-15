package com.c.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GcDao {

    public List<Map<String,Object>> getGcInfo(@Param("tableName")String tableName,@Param("coverTableName")String coverTableName, @Param("gridid")Integer gridid);
    public List<Map<String,Object>> getSaoPinInfo(@Param("tableName")String tableName);
    public List<Map<String,Object>> getAllSanGe();
}
