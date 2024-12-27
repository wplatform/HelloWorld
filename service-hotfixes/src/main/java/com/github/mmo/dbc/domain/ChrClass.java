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
@Table(name = "chr_classes")
@Db2DataBind(name = "ChrClasses.db2", layoutHash = 0x6F7AB8E7, indexField = 19, fields = {
        @Db2Field(name = "petNameToken", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "nameFemale", type = Db2Type.STRING),
        @Db2Field(name = "nameMale", type = Db2Type.STRING),
        @Db2Field(name = "filename", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "createScreenFileDataID", type = Db2Type.INT),
        @Db2Field(name = "selectScreenFileDataID", type = Db2Type.INT),
        @Db2Field(name = "lowResScreenFileDataID", type = Db2Type.INT),
        @Db2Field(name = "iconFileDataID", type = Db2Type.INT),
        @Db2Field(name = "startingLevel", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "cinematicSequenceID", type = Db2Type.SHORT),
        @Db2Field(name = "defaultSpec", type = Db2Type.SHORT),
        @Db2Field(name = "displayPower", type = Db2Type.BYTE),
        @Db2Field(name = "spellClassSet", type = Db2Type.BYTE),
        @Db2Field(name = "attackPowerPerStrength", type = Db2Type.BYTE),
        @Db2Field(name = "attackPowerPerAgility", type = Db2Type.BYTE),
        @Db2Field(name = "rangedAttackPowerPerAgility", type = Db2Type.BYTE),
        @Db2Field(name = "primaryStatPriority", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class ChrClass implements DbcEntity {
    @Column(name = "PetNameToken")
    private String petNameToken;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "NameFemale")
    private LocalizedString nameFemale;

    @Column(name = "NameMale")
    private LocalizedString nameMale;

    @Column(name = "Filename")
    private String filename;

    @Column(name = "CreateScreenFileDataID")
    private Integer createScreenFileDataID;

    @Column(name = "SelectScreenFileDataID")
    private Integer selectScreenFileDataID;

    @Column(name = "LowResScreenFileDataID")
    private Integer lowResScreenFileDataID;

    @Column(name = "IconFileDataID")
    private Integer iconFileDataID;

    @Column(name = "StartingLevel")
    private Integer startingLevel;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "CinematicSequenceID")
    private Short cinematicSequenceID;

    @Column(name = "DefaultSpec")
    private Short defaultSpec;

    @Column(name = "DisplayPower")
    private Byte displayPower;

    @Column(name = "SpellClassSet")
    private Byte spellClassSet;

    @Column(name = "AttackPowerPerStrength")
    private Byte attackPowerPerStrength;

    @Column(name = "AttackPowerPerAgility")
    private Byte attackPowerPerAgility;

    @Column(name = "RangedAttackPowerPerAgility")
    private Byte rangedAttackPowerPerAgility;

    @Column(name = "PrimaryStatPriority")
    private Byte primaryStatPriority;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
