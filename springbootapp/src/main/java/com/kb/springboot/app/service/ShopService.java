/**
 * 
 */
package com.kb.springboot.app.service;

import java.util.Set;

import com.kb.springboot.app.exception.ServiceException;
import com.kb.springboot.app.model.Shop;

/**
 * @author kapilborkar
 *
 */
public interface ShopService {
	public void addShop(Shop shop) throws ServiceException;
	public Set<Shop> getNearestShops(Double longitude,Double latitude, Double redius) throws ServiceException;
	public Set<Shop> getAllShop()throws ServiceException;
}
