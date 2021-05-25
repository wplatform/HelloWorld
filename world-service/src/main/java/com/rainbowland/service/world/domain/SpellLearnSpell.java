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
@Table("spell_learn_spell")
public class SpellLearnSpell {

    @Column("entry")
    private Integer entry;
    @Column("SpellID")
    private Integer spellId;
    @Column("Active")
    private Integer active;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellLearnSpell> {

        public SpellLearnSpell convert(Row row) {
            SpellLearnSpell domain = new SpellLearnSpell();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setActive(row.get("Active", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellLearnSpell, OutboundRow> {

        public OutboundRow convert(SpellLearnSpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getActive()).ifPresent(e -> row.put("Active", Parameter.from(e)));
            return row;
        }
    }

}
