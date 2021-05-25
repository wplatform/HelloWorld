package com.rainbowland.service.hotfixes.domain;

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
@Table("character_loadout_item")
public class CharacterLoadoutItem {

    @Column("ID")
    private Integer id;
    @Column("CharacterLoadoutID")
    private Integer characterLoadoutId;
    @Column("ItemID")
    private Integer itemId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterLoadoutItem> {

        public CharacterLoadoutItem convert(Row row) {
            CharacterLoadoutItem domain = new CharacterLoadoutItem();
            domain.setId(row.get("ID", Integer.class));
            domain.setCharacterLoadoutId(row.get("CharacterLoadoutID", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterLoadoutItem, OutboundRow> {

        public OutboundRow convert(CharacterLoadoutItem source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterLoadoutId()).ifPresent(e -> row.put("CharacterLoadoutID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
