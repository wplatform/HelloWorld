package com.rainbowland.service.hotfixes.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("world_map_overlay")
public class WorldMapOverlay {

    @Column("ID")
    private Integer id;
    @Column("UiMapArtID")
    private Integer uiMapArtId;
    @Column("TextureWidth")
    private Integer textureWidth;
    @Column("TextureHeight")
    private Integer textureHeight;
    @Column("OffsetX")
    private Integer offsetX;
    @Column("OffsetY")
    private Integer offsetY;
    @Column("HitRectTop")
    private Integer hitRectTop;
    @Column("HitRectBottom")
    private Integer hitRectBottom;
    @Column("HitRectLeft")
    private Integer hitRectLeft;
    @Column("HitRectRight")
    private Integer hitRectRight;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("Flags")
    private Integer flags;
    @Column("AreaID1")
    private Integer areaId1;
    @Column("AreaID2")
    private Integer areaId2;
    @Column("AreaID3")
    private Integer areaId3;
    @Column("AreaID4")
    private Integer areaId4;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, WorldMapOverlay> {

        public WorldMapOverlay convert(Row row) {
            WorldMapOverlay domain = new WorldMapOverlay();
            domain.setId(row.get("ID", Integer.class));
            domain.setUiMapArtId(row.get("UiMapArtID", Integer.class));
            domain.setTextureWidth(row.get("TextureWidth", Integer.class));
            domain.setTextureHeight(row.get("TextureHeight", Integer.class));
            domain.setOffsetX(row.get("OffsetX", Integer.class));
            domain.setOffsetY(row.get("OffsetY", Integer.class));
            domain.setHitRectTop(row.get("HitRectTop", Integer.class));
            domain.setHitRectBottom(row.get("HitRectBottom", Integer.class));
            domain.setHitRectLeft(row.get("HitRectLeft", Integer.class));
            domain.setHitRectRight(row.get("HitRectRight", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setAreaId1(row.get("AreaID1", Integer.class));
            domain.setAreaId2(row.get("AreaID2", Integer.class));
            domain.setAreaId3(row.get("AreaID3", Integer.class));
            domain.setAreaId4(row.get("AreaID4", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<WorldMapOverlay, OutboundRow> {

        public OutboundRow convert(WorldMapOverlay source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getUiMapArtId()).ifPresent(e -> row.put("UiMapArtID", Parameter.from(e)));
            Optional.ofNullable(source.getTextureWidth()).ifPresent(e -> row.put("TextureWidth", Parameter.from(e)));
            Optional.ofNullable(source.getTextureHeight()).ifPresent(e -> row.put("TextureHeight", Parameter.from(e)));
            Optional.ofNullable(source.getOffsetX()).ifPresent(e -> row.put("OffsetX", Parameter.from(e)));
            Optional.ofNullable(source.getOffsetY()).ifPresent(e -> row.put("OffsetY", Parameter.from(e)));
            Optional.ofNullable(source.getHitRectTop()).ifPresent(e -> row.put("HitRectTop", Parameter.from(e)));
            Optional.ofNullable(source.getHitRectBottom()).ifPresent(e -> row.put("HitRectBottom", Parameter.from(e)));
            Optional.ofNullable(source.getHitRectLeft()).ifPresent(e -> row.put("HitRectLeft", Parameter.from(e)));
            Optional.ofNullable(source.getHitRectRight()).ifPresent(e -> row.put("HitRectRight", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId1()).ifPresent(e -> row.put("AreaID1", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId2()).ifPresent(e -> row.put("AreaID2", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId3()).ifPresent(e -> row.put("AreaID3", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId4()).ifPresent(e -> row.put("AreaID4", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
