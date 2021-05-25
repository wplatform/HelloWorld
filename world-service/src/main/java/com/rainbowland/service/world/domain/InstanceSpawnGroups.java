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
@Table("instance_spawn_groups")
public class InstanceSpawnGroups {

    @Column("instanceMapId")
    private Integer instanceMapId;
    @Column("bossStateId")
    private Integer bossStateId;
    @Column("bossStates")
    private Integer bossStates;
    @Column("spawnGroupId")
    private Integer spawnGroupId;
    @Column("flags")
    private Integer flags;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, InstanceSpawnGroups> {

        public InstanceSpawnGroups convert(Row row) {
            InstanceSpawnGroups domain = new InstanceSpawnGroups();
            domain.setInstanceMapId(row.get("instanceMapId", Integer.class));
            domain.setBossStateId(row.get("bossStateId", Integer.class));
            domain.setBossStates(row.get("bossStates", Integer.class));
            domain.setSpawnGroupId(row.get("spawnGroupId", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<InstanceSpawnGroups, OutboundRow> {

        public OutboundRow convert(InstanceSpawnGroups source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getInstanceMapId()).ifPresent(e -> row.put("instanceMapId", Parameter.from(e)));
            Optional.ofNullable(source.getBossStateId()).ifPresent(e -> row.put("bossStateId", Parameter.from(e)));
            Optional.ofNullable(source.getBossStates()).ifPresent(e -> row.put("bossStates", Parameter.from(e)));
            Optional.ofNullable(source.getSpawnGroupId()).ifPresent(e -> row.put("spawnGroupId", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            return row;
        }
    }

}
