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
@Table("bugreport")
public class Bugreport {

    @Column("id")
    private Integer id;
    @Column("type")
    private String type;
    @Column("content")
    private String content;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Bugreport> {

        public Bugreport convert(Row row) {
            Bugreport domain = new Bugreport();
            domain.setId(row.get("id", Integer.class));
            domain.setType(row.get("type", String.class));
            domain.setContent(row.get("content", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Bugreport, OutboundRow> {

        public OutboundRow convert(Bugreport source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getContent()).ifPresent(e -> row.put("content", Parameter.from(e)));
            return row;
        }
    }

}
