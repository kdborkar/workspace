package com.kb.springboot.app.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kb.springboot.app.exception.ServiceException;
import com.kb.springboot.app.helper.GeolocationApiUtil;
import com.kb.springboot.app.model.Shop;
import com.kb.springboot.app.response.ServiceResponse;
import com.kb.springboot.app.response.ShopResponse;
import com.kb.springboot.app.service.ShopService;

public class ShopResource extends ServiceResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3917005275456578829L;

	private static final Logger LOG = LoggerFactory.getLogger(ShopResource.class);
	
	@Autowired
	private ShopService shopService;
	
	@POST
	@Path("/getNearestShop")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public ShopResponse getNearestShops(@FormParam("longitude") Double longitude, 
										@FormParam("latitude") Double latitude,
										@FormParam("redius") Double redius){
		ShopResponse shopResponse= null;
		LOG.info("getNearestShop <<<" );
		LOG.info("longitude..." + longitude);
		LOG.info("latitude..."+ latitude);
		
		try{
			shopResponse = new ShopResponse();
			Set<Shop> allShpos = shopService.getAllShop();

			Set<Shop> nearestShops = GeolocationApiUtil.getNearestShops(allShpos,longitude,latitude,redius);
			
			LOG.info("getShopList, count..."+ nearestShops.size());
			shopResponse.setStatus(Status.OK);
		}
		catch(ServiceException se){
			shopResponse.setStatus(Status.INTERNAL_SERVER_ERROR);
			se.printStackTrace();
		}catch(Exception e){
			shopResponse.setStatus(Status.BAD_REQUEST);
			e.printStackTrace();
		}
		return shopResponse;
	}
	
	@POST
	@Path("/addShop")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public ShopResponse addShops(@FormParam("shopNumber") String shopNumber, 
										@FormParam("address") String address){
		ShopResponse shopResponse= null;
		LOG.info("addShops <<<<" );
		LOG.info("shopNumber..." + shopNumber);
		LOG.info("address..."+ address);
		
		try{
			shopResponse = new ShopResponse();
			Shop shop = new Shop(shopNumber, address);
			
			List<Object> geoLocation = GeolocationApiUtil.getGeoLocationByGoogle(address);
			//TODO: Need to check value of longitudeAnd Latitude, and set the longtude and][ latitude accordingly
			shop.setLongitude(73.986d);
			shop.setLatitude(18.635754d);
			
			shopService.addShop(shop);
			shopResponse.setStatus(Status.OK);
		}
		catch(ServiceException se){
			shopResponse.setStatus(Status.INTERNAL_SERVER_ERROR);
			se.printStackTrace();
		}catch(Exception e){
			shopResponse.setStatus(Status.BAD_REQUEST);
			e.printStackTrace();
		}
		return shopResponse;
	}
	

}
