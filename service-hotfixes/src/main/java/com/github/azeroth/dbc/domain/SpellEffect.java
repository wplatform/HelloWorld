package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "spell_effect")
@Db2DataBind(name = "SpellEffect.db2", layoutHash = 0x3244098B, indexField = 0, parentIndexField = 29, fields = {
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "effect", type = Db2Type.INT),
        @Db2Field(name = "effectBasePoints", type = Db2Type.INT, signed = true),
        @Db2Field(name = "effectIndex", type = Db2Type.INT, signed = true),
        @Db2Field(name = "effectAura", type = Db2Type.INT, signed = true),
        @Db2Field(name = "difficultyID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "effectAmplitude", type = Db2Type.FLOAT),
        @Db2Field(name = "effectAuraPeriod", type = Db2Type.INT, signed = true),
        @Db2Field(name = "effectBonusCoefficient", type = Db2Type.FLOAT),
        @Db2Field(name = "effectChainAmplitude", type = Db2Type.FLOAT),
        @Db2Field(name = "effectChainTargets", type = Db2Type.INT, signed = true),
        @Db2Field(name = "effectDieSides", type = Db2Type.INT, signed = true),
        @Db2Field(name = "effectItemType", type = Db2Type.INT, signed = true),
        @Db2Field(name = "effectMechanic", type = Db2Type.INT, signed = true),
        @Db2Field(name = "effectPointsPerResource", type = Db2Type.FLOAT),
        @Db2Field(name = "effectRealPointsPerLevel", type = Db2Type.FLOAT),
        @Db2Field(name = "effectTriggerSpell", type = Db2Type.INT, signed = true),
        @Db2Field(name = "effectPosFacing", type = Db2Type.FLOAT),
        @Db2Field(name = "effectAttributes", type = Db2Type.INT, signed = true),
        @Db2Field(name = "bonusCoefficientFromAP", type = Db2Type.FLOAT),
        @Db2Field(name = "pvpMultiplier", type = Db2Type.FLOAT),
        @Db2Field(name = "coefficient", type = Db2Type.FLOAT),
        @Db2Field(name = "variance", type = Db2Type.FLOAT),
        @Db2Field(name = "resourceCoefficient", type = Db2Type.FLOAT),
        @Db2Field(name = "groupSizeBasePointsCoefficient", type = Db2Type.FLOAT),
        @Db2Field(name = {"effectSpellClassMask1", "effectSpellClassMask2", "effectSpellClassMask3", "effectSpellClassMask4"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"effectMiscValue1", "effectMiscValue2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"effectRadiusIndex1", "effectRadiusIndex2"}, type = Db2Type.INT),
        @Db2Field(name = {"implicitTarget1", "implicitTarget2"}, type = Db2Type.INT),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellEffect implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Effect")
    private Integer effect;

    @Column("EffectBasePoints")
    private Integer effectBasePoints;

    @Column("EffectIndex")
    private Integer effectIndex;

    @Column("EffectAura")
    private Integer effectAura;

    @Column("DifficultyID")
    private Integer difficultyID;

    @Column("EffectAmplitude")
    private Float effectAmplitude;

    @Column("EffectAuraPeriod")
    private Integer effectAuraPeriod;

    @Column("EffectBonusCoefficient")
    private Float effectBonusCoefficient;

    @Column("EffectChainAmplitude")
    private Float effectChainAmplitude;

    @Column("EffectChainTargets")
    private Integer effectChainTargets;

    @Column("EffectDieSides")
    private Integer effectDieSides;

    @Column("EffectItemType")
    private Integer effectItemType;

    @Column("EffectMechanic")
    private Integer effectMechanic;

    @Column("EffectPointsPerResource")
    private Float effectPointsPerResource;

    @Column("EffectRealPointsPerLevel")
    private Float effectRealPointsPerLevel;

    @Column("EffectTriggerSpell")
    private Integer effectTriggerSpell;

    @Column("EffectPosFacing")
    private Float effectPosFacing;

    @Column("EffectAttributes")
    private Integer effectAttributes;

    @Column("BonusCoefficientFromAP")
    private Float bonusCoefficientFromAP;

    @Column("PvpMultiplier")
    private Float pvpMultiplier;

    @Column("Coefficient")
    private Float coefficient;

    @Column("Variance")
    private Float variance;

    @Column("ResourceCoefficient")
    private Float resourceCoefficient;

    @Column("GroupSizeBasePointsCoefficient")
    private Float groupSizeBasePointsCoefficient;

    @Column("EffectSpellClassMask1")
    private Integer effectSpellClassMask1;

    @Column("EffectSpellClassMask2")
    private Integer effectSpellClassMask2;

    @Column("EffectSpellClassMask3")
    private Integer effectSpellClassMask3;

    @Column("EffectSpellClassMask4")
    private Integer effectSpellClassMask4;

    @Column("EffectMiscValue1")
    private Integer effectMiscValue1;

    @Column("EffectMiscValue2")
    private Integer effectMiscValue2;

    @Column("EffectRadiusIndex1")
    private Integer effectRadiusIndex1;

    @Column("EffectRadiusIndex2")
    private Integer effectRadiusIndex2;

    @Column("ImplicitTarget1")
    private Integer implicitTarget1;

    @Column("ImplicitTarget2")
    private Integer implicitTarget2;

    @Column("SpellID")
    private Integer spellID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
