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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "GameType")
    private LocalizedString gameType;

    @Column(name = "ShortDescription")
    private LocalizedString shortDescription;

    @Column(name = "LongDescription")
    private LocalizedString longDescription;

    @Column(name = "IconFileDataID")
    private Integer iconFileDataID;

    @Column(name = "MapID1")
    private Short mapID1;

    @Column(name = "MapID2")
    private Short mapID2;

    @Column(name = "MapID3")
    private Short mapID3;

    @Column(name = "MapID4")
    private Short mapID4;

    @Column(name = "MapID5")
    private Short mapID5;

    @Column(name = "MapID6")
    private Short mapID6;

    @Column(name = "MapID7")
    private Short mapID7;

    @Column(name = "MapID8")
    private Short mapID8;

    @Column(name = "MapID9")
    private Short mapID9;

    @Column(name = "MapID10")
    private Short mapID10;

    @Column(name = "MapID11")
    private Short mapID11;

    @Column(name = "MapID12")
    private Short mapID12;

    @Column(name = "MapID13")
    private Short mapID13;

    @Column(name = "MapID14")
    private Short mapID14;

    @Column(name = "MapID15")
    private Short mapID15;

    @Column(name = "MapID16")
    private Short mapID16;

    @Column(name = "HolidayWorldState")
    private Short holidayWorldState;

    @Column(name = "RequiredPlayerConditionID")
    private Short requiredPlayerConditionID;

    @Column(name = "InstanceType")
    private Byte instanceType;

    @Column(name = "GroupsAllowed")
    private Byte groupsAllowed;

    @Column(name = "MaxGroupSize")
    private Byte maxGroupSize;

    @Column(name = "MinLevel")
    private Byte minLevel;

    @Column(name = "MaxLevel")
    private Byte maxLevel;

    @Column(name = "RatedPlayers")
    private Byte ratedPlayers;

    @Column(name = "MinPlayers")
    private Byte minPlayers;

    @Column(name = "MaxPlayers")
    private Byte maxPlayers;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
