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
@Table("item_soulbound_trade_data")
public class ItemSoulboundTradeData {

    @Column("itemGuid")
    private Long itemGuid;
    @Column("allowedPlayers")
    private String allowedPlayers;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemSoulboundTradeData> {

        public ItemSoulboundTradeData convert(Row row) {
            ItemSoulboundTradeData domain = new ItemSoulboundTradeData();
            domain.setItemGuid(row.get("itemGuid", Long.class));
            domain.setAllowedPlayers(row.get("allowedPlayers", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemSoulboundTradeData, OutboundRow> {

        public OutboundRow convert(ItemSoulboundTradeData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getAllowedPlayers()).ifPresent(e -> row.put("allowedPlayers", Parameter.from(e)));
            return row;
        }
    }

}
