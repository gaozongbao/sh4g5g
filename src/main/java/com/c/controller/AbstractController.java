package com.c.controller;

import com.c.model.SysUser;


/** 
 * @ClassName: AbstractController 
 * @Description: Controller公共组件
 * @author: 高宗宝
 * @date: 2019年6月11日
 * @version: 1.0 
 */
public abstract class AbstractController {

	protected SysUser getUser() {
		return null;
//		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}
}
