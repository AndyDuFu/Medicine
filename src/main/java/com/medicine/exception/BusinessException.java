package com.medicine.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 8372652214797382977L;
	private ErrorCode errorCode;
	private Integer code;
	private String message;

	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getMessage());

		this.errorCode = errorCode;
	}

	public BusinessException(ErrorCode errorCode, Throwable ex) {
		super(errorCode.getMessage(), ex);
		this.errorCode = errorCode;
	}
	
	public BusinessException(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
