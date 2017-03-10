package com.kb.springboot.app.helper;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kb.springboot.app.config.AppConfig;
import com.kb.springboot.app.model.Shop;
import com.kb.springboot.app.service.impl.ShopServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class GeolocationApiUtilTest {

	GeolocationApiUtil geolocationApiUtil;
	
	ShopServiceImpl mockShopServiceImpl;
	
	String validAddress ="PUNE";
	String inValidAddress ="test";
	
	Double longitude = 73.98646899999999d;
	Double latitude = 18.6357545d;
	
	Double redius = 10d;
	
	Shop shop1 = new Shop("101","Pune");
	Shop shop2 = new Shop("102","Mumbai");
	
	List<Object> objects = null;
	
	@Before
	public void setUp() throws Exception{
		Set<Shop> shops = new HashSet<Shop>();
		shops.add(shop1);
		shops.add(shop2);
		
		objects = new ArrayList<Object>();
		objects.add(longitude);
		objects.add(latitude);
		
		mockShopServiceImpl = mock(ShopServiceImpl.class);
		when(mockShopServiceImpl.getAllShop()).thenReturn(shops);
		when(mockShopServiceImpl.getNearestShops(longitude, latitude, redius)).thenReturn(shops);
		
	}
	
	@Test
	public void testGeoLocationByAddress() throws Exception{
		List<Object> geoLocationByGoogle = geolocationApiUtil.getGeoLocationByGoogle(inValidAddress);
		assertNotNull("GetLocation validAddress" + validAddress, geoLocationByGoogle);
		assertTrue(geoLocationByGoogle.size()>0);
		
	}
	
	@Test
	public void testNearestShopCount() throws Exception{
		Set<Shop> allShops = mockShopServiceImpl.getAllShop();
		
		Set<Shop> nearestShops = geolocationApiUtil.getNearestShops(allShops, longitude, latitude, redius);
		assertNotNull("GetLocation nearestShops......longitude : " + longitude +" latitude : "+ latitude, nearestShops);
		assertTrue(nearestShops.size()>0);
		
	}
}
