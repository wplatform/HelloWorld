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
@Table("spell_aura_restrictions")
public class SpellAuraRestrictions {

    @Column("ID")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("CasterAuraState")
    private Integer casterAuraState;
    @Column("TargetAuraState")
    private Integer targetAuraState;
    @Column("ExcludeCasterAuraState")
    private Integer excludeCasterAuraState;
    @Column("ExcludeTargetAuraState")
    private Integer excludeTargetAuraState;
    @Column("CasterAuraSpell")
    private Integer casterAuraSpell;
    @Column("TargetAuraSpell")
    private Integer targetAuraSpell;
    @Column("ExcludeCasterAuraSpell")
    private Integer excludeCasterAuraSpell;
    @Column("ExcludeTargetAuraSpell")
    private Integer excludeTargetAuraSpell;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellAuraRestrictions> {

        public SpellAuraRestrictions convert(Row row) {
            SpellAuraRestrictions domain = new SpellAuraRestrictions();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setCasterAuraState(row.get("CasterAuraState", Integer.class));
            domain.setTargetAuraState(row.get("TargetAuraState", Integer.class));
            domain.setExcludeCasterAuraState(row.get("ExcludeCasterAuraState", Integer.class));
            domain.setExcludeTargetAuraState(row.get("ExcludeTargetAuraState", Integer.class));
            domain.setCasterAuraSpell(row.get("CasterAuraSpell", Integer.class));
            domain.setTargetAuraSpell(row.get("TargetAuraSpell", Integer.class));
            domain.setExcludeCasterAuraSpell(row.get("ExcludeCasterAuraSpell", Integer.class));
            domain.setExcludeTargetAuraSpell(row.get("ExcludeTargetAuraSpell", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellAuraRestrictions, OutboundRow> {

        public OutboundRow convert(SpellAuraRestrictions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getCasterAuraState()).ifPresent(e -> row.put("CasterAuraState", Parameter.from(e)));
            Optional.ofNullable(source.getTargetAuraState()).ifPresent(e -> row.put("TargetAuraState", Parameter.from(e)));
            Optional.ofNullable(source.getExcludeCasterAuraState()).ifPresent(e -> row.put("ExcludeCasterAuraState", Parameter.from(e)));
            Optional.ofNullable(source.getExcludeTargetAuraState()).ifPresent(e -> row.put("ExcludeTargetAuraState", Parameter.from(e)));
            Optional.ofNullable(source.getCasterAuraSpell()).ifPresent(e -> row.put("CasterAuraSpell", Parameter.from(e)));
            Optional.ofNullable(source.getTargetAuraSpell()).ifPresent(e -> row.put("TargetAuraSpell", Parameter.from(e)));
            Optional.ofNullable(source.getExcludeCasterAuraSpell()).ifPresent(e -> row.put("ExcludeCasterAuraSpell", Parameter.from(e)));
            Optional.ofNullable(source.getExcludeTargetAuraSpell()).ifPresent(e -> row.put("ExcludeTargetAuraSpell", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
