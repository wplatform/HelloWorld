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
@Table("gameobject_display_info")
public class GameobjectDisplayInfo {

    @Column("ID")
    private Integer id;
    @Column("GeoBoxMinX")
    private Double geoBoxMinX;
    @Column("GeoBoxMinY")
    private Double geoBoxMinY;
    @Column("GeoBoxMinZ")
    private Double geoBoxMinZ;
    @Column("GeoBoxMaxX")
    private Double geoBoxMaxX;
    @Column("GeoBoxMaxY")
    private Double geoBoxMaxY;
    @Column("GeoBoxMaxZ")
    private Double geoBoxMaxZ;
    @Column("FileDataID")
    private Integer fileDataId;
    @Column("ObjectEffectPackageID")
    private Integer objectEffectPackageId;
    @Column("OverrideLootEffectScale")
    private Double overrideLootEffectScale;
    @Column("OverrideNameScale")
    private Double overrideNameScale;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameobjectDisplayInfo> {

        public GameobjectDisplayInfo convert(Row row) {
            GameobjectDisplayInfo domain = new GameobjectDisplayInfo();
            domain.setId(row.get("ID", Integer.class));
            domain.setGeoBoxMinX(row.get("GeoBoxMinX", Double.class));
            domain.setGeoBoxMinY(row.get("GeoBoxMinY", Double.class));
            domain.setGeoBoxMinZ(row.get("GeoBoxMinZ", Double.class));
            domain.setGeoBoxMaxX(row.get("GeoBoxMaxX", Double.class));
            domain.setGeoBoxMaxY(row.get("GeoBoxMaxY", Double.class));
            domain.setGeoBoxMaxZ(row.get("GeoBoxMaxZ", Double.class));
            domain.setFileDataId(row.get("FileDataID", Integer.class));
            domain.setObjectEffectPackageId(row.get("ObjectEffectPackageID", Integer.class));
            domain.setOverrideLootEffectScale(row.get("OverrideLootEffectScale", Double.class));
            domain.setOverrideNameScale(row.get("OverrideNameScale", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameobjectDisplayInfo, OutboundRow> {

        public OutboundRow convert(GameobjectDisplayInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBoxMinX()).ifPresent(e -> row.put("GeoBoxMinX", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBoxMinY()).ifPresent(e -> row.put("GeoBoxMinY", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBoxMinZ()).ifPresent(e -> row.put("GeoBoxMinZ", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBoxMaxX()).ifPresent(e -> row.put("GeoBoxMaxX", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBoxMaxY()).ifPresent(e -> row.put("GeoBoxMaxY", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBoxMaxZ()).ifPresent(e -> row.put("GeoBoxMaxZ", Parameter.from(e)));
            Optional.ofNullable(source.getFileDataId()).ifPresent(e -> row.put("FileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getObjectEffectPackageId()).ifPresent(e -> row.put("ObjectEffectPackageID", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideLootEffectScale()).ifPresent(e -> row.put("OverrideLootEffectScale", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideNameScale()).ifPresent(e -> row.put("OverrideNameScale", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
