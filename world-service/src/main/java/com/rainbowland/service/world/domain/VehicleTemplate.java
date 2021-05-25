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
@Table("vehicle_template")
public class VehicleTemplate {

    @Column("creatureId")
    private Integer creatureId;
    @Column("despawnDelayMs")
    private Integer despawnDelayMs;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, VehicleTemplate> {

        public VehicleTemplate convert(Row row) {
            VehicleTemplate domain = new VehicleTemplate();
            domain.setCreatureId(row.get("creatureId", Integer.class));
            domain.setDespawnDelayMs(row.get("despawnDelayMs", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<VehicleTemplate, OutboundRow> {

        public OutboundRow convert(VehicleTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("creatureId", Parameter.from(e)));
            Optional.ofNullable(source.getDespawnDelayMs()).ifPresent(e -> row.put("despawnDelayMs", Parameter.from(e)));
            return row;
        }
    }

}
