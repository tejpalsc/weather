package com.pactera.weather.service;

import com.pactera.weather.exception.ValidationException;
import com.pactera.weather.model.WeatherDetails;

/**
 * @author Tejpal
 * 
 * Service for retrieving weather details
 *
 */
public interface WeatherDetailsService {

	/**
	 * @param city
	 * @return Weather details
	 * @throws ValidationException
	 */
	WeatherDetails getDetails(String city) throws ValidationException;

}
