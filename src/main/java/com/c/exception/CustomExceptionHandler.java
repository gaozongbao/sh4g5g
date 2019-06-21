package com.c.exception;


import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.c.util.ResponseEntity;



/** 
 * @ClassName: CustomExceptionHandler 
 * @Description: 统一异常处理
 * @author: 高宗宝
 * @date: 2019年6月11日
 * @version: 1.0 
 */
@ControllerAdvice
public class CustomExceptionHandler {
	private static Logger logger = Logger.getLogger(CustomExceptionHandler.class);

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(CustomException.class)
	@ResponseBody
	public ResponseEntity handleRRException(CustomException e){
		return ResponseEntity.commonResponse(-1, "错误");
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
	public  ResponseEntity handleRequestParameterException(MissingServletRequestParameterException e){
		logger.error(e.getMessage(),e);
		return ResponseEntity.commonResponse(-1, "缺少参数");
	}

//	@ExceptionHandler(AuthorizationException.class)
//	@ResponseBody
//	public ResponseEntity handleAuthorizationException(AuthorizationException e){
//		logger.error(e.getMessage(), e);
//		return ResponseEntity.commonResponse(-1, "没有权限");
//	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity handleException(Exception e){
		logger.error(e.getMessage(), e);
		return ResponseEntity.failResponse();
	}
}
