package com.kb.springboot.app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.google.maps.GeolocationApi.Response;
import com.kb.springboot.app.exception.ServiceException;
import com.kb.springboot.app.model.Shop;
import com.kb.springboot.app.response.ShopResponse;
import com.kb.springboot.app.service.ShopService;

@Service
@Singleton
public class ShopServiceImpl implements ShopService {

	private Map<String, Shop> inMemoryShopMap;
	
	ShopResponse respose;
	
	@Override
	public Set<Shop> getAllShop()throws ServiceException{
		Set<Shop> shops = null;
		try{
			shops = new HashSet<Shop>();
			
			Set<String> keySet = inMemoryShopMap.keySet();
			for(String key : keySet){
				shops.add(inMemoryShopMap.get(key));
			}
		}
		catch (Exception e) {
			throw new ServiceException("Somthing is wrong in service Layer:" , e.getMessage());
		}
		return shops;
	}

	

	@Override
	public void addShop(Shop shop) throws ServiceException {
		try{
			if(!inMemoryShopMap.containsKey(shop.getShopNumber())){
				inMemoryShopMap.put(shop.getShopNumber(),shop);
			}else{
				throw new ServiceException("Already exists...",shop.getShopNumber());
			}
		}
		catch(Exception e){
			throw new ServiceException(e);
		}
	}
	
	@Override
	public Set<Shop> getNearestShops(Double longitude,Double latitude, Double redius) throws ServiceException{
		Set<Shop> shops = null;
		try{
			shops = new HashSet<Shop>();
			
			Set<String> keySet = inMemoryShopMap.keySet();
			for (String key : keySet) {
				shops.add(inMemoryShopMap.get(key));
			}
			
		}
		catch(Exception e){
			throw new ServiceException("Somthing is wrong in service Layer:" , e.getMessage());
		}
		return  shops;
	}

}
