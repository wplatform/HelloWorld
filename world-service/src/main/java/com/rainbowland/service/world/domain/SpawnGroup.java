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
@Table("spawn_group")
public class SpawnGroup {

    @Column("groupId")
    private Integer groupId;
    @Column("spawnType")
    private Integer spawnType;
    @Column("spawnId")
    private Long spawnId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpawnGroup> {

        public SpawnGroup convert(Row row) {
            SpawnGroup domain = new SpawnGroup();
            domain.setGroupId(row.get("groupId", Integer.class));
            domain.setSpawnType(row.get("spawnType", Integer.class));
            domain.setSpawnId(row.get("spawnId", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpawnGroup, OutboundRow> {

        public OutboundRow convert(SpawnGroup source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGroupId()).ifPresent(e -> row.put("groupId", Parameter.from(e)));
            Optional.ofNullable(source.getSpawnType()).ifPresent(e -> row.put("spawnType", Parameter.from(e)));
            Optional.ofNullable(source.getSpawnId()).ifPresent(e -> row.put("spawnId", Parameter.from(e)));
            return row;
        }
    }

}
