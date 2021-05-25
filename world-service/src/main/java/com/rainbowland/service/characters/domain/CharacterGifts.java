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
@Table("character_gifts")
public class CharacterGifts {

    @Column("guid")
    private Long guid;
    @Column("item_guid")
    private Long itemGuid;
    @Column("entry")
    private Integer entry;
    @Column("flags")
    private Integer flags;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterGifts> {

        public CharacterGifts convert(Row row) {
            CharacterGifts domain = new CharacterGifts();
            domain.setGuid(row.get("guid", Long.class));
            domain.setItemGuid(row.get("item_guid", Long.class));
            domain.setEntry(row.get("entry", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterGifts, OutboundRow> {

        public OutboundRow convert(CharacterGifts source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("item_guid", Parameter.from(e)));
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            return row;
        }
    }

}
