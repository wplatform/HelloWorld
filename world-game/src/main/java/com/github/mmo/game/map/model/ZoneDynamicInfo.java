package com.github.mmo.game.map.model;

import com.github.mmo.world.weather.Weather;
import lombok.Data;

import java.util.List;

@Data
public class ZoneDynamicInfo {


    private int musicId;

    private Weather defaultWeather;
    private WeatherState weatherId;
    private float Intensity;
    private List<LightOverride> LightOverrides;

    ;

    record LightOverride(int areaLightId, int overrideLightId, int transitionMilliseconds) {

    }
}
