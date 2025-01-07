package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
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


@Table(name = "world_map_area")
@Db2DataBind(name = "WorldMapArea.db2", layoutHash = 0xC7E90019, indexField = 15, fields = {
        @Db2Field(name = "areaName", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "locLeft", type = Db2Type.FLOAT),
        @Db2Field(name = "locRight", type = Db2Type.FLOAT),
        @Db2Field(name = "locTop", type = Db2Type.FLOAT),
        @Db2Field(name = "locBottom", type = Db2Type.FLOAT),
        @Db2Field(name = "flags", type = Db2Type.INT),
        @Db2Field(name = "mapID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "areaID", type = Db2Type.SHORT),
        @Db2Field(name = "displayMapID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "defaultDungeonFloor", type = Db2Type.SHORT),
        @Db2Field(name = "parentWorldMapID", type = Db2Type.SHORT),
        @Db2Field(name = "levelRangeMin", type = Db2Type.BYTE),
        @Db2Field(name = "levelRangeMax", type = Db2Type.BYTE),
        @Db2Field(name = "bountySetID", type = Db2Type.BYTE),
        @Db2Field(name = "bountyDisplayLocation", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "visibilityPlayerConditionID", type = Db2Type.INT)
})
public class WorldMapArea implements DbcEntity {
    @Column("AreaName")
    private String areaName;

    @Column("LocLeft")
    private Float locLeft;

    @Column("LocRight")
    private Float locRight;

    @Column("LocTop")
    private Float locTop;

    @Column("LocBottom")
    private Float locBottom;

    @Column("Flags")
    private Integer flags;

    @Column("MapID")
    private Short mapID;

    @Column("AreaID")
    private Short areaID;

    @Column("DisplayMapID")
    private Short displayMapID;

    @Column("DefaultDungeonFloor")
    private Short defaultDungeonFloor;

    @Column("ParentWorldMapID")
    private Short parentWorldMapID;

    @Column("LevelRangeMin")
    private Byte levelRangeMin;

    @Column("LevelRangeMax")
    private Byte levelRangeMax;

    @Column("BountySetID")
    private Byte bountySetID;

    @Column("BountyDisplayLocation")
    private Byte bountyDisplayLocation;

    @Id
    
    @Column("ID")
    private int id;

    @Column("VisibilityPlayerConditionID")
    private Integer visibilityPlayerConditionID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
