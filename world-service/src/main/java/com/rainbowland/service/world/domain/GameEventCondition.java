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
@Table("game_event_condition")
public class GameEventCondition {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("condition_id")
    private Integer conditionId;
    @Column("req_num")
    private Double reqNum;
    @Column("max_world_state_field")
    private Integer maxWorldStateField;
    @Column("done_world_state_field")
    private Integer doneWorldStateField;
    @Column("description")
    private String description;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventCondition> {

        public GameEventCondition convert(Row row) {
            GameEventCondition domain = new GameEventCondition();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setConditionId(row.get("condition_id", Integer.class));
            domain.setReqNum(row.get("req_num", Double.class));
            domain.setMaxWorldStateField(row.get("max_world_state_field", Integer.class));
            domain.setDoneWorldStateField(row.get("done_world_state_field", Integer.class));
            domain.setDescription(row.get("description", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventCondition, OutboundRow> {

        public OutboundRow convert(GameEventCondition source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getConditionId()).ifPresent(e -> row.put("condition_id", Parameter.from(e)));
            Optional.ofNullable(source.getReqNum()).ifPresent(e -> row.put("req_num", Parameter.from(e)));
            Optional.ofNullable(source.getMaxWorldStateField()).ifPresent(e -> row.put("max_world_state_field", Parameter.from(e)));
            Optional.ofNullable(source.getDoneWorldStateField()).ifPresent(e -> row.put("done_world_state_field", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("description", Parameter.from(e)));
            return row;
        }
    }

}
