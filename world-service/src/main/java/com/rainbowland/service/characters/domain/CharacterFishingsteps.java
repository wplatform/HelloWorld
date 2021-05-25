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
@Table("character_fishingsteps")
public class CharacterFishingsteps {

    @Column("guid")
    private Long guid;
    @Column("fishingSteps")
    private Integer fishingSteps;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterFishingsteps> {

        public CharacterFishingsteps convert(Row row) {
            CharacterFishingsteps domain = new CharacterFishingsteps();
            domain.setGuid(row.get("guid", Long.class));
            domain.setFishingSteps(row.get("fishingSteps", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterFishingsteps, OutboundRow> {

        public OutboundRow convert(CharacterFishingsteps source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getFishingSteps()).ifPresent(e -> row.put("fishingSteps", Parameter.from(e)));
            return row;
        }
    }

}
