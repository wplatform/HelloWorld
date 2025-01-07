package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
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
    
    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("Description")
    private LocalizedString description;

    @Column("Map_1")
    private Float map_1;

    @Column("Map_2")
    private Float map_2;

    @Column("DungeonMapID")
    private Short dungeonMapID;

    @Column("WorldMapAreaID")
    private Short worldMapAreaID;

    @Column("FirstSectionID")
    private Short firstSectionID;

    @Column("JournalInstanceID")
    private Short journalInstanceID;

    @Column("DifficultyMask")
    private Byte difficultyMask;

    @Column("Flags")
    private Byte flags;

    @Column("OrderIndex")
    private Integer orderIndex;

    @Column("MapDisplayConditionID")
    private Integer mapDisplayConditionID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
