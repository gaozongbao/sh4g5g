package com.c.syslog;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.c.dao.SysLogDao;
import com.c.model.SysLogEntity;
import org.apache.log4j.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.c.util.HttpUtils;

/**
 * @ClassName: 操作日志切面
 * @Description: 拦截controller并完成用户操作记录到mysql中
 * @author: 高宗宝
 * @date: 2019年1月3日
 * @version: 1.0
 */
@Aspect
@Component
public class SysLogAspect {
	private static Logger logger = Logger.getLogger(SysLogAspect.class);

	@Autowired
	private SysLogDao sysLogDao;

	public static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");// 设置日期格式

	@Pointcut("@annotation(com.c.syslog.SysLog)")
	public void sysLogPointCut() {
	}

	@Around("sysLogPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		// 开始时间
		String startTime = df.format(new Date());
		// 执行方法
		Object result = point.proceed();
		// 结束时间
		String endTime = df.format(new Date());
		// 保存日志
		saveSysLog(point, startTime, endTime);
		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, String startTime, String endTime) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLogEntity sysLogEntity = new SysLogEntity();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if (syslog != null) {
			// 获取注解的描述
			sysLogEntity.setUseroperation(syslog.value());
		}
		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLogEntity.setUsermethod(className + "." + methodName + "()");
		// 请求的参数
		Object[] args = joinPoint.getArgs();
		try {
			// 如果传参是一个对象可以用此方法
			// String params = JSON.toJSONString(args[0]);
			sysLogEntity.setParams(getParamsInfo(joinPoint));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取request
		HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		sysLogEntity.setIpaddress(HttpUtils.getIPAddress(httpServletRequest));
		// 用户名和id信息，如shiro可以通过SecurityUtils.getSubject().getPrincipal()得到登录用户信息
//		sysLogEntity.setUserid(1L);
//		if(SecurityUtils.getSubject().isAuthenticated()) {
//			sysLogEntity.setUsername((String) SecurityUtils.getSubject().getPrincipal());
//		}
		
		sysLogEntity.setStarttime(startTime);
		sysLogEntity.setEndtime(endTime);
		logger.info(sysLogEntity);
		// 保存系统日志
		sysLogDao.insert(sysLogEntity);
	}

	private String getParamsInfo(ProceedingJoinPoint joinPoint) throws Exception {
		String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
		Object[] args = joinPoint.getArgs();
		StringBuilder sb = null;
		if (parameterNames != null) {
			sb = new StringBuilder();
			for (int i = 0; i < parameterNames.length; i++) {
				if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse
						|| args[i] instanceof HttpSession)
					continue;
				String value = args[i] != null ? args[i].toString() : "null";
				sb.append(parameterNames[i] + "=" + value + ";");
			}
		}
		return sb == null ? "" : sb.toString();
	}

}
