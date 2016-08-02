package com.zhangyw.utils.exception;

public class TimeStringFormateException extends Exception {

	private static final long serialVersionUID = 1L;

	public TimeStringFormateException() {
		super();
	}

	public TimeStringFormateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TimeStringFormateException(String message, Throwable cause) {
		super(message, cause);
	}

	public TimeStringFormateException(String message) {
		super(message);
	}

	public TimeStringFormateException(Throwable cause) {
		super(cause);
	}
	
}
