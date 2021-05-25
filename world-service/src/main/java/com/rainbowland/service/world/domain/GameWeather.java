package com.rainbowland.service.world.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("game_weather")
public class GameWeather {

    @Column("zone")
    private Integer zone;
    @Column("spring_rain_chance")
    private Integer springRainChance;
    @Column("spring_snow_chance")
    private Integer springSnowChance;
    @Column("spring_storm_chance")
    private Integer springStormChance;
    @Column("summer_rain_chance")
    private Integer summerRainChance;
    @Column("summer_snow_chance")
    private Integer summerSnowChance;
    @Column("summer_storm_chance")
    private Integer summerStormChance;
    @Column("fall_rain_chance")
    private Integer fallRainChance;
    @Column("fall_snow_chance")
    private Integer fallSnowChance;
    @Column("fall_storm_chance")
    private Integer fallStormChance;
    @Column("winter_rain_chance")
    private Integer winterRainChance;
    @Column("winter_snow_chance")
    private Integer winterSnowChance;
    @Column("winter_storm_chance")
    private Integer winterStormChance;
    @Column("ScriptName")
    private String scriptName;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameWeather> {

        public GameWeather convert(Row row) {
            GameWeather domain = new GameWeather();
            domain.setZone(row.get("zone", Integer.class));
            domain.setSpringRainChance(row.get("spring_rain_chance", Integer.class));
            domain.setSpringSnowChance(row.get("spring_snow_chance", Integer.class));
            domain.setSpringStormChance(row.get("spring_storm_chance", Integer.class));
            domain.setSummerRainChance(row.get("summer_rain_chance", Integer.class));
            domain.setSummerSnowChance(row.get("summer_snow_chance", Integer.class));
            domain.setSummerStormChance(row.get("summer_storm_chance", Integer.class));
            domain.setFallRainChance(row.get("fall_rain_chance", Integer.class));
            domain.setFallSnowChance(row.get("fall_snow_chance", Integer.class));
            domain.setFallStormChance(row.get("fall_storm_chance", Integer.class));
            domain.setWinterRainChance(row.get("winter_rain_chance", Integer.class));
            domain.setWinterSnowChance(row.get("winter_snow_chance", Integer.class));
            domain.setWinterStormChance(row.get("winter_storm_chance", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameWeather, OutboundRow> {

        public OutboundRow convert(GameWeather source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getZone()).ifPresent(e -> row.put("zone", Parameter.from(e)));
            Optional.ofNullable(source.getSpringRainChance()).ifPresent(e -> row.put("spring_rain_chance", Parameter.from(e)));
            Optional.ofNullable(source.getSpringSnowChance()).ifPresent(e -> row.put("spring_snow_chance", Parameter.from(e)));
            Optional.ofNullable(source.getSpringStormChance()).ifPresent(e -> row.put("spring_storm_chance", Parameter.from(e)));
            Optional.ofNullable(source.getSummerRainChance()).ifPresent(e -> row.put("summer_rain_chance", Parameter.from(e)));
            Optional.ofNullable(source.getSummerSnowChance()).ifPresent(e -> row.put("summer_snow_chance", Parameter.from(e)));
            Optional.ofNullable(source.getSummerStormChance()).ifPresent(e -> row.put("summer_storm_chance", Parameter.from(e)));
            Optional.ofNullable(source.getFallRainChance()).ifPresent(e -> row.put("fall_rain_chance", Parameter.from(e)));
            Optional.ofNullable(source.getFallSnowChance()).ifPresent(e -> row.put("fall_snow_chance", Parameter.from(e)));
            Optional.ofNullable(source.getFallStormChance()).ifPresent(e -> row.put("fall_storm_chance", Parameter.from(e)));
            Optional.ofNullable(source.getWinterRainChance()).ifPresent(e -> row.put("winter_rain_chance", Parameter.from(e)));
            Optional.ofNullable(source.getWinterSnowChance()).ifPresent(e -> row.put("winter_snow_chance", Parameter.from(e)));
            Optional.ofNullable(source.getWinterStormChance()).ifPresent(e -> row.put("winter_storm_chance", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            return row;
        }
    }

}
