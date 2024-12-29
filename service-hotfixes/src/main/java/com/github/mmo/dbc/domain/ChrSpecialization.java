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


@Table(name = "chr_specialization")
@Db2DataBind(name = "ChrSpecialization.db2", layoutHash = 0x3D86B8F7, indexField = 9, parentIndexField = 4, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "femaleName", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = {"masterySpellID1", "masterySpellID2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "classID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "petTalentType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "role", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "primaryStatPriority", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "spellIconFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.INT),
        @Db2Field(name = "animReplacements", type = Db2Type.INT, signed = true)
})
public class ChrSpecialization implements DbcEntity {
    @Column("Name")
    private LocalizedString name;

    @Column("FemaleName")
    private LocalizedString femaleName;

    @Column("Description")
    private LocalizedString description;

    @Column("MasterySpellID1")
    private Integer masterySpellID1;

    @Column("MasterySpellID2")
    private Integer masterySpellID2;

    @Column("ClassID")
    private Byte classID;

    @Column("OrderIndex")
    private Byte orderIndex;

    @Column("PetTalentType")
    private Byte petTalentType;

    @Column("Role")
    private Byte role;

    @Column("PrimaryStatPriority")
    private Byte primaryStatPriority;

    @Id

    @Column("ID")
    private int id;

    @Column("SpellIconFileID")
    private Integer spellIconFileID;

    @Column("Flags")
    private Integer flags;

    @Column("AnimReplacements")
    private Integer animReplacements;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
