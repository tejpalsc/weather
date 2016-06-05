package com.pactera.weather.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.pactera.weather.exception.ApplicationException;
import com.pactera.weather.exception.ValidationException;
import com.pactera.weather.model.WeatherDetails;
import com.pactera.weather.service.impl.WeatherDetailsServiceImpl;

public class WeatherServiceTest {

	@Test
	public void testEndToEndWeatherDetails() {
		try {
			WeatherDetails wd = new WeatherDetailsServiceImpl().getDetails("Sydney");
			assertEquals("Sydney", wd.getCityName());
			assertNotNull(wd.getLastUpdated());
			assertNotNull(wd.getTemperature());
			assertNotNull(wd.getWindSpeed());
			assertNotNull(wd.getWeather());
		} catch (ValidationException | ApplicationException e) {

		}
	}

}