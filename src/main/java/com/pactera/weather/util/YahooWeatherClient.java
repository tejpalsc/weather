package com.pactera.weather.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.pactera.weather.exception.ApplicationException;
import com.pactera.weather.exception.ValidationException;
import com.pactera.weather.model.WeatherDetails;

public class YahooWeatherClient {
	private String weatherApiUrl; 
	
	public YahooWeatherClient() throws ApplicationException {
		weatherApiUrl = Config.getConfiguration("weather-api-url");
	}
	
	public WeatherDetails fetchWeatherDetails(String city) throws ApplicationException {
		URI uri = null;
		try {
			String uriString = MessageFormat.format(weatherApiUrl, city);
			uri = new URIBuilder(uriString).build();
		} catch (URISyntaxException e) {
			throw new ApplicationException(e);
		}
		WeatherDetails wd = new WeatherDetails();
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpGet httpget = new HttpGet(uri);
		try(CloseableHttpResponse response = httpclient.execute(httpget)) {
			
			 if(response.getStatusLine().getStatusCode() != 200) {
				 throw new ApplicationException("Backend service call failed");
			 }

            String result = EntityUtils.toString(response.getEntity());

                JSONObject jo = new JSONObject(result);
                JSONObject channel = jo.getJSONObject("query")
                						.getJSONObject("results")
                						.getJSONObject("channel");
                						
                JSONObject condition = channel.getJSONObject("item").getJSONObject("condition");
                JSONObject wind = channel.getJSONObject("wind");
                wd.setName(city);
                wd.setWeather(condition.getString("text"));
                wd.setTemperature(condition.getString("temp"));
                wd.setLastUpdated(condition.getString("date"));
                wd.setWindSpeed(wind.getString("speed"));

            
		} catch (IOException e) {
			throw new ApplicationException("Error occurend while reading response", e);
		} 
		return wd;
	}

}
