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
@Table("game_event_condition_save")
public class GameEventConditionSave {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("condition_id")
    private Integer conditionId;
    @Column("done")
    private Double done;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventConditionSave> {

        public GameEventConditionSave convert(Row row) {
            GameEventConditionSave domain = new GameEventConditionSave();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setConditionId(row.get("condition_id", Integer.class));
            domain.setDone(row.get("done", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventConditionSave, OutboundRow> {

        public OutboundRow convert(GameEventConditionSave source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getConditionId()).ifPresent(e -> row.put("condition_id", Parameter.from(e)));
            Optional.ofNullable(source.getDone()).ifPresent(e -> row.put("done", Parameter.from(e)));
            return row;
        }
    }

}
