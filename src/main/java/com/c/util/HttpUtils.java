package com.c.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: HttpUtils
 * @Description: http相关工具
 * @author: 高宗宝
 * @date: 2019年1月17日
 * @version: 1.0
 */
public class HttpUtils {
	public final static String LOCAL_IP = "127.0.0.1";
	public final static String DEFAULT_IP = "0:0:0:0:0:0:0:1";
	public final static int DEFAULT_IP_LENGTH = 15;


	/** 
	* @Title: getIPAddress 
	* @Description: 从 HttpServletRequest得到用户ip
	* @param request
	* @return 
	* @return String
	* @author 高宗宝
	* @date 2019年1月17日下午2:49:06
	*/ 
	public static String getIPAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");// squid 服务代理
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");// apache服务代理
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");// weblogic 代理
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");// 有些代理
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP"); // nginx代理
		}

		// 如果此时还是获取不到ip地址，那么最后就使用request.getRemoteAddr()来获取

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if (LOCAL_IP.equalsIgnoreCase(ip) || DEFAULT_IP.equalsIgnoreCase(ip)) {
				// 根据网卡取本机配置的IP
				InetAddress iNet = null;
				try {
					iNet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					// logger.error("InetAddress getLocalHost error In HttpUtils
					// getRealIpAddress: " ,e);
				}
				ip = iNet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		// "***.***.***.***".length() = 15
		if (ip != null && ip.length() >= 0 && ip.length() > DEFAULT_IP_LENGTH) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}
}
