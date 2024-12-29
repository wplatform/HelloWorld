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


@Getter
@Setter
@ToString


@Table(name = "world_map_overlay")
@Db2DataBind(name = "WorldMapOverlay.db2", layoutHash = 0xDC4B6AF3, indexField = 1, parentIndexField = 4, fields = {
        @Db2Field(name = "textureName", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "textureWidth", type = Db2Type.SHORT),
        @Db2Field(name = "textureHeight", type = Db2Type.SHORT),
        @Db2Field(name = "mapAreaID", type = Db2Type.INT),
        @Db2Field(name = "offsetX", type = Db2Type.INT, signed = true),
        @Db2Field(name = "offsetY", type = Db2Type.INT, signed = true),
        @Db2Field(name = "hitRectTop", type = Db2Type.INT, signed = true),
        @Db2Field(name = "hitRectLeft", type = Db2Type.INT, signed = true),
        @Db2Field(name = "hitRectBottom", type = Db2Type.INT, signed = true),
        @Db2Field(name = "hitRectRight", type = Db2Type.INT, signed = true),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.INT),
        @Db2Field(name = {"areaID1", "areaID2", "areaID3", "areaID4"}, type = Db2Type.INT)
})
public class WorldMapOverlay implements DbcEntity {
    @Column("TextureName")
    private String textureName;

    @Id

    @Column("ID")
    private int id;

    @Column("TextureWidth")
    private Short textureWidth;

    @Column("TextureHeight")
    private Short textureHeight;

    @Column("MapAreaID")
    private Integer mapAreaID;

    @Column("OffsetX")
    private Integer offsetX;

    @Column("OffsetY")
    private Integer offsetY;

    @Column("HitRectTop")
    private Integer hitRectTop;

    @Column("HitRectLeft")
    private Integer hitRectLeft;

    @Column("HitRectBottom")
    private Integer hitRectBottom;

    @Column("HitRectRight")
    private Integer hitRectRight;

    @Column("PlayerConditionID")
    private Integer playerConditionID;

    @Column("Flags")
    private Integer flags;

    @Column("AreaID1")
    private Integer areaID1;

    @Column("AreaID2")
    private Integer areaID2;

    @Column("AreaID3")
    private Integer areaID3;

    @Column("AreaID4")
    private Integer areaID4;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
