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
@Table("playercreateinfo")
public class Playercreateinfo {

    @Column("race")
    private Integer race;
    @Column("class")
    private Integer klass;
    @Column("map")
    private Integer map;
    @Column("zone")
    private Integer zone;
    @Column("position_x")
    private Double positionX;
    @Column("position_y")
    private Double positionY;
    @Column("position_z")
    private Double positionZ;
    @Column("orientation")
    private Double orientation;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Playercreateinfo> {

        public Playercreateinfo convert(Row row) {
            Playercreateinfo domain = new Playercreateinfo();
            domain.setRace(row.get("race", Integer.class));
            domain.setKlass(row.get("class", Integer.class));
            domain.setMap(row.get("map", Integer.class));
            domain.setZone(row.get("zone", Integer.class));
            domain.setPositionX(row.get("position_x", Double.class));
            domain.setPositionY(row.get("position_y", Double.class));
            domain.setPositionZ(row.get("position_z", Double.class));
            domain.setOrientation(row.get("orientation", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Playercreateinfo, OutboundRow> {

        public OutboundRow convert(Playercreateinfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRace()).ifPresent(e -> row.put("race", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("class", Parameter.from(e)));
            Optional.ofNullable(source.getMap()).ifPresent(e -> row.put("map", Parameter.from(e)));
            Optional.ofNullable(source.getZone()).ifPresent(e -> row.put("zone", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("position_x", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("position_y", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("position_z", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("orientation", Parameter.from(e)));
            return row;
        }
    }

}
