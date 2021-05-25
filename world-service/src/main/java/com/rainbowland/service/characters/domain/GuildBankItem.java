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
@Table("guild_bank_item")
public class GuildBankItem {

    @Column("guildid")
    private Long guildid;
    @Column("TabId")
    private Integer tabId;
    @Column("SlotId")
    private Integer slotId;
    @Column("item_guid")
    private Long itemGuid;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildBankItem> {

        public GuildBankItem convert(Row row) {
            GuildBankItem domain = new GuildBankItem();
            domain.setGuildid(row.get("guildid", Long.class));
            domain.setTabId(row.get("TabId", Integer.class));
            domain.setSlotId(row.get("SlotId", Integer.class));
            domain.setItemGuid(row.get("item_guid", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildBankItem, OutboundRow> {

        public OutboundRow convert(GuildBankItem source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildid()).ifPresent(e -> row.put("guildid", Parameter.from(e)));
            Optional.ofNullable(source.getTabId()).ifPresent(e -> row.put("TabId", Parameter.from(e)));
            Optional.ofNullable(source.getSlotId()).ifPresent(e -> row.put("SlotId", Parameter.from(e)));
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("item_guid", Parameter.from(e)));
            return row;
        }
    }

}
