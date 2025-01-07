package com.github.azeroth.game.scripting.interfaces.iweather;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IWeatherOnChange extends IScriptObject {
    void OnChange(Weather weather, WeatherState state, float grade);
}
