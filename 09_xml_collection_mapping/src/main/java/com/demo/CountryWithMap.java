package com.demo;

import java.util.*;

public class CountryWithMap {
	private String countryName;
	private Map<String, List<String>> touristSpot;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Map<String, List<String>> getTouristSpot() {
		return touristSpot;
	}

	public void setTouristSpot(Map<String, List<String>> touristSpot) {
		this.touristSpot = touristSpot;
	}

	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", touristSpot=" + touristSpot + "]";
	}

}