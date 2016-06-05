package com.pactera.weather.service;

import com.pactera.weather.exception.ApplicationException;

/**
 * 
 * @author Tejpal
 * 
 * Service to manage supported cities
 *
 */
public interface LocationService {
	/**
	 * @returnn list of cities
	 * @throws ApplicationException
	 */
	public String[] getSupportedCities() throws ApplicationException;
	
	/**
	 * Validates input city name
	 * @param city
	 * @return true if valid
	 */
	boolean isValid(String city);

}
