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
@Table("guild_newslog")
public class GuildNewslog {

    @Column("guildid")
    private Long guildid;
    @Column("LogGuid")
    private Integer logGuid;
    @Column("EventType")
    private Integer eventType;
    @Column("PlayerGuid")
    private Long playerGuid;
    @Column("Flags")
    private Integer flags;
    @Column("Value")
    private Integer value;
    @Column("TimeStamp")
    private Long timeStamp;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildNewslog> {

        public GuildNewslog convert(Row row) {
            GuildNewslog domain = new GuildNewslog();
            domain.setGuildid(row.get("guildid", Long.class));
            domain.setLogGuid(row.get("LogGuid", Integer.class));
            domain.setEventType(row.get("EventType", Integer.class));
            domain.setPlayerGuid(row.get("PlayerGuid", Long.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setValue(row.get("Value", Integer.class));
            domain.setTimeStamp(row.get("TimeStamp", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildNewslog, OutboundRow> {

        public OutboundRow convert(GuildNewslog source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildid()).ifPresent(e -> row.put("guildid", Parameter.from(e)));
            Optional.ofNullable(source.getLogGuid()).ifPresent(e -> row.put("LogGuid", Parameter.from(e)));
            Optional.ofNullable(source.getEventType()).ifPresent(e -> row.put("EventType", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerGuid()).ifPresent(e -> row.put("PlayerGuid", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getValue()).ifPresent(e -> row.put("Value", Parameter.from(e)));
            Optional.ofNullable(source.getTimeStamp()).ifPresent(e -> row.put("TimeStamp", Parameter.from(e)));
            return row;
        }
    }

}
