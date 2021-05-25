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
@Table("guild_bank_right")
public class GuildBankRight {

    @Column("guildid")
    private Long guildid;
    @Column("TabId")
    private Integer tabId;
    @Column("rid")
    private Integer rid;
    @Column("gbright")
    private Integer gbright;
    @Column("SlotPerDay")
    private Integer slotPerDay;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildBankRight> {

        public GuildBankRight convert(Row row) {
            GuildBankRight domain = new GuildBankRight();
            domain.setGuildid(row.get("guildid", Long.class));
            domain.setTabId(row.get("TabId", Integer.class));
            domain.setRid(row.get("rid", Integer.class));
            domain.setGbright(row.get("gbright", Integer.class));
            domain.setSlotPerDay(row.get("SlotPerDay", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildBankRight, OutboundRow> {

        public OutboundRow convert(GuildBankRight source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildid()).ifPresent(e -> row.put("guildid", Parameter.from(e)));
            Optional.ofNullable(source.getTabId()).ifPresent(e -> row.put("TabId", Parameter.from(e)));
            Optional.ofNullable(source.getRid()).ifPresent(e -> row.put("rid", Parameter.from(e)));
            Optional.ofNullable(source.getGbright()).ifPresent(e -> row.put("gbright", Parameter.from(e)));
            Optional.ofNullable(source.getSlotPerDay()).ifPresent(e -> row.put("SlotPerDay", Parameter.from(e)));
            return row;
        }
    }

}
