package com.rainbowland.service.world.domain;

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
@Table("player_factionchange_items")
public class PlayerFactionchangeItems {

    @Column("race_A")
    private Integer raceA;
    @Column("alliance_id")
    private Integer allianceId;
    @Column("commentA")
    private String commentA;
    @Column("race_H")
    private Integer raceH;
    @Column("horde_id")
    private Integer hordeId;
    @Column("commentH")
    private String commentH;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerFactionchangeItems> {

        public PlayerFactionchangeItems convert(Row row) {
            PlayerFactionchangeItems domain = new PlayerFactionchangeItems();
            domain.setRaceA(row.get("race_A", Integer.class));
            domain.setAllianceId(row.get("alliance_id", Integer.class));
            domain.setCommentA(row.get("commentA", String.class));
            domain.setRaceH(row.get("race_H", Integer.class));
            domain.setHordeId(row.get("horde_id", Integer.class));
            domain.setCommentH(row.get("commentH", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerFactionchangeItems, OutboundRow> {

        public OutboundRow convert(PlayerFactionchangeItems source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRaceA()).ifPresent(e -> row.put("race_A", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceId()).ifPresent(e -> row.put("alliance_id", Parameter.from(e)));
            Optional.ofNullable(source.getCommentA()).ifPresent(e -> row.put("commentA", Parameter.from(e)));
            Optional.ofNullable(source.getRaceH()).ifPresent(e -> row.put("race_H", Parameter.from(e)));
            Optional.ofNullable(source.getHordeId()).ifPresent(e -> row.put("horde_id", Parameter.from(e)));
            Optional.ofNullable(source.getCommentH()).ifPresent(e -> row.put("commentH", Parameter.from(e)));
            return row;
        }
    }

}
