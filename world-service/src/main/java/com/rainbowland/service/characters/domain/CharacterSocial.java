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
@Table("character_social")
public class CharacterSocial {

    @Column("guid")
    private Long guid;
    @Column("friend")
    private Long friend;
    @Column("flags")
    private Integer flags;
    @Column("note")
    private String note;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterSocial> {

        public CharacterSocial convert(Row row) {
            CharacterSocial domain = new CharacterSocial();
            domain.setGuid(row.get("guid", Long.class));
            domain.setFriend(row.get("friend", Long.class));
            domain.setFlags(row.get("flags", Integer.class));
            domain.setNote(row.get("note", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterSocial, OutboundRow> {

        public OutboundRow convert(CharacterSocial source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getFriend()).ifPresent(e -> row.put("friend", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            Optional.ofNullable(source.getNote()).ifPresent(e -> row.put("note", Parameter.from(e)));
            return row;
        }
    }

}
