package com.kb.springboot.app.helper;

import java.io.ByteArrayOutputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.json.JsonJsonParser;

import com.kb.springboot.app.model.Shop;

public class GeolocationApiUtil {
	private static final String URL ="http://maps.googleapis.com/maps/api/geocode/json";
	
	public static List<Object> getGeoLocationByGoogle(String fullAddress){
		
		List<Object> parseList = null;
		
		try(ByteArrayOutputStream out= new ByteArrayOutputStream(1024)){
			URL url = new URL (URL + "?address=" + URLEncoder.encode(fullAddress, "UTF-8") + "&sensor=false");
			
			URLConnection conn = url.openConnection();
			
			IOUtils.copy(conn.getInputStream(), out);
			String stringToParse =  out.toString();
			
			JsonJsonParser parser = new JsonJsonParser();
			
			parseList = parser.parseList(stringToParse);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return parseList;
	}

	public static Set<Shop> getNearestShops(Set<Shop> allShpos, Double longitude, Double latitude, Double redius) {
		Set<Shop> nearestShops= null;
		
		try(ByteArrayOutputStream out= new ByteArrayOutputStream(1024)){
			nearestShops = new HashSet<Shop>();
			//need to filter allshops as per redius
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return allShpos;
	}
}
