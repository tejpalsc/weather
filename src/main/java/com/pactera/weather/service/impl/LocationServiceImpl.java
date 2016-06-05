package com.pactera.weather.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pactera.weather.exception.ApplicationException;
import com.pactera.weather.service.LocationService;
import com.pactera.weather.util.Config;

@Service
@Scope("singleton")
public class LocationServiceImpl implements LocationService{

	private List<String> cities;
	
	public LocationServiceImpl() throws ApplicationException {
		String citiesProp = Config.getConfiguration("cities");
		String[] cityArray = citiesProp.split(",");	
		cities = Arrays.asList(cityArray);
	}
	
	@Override
	public String[] getSupportedCities() {
		return (String[]) cities.toArray();
	}
	
	@Override
	public boolean isValid(String city) {
		return cities.contains(city);
	}
}
