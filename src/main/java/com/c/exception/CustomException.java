package com.c.exception;


/** 
 * @ClassName: CustomException 
 * @Description: TODO
 * @author: 高宗宝
 * @date: 2019年6月10日
 * @version: 1.0 
 */
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int status = 500;

    public CustomException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public CustomException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public CustomException(String msg, int status) {
		super(msg);
		this.msg = msg;
		this.status = status;
	}

	public CustomException(String msg, int status, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
