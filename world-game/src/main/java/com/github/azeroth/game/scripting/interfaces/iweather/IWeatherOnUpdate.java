package com.github.azeroth.game.scripting.interfaces.iweather;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IWeatherOnUpdate extends IScriptObject {
    void onUpdate(Weather obj, int diff);
}
