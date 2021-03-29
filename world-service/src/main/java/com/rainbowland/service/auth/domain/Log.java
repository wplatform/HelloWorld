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
@Table("logs")
public class Log {

    @Column("time")
    private Long time;
    @Column("realm")
    private Long realm;
    @Column("type")
    private String type;
    @Column("level")
    private Integer level;
    @Column("string")
    private String string;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Log> {

        public Log convert(Row row) {
            Log domain = new Log();
            domain.setTime(row.get("time", Long.class));
            domain.setRealm(row.get("realm", Long.class));
            domain.setType(row.get("type", String.class));
            domain.setLevel(row.get("level", Integer.class));
            domain.setString(row.get("string", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Log, OutboundRow> {

        public OutboundRow convert(Log source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getTime()).ifPresent(e -> row.put("time", Parameter.from(e)));
            Optional.ofNullable(source.getRealm()).ifPresent(e -> row.put("realm", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getString()).ifPresent(e -> row.put("string", Parameter.from(e)));
            return row;
        }
    }

}
