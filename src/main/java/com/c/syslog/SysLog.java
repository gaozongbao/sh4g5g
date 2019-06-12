package com.c.syslog;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @ClassName: SysLog 
 * @Description: 日志功能注解
 * @author: 高宗宝
 * @date: 2019年4月11日
 * @version: 1.0 
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {
	String value() default "日志";
}
