package com.github.mmo.game.scripting.interfaces.iweather;

import com.github.mmo.game.scripting.interfaces.*;
public interface IWeatherOnChange extends IScriptObject
{
	void OnChange(Weather weather, WeatherState state, float grade);
}
