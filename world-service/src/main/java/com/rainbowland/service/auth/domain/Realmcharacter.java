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
@Table("realmcharacters")
public class Realmcharacter {

    @Column("realmid")
    private Integer realmid;
    @Column("acctid")
    private Long acctid;
    @Column("numchars")
    private Integer numchars;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Realmcharacter> {

        public Realmcharacter convert(Row row) {
            Realmcharacter domain = new Realmcharacter();
            domain.setRealmid(row.get("realmid", Integer.class));
            domain.setAcctid(row.get("acctid", Long.class));
            domain.setNumchars(row.get("numchars", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Realmcharacter, OutboundRow> {

        public OutboundRow convert(Realmcharacter source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRealmid()).ifPresent(e -> row.put("realmid", Parameter.from(e)));
            Optional.ofNullable(source.getAcctid()).ifPresent(e -> row.put("acctid", Parameter.from(e)));
            Optional.ofNullable(source.getNumchars()).ifPresent(e -> row.put("numchars", Parameter.from(e)));
            return row;
        }
    }

}
