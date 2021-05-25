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
@Table("guild_bank_eventlog")
public class GuildBankEventlog {

    @Column("guildid")
    private Long guildid;
    @Column("LogGuid")
    private Integer logGuid;
    @Column("TabId")
    private Integer tabId;
    @Column("EventType")
    private Integer eventType;
    @Column("PlayerGuid")
    private Long playerGuid;
    @Column("ItemOrMoney")
    private Long itemOrMoney;
    @Column("ItemStackCount")
    private Integer itemStackCount;
    @Column("DestTabId")
    private Integer destTabId;
    @Column("TimeStamp")
    private Long timeStamp;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildBankEventlog> {

        public GuildBankEventlog convert(Row row) {
            GuildBankEventlog domain = new GuildBankEventlog();
            domain.setGuildid(row.get("guildid", Long.class));
            domain.setLogGuid(row.get("LogGuid", Integer.class));
            domain.setTabId(row.get("TabId", Integer.class));
            domain.setEventType(row.get("EventType", Integer.class));
            domain.setPlayerGuid(row.get("PlayerGuid", Long.class));
            domain.setItemOrMoney(row.get("ItemOrMoney", Long.class));
            domain.setItemStackCount(row.get("ItemStackCount", Integer.class));
            domain.setDestTabId(row.get("DestTabId", Integer.class));
            domain.setTimeStamp(row.get("TimeStamp", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildBankEventlog, OutboundRow> {

        public OutboundRow convert(GuildBankEventlog source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildid()).ifPresent(e -> row.put("guildid", Parameter.from(e)));
            Optional.ofNullable(source.getLogGuid()).ifPresent(e -> row.put("LogGuid", Parameter.from(e)));
            Optional.ofNullable(source.getTabId()).ifPresent(e -> row.put("TabId", Parameter.from(e)));
            Optional.ofNullable(source.getEventType()).ifPresent(e -> row.put("EventType", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerGuid()).ifPresent(e -> row.put("PlayerGuid", Parameter.from(e)));
            Optional.ofNullable(source.getItemOrMoney()).ifPresent(e -> row.put("ItemOrMoney", Parameter.from(e)));
            Optional.ofNullable(source.getItemStackCount()).ifPresent(e -> row.put("ItemStackCount", Parameter.from(e)));
            Optional.ofNullable(source.getDestTabId()).ifPresent(e -> row.put("DestTabId", Parameter.from(e)));
            Optional.ofNullable(source.getTimeStamp()).ifPresent(e -> row.put("TimeStamp", Parameter.from(e)));
            return row;
        }
    }

}
