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
    @Column(name = "SpellVisualID")
    private Integer spellVisualID;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Probability")
    private Float probability;

    @Column(name = "CasterPlayerConditionID")
    private Integer casterPlayerConditionID;

    @Column(name = "CasterUnitConditionID")
    private Short casterUnitConditionID;

    @Column(name = "ViewerPlayerConditionID")
    private Integer viewerPlayerConditionID;

    @Column(name = "ViewerUnitConditionID")
    private Short viewerUnitConditionID;

    @Column(name = "SpellIconFileID")
    private Integer spellIconFileID;

    @Column(name = "ActiveIconFileID")
    private Integer activeIconFileID;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "Priority")
    private Byte priority;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
