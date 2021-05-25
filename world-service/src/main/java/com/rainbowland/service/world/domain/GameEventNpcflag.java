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
@Table("game_event_npcflag")
public class GameEventNpcflag {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("guid")
    private Long guid;
    @Column("npcflag")
    private Long npcflag;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventNpcflag> {

        public GameEventNpcflag convert(Row row) {
            GameEventNpcflag domain = new GameEventNpcflag();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setGuid(row.get("guid", Long.class));
            domain.setNpcflag(row.get("npcflag", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventNpcflag, OutboundRow> {

        public OutboundRow convert(GameEventNpcflag source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getNpcflag()).ifPresent(e -> row.put("npcflag", Parameter.from(e)));
            return row;
        }
    }

}
