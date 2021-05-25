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
@Table("game_event_battleground_holiday")
public class GameEventBattlegroundHoliday {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("bgflag")
    private Integer bgflag;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventBattlegroundHoliday> {

        public GameEventBattlegroundHoliday convert(Row row) {
            GameEventBattlegroundHoliday domain = new GameEventBattlegroundHoliday();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setBgflag(row.get("bgflag", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventBattlegroundHoliday, OutboundRow> {

        public OutboundRow convert(GameEventBattlegroundHoliday source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getBgflag()).ifPresent(e -> row.put("bgflag", Parameter.from(e)));
            return row;
        }
    }

}
