package com.github.azeroth.game.map;

import com.github.azeroth.game.weather.Weather;
import com.github.azeroth.game.weather.WeatherState;

import java.util.ArrayList;


public class ZoneDynamicInfo {
    private int musicId;
    private Weather defaultWeather;
    private WeatherState weatherId = WeatherState.values()[0];
    private float intensity;
    private ArrayList<LightOverride> lightOverrides = new ArrayList<>();

    public final int getMusicId() {
        return musicId;
    }

    public final void setMusicId(int value) {
        musicId = value;
    }

    public final Weather getDefaultWeather() {
        return defaultWeather;
    }

    public final void setDefaultWeather(Weather value) {
        defaultWeather = value;
    }

    public final WeatherState getWeatherId() {
        return weatherId;
    }

    public final void setWeatherId(WeatherState value) {
        weatherId = value;
    }

    public final float getIntensity() {
        return intensity;
    }

    public final void setIntensity(float value) {
        intensity = value;
    }

    public final ArrayList<LightOverride> getLightOverrides() {
        return lightOverrides;
    }

    public final void setLightOverrides(ArrayList<LightOverride> value) {
        lightOverrides = value;
    }

    public final static class LightOverride {
        public int areaLightId;
        public int overrideLightId;
        public int transitionMilliseconds;

    }
}
