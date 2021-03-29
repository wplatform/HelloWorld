package com.rainbowland.service.auth.domain;

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
@Table("updates")
public class Update {

    @Column("name")
    private String name;
    @Column("hash")
    private String hash;
    @Column("state")
    private String state;
    @Column("timestamp")
    private java.time.LocalDateTime timestamp;
    @Column("speed")
    private Integer speed;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Update> {

        public Update convert(Row row) {
            Update domain = new Update();
            domain.setName(row.get("name", String.class));
            domain.setHash(row.get("hash", String.class));
            domain.setState(row.get("state", String.class));
            domain.setTimestamp(row.get("timestamp", java.time.LocalDateTime.class));
            domain.setSpeed(row.get("speed", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Update, OutboundRow> {

        public OutboundRow convert(Update source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getHash()).ifPresent(e -> row.put("hash", Parameter.from(e)));
            Optional.ofNullable(source.getState()).ifPresent(e -> row.put("state", Parameter.from(e)));
            Optional.ofNullable(source.getTimestamp()).ifPresent(e -> row.put("timestamp", Parameter.from(e)));
            Optional.ofNullable(source.getSpeed()).ifPresent(e -> row.put("speed", Parameter.from(e)));
            return row;
        }
    }

}
