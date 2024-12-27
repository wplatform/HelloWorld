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
@Table(name = "durability_costs")
@Db2DataBind(name = "DurabilityCosts.db2", layoutHash = 0x8447966A, fields = {
        @Db2Field(name = {"weaponSubClassCost1", "weaponSubClassCost2", "weaponSubClassCost3", "weaponSubClassCost4", "weaponSubClassCost5", "weaponSubClassCost6", "weaponSubClassCost7", "weaponSubClassCost8", "weaponSubClassCost9", "weaponSubClassCost10", "weaponSubClassCost11", "weaponSubClassCost12", "weaponSubClassCost13", "weaponSubClassCost14", "weaponSubClassCost15", "weaponSubClassCost16", "weaponSubClassCost17", "weaponSubClassCost18", "weaponSubClassCost19", "weaponSubClassCost20", "weaponSubClassCost21"}, type = Db2Type.SHORT),
        @Db2Field(name = {"armorSubClassCost1", "armorSubClassCost2", "armorSubClassCost3", "armorSubClassCost4", "armorSubClassCost5", "armorSubClassCost6", "armorSubClassCost7", "armorSubClassCost8"}, type = Db2Type.SHORT)
})
public class DurabilityCost implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "WeaponSubClassCost1")
    private Short weaponSubClassCost1;

    @Column(name = "WeaponSubClassCost2")
    private Short weaponSubClassCost2;

    @Column(name = "WeaponSubClassCost3")
    private Short weaponSubClassCost3;

    @Column(name = "WeaponSubClassCost4")
    private Short weaponSubClassCost4;

    @Column(name = "WeaponSubClassCost5")
    private Short weaponSubClassCost5;

    @Column(name = "WeaponSubClassCost6")
    private Short weaponSubClassCost6;

    @Column(name = "WeaponSubClassCost7")
    private Short weaponSubClassCost7;

    @Column(name = "WeaponSubClassCost8")
    private Short weaponSubClassCost8;

    @Column(name = "WeaponSubClassCost9")
    private Short weaponSubClassCost9;

    @Column(name = "WeaponSubClassCost10")
    private Short weaponSubClassCost10;

    @Column(name = "WeaponSubClassCost11")
    private Short weaponSubClassCost11;

    @Column(name = "WeaponSubClassCost12")
    private Short weaponSubClassCost12;

    @Column(name = "WeaponSubClassCost13")
    private Short weaponSubClassCost13;

    @Column(name = "WeaponSubClassCost14")
    private Short weaponSubClassCost14;

    @Column(name = "WeaponSubClassCost15")
    private Short weaponSubClassCost15;

    @Column(name = "WeaponSubClassCost16")
    private Short weaponSubClassCost16;

    @Column(name = "WeaponSubClassCost17")
    private Short weaponSubClassCost17;

    @Column(name = "WeaponSubClassCost18")
    private Short weaponSubClassCost18;

    @Column(name = "WeaponSubClassCost19")
    private Short weaponSubClassCost19;

    @Column(name = "WeaponSubClassCost20")
    private Short weaponSubClassCost20;

    @Column(name = "WeaponSubClassCost21")
    private Short weaponSubClassCost21;

    @Column(name = "ArmorSubClassCost1")
    private Short armorSubClassCost1;

    @Column(name = "ArmorSubClassCost2")
    private Short armorSubClassCost2;

    @Column(name = "ArmorSubClassCost3")
    private Short armorSubClassCost3;

    @Column(name = "ArmorSubClassCost4")
    private Short armorSubClassCost4;

    @Column(name = "ArmorSubClassCost5")
    private Short armorSubClassCost5;

    @Column(name = "ArmorSubClassCost6")
    private Short armorSubClassCost6;

    @Column(name = "ArmorSubClassCost7")
    private Short armorSubClassCost7;

    @Column(name = "ArmorSubClassCost8")
    private Short armorSubClassCost8;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
