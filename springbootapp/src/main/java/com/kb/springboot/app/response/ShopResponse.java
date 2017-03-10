package com.kb.springboot.app.response;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import com.kb.springboot.app.exception.ServiceException;
import com.kb.springboot.app.model.Shop;

public class ShopResponse extends ServiceResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5219268205980625933L;
	
	private List<Shop> data;
	public ShopResponse(){
		super();
		
	}
	public ShopResponse(ServiceException ex){
		super(ex);
		
	}
	public ShopResponse(Status status){
		super(status);
		
	}
	public List<Shop> getData() {
		return data;
	}
	public void setData(List<Shop> data) {
		this.data = data;
	}
	
	

}
