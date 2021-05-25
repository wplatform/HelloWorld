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
@Table("character_queststatus_objectives_criteria")
public class CharacterQueststatusObjectivesCriteria {

    @Column("guid")
    private Long guid;
    @Column("questObjectiveId")
    private Integer questObjectiveId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterQueststatusObjectivesCriteria> {

        public CharacterQueststatusObjectivesCriteria convert(Row row) {
            CharacterQueststatusObjectivesCriteria domain = new CharacterQueststatusObjectivesCriteria();
            domain.setGuid(row.get("guid", Long.class));
            domain.setQuestObjectiveId(row.get("questObjectiveId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterQueststatusObjectivesCriteria, OutboundRow> {

        public OutboundRow convert(CharacterQueststatusObjectivesCriteria source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getQuestObjectiveId()).ifPresent(e -> row.put("questObjectiveId", Parameter.from(e)));
            return row;
        }
    }

}
