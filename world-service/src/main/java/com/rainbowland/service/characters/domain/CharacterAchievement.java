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
@Table("character_achievement")
public class CharacterAchievement {

    @Column("guid")
    private Long guid;
    @Column("achievement")
    private Integer achievement;
    @Column("date")
    private Long date;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterAchievement> {

        public CharacterAchievement convert(Row row) {
            CharacterAchievement domain = new CharacterAchievement();
            domain.setGuid(row.get("guid", Long.class));
            domain.setAchievement(row.get("achievement", Integer.class));
            domain.setDate(row.get("date", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterAchievement, OutboundRow> {

        public OutboundRow convert(CharacterAchievement source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getAchievement()).ifPresent(e -> row.put("achievement", Parameter.from(e)));
            Optional.ofNullable(source.getDate()).ifPresent(e -> row.put("date", Parameter.from(e)));
            return row;
        }
    }

}
