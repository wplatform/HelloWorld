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
@Table("character_queststatus_weekly")
public class CharacterQueststatusWeekly {

    @Column("guid")
    private Long guid;
    @Column("quest")
    private Integer quest;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterQueststatusWeekly> {

        public CharacterQueststatusWeekly convert(Row row) {
            CharacterQueststatusWeekly domain = new CharacterQueststatusWeekly();
            domain.setGuid(row.get("guid", Long.class));
            domain.setQuest(row.get("quest", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterQueststatusWeekly, OutboundRow> {

        public OutboundRow convert(CharacterQueststatusWeekly source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getQuest()).ifPresent(e -> row.put("quest", Parameter.from(e)));
            return row;
        }
    }

}
