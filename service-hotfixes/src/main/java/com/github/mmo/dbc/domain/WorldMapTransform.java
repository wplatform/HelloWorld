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
@Table(name = "world_map_transforms")
@Db2DataBind(name = "WorldMapTransforms.db2", layoutHash = 0x99FB4B71, parentIndexField = 3, fields = {
        @Db2Field(name = {"regionMinX", "regionMinY", "regionMinZ", "regionMaxX", "regionMaxY", "regionMaxZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"regionOffsetX", "regionOffsetY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "regionScale", type = Db2Type.FLOAT),
        @Db2Field(name = "mapID", type = Db2Type.SHORT),
        @Db2Field(name = "areaID", type = Db2Type.SHORT),
        @Db2Field(name = "newMapID", type = Db2Type.SHORT),
        @Db2Field(name = "newDungeonMapID", type = Db2Type.SHORT),
        @Db2Field(name = "newAreaID", type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "priority", type = Db2Type.INT, signed = true)
})
public class WorldMapTransform implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "RegionMinX")
    private Float regionMinX;

    @Column(name = "RegionMinY")
    private Float regionMinY;

    @Column(name = "RegionMinZ")
    private Float regionMinZ;

    @Column(name = "RegionMaxX")
    private Float regionMaxX;

    @Column(name = "RegionMaxY")
    private Float regionMaxY;

    @Column(name = "RegionMaxZ")
    private Float regionMaxZ;

    @Column(name = "RegionOffsetX")
    private Float regionOffsetX;

    @Column(name = "RegionOffsetY")
    private Float regionOffsetY;

    @Column(name = "RegionScale")
    private Float regionScale;

    @Column(name = "MapID")
    private Short mapID;

    @Column(name = "AreaID")
    private Short areaID;

    @Column(name = "NewMapID")
    private Short newMapID;

    @Column(name = "NewDungeonMapID")
    private Short newDungeonMapID;

    @Column(name = "NewAreaID")
    private Short newAreaID;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "Priority")
    private Integer priority;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
