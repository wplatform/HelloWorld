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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "journal_encounter_section")
@Db2DataBind(name = "JournalEncounterSection.db2", layoutHash = 0x13E56B12, fields = {
        @Db2Field(name = "title", type = Db2Type.STRING),
        @Db2Field(name = "bodyText", type = Db2Type.STRING),
        @Db2Field(name = "iconCreatureDisplayInfoID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "iconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "journalEncounterID", type = Db2Type.SHORT),
        @Db2Field(name = "nextSiblingSectionID", type = Db2Type.SHORT),
        @Db2Field(name = "firstChildSectionID", type = Db2Type.SHORT),
        @Db2Field(name = "parentSectionID", type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "iconFlags", type = Db2Type.SHORT),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE),
        @Db2Field(name = "type", type = Db2Type.BYTE),
        @Db2Field(name = "difficultyMask", type = Db2Type.BYTE),
        @Db2Field(name = "uiModelSceneID", type = Db2Type.INT),
})
public class JournalEncounterSection implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Title")
    private LocalizedString title;

    @Lob
    @Column(name = "BodyText")
    private LocalizedString bodyText;

    @ColumnDefault("'0'")
    @Column(name = "JournalEncounterID", columnDefinition = "smallint UNSIGNED not null")
    private Integer journalEncounterID;

    @ColumnDefault("'0'")
    @Column(name = "OrderIndex", columnDefinition = "tinyint UNSIGNED not null")
    private Short orderIndex;

    @ColumnDefault("'0'")
    @Column(name = "ParentSectionID", columnDefinition = "smallint UNSIGNED not null")
    private Integer parentSectionID;

    @ColumnDefault("'0'")
    @Column(name = "FirstChildSectionID", columnDefinition = "smallint UNSIGNED not null")
    private Integer firstChildSectionID;

    @ColumnDefault("'0'")
    @Column(name = "NextSiblingSectionID", columnDefinition = "smallint UNSIGNED not null")
    private Integer nextSiblingSectionID;

    @ColumnDefault("0")
    @Column(name = "Type", nullable = false)
    private Byte type;

    @ColumnDefault("'0'")
    @Column(name = "IconCreatureDisplayInfoID", columnDefinition = "int UNSIGNED not null")
    private Long iconCreatureDisplayInfoID;

    @ColumnDefault("0")
    @Column(name = "UiModelSceneID", nullable = false)
    private Integer uiModelSceneID;

    @ColumnDefault("0")
    @Column(name = "SpellID", nullable = false)
    private Integer spellID;

    @ColumnDefault("0")
    @Column(name = "IconFileDataID", nullable = false)
    private Integer iconFileDataID;

    @ColumnDefault("0")
    @Column(name = "Flags", nullable = false)
    private Integer flags;

    @ColumnDefault("0")
    @Column(name = "IconFlags", nullable = false)
    private Integer iconFlags;

    @ColumnDefault("0")
    @Column(name = "DifficultyMask", nullable = false)
    private Byte difficultyMask;

}