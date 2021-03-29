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
@Table("autobroadcast")
public class Autobroadcast {

    @Column("realmid")
    private Integer realmid;
    @Column("id")
    private Integer id;
    @Column("weight")
    private Integer weight;
    @Column("text")
    private String text;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Autobroadcast> {

        public Autobroadcast convert(Row row) {
            Autobroadcast domain = new Autobroadcast();
            domain.setRealmid(row.get("realmid", Integer.class));
            domain.setId(row.get("id", Integer.class));
            domain.setWeight(row.get("weight", Integer.class));
            domain.setText(row.get("text", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Autobroadcast, OutboundRow> {

        public OutboundRow convert(Autobroadcast source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRealmid()).ifPresent(e -> row.put("realmid", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getWeight()).ifPresent(e -> row.put("weight", Parameter.from(e)));
            Optional.ofNullable(source.getText()).ifPresent(e -> row.put("text", Parameter.from(e)));
            return row;
        }
    }

}
