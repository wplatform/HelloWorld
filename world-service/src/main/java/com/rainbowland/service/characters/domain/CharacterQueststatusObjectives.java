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
@Table("character_queststatus_objectives")
public class CharacterQueststatusObjectives {

    @Column("guid")
    private Long guid;
    @Column("quest")
    private Integer quest;
    @Column("objective")
    private Integer objective;
    @Column("data")
    private Integer data;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterQueststatusObjectives> {

        public CharacterQueststatusObjectives convert(Row row) {
            CharacterQueststatusObjectives domain = new CharacterQueststatusObjectives();
            domain.setGuid(row.get("guid", Long.class));
            domain.setQuest(row.get("quest", Integer.class));
            domain.setObjective(row.get("objective", Integer.class));
            domain.setData(row.get("data", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterQueststatusObjectives, OutboundRow> {

        public OutboundRow convert(CharacterQueststatusObjectives source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getQuest()).ifPresent(e -> row.put("quest", Parameter.from(e)));
            Optional.ofNullable(source.getObjective()).ifPresent(e -> row.put("objective", Parameter.from(e)));
            Optional.ofNullable(source.getData()).ifPresent(e -> row.put("data", Parameter.from(e)));
            return row;
        }
    }

}
