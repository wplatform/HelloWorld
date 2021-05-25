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
@Table("character_queststatus_objectives_criteria_progress")
public class CharacterQueststatusObjectivesCriteriaProgress {

    @Column("guid")
    private Long guid;
    @Column("criteriaId")
    private Integer criteriaId;
    @Column("counter")
    private Long counter;
    @Column("date")
    private Long date;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterQueststatusObjectivesCriteriaProgress> {

        public CharacterQueststatusObjectivesCriteriaProgress convert(Row row) {
            CharacterQueststatusObjectivesCriteriaProgress domain = new CharacterQueststatusObjectivesCriteriaProgress();
            domain.setGuid(row.get("guid", Long.class));
            domain.setCriteriaId(row.get("criteriaId", Integer.class));
            domain.setCounter(row.get("counter", Long.class));
            domain.setDate(row.get("date", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterQueststatusObjectivesCriteriaProgress, OutboundRow> {

        public OutboundRow convert(CharacterQueststatusObjectivesCriteriaProgress source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getCriteriaId()).ifPresent(e -> row.put("criteriaId", Parameter.from(e)));
            Optional.ofNullable(source.getCounter()).ifPresent(e -> row.put("counter", Parameter.from(e)));
            Optional.ofNullable(source.getDate()).ifPresent(e -> row.put("date", Parameter.from(e)));
            return row;
        }
    }

}
