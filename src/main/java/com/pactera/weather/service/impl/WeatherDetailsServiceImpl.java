package com.pactera.weather.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pactera.weather.exception.ValidationException;
import com.pactera.weather.model.WeatherDetails;
import com.pactera.weather.service.WeatherDetailsService;

@Service
@Scope("singleton")
public class WeatherDetailsServiceImpl implements WeatherDetailsService {

	@Override
	public WeatherDetails getDetails(String city) throws ValidationException {
		WeatherDetails wd = new WeatherDetails();
		wd.setName("Sydney");
		wd.setTemperature("10");
		wd.setWeather("blah");
		wd.setTemperature("");
		return wd;
	}
}