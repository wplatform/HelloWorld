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


@Table(name = "battlemaster_list")
@Db2DataBind(name = "BattlemasterList.db2", layoutHash = 0xD8AAA088, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "gameType", type = Db2Type.STRING),
        @Db2Field(name = "shortDescription", type = Db2Type.STRING),
        @Db2Field(name = "longDescription", type = Db2Type.STRING),
        @Db2Field(name = "iconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"mapID1", "mapID2", "mapID3", "mapID4", "mapID5", "mapID6", "mapID7", "mapID8", "mapID9", "mapID10", "mapID11", "mapID12", "mapID13", "mapID14", "mapID15", "mapID16"}, type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "holidayWorldState", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "requiredPlayerConditionID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "instanceType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "groupsAllowed", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "maxGroupSize", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "minLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "maxLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "ratedPlayers", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "minPlayers", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "maxPlayers", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE, signed = true)
})
public class BattleMasterList implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("GameType")
    private LocalizedString gameType;

    @Column("ShortDescription")
    private LocalizedString shortDescription;

    @Column("LongDescription")
    private LocalizedString longDescription;

    @Column("IconFileDataID")
    private Integer iconFileDataID;

    @Column("MapID1")
    private Short mapID1;

    @Column("MapID2")
    private Short mapID2;

    @Column("MapID3")
    private Short mapID3;

    @Column("MapID4")
    private Short mapID4;

    @Column("MapID5")
    private Short mapID5;

    @Column("MapID6")
    private Short mapID6;

    @Column("MapID7")
    private Short mapID7;

    @Column("MapID8")
    private Short mapID8;

    @Column("MapID9")
    private Short mapID9;

    @Column("MapID10")
    private Short mapID10;

    @Column("MapID11")
    private Short mapID11;

    @Column("MapID12")
    private Short mapID12;

    @Column("MapID13")
    private Short mapID13;

    @Column("MapID14")
    private Short mapID14;

    @Column("MapID15")
    private Short mapID15;

    @Column("MapID16")
    private Short mapID16;

    @Column("HolidayWorldState")
    private Short holidayWorldState;

    @Column("RequiredPlayerConditionID")
    private Short requiredPlayerConditionID;

    @Column("InstanceType")
    private Byte instanceType;

    @Column("GroupsAllowed")
    private Byte groupsAllowed;

    @Column("MaxGroupSize")
    private Byte maxGroupSize;

    @Column("MinLevel")
    private Byte minLevel;

    @Column("MaxLevel")
    private Byte maxLevel;

    @Column("RatedPlayers")
    private Byte ratedPlayers;

    @Column("MinPlayers")
    private Byte minPlayers;

    @Column("MaxPlayers")
    private Byte maxPlayers;

    @Column("Flags")
    private Byte flags;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
