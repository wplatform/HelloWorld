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
@Table("creature_respawn")
public class CreatureRespawn {

    @Column("guid")
    private Long guid;
    @Column("respawnTime")
    private Long respawnTime;
    @Column("mapId")
    private Integer mapId;
    @Column("instanceId")
    private Integer instanceId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureRespawn> {

        public CreatureRespawn convert(Row row) {
            CreatureRespawn domain = new CreatureRespawn();
            domain.setGuid(row.get("guid", Long.class));
            domain.setRespawnTime(row.get("respawnTime", Long.class));
            domain.setMapId(row.get("mapId", Integer.class));
            domain.setInstanceId(row.get("instanceId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureRespawn, OutboundRow> {

        public OutboundRow convert(CreatureRespawn source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getRespawnTime()).ifPresent(e -> row.put("respawnTime", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("mapId", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceId()).ifPresent(e -> row.put("instanceId", Parameter.from(e)));
            return row;
        }
    }

}
