package com.github.mmo.game.map;

import com.github.mmo.game.weather.Weather;
import com.github.mmo.game.weather.WeatherState;


import java.util.*;


public class ZoneDynamicInfo
{
	private int musicId;
	public final int getMusicId()
	{
		return musicId;
	}
	public final void setMusicId(int value)
	{
		musicId = value;
	}
	private Weather defaultWeather;
	public final Weather getDefaultWeather()
	{
		return defaultWeather;
	}
	public final void setDefaultWeather(Weather value)
	{
		defaultWeather = value;
	}
	private WeatherState weatherId = WeatherState.values()[0];
	public final WeatherState getWeatherId()
	{
		return weatherId;
	}
	public final void setWeatherId(WeatherState value)
	{
		weatherId = value;
	}
	private float intensity;
	public final float getIntensity()
	{
		return intensity;
	}
	public final void setIntensity(float value)
	{
		intensity = value;
	}
	private ArrayList<LightOverride> lightOverrides = new ArrayList<>();
	public final ArrayList<LightOverride> getLightOverrides()
	{
		return lightOverrides;
	}
	public final void setLightOverrides(ArrayList<LightOverride> value)
	{
		lightOverrides = value;
	}

	public final static class LightOverride
	{
		public int areaLightId;
		public int overrideLightId;
		public int transitionMilliseconds;

	}
}
