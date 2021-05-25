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
@Table("achievement_dbc")
public class AchievementDbc {

    @Column("ID")
    private Integer id;
    @Column("requiredFaction")
    private Integer requiredFaction;
    @Column("mapID")
    private Integer mapId;
    @Column("points")
    private Integer points;
    @Column("flags")
    private Integer flags;
    @Column("count")
    private Integer count;
    @Column("refAchievement")
    private Integer refAchievement;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AchievementDbc> {

        public AchievementDbc convert(Row row) {
            AchievementDbc domain = new AchievementDbc();
            domain.setId(row.get("ID", Integer.class));
            domain.setRequiredFaction(row.get("requiredFaction", Integer.class));
            domain.setMapId(row.get("mapID", Integer.class));
            domain.setPoints(row.get("points", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            domain.setCount(row.get("count", Integer.class));
            domain.setRefAchievement(row.get("refAchievement", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AchievementDbc, OutboundRow> {

        public OutboundRow convert(AchievementDbc source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredFaction()).ifPresent(e -> row.put("requiredFaction", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("mapID", Parameter.from(e)));
            Optional.ofNullable(source.getPoints()).ifPresent(e -> row.put("points", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            Optional.ofNullable(source.getCount()).ifPresent(e -> row.put("count", Parameter.from(e)));
            Optional.ofNullable(source.getRefAchievement()).ifPresent(e -> row.put("refAchievement", Parameter.from(e)));
            return row;
        }
    }

}
