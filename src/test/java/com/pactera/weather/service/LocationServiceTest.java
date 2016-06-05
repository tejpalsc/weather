package com.pactera.weather.service;

import static org.junit.Assert.*;
import org.junit.Test;

import com.pactera.weather.exception.ApplicationException;
import com.pactera.weather.service.impl.LocationServiceImpl;

public class LocationServiceTest {
	
	@Test
	public void testSupportedCitiesy() {
		try {
			int count = new LocationServiceImpl().getSupportedCities().length;
			assertEquals(3, count);
		} catch (ApplicationException e) {

		}

	}
}

