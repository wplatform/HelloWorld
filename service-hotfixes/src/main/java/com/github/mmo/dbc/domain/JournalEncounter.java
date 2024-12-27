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
@Table(name = "journal_encounter")
@Db2DataBind(name = "JournalEncounter.db2", layoutHash = 0x2935A0FD, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = {"map_1", "map_2"}, type = Db2Type.FLOAT),
        @Db2Field(name = "dungeonMapID", type = Db2Type.SHORT),
        @Db2Field(name = "worldMapAreaID", type = Db2Type.SHORT),
        @Db2Field(name = "firstSectionID", type = Db2Type.SHORT),
        @Db2Field(name = "journalInstanceID", type = Db2Type.SHORT),
        @Db2Field(name = "difficultyMask", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "orderIndex", type = Db2Type.INT),
        @Db2Field(name = "mapDisplayConditionID", type = Db2Type.INT)
})
public class JournalEncounter implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "Map_1")
    private Float map_1;

    @Column(name = "Map_2")
    private Float map_2;

    @Column(name = "DungeonMapID")
    private Short dungeonMapID;

    @Column(name = "WorldMapAreaID")
    private Short worldMapAreaID;

    @Column(name = "FirstSectionID")
    private Short firstSectionID;

    @Column(name = "JournalInstanceID")
    private Short journalInstanceID;

    @Column(name = "DifficultyMask")
    private Byte difficultyMask;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "OrderIndex")
    private Integer orderIndex;

    @Column(name = "MapDisplayConditionID")
    private Integer mapDisplayConditionID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
