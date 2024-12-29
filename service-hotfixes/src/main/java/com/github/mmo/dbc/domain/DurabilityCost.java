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


@Table(name = "durability_costs")
@Db2DataBind(name = "DurabilityCosts.db2", layoutHash = 0x8447966A, fields = {
        @Db2Field(name = {"weaponSubClassCost1", "weaponSubClassCost2", "weaponSubClassCost3", "weaponSubClassCost4", "weaponSubClassCost5", "weaponSubClassCost6", "weaponSubClassCost7", "weaponSubClassCost8", "weaponSubClassCost9", "weaponSubClassCost10", "weaponSubClassCost11", "weaponSubClassCost12", "weaponSubClassCost13", "weaponSubClassCost14", "weaponSubClassCost15", "weaponSubClassCost16", "weaponSubClassCost17", "weaponSubClassCost18", "weaponSubClassCost19", "weaponSubClassCost20", "weaponSubClassCost21"}, type = Db2Type.SHORT),
        @Db2Field(name = {"armorSubClassCost1", "armorSubClassCost2", "armorSubClassCost3", "armorSubClassCost4", "armorSubClassCost5", "armorSubClassCost6", "armorSubClassCost7", "armorSubClassCost8"}, type = Db2Type.SHORT)
})
public class DurabilityCost implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("WeaponSubClassCost1")
    private Short weaponSubClassCost1;

    @Column("WeaponSubClassCost2")
    private Short weaponSubClassCost2;

    @Column("WeaponSubClassCost3")
    private Short weaponSubClassCost3;

    @Column("WeaponSubClassCost4")
    private Short weaponSubClassCost4;

    @Column("WeaponSubClassCost5")
    private Short weaponSubClassCost5;

    @Column("WeaponSubClassCost6")
    private Short weaponSubClassCost6;

    @Column("WeaponSubClassCost7")
    private Short weaponSubClassCost7;

    @Column("WeaponSubClassCost8")
    private Short weaponSubClassCost8;

    @Column("WeaponSubClassCost9")
    private Short weaponSubClassCost9;

    @Column("WeaponSubClassCost10")
    private Short weaponSubClassCost10;

    @Column("WeaponSubClassCost11")
    private Short weaponSubClassCost11;

    @Column("WeaponSubClassCost12")
    private Short weaponSubClassCost12;

    @Column("WeaponSubClassCost13")
    private Short weaponSubClassCost13;

    @Column("WeaponSubClassCost14")
    private Short weaponSubClassCost14;

    @Column("WeaponSubClassCost15")
    private Short weaponSubClassCost15;

    @Column("WeaponSubClassCost16")
    private Short weaponSubClassCost16;

    @Column("WeaponSubClassCost17")
    private Short weaponSubClassCost17;

    @Column("WeaponSubClassCost18")
    private Short weaponSubClassCost18;

    @Column("WeaponSubClassCost19")
    private Short weaponSubClassCost19;

    @Column("WeaponSubClassCost20")
    private Short weaponSubClassCost20;

    @Column("WeaponSubClassCost21")
    private Short weaponSubClassCost21;

    @Column("ArmorSubClassCost1")
    private Short armorSubClassCost1;

    @Column("ArmorSubClassCost2")
    private Short armorSubClassCost2;

    @Column("ArmorSubClassCost3")
    private Short armorSubClassCost3;

    @Column("ArmorSubClassCost4")
    private Short armorSubClassCost4;

    @Column("ArmorSubClassCost5")
    private Short armorSubClassCost5;

    @Column("ArmorSubClassCost6")
    private Short armorSubClassCost6;

    @Column("ArmorSubClassCost7")
    private Short armorSubClassCost7;

    @Column("ArmorSubClassCost8")
    private Short armorSubClassCost8;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
