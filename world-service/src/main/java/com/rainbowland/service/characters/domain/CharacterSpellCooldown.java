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
@Table("character_spell_cooldown")
public class CharacterSpellCooldown {

    @Column("guid")
    private Long guid;
    @Column("spell")
    private Integer spell;
    @Column("item")
    private Integer item;
    @Column("time")
    private Long time;
    @Column("categoryId")
    private Integer categoryId;
    @Column("categoryEnd")
    private Long categoryEnd;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterSpellCooldown> {

        public CharacterSpellCooldown convert(Row row) {
            CharacterSpellCooldown domain = new CharacterSpellCooldown();
            domain.setGuid(row.get("guid", Long.class));
            domain.setSpell(row.get("spell", Integer.class));
            domain.setItem(row.get("item", Integer.class));
            domain.setTime(row.get("time", Long.class));
            domain.setCategoryId(row.get("categoryId", Integer.class));
            domain.setCategoryEnd(row.get("categoryEnd", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterSpellCooldown, OutboundRow> {

        public OutboundRow convert(CharacterSpellCooldown source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("spell", Parameter.from(e)));
            Optional.ofNullable(source.getItem()).ifPresent(e -> row.put("item", Parameter.from(e)));
            Optional.ofNullable(source.getTime()).ifPresent(e -> row.put("time", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryId()).ifPresent(e -> row.put("categoryId", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryEnd()).ifPresent(e -> row.put("categoryEnd", Parameter.from(e)));
            return row;
        }
    }

}
