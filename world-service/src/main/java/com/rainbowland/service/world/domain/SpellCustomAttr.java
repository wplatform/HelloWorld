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
@Table("spell_custom_attr")
public class SpellCustomAttr {

    @Column("entry")
    private Integer entry;
    @Column("attributes")
    private Integer attributes;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellCustomAttr> {

        public SpellCustomAttr convert(Row row) {
            SpellCustomAttr domain = new SpellCustomAttr();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setAttributes(row.get("attributes", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellCustomAttr, OutboundRow> {

        public OutboundRow convert(SpellCustomAttr source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes()).ifPresent(e -> row.put("attributes", Parameter.from(e)));
            return row;
        }
    }

}
