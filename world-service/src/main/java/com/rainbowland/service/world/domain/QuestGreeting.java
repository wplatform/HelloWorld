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
@Table("quest_greeting")
public class QuestGreeting {

    @Column("ID")
    private Integer id;
    @Column("Type")
    private Integer type;
    @Column("GreetEmoteType")
    private Integer greetEmoteType;
    @Column("GreetEmoteDelay")
    private Integer greetEmoteDelay;
    @Column("Greeting")
    private String greeting;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestGreeting> {

        public QuestGreeting convert(Row row) {
            QuestGreeting domain = new QuestGreeting();
            domain.setId(row.get("ID", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setGreetEmoteType(row.get("GreetEmoteType", Integer.class));
            domain.setGreetEmoteDelay(row.get("GreetEmoteDelay", Integer.class));
            domain.setGreeting(row.get("Greeting", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestGreeting, OutboundRow> {

        public OutboundRow convert(QuestGreeting source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getGreetEmoteType()).ifPresent(e -> row.put("GreetEmoteType", Parameter.from(e)));
            Optional.ofNullable(source.getGreetEmoteDelay()).ifPresent(e -> row.put("GreetEmoteDelay", Parameter.from(e)));
            Optional.ofNullable(source.getGreeting()).ifPresent(e -> row.put("Greeting", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
