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
@Table("pvpstats_battlegrounds")
public class PvpstatsBattlegrounds {

    @Column("id")
    private Long id;
    @Column("winner_faction")
    private Integer winnerFaction;
    @Column("bracket_id")
    private Integer bracketId;
    @Column("type")
    private Integer type;
    @Column("date")
    private java.time.LocalDateTime date;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PvpstatsBattlegrounds> {

        public PvpstatsBattlegrounds convert(Row row) {
            PvpstatsBattlegrounds domain = new PvpstatsBattlegrounds();
            domain.setId(row.get("id", Long.class));
            domain.setWinnerFaction(row.get("winner_faction", Integer.class));
            domain.setBracketId(row.get("bracket_id", Integer.class));
            domain.setType(row.get("type", Integer.class));
            domain.setDate(row.get("date", java.time.LocalDateTime.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PvpstatsBattlegrounds, OutboundRow> {

        public OutboundRow convert(PvpstatsBattlegrounds source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getWinnerFaction()).ifPresent(e -> row.put("winner_faction", Parameter.from(e)));
            Optional.ofNullable(source.getBracketId()).ifPresent(e -> row.put("bracket_id", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getDate()).ifPresent(e -> row.put("date", Parameter.from(e)));
            return row;
        }
    }

}
