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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Category")
    private Short category;

    @Column(name = "StartRecoveryCategory")
    private Short startRecoveryCategory;

    @Column(name = "ChargeCategory")
    private Short chargeCategory;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "DefenseType")
    private Byte defenseType;

    @Column(name = "DispelType")
    private Byte dispelType;

    @Column(name = "Mechanic")
    private Byte mechanic;

    @Column(name = "PreventionType")
    private Byte preventionType;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
