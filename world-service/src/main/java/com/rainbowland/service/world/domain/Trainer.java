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
@Table("trainer")
public class Trainer {

    @Column("Id")
    private Integer id;
    @Column("Type")
    private Integer type;
    @Column("Greeting")
    private String greeting;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Trainer> {

        public Trainer convert(Row row) {
            Trainer domain = new Trainer();
            domain.setId(row.get("Id", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setGreeting(row.get("Greeting", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Trainer, OutboundRow> {

        public OutboundRow convert(Trainer source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getGreeting()).ifPresent(e -> row.put("Greeting", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
