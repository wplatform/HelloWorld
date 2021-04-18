package com.rainbowland.enums;

enum WeatherType {
   WEATHER_TYPE_FINE(0),
   WEATHER_TYPE_RAIN(1),
   WEATHER_TYPE_SNOW(2),
   WEATHER_TYPE_STORM(3),
   WEATHER_TYPE_THUNDERS(86),
   WEATHER_TYPE_BLACKRAIN(90);

   private final int value;

   WeatherType(int value) {
      this.value = value;
   }

   public int val() {
      return this.value;
   }
}
