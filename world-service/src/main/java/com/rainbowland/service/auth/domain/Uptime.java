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
@Table("uptime")
public class Uptime {

    @Column("realmid")
    private Integer realmid;
    @Column("starttime")
    private Long starttime;
    @Column("uptime")
    private Long uptime;
    @Column("maxplayers")
    private Integer maxplayers;
    @Column("revision")
    private String revision;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Uptime> {

        public Uptime convert(Row row) {
            Uptime domain = new Uptime();
            domain.setRealmid(row.get("realmid", Integer.class));
            domain.setStarttime(row.get("starttime", Long.class));
            domain.setUptime(row.get("uptime", Long.class));
            domain.setMaxplayers(row.get("maxplayers", Integer.class));
            domain.setRevision(row.get("revision", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Uptime, OutboundRow> {

        public OutboundRow convert(Uptime source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRealmid()).ifPresent(e -> row.put("realmid", Parameter.from(e)));
            Optional.ofNullable(source.getStarttime()).ifPresent(e -> row.put("starttime", Parameter.from(e)));
            Optional.ofNullable(source.getUptime()).ifPresent(e -> row.put("uptime", Parameter.from(e)));
            Optional.ofNullable(source.getMaxplayers()).ifPresent(e -> row.put("maxplayers", Parameter.from(e)));
            Optional.ofNullable(source.getRevision()).ifPresent(e -> row.put("revision", Parameter.from(e)));
            return row;
        }
    }

}
