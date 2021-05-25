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
@Table("game_event_arena_seasons")
public class GameEventArenaSeasons {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("season")
    private Integer season;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventArenaSeasons> {

        public GameEventArenaSeasons convert(Row row) {
            GameEventArenaSeasons domain = new GameEventArenaSeasons();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setSeason(row.get("season", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventArenaSeasons, OutboundRow> {

        public OutboundRow convert(GameEventArenaSeasons source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getSeason()).ifPresent(e -> row.put("season", Parameter.from(e)));
            return row;
        }
    }

}
