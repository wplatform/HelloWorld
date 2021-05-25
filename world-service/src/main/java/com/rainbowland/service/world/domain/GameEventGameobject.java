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
@Table("game_event_gameobject")
public class GameEventGameobject {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("guid")
    private Long guid;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventGameobject> {

        public GameEventGameobject convert(Row row) {
            GameEventGameobject domain = new GameEventGameobject();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setGuid(row.get("guid", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventGameobject, OutboundRow> {

        public OutboundRow convert(GameEventGameobject source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            return row;
        }
    }

}
