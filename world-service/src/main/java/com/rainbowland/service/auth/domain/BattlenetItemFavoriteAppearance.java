package com.rainbowland.service.auth.domain;

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
@Table("battlenet_item_favorite_appearances")
public class BattlenetItemFavoriteAppearance {

    @Column("battlenetAccountId")
    private Long battlenetAccountId;
    @Column("itemModifiedAppearanceId")
    private Long itemModifiedAppearanceId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlenetItemFavoriteAppearance> {

        public BattlenetItemFavoriteAppearance convert(Row row) {
            BattlenetItemFavoriteAppearance domain = new BattlenetItemFavoriteAppearance();
            domain.setBattlenetAccountId(row.get("battlenetAccountId", Long.class));
            domain.setItemModifiedAppearanceId(row.get("itemModifiedAppearanceId", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlenetItemFavoriteAppearance, OutboundRow> {

        public OutboundRow convert(BattlenetItemFavoriteAppearance source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getBattlenetAccountId()).ifPresent(e -> row.put("battlenetAccountId", Parameter.from(e)));
            Optional.ofNullable(source.getItemModifiedAppearanceId()).ifPresent(e -> row.put("itemModifiedAppearanceId", Parameter.from(e)));
            return row;
        }
    }

}
