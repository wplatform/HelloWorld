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
@Table("character_spell")
public class CharacterSpell {

    @Column("guid")
    private Long guid;
    @Column("spell")
    private Integer spell;
    @Column("active")
    private Integer active;
    @Column("disabled")
    private Integer disabled;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterSpell> {

        public CharacterSpell convert(Row row) {
            CharacterSpell domain = new CharacterSpell();
            domain.setGuid(row.get("guid", Long.class));
            domain.setSpell(row.get("spell", Integer.class));
            domain.setActive(row.get("active", Integer.class));
            domain.setDisabled(row.get("disabled", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterSpell, OutboundRow> {

        public OutboundRow convert(CharacterSpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("spell", Parameter.from(e)));
            Optional.ofNullable(source.getActive()).ifPresent(e -> row.put("active", Parameter.from(e)));
            Optional.ofNullable(source.getDisabled()).ifPresent(e -> row.put("disabled", Parameter.from(e)));
            return row;
        }
    }

}
