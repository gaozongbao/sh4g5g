package com.c.util;

import com.c.exception.CustomException;

/**
 * @ClassName: PasswordCheck 
 * @Description: 密码、邮箱验证机制
 * @author: 高宗宝
 * @date: 2018年7月27日
 * @version: 1.0 
 */
public class PasswordEmailCheck {
	/**密码校验规则
	 * 1. 必须同时包含数字和字母
	 * 2. 长度在[5,10]范围内
	 * */
	//密码是数字+字母+特殊符号(!@#$%^&*_)组成
	public static Boolean passwordCheck(String inputP){
		String regex = "^^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*_-]+$)(?![a-zA-z\\d]+$)(?![a-zA-z!@#$%^&*_-]+$)(?![\\d!@#$%^&*_-]+$)[a-zA-Z\\d!@#$%^&*_-]{5,14}$";
		return inputP.matches(regex);
	}

	public static Boolean isincludenumandwordlen5to10(String inputP) {
		String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,10}$";
		return inputP.matches(regex);
	}
	
	public static Boolean isEmail(String inputE) {
		String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return inputE.matches(regex);
	}
	
	public static void main(String[] args) {
		System.out.println(isincludenumandwordlen5to10("asdfg"));
		System.out.println(isEmail("asa@1.com"));
	}
}
