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
@Table("game_event_pool")
public class GameEventPool {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("pool_entry")
    private Integer poolEntry;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventPool> {

        public GameEventPool convert(Row row) {
            GameEventPool domain = new GameEventPool();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setPoolEntry(row.get("pool_entry", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventPool, OutboundRow> {

        public OutboundRow convert(GameEventPool source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getPoolEntry()).ifPresent(e -> row.put("pool_entry", Parameter.from(e)));
            return row;
        }
    }

}
