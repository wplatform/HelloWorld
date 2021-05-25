package com.rainbowland.service.hotfixes.domain;

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

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
    @Column("LearnSpellID")
    private Integer learnSpellId;
    @Column("OverridesSpellID")
    private Integer overridesSpellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellLearnSpell> {

        public SpellLearnSpell convert(Row row) {
            SpellLearnSpell domain = new SpellLearnSpell();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setLearnSpellId(row.get("LearnSpellID", Integer.class));
            domain.setOverridesSpellId(row.get("OverridesSpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellLearnSpell, OutboundRow> {

        public OutboundRow convert(SpellLearnSpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getLearnSpellId()).ifPresent(e -> row.put("LearnSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getOverridesSpellId()).ifPresent(e -> row.put("OverridesSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
