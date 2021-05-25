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
@Table("game_event_save")
public class GameEventSave {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("state")
    private Integer state;
    @Column("next_start")
    private Long nextStart;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventSave> {

        public GameEventSave convert(Row row) {
            GameEventSave domain = new GameEventSave();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setState(row.get("state", Integer.class));
            domain.setNextStart(row.get("next_start", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventSave, OutboundRow> {

        public OutboundRow convert(GameEventSave source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getState()).ifPresent(e -> row.put("state", Parameter.from(e)));
            Optional.ofNullable(source.getNextStart()).ifPresent(e -> row.put("next_start", Parameter.from(e)));
            return row;
        }
    }

}
