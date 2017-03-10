package com.kb.springboot.app.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Shop implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8005424181351924004L;
	
	String shopNumber;
	
	String address;
	
	Double longitude;
	Double latitude;
	
	
	public Shop(String shopNumber, String address) {
		this.shopNumber = shopNumber;
		this.address = address;
	}
	
	public Shop(String shopNumber) {
		this.shopNumber = shopNumber;
	}

	public String getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
}
