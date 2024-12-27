package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Effect")
    private Integer effect;

    @Column(name = "EffectBasePoints")
    private Integer effectBasePoints;

    @Column(name = "EffectIndex")
    private Integer effectIndex;

    @Column(name = "EffectAura")
    private Integer effectAura;

    @Column(name = "DifficultyID")
    private Integer difficultyID;

    @Column(name = "EffectAmplitude")
    private Float effectAmplitude;

    @Column(name = "EffectAuraPeriod")
    private Integer effectAuraPeriod;

    @Column(name = "EffectBonusCoefficient")
    private Float effectBonusCoefficient;

    @Column(name = "EffectChainAmplitude")
    private Float effectChainAmplitude;

    @Column(name = "EffectChainTargets")
    private Integer effectChainTargets;

    @Column(name = "EffectDieSides")
    private Integer effectDieSides;

    @Column(name = "EffectItemType")
    private Integer effectItemType;

    @Column(name = "EffectMechanic")
    private Integer effectMechanic;

    @Column(name = "EffectPointsPerResource")
    private Float effectPointsPerResource;

    @Column(name = "EffectRealPointsPerLevel")
    private Float effectRealPointsPerLevel;

    @Column(name = "EffectTriggerSpell")
    private Integer effectTriggerSpell;

    @Column(name = "EffectPosFacing")
    private Float effectPosFacing;

    @Column(name = "EffectAttributes")
    private Integer effectAttributes;

    @Column(name = "BonusCoefficientFromAP")
    private Float bonusCoefficientFromAP;

    @Column(name = "PvpMultiplier")
    private Float pvpMultiplier;

    @Column(name = "Coefficient")
    private Float coefficient;

    @Column(name = "Variance")
    private Float variance;

    @Column(name = "ResourceCoefficient")
    private Float resourceCoefficient;

    @Column(name = "GroupSizeBasePointsCoefficient")
    private Float groupSizeBasePointsCoefficient;

    @Column(name = "EffectSpellClassMask1")
    private Integer effectSpellClassMask1;

    @Column(name = "EffectSpellClassMask2")
    private Integer effectSpellClassMask2;

    @Column(name = "EffectSpellClassMask3")
    private Integer effectSpellClassMask3;

    @Column(name = "EffectSpellClassMask4")
    private Integer effectSpellClassMask4;

    @Column(name = "EffectMiscValue1")
    private Integer effectMiscValue1;

    @Column(name = "EffectMiscValue2")
    private Integer effectMiscValue2;

    @Column(name = "EffectRadiusIndex1")
    private Integer effectRadiusIndex1;

    @Column(name = "EffectRadiusIndex2")
    private Integer effectRadiusIndex2;

    @Column(name = "ImplicitTarget1")
    private Integer implicitTarget1;

    @Column(name = "ImplicitTarget2")
    private Integer implicitTarget2;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
