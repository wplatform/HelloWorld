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
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "spell_shapeshift_form")
@Db2DataBind(name = "SpellShapeshiftForm.db2", layoutHash = 0x130819AF, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "damageVariance", type = Db2Type.FLOAT),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "combatRoundTime", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "mountTypeID", type = Db2Type.SHORT),
        @Db2Field(name = "creatureType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "bonusActionBar", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "attackIconFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"creatureDisplayID1", "creatureDisplayID2", "creatureDisplayID3", "creatureDisplayID4"}, type = Db2Type.INT),
        @Db2Field(name = {"presetSpellID1", "presetSpellID2", "presetSpellID3", "presetSpellID4", "presetSpellID5", "presetSpellID6", "presetSpellID7", "presetSpellID8"}, type = Db2Type.INT)
})
public class SpellShapeshiftForm implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "DamageVariance")
    private Float damageVariance;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "CombatRoundTime")
    private Short combatRoundTime;

    @Column(name = "MountTypeID")
    private Short mountTypeID;

    @Column(name = "CreatureType")
    private Byte creatureType;

    @Column(name = "BonusActionBar")
    private Byte bonusActionBar;

    @Column(name = "AttackIconFileID")
    private Integer attackIconFileID;

    @Column(name = "CreatureDisplayID1")
    private Integer creatureDisplayID1;

    @Column(name = "CreatureDisplayID2")
    private Integer creatureDisplayID2;

    @Column(name = "CreatureDisplayID3")
    private Integer creatureDisplayID3;

    @Column(name = "CreatureDisplayID4")
    private Integer creatureDisplayID4;

    @Column(name = "PresetSpellID1")
    private Integer presetSpellID1;

    @Column(name = "PresetSpellID2")
    private Integer presetSpellID2;

    @Column(name = "PresetSpellID3")
    private Integer presetSpellID3;

    @Column(name = "PresetSpellID4")
    private Integer presetSpellID4;

    @Column(name = "PresetSpellID5")
    private Integer presetSpellID5;

    @Column(name = "PresetSpellID6")
    private Integer presetSpellID6;

    @Column(name = "PresetSpellID7")
    private Integer presetSpellID7;

    @Column(name = "PresetSpellID8")
    private Integer presetSpellID8;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
