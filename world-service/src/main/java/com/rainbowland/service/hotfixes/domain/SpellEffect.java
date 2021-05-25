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
@Table("spell_effect")
public class SpellEffect {

    @Column("ID")
    private Integer id;
    @Column("EffectAura")
    private Integer effectAura;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("EffectIndex")
    private Integer effectIndex;
    @Column("Effect")
    private Integer effect;
    @Column("EffectAmplitude")
    private Double effectAmplitude;
    @Column("EffectAttributes")
    private Integer effectAttributes;
    @Column("EffectAuraPeriod")
    private Integer effectAuraPeriod;
    @Column("EffectBonusCoefficient")
    private Double effectBonusCoefficient;
    @Column("EffectChainAmplitude")
    private Double effectChainAmplitude;
    @Column("EffectChainTargets")
    private Integer effectChainTargets;
    @Column("EffectItemType")
    private Integer effectItemType;
    @Column("EffectMechanic")
    private Integer effectMechanic;
    @Column("EffectPointsPerResource")
    private Double effectPointsPerResource;
    @Column("EffectPosFacing")
    private Double effectPosFacing;
    @Column("EffectRealPointsPerLevel")
    private Double effectRealPointsPerLevel;
    @Column("EffectTriggerSpell")
    private Integer effectTriggerSpell;
    @Column("BonusCoefficientFromAP")
    private Double bonusCoefficientFromAp;
    @Column("PvpMultiplier")
    private Double pvpMultiplier;
    @Column("Coefficient")
    private Double coefficient;
    @Column("Variance")
    private Double variance;
    @Column("ResourceCoefficient")
    private Double resourceCoefficient;
    @Column("GroupSizeBasePointsCoefficient")
    private Double groupSizeBasePointsCoefficient;
    @Column("EffectBasePoints")
    private Double effectBasePoints;
    @Column("EffectMiscValue1")
    private Integer effectMiscValue1;
    @Column("EffectMiscValue2")
    private Integer effectMiscValue2;
    @Column("EffectRadiusIndex1")
    private Integer effectRadiusIndex1;
    @Column("EffectRadiusIndex2")
    private Integer effectRadiusIndex2;
    @Column("EffectSpellClassMask1")
    private Integer effectSpellClassMask1;
    @Column("EffectSpellClassMask2")
    private Integer effectSpellClassMask2;
    @Column("EffectSpellClassMask3")
    private Integer effectSpellClassMask3;
    @Column("EffectSpellClassMask4")
    private Integer effectSpellClassMask4;
    @Column("ImplicitTarget1")
    private Integer implicitTarget1;
    @Column("ImplicitTarget2")
    private Integer implicitTarget2;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellEffect> {

        public SpellEffect convert(Row row) {
            SpellEffect domain = new SpellEffect();
            domain.setId(row.get("ID", Integer.class));
            domain.setEffectAura(row.get("EffectAura", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setEffectIndex(row.get("EffectIndex", Integer.class));
            domain.setEffect(row.get("Effect", Integer.class));
            domain.setEffectAmplitude(row.get("EffectAmplitude", Double.class));
            domain.setEffectAttributes(row.get("EffectAttributes", Integer.class));
            domain.setEffectAuraPeriod(row.get("EffectAuraPeriod", Integer.class));
            domain.setEffectBonusCoefficient(row.get("EffectBonusCoefficient", Double.class));
            domain.setEffectChainAmplitude(row.get("EffectChainAmplitude", Double.class));
            domain.setEffectChainTargets(row.get("EffectChainTargets", Integer.class));
            domain.setEffectItemType(row.get("EffectItemType", Integer.class));
            domain.setEffectMechanic(row.get("EffectMechanic", Integer.class));
            domain.setEffectPointsPerResource(row.get("EffectPointsPerResource", Double.class));
            domain.setEffectPosFacing(row.get("EffectPosFacing", Double.class));
            domain.setEffectRealPointsPerLevel(row.get("EffectRealPointsPerLevel", Double.class));
            domain.setEffectTriggerSpell(row.get("EffectTriggerSpell", Integer.class));
            domain.setBonusCoefficientFromAp(row.get("BonusCoefficientFromAP", Double.class));
            domain.setPvpMultiplier(row.get("PvpMultiplier", Double.class));
            domain.setCoefficient(row.get("Coefficient", Double.class));
            domain.setVariance(row.get("Variance", Double.class));
            domain.setResourceCoefficient(row.get("ResourceCoefficient", Double.class));
            domain.setGroupSizeBasePointsCoefficient(row.get("GroupSizeBasePointsCoefficient", Double.class));
            domain.setEffectBasePoints(row.get("EffectBasePoints", Double.class));
            domain.setEffectMiscValue1(row.get("EffectMiscValue1", Integer.class));
            domain.setEffectMiscValue2(row.get("EffectMiscValue2", Integer.class));
            domain.setEffectRadiusIndex1(row.get("EffectRadiusIndex1", Integer.class));
            domain.setEffectRadiusIndex2(row.get("EffectRadiusIndex2", Integer.class));
            domain.setEffectSpellClassMask1(row.get("EffectSpellClassMask1", Integer.class));
            domain.setEffectSpellClassMask2(row.get("EffectSpellClassMask2", Integer.class));
            domain.setEffectSpellClassMask3(row.get("EffectSpellClassMask3", Integer.class));
            domain.setEffectSpellClassMask4(row.get("EffectSpellClassMask4", Integer.class));
            domain.setImplicitTarget1(row.get("ImplicitTarget1", Integer.class));
            domain.setImplicitTarget2(row.get("ImplicitTarget2", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellEffect, OutboundRow> {

        public OutboundRow convert(SpellEffect source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getEffectAura()).ifPresent(e -> row.put("EffectAura", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getEffectIndex()).ifPresent(e -> row.put("EffectIndex", Parameter.from(e)));
            Optional.ofNullable(source.getEffect()).ifPresent(e -> row.put("Effect", Parameter.from(e)));
            Optional.ofNullable(source.getEffectAmplitude()).ifPresent(e -> row.put("EffectAmplitude", Parameter.from(e)));
            Optional.ofNullable(source.getEffectAttributes()).ifPresent(e -> row.put("EffectAttributes", Parameter.from(e)));
            Optional.ofNullable(source.getEffectAuraPeriod()).ifPresent(e -> row.put("EffectAuraPeriod", Parameter.from(e)));
            Optional.ofNullable(source.getEffectBonusCoefficient()).ifPresent(e -> row.put("EffectBonusCoefficient", Parameter.from(e)));
            Optional.ofNullable(source.getEffectChainAmplitude()).ifPresent(e -> row.put("EffectChainAmplitude", Parameter.from(e)));
            Optional.ofNullable(source.getEffectChainTargets()).ifPresent(e -> row.put("EffectChainTargets", Parameter.from(e)));
            Optional.ofNullable(source.getEffectItemType()).ifPresent(e -> row.put("EffectItemType", Parameter.from(e)));
            Optional.ofNullable(source.getEffectMechanic()).ifPresent(e -> row.put("EffectMechanic", Parameter.from(e)));
            Optional.ofNullable(source.getEffectPointsPerResource()).ifPresent(e -> row.put("EffectPointsPerResource", Parameter.from(e)));
            Optional.ofNullable(source.getEffectPosFacing()).ifPresent(e -> row.put("EffectPosFacing", Parameter.from(e)));
            Optional.ofNullable(source.getEffectRealPointsPerLevel()).ifPresent(e -> row.put("EffectRealPointsPerLevel", Parameter.from(e)));
            Optional.ofNullable(source.getEffectTriggerSpell()).ifPresent(e -> row.put("EffectTriggerSpell", Parameter.from(e)));
            Optional.ofNullable(source.getBonusCoefficientFromAp()).ifPresent(e -> row.put("BonusCoefficientFromAP", Parameter.from(e)));
            Optional.ofNullable(source.getPvpMultiplier()).ifPresent(e -> row.put("PvpMultiplier", Parameter.from(e)));
            Optional.ofNullable(source.getCoefficient()).ifPresent(e -> row.put("Coefficient", Parameter.from(e)));
            Optional.ofNullable(source.getVariance()).ifPresent(e -> row.put("Variance", Parameter.from(e)));
            Optional.ofNullable(source.getResourceCoefficient()).ifPresent(e -> row.put("ResourceCoefficient", Parameter.from(e)));
            Optional.ofNullable(source.getGroupSizeBasePointsCoefficient()).ifPresent(e -> row.put("GroupSizeBasePointsCoefficient", Parameter.from(e)));
            Optional.ofNullable(source.getEffectBasePoints()).ifPresent(e -> row.put("EffectBasePoints", Parameter.from(e)));
            Optional.ofNullable(source.getEffectMiscValue1()).ifPresent(e -> row.put("EffectMiscValue1", Parameter.from(e)));
            Optional.ofNullable(source.getEffectMiscValue2()).ifPresent(e -> row.put("EffectMiscValue2", Parameter.from(e)));
            Optional.ofNullable(source.getEffectRadiusIndex1()).ifPresent(e -> row.put("EffectRadiusIndex1", Parameter.from(e)));
            Optional.ofNullable(source.getEffectRadiusIndex2()).ifPresent(e -> row.put("EffectRadiusIndex2", Parameter.from(e)));
            Optional.ofNullable(source.getEffectSpellClassMask1()).ifPresent(e -> row.put("EffectSpellClassMask1", Parameter.from(e)));
            Optional.ofNullable(source.getEffectSpellClassMask2()).ifPresent(e -> row.put("EffectSpellClassMask2", Parameter.from(e)));
            Optional.ofNullable(source.getEffectSpellClassMask3()).ifPresent(e -> row.put("EffectSpellClassMask3", Parameter.from(e)));
            Optional.ofNullable(source.getEffectSpellClassMask4()).ifPresent(e -> row.put("EffectSpellClassMask4", Parameter.from(e)));
            Optional.ofNullable(source.getImplicitTarget1()).ifPresent(e -> row.put("ImplicitTarget1", Parameter.from(e)));
            Optional.ofNullable(source.getImplicitTarget2()).ifPresent(e -> row.put("ImplicitTarget2", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
