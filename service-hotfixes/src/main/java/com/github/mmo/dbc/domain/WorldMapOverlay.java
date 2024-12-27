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
    @Column(name = "TextureName")
    private String textureName;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "TextureWidth")
    private Short textureWidth;

    @Column(name = "TextureHeight")
    private Short textureHeight;

    @Column(name = "MapAreaID")
    private Integer mapAreaID;

    @Column(name = "OffsetX")
    private Integer offsetX;

    @Column(name = "OffsetY")
    private Integer offsetY;

    @Column(name = "HitRectTop")
    private Integer hitRectTop;

    @Column(name = "HitRectLeft")
    private Integer hitRectLeft;

    @Column(name = "HitRectBottom")
    private Integer hitRectBottom;

    @Column(name = "HitRectRight")
    private Integer hitRectRight;

    @Column(name = "PlayerConditionID")
    private Integer playerConditionID;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "AreaID1")
    private Integer areaID1;

    @Column(name = "AreaID2")
    private Integer areaID2;

    @Column(name = "AreaID3")
    private Integer areaID3;

    @Column(name = "AreaID4")
    private Integer areaID4;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
