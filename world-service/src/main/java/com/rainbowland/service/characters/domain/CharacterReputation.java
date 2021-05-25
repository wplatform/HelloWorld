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
@Table("character_reputation")
public class CharacterReputation {

    @Column("guid")
    private Long guid;
    @Column("faction")
    private Integer faction;
    @Column("standing")
    private Integer standing;
    @Column("flags")
    private Integer flags;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterReputation> {

        public CharacterReputation convert(Row row) {
            CharacterReputation domain = new CharacterReputation();
            domain.setGuid(row.get("guid", Long.class));
            domain.setFaction(row.get("faction", Integer.class));
            domain.setStanding(row.get("standing", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterReputation, OutboundRow> {

        public OutboundRow convert(CharacterReputation source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("faction", Parameter.from(e)));
            Optional.ofNullable(source.getStanding()).ifPresent(e -> row.put("standing", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            return row;
        }
    }

}
