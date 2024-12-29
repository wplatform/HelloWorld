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


@Table(name = "spell_x_spell_visual")
@Db2DataBind(name = "SpellXSpellVisual.db2", layoutHash = 0x4F4B8A2A, indexField = 1, parentIndexField = 12, fields = {
        @Db2Field(name = "spellVisualID", type = Db2Type.INT),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "probability", type = Db2Type.FLOAT),
        @Db2Field(name = "casterPlayerConditionID", type = Db2Type.SHORT),
        @Db2Field(name = "casterUnitConditionID", type = Db2Type.SHORT),
        @Db2Field(name = "viewerPlayerConditionID", type = Db2Type.SHORT),
        @Db2Field(name = "viewerUnitConditionID", type = Db2Type.SHORT),
        @Db2Field(name = "spellIconFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "activeIconFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "priority", type = Db2Type.BYTE),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellXSpellVisual implements DbcEntity {
    @Column("SpellVisualID")
    private Integer spellVisualID;

    @Id

    @Column("ID")
    private int id;

    @Column("Probability")
    private Float probability;

    @Column("CasterPlayerConditionID")
    private Integer casterPlayerConditionID;

    @Column("CasterUnitConditionID")
    private Short casterUnitConditionID;

    @Column("ViewerPlayerConditionID")
    private Integer viewerPlayerConditionID;

    @Column("ViewerUnitConditionID")
    private Short viewerUnitConditionID;

    @Column("SpellIconFileID")
    private Integer spellIconFileID;

    @Column("ActiveIconFileID")
    private Integer activeIconFileID;

    @Column("Flags")
    private Byte flags;

    @Column("DifficultyID")
    private Byte difficultyID;

    @Column("Priority")
    private Byte priority;

    @Column("SpellID")
    private Integer spellID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
