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


@Table(name = "game_object_display_info")
@Db2DataBind(name = "GameObjectDisplayInfo.db2", layoutHash = 0x9F2098D1, fields = {
        @Db2Field(name = "fileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"geoBoxMinX", "geoBoxMinY", "geoBoxMinZ", "geoBoxMaxX", "geoBoxMaxY", "geoBoxMaxZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "overrideLootEffectScale", type = Db2Type.FLOAT),
        @Db2Field(name = "overrideNameScale", type = Db2Type.FLOAT),
        @Db2Field(name = "objectEffectPackageID", type = Db2Type.SHORT, signed = true)
})
public class GameObjectDisplayInfo implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("FileDataID")
    private Integer fileDataID;

    @Column("GeoBoxMinX")
    private Float geoBoxMinX;

    @Column("GeoBoxMinY")
    private Float geoBoxMinY;

    @Column("GeoBoxMinZ")
    private Float geoBoxMinZ;

    @Column("GeoBoxMaxX")
    private Float geoBoxMaxX;

    @Column("GeoBoxMaxY")
    private Float geoBoxMaxY;

    @Column("GeoBoxMaxZ")
    private Float geoBoxMaxZ;

    @Column("OverrideLootEffectScale")
    private Float overrideLootEffectScale;

    @Column("OverrideNameScale")
    private Float overrideNameScale;

    @Column("ObjectEffectPackageID")
    private Short objectEffectPackageID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
