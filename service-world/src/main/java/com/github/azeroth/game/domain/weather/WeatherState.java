package com.github.azeroth.game.domain.weather;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WeatherState {
    Fine(0),
    Fog(1), // Used in some instance encounters.
    Drizzle(2),
    LightRain(3),
    MediumRain(4),
    HeavyRain(5),
    LightSnow(6),
    MediumSnow(7),
    HeavySnow(8),
    LightSandstorm(22),
    MediumSandstorm(41),
    HeavySandstorm(42),
    Thunders(86),
    BlackRain(90),
    BlackSnow(106);

    public final int value;
}
