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
@Table("game_event")
public class GameEvent {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("start_time")
    private java.time.LocalDateTime startTime;
    @Column("end_time")
    private java.time.LocalDateTime endTime;
    @Column("occurence")
    private Long occurence;
    @Column("length")
    private Long length;
    @Column("holiday")
    private Integer holiday;
    @Column("holidayStage")
    private Integer holidayStage;
    @Column("description")
    private String description;
    @Column("world_event")
    private Integer worldEvent;
    @Column("announce")
    private Integer announce;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEvent> {

        public GameEvent convert(Row row) {
            GameEvent domain = new GameEvent();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setStartTime(row.get("start_time", java.time.LocalDateTime.class));
            domain.setEndTime(row.get("end_time", java.time.LocalDateTime.class));
            domain.setOccurence(row.get("occurence", Long.class));
            domain.setLength(row.get("length", Long.class));
            domain.setHoliday(row.get("holiday", Integer.class));
            domain.setHolidayStage(row.get("holidayStage", Integer.class));
            domain.setDescription(row.get("description", String.class));
            domain.setWorldEvent(row.get("world_event", Integer.class));
            domain.setAnnounce(row.get("announce", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEvent, OutboundRow> {

        public OutboundRow convert(GameEvent source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getStartTime()).ifPresent(e -> row.put("start_time", Parameter.from(e)));
            Optional.ofNullable(source.getEndTime()).ifPresent(e -> row.put("end_time", Parameter.from(e)));
            Optional.ofNullable(source.getOccurence()).ifPresent(e -> row.put("occurence", Parameter.from(e)));
            Optional.ofNullable(source.getLength()).ifPresent(e -> row.put("length", Parameter.from(e)));
            Optional.ofNullable(source.getHoliday()).ifPresent(e -> row.put("holiday", Parameter.from(e)));
            Optional.ofNullable(source.getHolidayStage()).ifPresent(e -> row.put("holidayStage", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("description", Parameter.from(e)));
            Optional.ofNullable(source.getWorldEvent()).ifPresent(e -> row.put("world_event", Parameter.from(e)));
            Optional.ofNullable(source.getAnnounce()).ifPresent(e -> row.put("announce", Parameter.from(e)));
            return row;
        }
    }

}
