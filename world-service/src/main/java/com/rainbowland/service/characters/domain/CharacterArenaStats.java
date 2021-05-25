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
@Table("character_arena_stats")
public class CharacterArenaStats {

    @Column("guid")
    private Long guid;
    @Column("slot")
    private Integer slot;
    @Column("matchMakerRating")
    private Integer matchMakerRating;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterArenaStats> {

        public CharacterArenaStats convert(Row row) {
            CharacterArenaStats domain = new CharacterArenaStats();
            domain.setGuid(row.get("guid", Long.class));
            domain.setSlot(row.get("slot", Integer.class));
            domain.setMatchMakerRating(row.get("matchMakerRating", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterArenaStats, OutboundRow> {

        public OutboundRow convert(CharacterArenaStats source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSlot()).ifPresent(e -> row.put("slot", Parameter.from(e)));
            Optional.ofNullable(source.getMatchMakerRating()).ifPresent(e -> row.put("matchMakerRating", Parameter.from(e)));
            return row;
        }
    }

}
