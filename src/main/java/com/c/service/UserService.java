package com.c.service;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.c.model.SysUser;


@Component
public interface UserService {
	public SysUser getSysUser(Integer id) throws Exception;
}
