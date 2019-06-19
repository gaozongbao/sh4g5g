package com.c.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GcDao {

    public List<Map<String,Object>> getGcInfo(@Param("type")String type, @Param("gridid")List<String> gridid);
    public List<Map<String,Object>> getSaoPinInfo(@Param("tableName")String tableName,@Param("gridid")List<String> gridid);
    public List<Map<String,Object>> getAllSanGe();
    public List<Map<String,Object>> getMroInfo(@Param("type")String type, @Param("gridid")List<String> gridid);
}
