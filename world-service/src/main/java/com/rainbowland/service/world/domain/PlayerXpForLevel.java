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
@Table("player_xp_for_level")
public class PlayerXpForLevel {

    @Column("Level")
    private Integer level;
    @Column("Experience")
    private Double experience;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerXpForLevel> {

        public PlayerXpForLevel convert(Row row) {
            PlayerXpForLevel domain = new PlayerXpForLevel();
            domain.setLevel(row.get("Level", Integer.class));
            domain.setExperience(row.get("Experience", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerXpForLevel, OutboundRow> {

        public OutboundRow convert(PlayerXpForLevel source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("Level", Parameter.from(e)));
            Optional.ofNullable(source.getExperience()).ifPresent(e -> row.put("Experience", Parameter.from(e)));
            return row;
        }
    }

}
