package com.rainbowland.service.characters.domain;

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
@Table("reserved_name")
public class ReservedName {

    @Column("name")
    private String name;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ReservedName> {

        public ReservedName convert(Row row) {
            ReservedName domain = new ReservedName();
            domain.setName(row.get("name", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ReservedName, OutboundRow> {

        public OutboundRow convert(ReservedName source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            return row;
        }
    }

}
