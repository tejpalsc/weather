package com.pactera.weather.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.pactera.weather.exception.ApplicationException;
import com.pactera.weather.exception.ValidationException;
import com.pactera.weather.model.WeatherDetails;
import com.pactera.weather.service.WeatherDetailsService;
import com.pactera.weather.util.Config;
import com.pactera.weather.util.YahooWeatherClient;

@Service
@Scope("singleton")
public class WeatherDetailsServiceImpl implements WeatherDetailsService {

	private YahooWeatherClient yahooWeatherClient; 
	private LoadingCache<String, WeatherDetails> cache;
	
	public WeatherDetailsServiceImpl() throws ApplicationException {
		
		yahooWeatherClient = new YahooWeatherClient();
		long cacheExpiry = Long.parseLong(Config.getConfiguration("refresh-interval"));
		
		cache = CacheBuilder.newBuilder()
		            .maximumSize(100)
		            .expireAfterWrite(cacheExpiry, TimeUnit.SECONDS)
		            .build(new CacheLoader<String, WeatherDetails>(){ 
		            
		               @Override
		               public WeatherDetails load(String city) throws Exception {
		                  return yahooWeatherClient.fetchWeatherDetails(city);
		               } 
		            });
			}
	
	@Override
	public WeatherDetails getDetails(String city) throws ValidationException {
		try {
			return cache.get(city);
		} catch (ExecutionException e) {
			throw new ValidationException(e);
		}
	}
}