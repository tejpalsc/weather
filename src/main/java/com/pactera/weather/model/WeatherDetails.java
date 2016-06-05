package com.pactera.weather.model;

public class WeatherDetails {
	
	private String name;
	private String lastUpdated;
	private String weather;
	private String temperature;
	private String windSpeed;
	/**
	 * @return the name
	 */
	public String getCityName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	/**
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}
	/**
	 * @param weather the weather to set
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}
	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the windSpeed
	 */
	public String getWindSpeed() {
		return windSpeed;
	}
	/**
	 * @param windSpeed the windSpeed to set
	 */
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
}
