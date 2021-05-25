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
@Table("game_event_seasonal_questrelation")
public class GameEventSeasonalQuestrelation {

    @Column("questId")
    private Integer questId;
    @Column("eventEntry")
    private Integer eventEntry;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventSeasonalQuestrelation> {

        public GameEventSeasonalQuestrelation convert(Row row) {
            GameEventSeasonalQuestrelation domain = new GameEventSeasonalQuestrelation();
            domain.setQuestId(row.get("questId", Integer.class));
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventSeasonalQuestrelation, OutboundRow> {

        public OutboundRow convert(GameEventSeasonalQuestrelation source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("questId", Parameter.from(e)));
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            return row;
        }
    }

}
