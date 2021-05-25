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
@Table("race_unlock_requirement")
public class RaceUnlockRequirement {

    @Column("raceID")
    private Integer raceId;
    @Column("expansion")
    private Integer expansion;
    @Column("achievementId")
    private Integer achievementId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, RaceUnlockRequirement> {

        public RaceUnlockRequirement convert(Row row) {
            RaceUnlockRequirement domain = new RaceUnlockRequirement();
            domain.setRaceId(row.get("raceID", Integer.class));
            domain.setExpansion(row.get("expansion", Integer.class));
            domain.setAchievementId(row.get("achievementId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<RaceUnlockRequirement, OutboundRow> {

        public OutboundRow convert(RaceUnlockRequirement source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRaceId()).ifPresent(e -> row.put("raceID", Parameter.from(e)));
            Optional.ofNullable(source.getExpansion()).ifPresent(e -> row.put("expansion", Parameter.from(e)));
            Optional.ofNullable(source.getAchievementId()).ifPresent(e -> row.put("achievementId", Parameter.from(e)));
            return row;
        }
    }

}
