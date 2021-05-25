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
@Table("quest_greeting_locale")
public class QuestGreetingLocale {

    @Column("ID")
    private Integer id;
    @Column("type")
    private Integer type;
    @Column("locale")
    private String locale;
    @Column("Greeting")
    private String greeting;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestGreetingLocale> {

        public QuestGreetingLocale convert(Row row) {
            QuestGreetingLocale domain = new QuestGreetingLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setType(row.get("type", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setGreeting(row.get("Greeting", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestGreetingLocale, OutboundRow> {

        public OutboundRow convert(QuestGreetingLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getGreeting()).ifPresent(e -> row.put("Greeting", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
