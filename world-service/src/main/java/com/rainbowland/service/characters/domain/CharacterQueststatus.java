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
@Table("character_queststatus")
public class CharacterQueststatus {

    @Column("guid")
    private Long guid;
    @Column("quest")
    private Integer quest;
    @Column("status")
    private Integer status;
    @Column("timer")
    private Long timer;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterQueststatus> {

        public CharacterQueststatus convert(Row row) {
            CharacterQueststatus domain = new CharacterQueststatus();
            domain.setGuid(row.get("guid", Long.class));
            domain.setQuest(row.get("quest", Integer.class));
            domain.setStatus(row.get("status", Integer.class));
            domain.setTimer(row.get("timer", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterQueststatus, OutboundRow> {

        public OutboundRow convert(CharacterQueststatus source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getQuest()).ifPresent(e -> row.put("quest", Parameter.from(e)));
            Optional.ofNullable(source.getStatus()).ifPresent(e -> row.put("status", Parameter.from(e)));
            Optional.ofNullable(source.getTimer()).ifPresent(e -> row.put("timer", Parameter.from(e)));
            return row;
        }
    }

}
