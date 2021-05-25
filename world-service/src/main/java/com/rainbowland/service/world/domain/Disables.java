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
@Table("disables")
public class Disables {

    @Column("sourceType")
    private Integer sourceType;
    @Column("entry")
    private Integer entry;
    @Column("flags")
    private Integer flags;
    @Column("params_0")
    private String params0;
    @Column("params_1")
    private String params1;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Disables> {

        public Disables convert(Row row) {
            Disables domain = new Disables();
            domain.setSourceType(row.get("sourceType", Integer.class));
            domain.setEntry(row.get("entry", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            domain.setParams0(row.get("params_0", String.class));
            domain.setParams1(row.get("params_1", String.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Disables, OutboundRow> {

        public OutboundRow convert(Disables source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSourceType()).ifPresent(e -> row.put("sourceType", Parameter.from(e)));
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            Optional.ofNullable(source.getParams0()).ifPresent(e -> row.put("params_0", Parameter.from(e)));
            Optional.ofNullable(source.getParams1()).ifPresent(e -> row.put("params_1", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
