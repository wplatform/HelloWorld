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
@Table("vehicle_template_accessory")
public class VehicleTemplateAccessory {

    @Column("entry")
    private Integer entry;
    @Column("accessory_entry")
    private Integer accessoryEntry;
    @Column("seat_id")
    private Integer seatId;
    @Column("minion")
    private Integer minion;
    @Column("description")
    private String description;
    @Column("summontype")
    private Integer summontype;
    @Column("summontimer")
    private Integer summontimer;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, VehicleTemplateAccessory> {

        public VehicleTemplateAccessory convert(Row row) {
            VehicleTemplateAccessory domain = new VehicleTemplateAccessory();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setAccessoryEntry(row.get("accessory_entry", Integer.class));
            domain.setSeatId(row.get("seat_id", Integer.class));
            domain.setMinion(row.get("minion", Integer.class));
            domain.setDescription(row.get("description", String.class));
            domain.setSummontype(row.get("summontype", Integer.class));
            domain.setSummontimer(row.get("summontimer", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<VehicleTemplateAccessory, OutboundRow> {

        public OutboundRow convert(VehicleTemplateAccessory source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getAccessoryEntry()).ifPresent(e -> row.put("accessory_entry", Parameter.from(e)));
            Optional.ofNullable(source.getSeatId()).ifPresent(e -> row.put("seat_id", Parameter.from(e)));
            Optional.ofNullable(source.getMinion()).ifPresent(e -> row.put("minion", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("description", Parameter.from(e)));
            Optional.ofNullable(source.getSummontype()).ifPresent(e -> row.put("summontype", Parameter.from(e)));
            Optional.ofNullable(source.getSummontimer()).ifPresent(e -> row.put("summontimer", Parameter.from(e)));
            return row;
        }
    }

}
