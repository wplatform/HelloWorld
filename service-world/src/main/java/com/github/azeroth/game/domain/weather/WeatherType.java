package com.github.azeroth.game.domain.weather;

public enum WeatherType {
    Fine(0),
    Rain(1),
    Snow(2),
    Storm(3),
    Thunders(86),
    BlackRain(90);

    public static final int SIZE = Integer.SIZE;
    private static java.util.HashMap<Integer, WeatherType> mappings;
    private int intValue;

    private WeatherType(int value) {
        intValue = value;
        getMappings().put(value, this);
    }

    private static java.util.HashMap<Integer, WeatherType> getMappings() {
        if (mappings == null) {
            synchronized (WeatherType.class) {
                if (mappings == null) {
                    mappings = new java.util.HashMap<Integer, WeatherType>();
                }
            }
        }
        return mappings;
    }

    public static WeatherType forValue(int value) {
        return getMappings().get(value);
    }

    public int getValue() {
        return intValue;
    }
}
