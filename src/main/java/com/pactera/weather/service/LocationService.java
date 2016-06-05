package com.pactera.weather.service;

import com.pactera.weather.exception.ApplicationException;

public interface LocationService {
	
	public String[] getSupportedCities() throws ApplicationException;

}
