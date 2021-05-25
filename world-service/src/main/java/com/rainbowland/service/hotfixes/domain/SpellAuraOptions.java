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
@Table("spell_aura_options")
public class SpellAuraOptions {

    @Column("ID")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("CumulativeAura")
    private Integer cumulativeAura;
    @Column("ProcCategoryRecovery")
    private Integer procCategoryRecovery;
    @Column("ProcChance")
    private Integer procChance;
    @Column("ProcCharges")
    private Integer procCharges;
    @Column("SpellProcsPerMinuteID")
    private Integer spellProcsPerMinuteId;
    @Column("ProcTypeMask1")
    private Integer procTypeMask1;
    @Column("ProcTypeMask2")
    private Integer procTypeMask2;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellAuraOptions> {

        public SpellAuraOptions convert(Row row) {
            SpellAuraOptions domain = new SpellAuraOptions();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setCumulativeAura(row.get("CumulativeAura", Integer.class));
            domain.setProcCategoryRecovery(row.get("ProcCategoryRecovery", Integer.class));
            domain.setProcChance(row.get("ProcChance", Integer.class));
            domain.setProcCharges(row.get("ProcCharges", Integer.class));
            domain.setSpellProcsPerMinuteId(row.get("SpellProcsPerMinuteID", Integer.class));
            domain.setProcTypeMask1(row.get("ProcTypeMask1", Integer.class));
            domain.setProcTypeMask2(row.get("ProcTypeMask2", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellAuraOptions, OutboundRow> {

        public OutboundRow convert(SpellAuraOptions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getCumulativeAura()).ifPresent(e -> row.put("CumulativeAura", Parameter.from(e)));
            Optional.ofNullable(source.getProcCategoryRecovery()).ifPresent(e -> row.put("ProcCategoryRecovery", Parameter.from(e)));
            Optional.ofNullable(source.getProcChance()).ifPresent(e -> row.put("ProcChance", Parameter.from(e)));
            Optional.ofNullable(source.getProcCharges()).ifPresent(e -> row.put("ProcCharges", Parameter.from(e)));
            Optional.ofNullable(source.getSpellProcsPerMinuteId()).ifPresent(e -> row.put("SpellProcsPerMinuteID", Parameter.from(e)));
            Optional.ofNullable(source.getProcTypeMask1()).ifPresent(e -> row.put("ProcTypeMask1", Parameter.from(e)));
            Optional.ofNullable(source.getProcTypeMask2()).ifPresent(e -> row.put("ProcTypeMask2", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
