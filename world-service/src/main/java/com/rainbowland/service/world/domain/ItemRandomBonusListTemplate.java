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
@Table("item_random_bonus_list_template")
public class ItemRandomBonusListTemplate {

    @Column("Id")
    private Integer id;
    @Column("BonusListID")
    private Integer bonusListId;
    @Column("Chance")
    private Double chance;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemRandomBonusListTemplate> {

        public ItemRandomBonusListTemplate convert(Row row) {
            ItemRandomBonusListTemplate domain = new ItemRandomBonusListTemplate();
            domain.setId(row.get("Id", Integer.class));
            domain.setBonusListId(row.get("BonusListID", Integer.class));
            domain.setChance(row.get("Chance", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemRandomBonusListTemplate, OutboundRow> {

        public OutboundRow convert(ItemRandomBonusListTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getBonusListId()).ifPresent(e -> row.put("BonusListID", Parameter.from(e)));
            Optional.ofNullable(source.getChance()).ifPresent(e -> row.put("Chance", Parameter.from(e)));
            return row;
        }
    }

}
