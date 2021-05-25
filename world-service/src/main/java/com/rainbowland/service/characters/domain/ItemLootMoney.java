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
@Table("item_loot_money")
public class ItemLootMoney {

    @Column("container_id")
    private Long containerId;
    @Column("money")
    private Integer money;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemLootMoney> {

        public ItemLootMoney convert(Row row) {
            ItemLootMoney domain = new ItemLootMoney();
            domain.setContainerId(row.get("container_id", Long.class));
            domain.setMoney(row.get("money", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemLootMoney, OutboundRow> {

        public OutboundRow convert(ItemLootMoney source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getContainerId()).ifPresent(e -> row.put("container_id", Parameter.from(e)));
            Optional.ofNullable(source.getMoney()).ifPresent(e -> row.put("money", Parameter.from(e)));
            return row;
        }
    }

}
