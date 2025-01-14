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


@Table(name = "spell_categories")
@Db2DataBind(name = "SpellCategories.db2", layoutHash = 0x14E916CC, parentIndexField = 8, fields = {
        @Db2Field(name = "category", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "startRecoveryCategory", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "chargeCategory", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "defenseType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "dispelType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "mechanic", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "preventionType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellCategories implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Category")
    private Short category;

    @Column("StartRecoveryCategory")
    private Short startRecoveryCategory;

    @Column("ChargeCategory")
    private Short chargeCategory;

    @Column("DifficultyID")
    private Byte difficultyID;

    @Column("DefenseType")
    private Byte defenseType;

    @Column("DispelType")
    private Byte dispelType;

    @Column("Mechanic")
    private Byte mechanic;

    @Column("PreventionType")
    private Byte preventionType;

    @Column("SpellID")
    private Integer spellID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
