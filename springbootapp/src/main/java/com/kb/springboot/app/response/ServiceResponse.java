package com.kb.springboot.app.response;

import java.io.Serializable;

import javax.ws.rs.core.Response.Status;

import com.kb.springboot.app.exception.ServiceException;

public class ServiceResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7727886813961186925L;

	private ServiceException serviceException;
	private Status status;
	
	public ServiceResponse(){
		
	}

	public ServiceResponse(ServiceException serviceException, Status status) {
		super();
		this.serviceException = serviceException;
		this.status = status;
	}
	
	public ServiceResponse(ServiceException serviceException) {
		super();
		this.serviceException = serviceException;
	}
	public ServiceResponse(Status status) {
		super();
		this.status = status;
	}

	public ServiceException getServiceException() {
		return serviceException;
	}

	public void setServiceException(ServiceException serviceException) {
		this.serviceException = serviceException;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
