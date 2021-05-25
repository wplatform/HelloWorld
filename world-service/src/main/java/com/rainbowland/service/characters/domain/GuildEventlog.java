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
@Table("guild_eventlog")
public class GuildEventlog {

    @Column("guildid")
    private Long guildid;
    @Column("LogGuid")
    private Integer logGuid;
    @Column("EventType")
    private Integer eventType;
    @Column("PlayerGuid1")
    private Long playerGuid1;
    @Column("PlayerGuid2")
    private Long playerGuid2;
    @Column("NewRank")
    private Integer newRank;
    @Column("TimeStamp")
    private Long timeStamp;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildEventlog> {

        public GuildEventlog convert(Row row) {
            GuildEventlog domain = new GuildEventlog();
            domain.setGuildid(row.get("guildid", Long.class));
            domain.setLogGuid(row.get("LogGuid", Integer.class));
            domain.setEventType(row.get("EventType", Integer.class));
            domain.setPlayerGuid1(row.get("PlayerGuid1", Long.class));
            domain.setPlayerGuid2(row.get("PlayerGuid2", Long.class));
            domain.setNewRank(row.get("NewRank", Integer.class));
            domain.setTimeStamp(row.get("TimeStamp", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildEventlog, OutboundRow> {

        public OutboundRow convert(GuildEventlog source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildid()).ifPresent(e -> row.put("guildid", Parameter.from(e)));
            Optional.ofNullable(source.getLogGuid()).ifPresent(e -> row.put("LogGuid", Parameter.from(e)));
            Optional.ofNullable(source.getEventType()).ifPresent(e -> row.put("EventType", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerGuid1()).ifPresent(e -> row.put("PlayerGuid1", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerGuid2()).ifPresent(e -> row.put("PlayerGuid2", Parameter.from(e)));
            Optional.ofNullable(source.getNewRank()).ifPresent(e -> row.put("NewRank", Parameter.from(e)));
            Optional.ofNullable(source.getTimeStamp()).ifPresent(e -> row.put("TimeStamp", Parameter.from(e)));
            return row;
        }
    }

}
