package com.pactera.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pactera.weather.exception.ApplicationException;
import com.pactera.weather.exception.ValidationException;
import com.pactera.weather.model.WeatherDetails;
import com.pactera.weather.service.LocationService;
import com.pactera.weather.service.WeatherDetailsService;

@Controller
public class WeatherController {

	private static final Logger logger = LoggerFactory
			.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherDetailsService weatherService;
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public @ResponseBody
	WeatherDetails getWeatherDetails(@RequestParam String city) throws ValidationException {
		logger.debug("Serving weather details for city: {}.", city);
		
		if(!locationService.isValid(city)) {
			logger.error("Unsupported city: " + city );
			throw new ValidationException("Unsupported City.");
		}
		
		return weatherService.getDetails(city);
	}
	
	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	public @ResponseBody
	String[] getCityList() throws ValidationException, ApplicationException {
		logger.debug("Serving list of supported cities.");
		return locationService.getSupportedCities();
	}

	@ExceptionHandler(ValidationException.class)
	public String handleWeatherException(Exception e) {
		return e.getMessage();
	}
}
