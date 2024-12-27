package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum WeatherType {
    WEATHER_TYPE_FINE(0),
    WEATHER_TYPE_RAIN(1),
    WEATHER_TYPE_SNOW(2),
    WEATHER_TYPE_STORM(3),
    WEATHER_TYPE_THUNDERS(86),
    WEATHER_TYPE_BLACKRAIN(90);

    public final int value;

}
