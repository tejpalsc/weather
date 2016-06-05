package com.pactera.weather.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.pactera.weather.exception.ApplicationException;

public class Config {
	
	private static final String CONFIG_FILE =  "config.properties";
	
	public static String getConfiguration(String propName) throws ApplicationException {		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try(InputStream in = loader.getResourceAsStream(CONFIG_FILE)) {
			props.load(in);
		} catch (IOException e) {
			throw new ApplicationException("Error while loading configuration.", e);
		}
		System.out.println();
		return props.getProperty(propName);
	}

}
