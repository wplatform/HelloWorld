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
@Table("terrain_worldmap")
public class TerrainWorldmap {

    @Column("TerrainSwapMap")
    private Integer terrainSwapMap;
    @Column("UiMapPhaseId")
    private Integer uiMapPhaseId;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TerrainWorldmap> {

        public TerrainWorldmap convert(Row row) {
            TerrainWorldmap domain = new TerrainWorldmap();
            domain.setTerrainSwapMap(row.get("TerrainSwapMap", Integer.class));
            domain.setUiMapPhaseId(row.get("UiMapPhaseId", Integer.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TerrainWorldmap, OutboundRow> {

        public OutboundRow convert(TerrainWorldmap source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getTerrainSwapMap()).ifPresent(e -> row.put("TerrainSwapMap", Parameter.from(e)));
            Optional.ofNullable(source.getUiMapPhaseId()).ifPresent(e -> row.put("UiMapPhaseId", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
