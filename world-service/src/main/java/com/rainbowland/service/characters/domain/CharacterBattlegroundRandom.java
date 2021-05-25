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
@Table("character_battleground_random")
public class CharacterBattlegroundRandom {

    @Column("guid")
    private Long guid;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterBattlegroundRandom> {

        public CharacterBattlegroundRandom convert(Row row) {
            CharacterBattlegroundRandom domain = new CharacterBattlegroundRandom();
            domain.setGuid(row.get("guid", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterBattlegroundRandom, OutboundRow> {

        public OutboundRow convert(CharacterBattlegroundRandom source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            return row;
        }
    }

}
