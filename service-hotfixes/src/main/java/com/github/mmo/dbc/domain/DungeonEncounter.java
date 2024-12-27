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
@Table(name = "dungeon_encounter")
@Db2DataBind(name = "DungeonEncounter.db2", layoutHash = 0xB04A2596, indexField = 6, parentIndexField = 2, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "creatureDisplayID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "mapID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "bit", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "orderIndex", type = Db2Type.INT, signed = true),
        @Db2Field(name = "spellIconFileID", type = Db2Type.INT, signed = true)
})
public class DungeonEncounter implements DbcEntity {
    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "CreatureDisplayID")
    private Integer creatureDisplayID;

    @Column(name = "MapID")
    private Short mapID;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "Bit")
    private Byte bit;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "OrderIndex")
    private Integer orderIndex;

    @Column(name = "SpellIconFileID")
    private Integer spellIconFileID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
