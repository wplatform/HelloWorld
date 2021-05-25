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
@Table("world_safe_locs")
public class WorldSafeLocs {

    @Column("ID")
    private Integer id;
    @Column("MapID")
    private Integer mapId;
    @Column("LocX")
    private Double locX;
    @Column("LocY")
    private Double locY;
    @Column("LocZ")
    private Double locZ;
    @Column("Facing")
    private Double facing;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, WorldSafeLocs> {

        public WorldSafeLocs convert(Row row) {
            WorldSafeLocs domain = new WorldSafeLocs();
            domain.setId(row.get("ID", Integer.class));
            domain.setMapId(row.get("MapID", Integer.class));
            domain.setLocX(row.get("LocX", Double.class));
            domain.setLocY(row.get("LocY", Double.class));
            domain.setLocZ(row.get("LocZ", Double.class));
            domain.setFacing(row.get("Facing", Double.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<WorldSafeLocs, OutboundRow> {

        public OutboundRow convert(WorldSafeLocs source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapID", Parameter.from(e)));
            Optional.ofNullable(source.getLocX()).ifPresent(e -> row.put("LocX", Parameter.from(e)));
            Optional.ofNullable(source.getLocY()).ifPresent(e -> row.put("LocY", Parameter.from(e)));
            Optional.ofNullable(source.getLocZ()).ifPresent(e -> row.put("LocZ", Parameter.from(e)));
            Optional.ofNullable(source.getFacing()).ifPresent(e -> row.put("Facing", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
