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
@Table("character_action")
public class CharacterAction {

    @Column("guid")
    private Long guid;
    @Column("spec")
    private Integer spec;
    @Column("button")
    private Integer button;
    @Column("action")
    private Integer action;
    @Column("type")
    private Integer type;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterAction> {

        public CharacterAction convert(Row row) {
            CharacterAction domain = new CharacterAction();
            domain.setGuid(row.get("guid", Long.class));
            domain.setSpec(row.get("spec", Integer.class));
            domain.setButton(row.get("button", Integer.class));
            domain.setAction(row.get("action", Integer.class));
            domain.setType(row.get("type", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterAction, OutboundRow> {

        public OutboundRow convert(CharacterAction source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSpec()).ifPresent(e -> row.put("spec", Parameter.from(e)));
            Optional.ofNullable(source.getButton()).ifPresent(e -> row.put("button", Parameter.from(e)));
            Optional.ofNullable(source.getAction()).ifPresent(e -> row.put("action", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            return row;
        }
    }

}
