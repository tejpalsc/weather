package com.pactera.weather.service;

import com.pactera.weather.exception.ValidationException;
import com.pactera.weather.model.WeatherDetails;

public interface WeatherDetailsService {

	WeatherDetails getDetails(String city) throws ValidationException;

}
