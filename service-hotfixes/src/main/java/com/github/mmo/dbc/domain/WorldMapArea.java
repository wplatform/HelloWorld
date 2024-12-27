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
    @Column(name = "AreaName")
    private String areaName;

    @Column(name = "LocLeft")
    private Float locLeft;

    @Column(name = "LocRight")
    private Float locRight;

    @Column(name = "LocTop")
    private Float locTop;

    @Column(name = "LocBottom")
    private Float locBottom;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "MapID")
    private Short mapID;

    @Column(name = "AreaID")
    private Short areaID;

    @Column(name = "DisplayMapID")
    private Short displayMapID;

    @Column(name = "DefaultDungeonFloor")
    private Short defaultDungeonFloor;

    @Column(name = "ParentWorldMapID")
    private Short parentWorldMapID;

    @Column(name = "LevelRangeMin")
    private Byte levelRangeMin;

    @Column(name = "LevelRangeMax")
    private Byte levelRangeMax;

    @Column(name = "BountySetID")
    private Byte bountySetID;

    @Column(name = "BountyDisplayLocation")
    private Byte bountyDisplayLocation;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "VisibilityPlayerConditionID")
    private Integer visibilityPlayerConditionID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
