package com.github.azeroth.game.domain.weather;


import java.util.HashMap;

public class WeatherManager {

    private final HashMap<Integer, WeatherData> weatherData = new HashMap<Integer, WeatherData>();

    private WeatherManager() {
    }

    public final void loadWeatherData() {
        var oldMSTime = System.currentTimeMillis();

        int count = 0;

        var result = DB.World.query("SELECT zone, spring_rain_chance, spring_snow_chance, spring_storm_chance," + "summer_rain_chance, summer_snow_chance, summer_storm_chance, fall_rain_chance, fall_snow_chance, fall_storm_chance," + "winter_rain_chance, winter_snow_chance, winter_storm_chance, ScriptName FROM game_weather");

        if (result.isEmpty()) {
            Log.outInfo(LogFilter.ServerLoading, "Loaded 0 weather definitions. DB table `game_weather` is empty.");

            return;
        }

        do {
            var zone_id = result.<Integer>Read(0);

            WeatherData wzc = new WeatherData();

            for (byte season = 0; season < 4; ++season) {
                wzc.Data[season].rainChance = result.<Byte>Read(season * (4 - 1) + 1);
                wzc.Data[season].snowChance = result.<Byte>Read(season * (4 - 1) + 2);
                wzc.Data[season].stormChance = result.<Byte>Read(season * (4 - 1) + 3);

                if (wzc.Data[season].rainChance > 100) {
                    wzc.Data[season].rainChance = 25;
                    Logs.SQL.error("Weather for zone {0} season {1} has wrong rain chance > 100%", zone_id, season);
                }

                if (wzc.Data[season].snowChance > 100) {
                    wzc.Data[season].snowChance = 25;
                    Logs.SQL.error("Weather for zone {0} season {1} has wrong snow chance > 100%", zone_id, season);
                }

                if (wzc.Data[season].stormChance > 100) {
                    wzc.Data[season].stormChance = 25;
                    Logs.SQL.error("Weather for zone {0} season {1} has wrong storm chance > 100%", zone_id, season);
                }
            }

            wzc.scriptId = global.getObjectMgr().getScriptId(result.<String>Read(13));
            weatherData.put(zone_id, wzc);
            ++count;
        } while (result.NextRow());

        Log.outInfo(LogFilter.ServerLoading, "Loaded {0} weather definitions in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
    }


    public final WeatherData getWeatherData(int zoneId) {
        return weatherData.get(zoneId);
    }
}
