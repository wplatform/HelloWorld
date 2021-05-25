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
@Table("creature_summon_groups")
public class CreatureSummonGroups {

    @Column("summonerId")
    private Integer summonerId;
    @Column("summonerType")
    private Integer summonerType;
    @Column("groupId")
    private Integer groupId;
    @Column("entry")
    private Integer entry;
    @Column("position_x")
    private Double positionX;
    @Column("position_y")
    private Double positionY;
    @Column("position_z")
    private Double positionZ;
    @Column("orientation")
    private Double orientation;
    @Column("summonType")
    private Integer summonType;
    @Column("summonTime")
    private Integer summonTime;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureSummonGroups> {

        public CreatureSummonGroups convert(Row row) {
            CreatureSummonGroups domain = new CreatureSummonGroups();
            domain.setSummonerId(row.get("summonerId", Integer.class));
            domain.setSummonerType(row.get("summonerType", Integer.class));
            domain.setGroupId(row.get("groupId", Integer.class));
            domain.setEntry(row.get("entry", Integer.class));
            domain.setPositionX(row.get("position_x", Double.class));
            domain.setPositionY(row.get("position_y", Double.class));
            domain.setPositionZ(row.get("position_z", Double.class));
            domain.setOrientation(row.get("orientation", Double.class));
            domain.setSummonType(row.get("summonType", Integer.class));
            domain.setSummonTime(row.get("summonTime", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureSummonGroups, OutboundRow> {

        public OutboundRow convert(CreatureSummonGroups source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSummonerId()).ifPresent(e -> row.put("summonerId", Parameter.from(e)));
            Optional.ofNullable(source.getSummonerType()).ifPresent(e -> row.put("summonerType", Parameter.from(e)));
            Optional.ofNullable(source.getGroupId()).ifPresent(e -> row.put("groupId", Parameter.from(e)));
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("position_x", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("position_y", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("position_z", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("orientation", Parameter.from(e)));
            Optional.ofNullable(source.getSummonType()).ifPresent(e -> row.put("summonType", Parameter.from(e)));
            Optional.ofNullable(source.getSummonTime()).ifPresent(e -> row.put("summonTime", Parameter.from(e)));
            return row;
        }
    }

}
