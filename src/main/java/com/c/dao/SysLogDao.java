package com.c.dao;

import com.c.model.SysLogEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysLogEntity record);

    int insertSelective(SysLogEntity record);

    SysLogEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLogEntity record);

    int updateByPrimaryKeyWithBLOBs(SysLogEntity record);

    int updateByPrimaryKey(SysLogEntity record);
}