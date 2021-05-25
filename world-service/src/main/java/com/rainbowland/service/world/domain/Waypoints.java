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
@Table("waypoints")
public class Waypoints {

    @Column("entry")
    private Integer entry;
    @Column("pointid")
    private Integer pointid;
    @Column("position_x")
    private Double positionX;
    @Column("position_y")
    private Double positionY;
    @Column("position_z")
    private Double positionZ;
    @Column("point_comment")
    private String pointComment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Waypoints> {

        public Waypoints convert(Row row) {
            Waypoints domain = new Waypoints();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setPointid(row.get("pointid", Integer.class));
            domain.setPositionX(row.get("position_x", Double.class));
            domain.setPositionY(row.get("position_y", Double.class));
            domain.setPositionZ(row.get("position_z", Double.class));
            domain.setPointComment(row.get("point_comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Waypoints, OutboundRow> {

        public OutboundRow convert(Waypoints source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getPointid()).ifPresent(e -> row.put("pointid", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("position_x", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("position_y", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("position_z", Parameter.from(e)));
            Optional.ofNullable(source.getPointComment()).ifPresent(e -> row.put("point_comment", Parameter.from(e)));
            return row;
        }
    }

}
