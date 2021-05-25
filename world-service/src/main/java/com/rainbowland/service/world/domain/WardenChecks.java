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
@Table("warden_checks")
public class WardenChecks {

    @Column("id")
    private Integer id;
    @Column("type")
    private Integer type;
    @Column("data")
    private String data;
    @Column("str")
    private String str;
    @Column("address")
    private Integer address;
    @Column("length")
    private Integer length;
    @Column("result")
    private String result;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, WardenChecks> {

        public WardenChecks convert(Row row) {
            WardenChecks domain = new WardenChecks();
            domain.setId(row.get("id", Integer.class));
            domain.setType(row.get("type", Integer.class));
            domain.setData(row.get("data", String.class));
            domain.setStr(row.get("str", String.class));
            domain.setAddress(row.get("address", Integer.class));
            domain.setLength(row.get("length", Integer.class));
            domain.setResult(row.get("result", String.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<WardenChecks, OutboundRow> {

        public OutboundRow convert(WardenChecks source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getData()).ifPresent(e -> row.put("data", Parameter.from(e)));
            Optional.ofNullable(source.getStr()).ifPresent(e -> row.put("str", Parameter.from(e)));
            Optional.ofNullable(source.getAddress()).ifPresent(e -> row.put("address", Parameter.from(e)));
            Optional.ofNullable(source.getLength()).ifPresent(e -> row.put("length", Parameter.from(e)));
            Optional.ofNullable(source.getResult()).ifPresent(e -> row.put("result", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
