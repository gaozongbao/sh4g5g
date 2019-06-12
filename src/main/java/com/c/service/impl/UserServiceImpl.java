package com.c.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.c.dao.SysUserDao;
import com.c.model.SysUser;
import com.c.service.UserService;
import com.c.util.CustomerContextHolder;

/**
 * 测试Service
 * 
 * @author: 高宗宝
 * @Description:事务管理需要注意数据引擎，异常类型为RuntimeException
 */
@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserDao userDao;

	/* @Title: getSysUser
	 * @Description: TODO
	 * @param id
	 * @return
	 * @throws Exception 
	 * @see com.c.service.UserService#getSysUser(java.lang.Integer) 
	 */
	@Override
	public SysUser getSysUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}

	
	

}
