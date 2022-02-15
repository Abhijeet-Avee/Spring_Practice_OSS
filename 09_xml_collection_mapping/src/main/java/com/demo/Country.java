package com.demo;
import java.util.*;
import java.util.ArrayList;
public class Country {
	private String countryName;
	private Map<String, String> touristSpot;
	
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public void setTouristSpot(Map<String, String> touristSpot) {
		this.touristSpot = touristSpot;
	}
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", touristSpot=" + touristSpot + "]";
	}
	
	
	
}