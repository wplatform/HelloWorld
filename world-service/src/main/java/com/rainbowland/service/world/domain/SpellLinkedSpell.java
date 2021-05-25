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
@Table("spell_linked_spell")
public class SpellLinkedSpell {

    @Column("spell_trigger")
    private Integer spellTrigger;
    @Column("spell_effect")
    private Integer spellEffect;
    @Column("type")
    private Integer type;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellLinkedSpell> {

        public SpellLinkedSpell convert(Row row) {
            SpellLinkedSpell domain = new SpellLinkedSpell();
            domain.setSpellTrigger(row.get("spell_trigger", Integer.class));
            domain.setSpellEffect(row.get("spell_effect", Integer.class));
            domain.setType(row.get("type", Integer.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellLinkedSpell, OutboundRow> {

        public OutboundRow convert(SpellLinkedSpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellTrigger()).ifPresent(e -> row.put("spell_trigger", Parameter.from(e)));
            Optional.ofNullable(source.getSpellEffect()).ifPresent(e -> row.put("spell_effect", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
