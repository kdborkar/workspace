package com.kb.springboot.app.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7423803207589332111L;

	private String errorMessage;
	private String innerMessage;
	private String stackTraceMessage;
	
	public ServiceException(String errorMessage, String innerMessage, String stackTraceMessage) {
		this.errorMessage = errorMessage;
		this.innerMessage = innerMessage;
		this.stackTraceMessage = stackTraceMessage;
	}
	public ServiceException(String errorMessage, String innerMessage) {
		this.errorMessage = errorMessage;
		this.innerMessage = innerMessage;
	}
	public ServiceException(Exception ex) {
		super();
		this.errorMessage = ex.getMessage();
		this.innerMessage = ex.getMessage();
		setStackTraceMessage(ex.getStackTrace().toString());
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getInnerMessage() {
		return innerMessage;
	}
	public void setInnerMessage(String innerMessage) {
		this.innerMessage = innerMessage;
	}
	public String getStackTraceMessage() {
		return stackTraceMessage;
	}
	public void setStackTraceMessage(String stackTraceMessage) {
		this.stackTraceMessage = stackTraceMessage;
	}
	@Override
	public String toString() {
		return "ServiceException [errorMessage=" + errorMessage + ", innerMessage=" + innerMessage
				+ ", stackTraceMessage=" + stackTraceMessage + "]";
	}
	
}
