package com.github.mmo.game.scripting.interfaces.iweather;

import com.github.mmo.game.scripting.interfaces.*;
public interface IWeatherOnUpdate extends IScriptObject
{
	void onUpdate(Weather obj, int diff);
}
