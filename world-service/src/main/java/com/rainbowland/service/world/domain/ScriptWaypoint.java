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
@Table("script_waypoint")
public class ScriptWaypoint {

    @Column("entry")
    private Integer entry;
    @Column("pointid")
    private Integer pointid;
    @Column("location_x")
    private Double locationX;
    @Column("location_y")
    private Double locationY;
    @Column("location_z")
    private Double locationZ;
    @Column("waittime")
    private Integer waittime;
    @Column("point_comment")
    private String pointComment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ScriptWaypoint> {

        public ScriptWaypoint convert(Row row) {
            ScriptWaypoint domain = new ScriptWaypoint();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setPointid(row.get("pointid", Integer.class));
            domain.setLocationX(row.get("location_x", Double.class));
            domain.setLocationY(row.get("location_y", Double.class));
            domain.setLocationZ(row.get("location_z", Double.class));
            domain.setWaittime(row.get("waittime", Integer.class));
            domain.setPointComment(row.get("point_comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ScriptWaypoint, OutboundRow> {

        public OutboundRow convert(ScriptWaypoint source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getPointid()).ifPresent(e -> row.put("pointid", Parameter.from(e)));
            Optional.ofNullable(source.getLocationX()).ifPresent(e -> row.put("location_x", Parameter.from(e)));
            Optional.ofNullable(source.getLocationY()).ifPresent(e -> row.put("location_y", Parameter.from(e)));
            Optional.ofNullable(source.getLocationZ()).ifPresent(e -> row.put("location_z", Parameter.from(e)));
            Optional.ofNullable(source.getWaittime()).ifPresent(e -> row.put("waittime", Parameter.from(e)));
            Optional.ofNullable(source.getPointComment()).ifPresent(e -> row.put("point_comment", Parameter.from(e)));
            return row;
        }
    }

}
