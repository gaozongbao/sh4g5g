package com.c.dao;

import com.c.model.SysUser;

public interface SysUserDao {
    SysUser selectByUsername(String username);
    SysUser selectById(Integer id);
}