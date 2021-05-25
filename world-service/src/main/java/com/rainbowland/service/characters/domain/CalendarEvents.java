package com.rainbowland.service.characters.domain;

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
@Table("calendar_events")
public class CalendarEvents {

    @Column("EventID")
    private Long eventId;
    @Column("Owner")
    private Long owner;
    @Column("Title")
    private String title;
    @Column("Description")
    private String description;
    @Column("EventType")
    private Integer eventType;
    @Column("TextureID")
    private Integer textureId;
    @Column("Date")
    private Long date;
    @Column("Flags")
    private Integer flags;
    @Column("LockDate")
    private Long lockDate;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CalendarEvents> {

        public CalendarEvents convert(Row row) {
            CalendarEvents domain = new CalendarEvents();
            domain.setEventId(row.get("EventID", Long.class));
            domain.setOwner(row.get("Owner", Long.class));
            domain.setTitle(row.get("Title", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setEventType(row.get("EventType", Integer.class));
            domain.setTextureId(row.get("TextureID", Integer.class));
            domain.setDate(row.get("Date", Long.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setLockDate(row.get("LockDate", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CalendarEvents, OutboundRow> {

        public OutboundRow convert(CalendarEvents source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventId()).ifPresent(e -> row.put("EventID", Parameter.from(e)));
            Optional.ofNullable(source.getOwner()).ifPresent(e -> row.put("Owner", Parameter.from(e)));
            Optional.ofNullable(source.getTitle()).ifPresent(e -> row.put("Title", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getEventType()).ifPresent(e -> row.put("EventType", Parameter.from(e)));
            Optional.ofNullable(source.getTextureId()).ifPresent(e -> row.put("TextureID", Parameter.from(e)));
            Optional.ofNullable(source.getDate()).ifPresent(e -> row.put("Date", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getLockDate()).ifPresent(e -> row.put("LockDate", Parameter.from(e)));
            return row;
        }
    }

}
