package com.pactera.weather.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pactera.weather.exception.ApplicationException;
import com.pactera.weather.service.LocationService;

@Service
@Scope("singleton")
public class LocationServiceImpl implements LocationService{

	
	public LocationServiceImpl() throws ApplicationException {

	}
	
	@Override
	public String[] getSupportedCities() {
		return new String[]{"Sydney","Melboune"};
	}

}
