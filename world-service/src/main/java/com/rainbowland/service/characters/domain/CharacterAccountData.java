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
@Table("character_account_data")
public class CharacterAccountData {

    @Column("guid")
    private Long guid;
    @Column("type")
    private Integer type;
    @Column("time")
    private Long time;
    @Column("data")
    private String data;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterAccountData> {

        public CharacterAccountData convert(Row row) {
            CharacterAccountData domain = new CharacterAccountData();
            domain.setGuid(row.get("guid", Long.class));
            domain.setType(row.get("type", Integer.class));
            domain.setTime(row.get("time", Long.class));
            domain.setData(row.get("data", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterAccountData, OutboundRow> {

        public OutboundRow convert(CharacterAccountData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getTime()).ifPresent(e -> row.put("time", Parameter.from(e)));
            Optional.ofNullable(source.getData()).ifPresent(e -> row.put("data", Parameter.from(e)));
            return row;
        }
    }

}
