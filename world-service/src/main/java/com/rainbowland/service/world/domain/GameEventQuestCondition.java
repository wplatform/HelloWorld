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
@Table("game_event_quest_condition")
public class GameEventQuestCondition {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("quest")
    private Integer quest;
    @Column("condition_id")
    private Integer conditionId;
    @Column("num")
    private Double num;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventQuestCondition> {

        public GameEventQuestCondition convert(Row row) {
            GameEventQuestCondition domain = new GameEventQuestCondition();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setQuest(row.get("quest", Integer.class));
            domain.setConditionId(row.get("condition_id", Integer.class));
            domain.setNum(row.get("num", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventQuestCondition, OutboundRow> {

        public OutboundRow convert(GameEventQuestCondition source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getQuest()).ifPresent(e -> row.put("quest", Parameter.from(e)));
            Optional.ofNullable(source.getConditionId()).ifPresent(e -> row.put("condition_id", Parameter.from(e)));
            Optional.ofNullable(source.getNum()).ifPresent(e -> row.put("num", Parameter.from(e)));
            return row;
        }
    }

}
