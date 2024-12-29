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


@Getter
@Setter
@ToString


@Table(name = "spell_power")
@Db2DataBind(name = "SpellPower.db2", layoutHash = 0x8E5E46EC, indexField = 7, parentIndexField = 13, fields = {
        @Db2Field(name = "manaCost", type = Db2Type.INT, signed = true),
        @Db2Field(name = "powerCostPct", type = Db2Type.FLOAT),
        @Db2Field(name = "powerPctPerSecond", type = Db2Type.FLOAT),
        @Db2Field(name = "requiredAuraSpellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "powerCostMaxPct", type = Db2Type.FLOAT),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE),
        @Db2Field(name = "powerType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "manaCostPerLevel", type = Db2Type.INT, signed = true),
        @Db2Field(name = "manaPerSecond", type = Db2Type.INT, signed = true),
        @Db2Field(name = "optionalCost", type = Db2Type.INT),
        @Db2Field(name = "powerDisplayID", type = Db2Type.INT),
        @Db2Field(name = "altPowerBarID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellPower implements DbcEntity {
    @Column("ManaCost")
    private Integer manaCost;

    @Column("PowerCostPct")
    private Float powerCostPct;

    @Column("PowerPctPerSecond")
    private Float powerPctPerSecond;

    @Column("RequiredAuraSpellID")
    private Integer requiredAuraSpellID;

    @Column("PowerCostMaxPct")
    private Float powerCostMaxPct;

    @Column("OrderIndex")
    private Byte orderIndex;

    @Column("PowerType")
    private Byte powerType;

    @Id

    @Column("ID")
    private int id;

    @Column("ManaCostPerLevel")
    private Integer manaCostPerLevel;

    @Column("ManaPerSecond")
    private Integer manaPerSecond;

    @Column("OptionalCost")
    private Integer optionalCost;

    @Column("PowerDisplayID")
    private Integer powerDisplayID;

    @Column("AltPowerBarID")
    private Integer altPowerBarID;

    @Column("SpellID")
    private Integer spellID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
