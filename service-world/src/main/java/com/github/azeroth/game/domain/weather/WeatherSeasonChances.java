package com.github.azeroth.game.domain.weather;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined second types. The behavior of this class may differ from the original:

public final class WeatherSeasonChances {
    public int rainChance;
    public int snowChance;
    public int stormChance;

    public WeatherSeasonChances clone() {
        WeatherSeasonChances varCopy = new WeatherSeasonChances();

        varCopy.rainChance = this.rainChance;
        varCopy.snowChance = this.snowChance;
        varCopy.stormChance = this.stormChance;

        return varCopy;
    }
}
