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
@Table("waypoint_data")
public class WaypointData {

    @Column("id")
    private Integer id;
    @Column("point")
    private Integer point;
    @Column("position_x")
    private Double positionX;
    @Column("position_y")
    private Double positionY;
    @Column("position_z")
    private Double positionZ;
    @Column("orientation")
    private Double orientation;
    @Column("delay")
    private Integer delay;
    @Column("move_type")
    private Integer moveType;
    @Column("action")
    private Integer action;
    @Column("action_chance")
    private Integer actionChance;
    @Column("wpguid")
    private Long wpguid;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, WaypointData> {

        public WaypointData convert(Row row) {
            WaypointData domain = new WaypointData();
            domain.setId(row.get("id", Integer.class));
            domain.setPoint(row.get("point", Integer.class));
            domain.setPositionX(row.get("position_x", Double.class));
            domain.setPositionY(row.get("position_y", Double.class));
            domain.setPositionZ(row.get("position_z", Double.class));
            domain.setOrientation(row.get("orientation", Double.class));
            domain.setDelay(row.get("delay", Integer.class));
            domain.setMoveType(row.get("move_type", Integer.class));
            domain.setAction(row.get("action", Integer.class));
            domain.setActionChance(row.get("action_chance", Integer.class));
            domain.setWpguid(row.get("wpguid", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<WaypointData, OutboundRow> {

        public OutboundRow convert(WaypointData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getPoint()).ifPresent(e -> row.put("point", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("position_x", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("position_y", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("position_z", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("orientation", Parameter.from(e)));
            Optional.ofNullable(source.getDelay()).ifPresent(e -> row.put("delay", Parameter.from(e)));
            Optional.ofNullable(source.getMoveType()).ifPresent(e -> row.put("move_type", Parameter.from(e)));
            Optional.ofNullable(source.getAction()).ifPresent(e -> row.put("action", Parameter.from(e)));
            Optional.ofNullable(source.getActionChance()).ifPresent(e -> row.put("action_chance", Parameter.from(e)));
            Optional.ofNullable(source.getWpguid()).ifPresent(e -> row.put("wpguid", Parameter.from(e)));
            return row;
        }
    }

}
