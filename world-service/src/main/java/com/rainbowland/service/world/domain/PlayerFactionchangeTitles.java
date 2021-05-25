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
@Table("player_factionchange_titles")
public class PlayerFactionchangeTitles {

    @Column("alliance_id")
    private Integer allianceId;
    @Column("horde_id")
    private Integer hordeId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerFactionchangeTitles> {

        public PlayerFactionchangeTitles convert(Row row) {
            PlayerFactionchangeTitles domain = new PlayerFactionchangeTitles();
            domain.setAllianceId(row.get("alliance_id", Integer.class));
            domain.setHordeId(row.get("horde_id", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerFactionchangeTitles, OutboundRow> {

        public OutboundRow convert(PlayerFactionchangeTitles source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAllianceId()).ifPresent(e -> row.put("alliance_id", Parameter.from(e)));
            Optional.ofNullable(source.getHordeId()).ifPresent(e -> row.put("horde_id", Parameter.from(e)));
            return row;
        }
    }

}
