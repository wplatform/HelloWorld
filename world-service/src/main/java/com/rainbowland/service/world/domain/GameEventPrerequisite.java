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
@Table("game_event_prerequisite")
public class GameEventPrerequisite {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("prerequisite_event")
    private Integer prerequisiteEvent;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventPrerequisite> {

        public GameEventPrerequisite convert(Row row) {
            GameEventPrerequisite domain = new GameEventPrerequisite();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setPrerequisiteEvent(row.get("prerequisite_event", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventPrerequisite, OutboundRow> {

        public OutboundRow convert(GameEventPrerequisite source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getPrerequisiteEvent()).ifPresent(e -> row.put("prerequisite_event", Parameter.from(e)));
            return row;
        }
    }

}
