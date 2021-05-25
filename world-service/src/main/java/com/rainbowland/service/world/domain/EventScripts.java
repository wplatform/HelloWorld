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
@Table("event_scripts")
public class EventScripts {

    @Column("id")
    private Integer id;
    @Column("delay")
    private Integer delay;
    @Column("command")
    private Integer command;
    @Column("datalong")
    private Integer datalong;
    @Column("datalong2")
    private Integer datalong2;
    @Column("dataint")
    private Integer dataint;
    @Column("x")
    private Double X;
    @Column("y")
    private Double Y;
    @Column("z")
    private Double Z;
    @Column("o")
    private Double O;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, EventScripts> {

        public EventScripts convert(Row row) {
            EventScripts domain = new EventScripts();
            domain.setId(row.get("id", Integer.class));
            domain.setDelay(row.get("delay", Integer.class));
            domain.setCommand(row.get("command", Integer.class));
            domain.setDatalong(row.get("datalong", Integer.class));
            domain.setDatalong2(row.get("datalong2", Integer.class));
            domain.setDataint(row.get("dataint", Integer.class));
            domain.setX(row.get("x", Double.class));
            domain.setY(row.get("y", Double.class));
            domain.setZ(row.get("z", Double.class));
            domain.setO(row.get("o", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<EventScripts, OutboundRow> {

        public OutboundRow convert(EventScripts source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getDelay()).ifPresent(e -> row.put("delay", Parameter.from(e)));
            Optional.ofNullable(source.getCommand()).ifPresent(e -> row.put("command", Parameter.from(e)));
            Optional.ofNullable(source.getDatalong()).ifPresent(e -> row.put("datalong", Parameter.from(e)));
            Optional.ofNullable(source.getDatalong2()).ifPresent(e -> row.put("datalong2", Parameter.from(e)));
            Optional.ofNullable(source.getDataint()).ifPresent(e -> row.put("dataint", Parameter.from(e)));
            Optional.ofNullable(source.getX()).ifPresent(e -> row.put("x", Parameter.from(e)));
            Optional.ofNullable(source.getY()).ifPresent(e -> row.put("y", Parameter.from(e)));
            Optional.ofNullable(source.getZ()).ifPresent(e -> row.put("z", Parameter.from(e)));
            Optional.ofNullable(source.getO()).ifPresent(e -> row.put("o", Parameter.from(e)));
            return row;
        }
    }

}
