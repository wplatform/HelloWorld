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
@Table("areatrigger_teleport")
public class AreatriggerTeleport {

    @Column("ID")
    private Integer id;
    @Column("PortLocID")
    private Integer portLocId;
    @Column("Name")
    private String name;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AreatriggerTeleport> {

        public AreatriggerTeleport convert(Row row) {
            AreatriggerTeleport domain = new AreatriggerTeleport();
            domain.setId(row.get("ID", Integer.class));
            domain.setPortLocId(row.get("PortLocID", Integer.class));
            domain.setName(row.get("Name", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AreatriggerTeleport, OutboundRow> {

        public OutboundRow convert(AreatriggerTeleport source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPortLocId()).ifPresent(e -> row.put("PortLocID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            return row;
        }
    }

}
