package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "spell_item_enchantment")
@Db2DataBind(name = "SpellItemEnchantment.db2", layoutHash = 0x80DEA734, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = {"effectArg1", "effectArg2", "effectArg3"}, type = Db2Type.INT),
        @Db2Field(name = {"effectScalingPoints1", "effectScalingPoints2", "effectScalingPoints3"}, type = Db2Type.FLOAT),
        @Db2Field(name = "transmogCost", type = Db2Type.INT),
        @Db2Field(name = "iconFileDataID", type = Db2Type.INT),
        @Db2Field(name = {"effectPointsMin1", "effectPointsMin2", "effectPointsMin3"}, type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "itemVisual", type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "requiredSkillID", type = Db2Type.SHORT),
        @Db2Field(name = "requiredSkillRank", type = Db2Type.SHORT),
        @Db2Field(name = "itemLevel", type = Db2Type.SHORT),
        @Db2Field(name = "charges", type = Db2Type.BYTE),
        @Db2Field(name = {"effect1", "effect2", "effect3"}, type = Db2Type.BYTE),
        @Db2Field(name = "conditionID", type = Db2Type.BYTE),
        @Db2Field(name = "minLevel", type = Db2Type.BYTE),
        @Db2Field(name = "maxLevel", type = Db2Type.BYTE),
        @Db2Field(name = "scalingClass", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "scalingClassRestricted", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "transmogPlayerConditionID", type = Db2Type.INT)
})
public class SpellItemEnchantment implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("EffectArg1")
    private Integer effectArg1;

    @Column("EffectArg2")
    private Integer effectArg2;

    @Column("EffectArg3")
    private Integer effectArg3;

    @Column("EffectScalingPoints1")
    private Float effectScalingPoints1;

    @Column("EffectScalingPoints2")
    private Float effectScalingPoints2;

    @Column("EffectScalingPoints3")
    private Float effectScalingPoints3;

    @Column("TransmogCost")
    private Integer transmogCost;

    @Column("IconFileDataID")
    private Integer iconFileDataID;

    @Column("EffectPointsMin1")
    private Short effectPointsMin1;

    @Column("EffectPointsMin2")
    private Short effectPointsMin2;

    @Column("EffectPointsMin3")
    private Short effectPointsMin3;

    @Column("ItemVisual")
    private Short itemVisual;

    @Column("Flags")
    private Short flags;

    @Column("RequiredSkillID")
    private Short requiredSkillID;

    @Column("RequiredSkillRank")
    private Short requiredSkillRank;

    @Column("ItemLevel")
    private Short itemLevel;

    @Column("Charges")
    private Byte charges;

    @Column("Effect1")
    private Byte effect1;

    @Column("Effect2")
    private Byte effect2;

    @Column("Effect3")
    private Byte effect3;

    @Column("ConditionID")
    private Byte conditionID;

    @Column("MinLevel")
    private Byte minLevel;

    @Column("MaxLevel")
    private Byte maxLevel;

    @Column("ScalingClass")
    private Byte scalingClass;

    @Column("ScalingClassRestricted")
    private Byte scalingClassRestricted;

    @Column("TransmogPlayerConditionID")
    private Integer transmogPlayerConditionID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
