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
@Table("terrain_swap_defaults")
public class TerrainSwapDefaults {

    @Column("MapId")
    private Integer mapId;
    @Column("TerrainSwapMap")
    private Integer terrainSwapMap;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TerrainSwapDefaults> {

        public TerrainSwapDefaults convert(Row row) {
            TerrainSwapDefaults domain = new TerrainSwapDefaults();
            domain.setMapId(row.get("MapId", Integer.class));
            domain.setTerrainSwapMap(row.get("TerrainSwapMap", Integer.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TerrainSwapDefaults, OutboundRow> {

        public OutboundRow convert(TerrainSwapDefaults source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapId", Parameter.from(e)));
            Optional.ofNullable(source.getTerrainSwapMap()).ifPresent(e -> row.put("TerrainSwapMap", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
