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
@Table("trainer_locale")
public class TrainerLocale {

    @Column("Id")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Greeting_lang")
    private String greetingLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TrainerLocale> {

        public TrainerLocale convert(Row row) {
            TrainerLocale domain = new TrainerLocale();
            domain.setId(row.get("Id", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setGreetingLang(row.get("Greeting_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TrainerLocale, OutboundRow> {

        public OutboundRow convert(TrainerLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getGreetingLang()).ifPresent(e -> row.put("Greeting_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
