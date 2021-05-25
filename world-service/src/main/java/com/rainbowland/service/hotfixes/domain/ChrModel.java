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
@Table("chr_model")
public class ChrModel {

    @Column("FaceCustomizationOffset1")
    private Double faceCustomizationOffset1;
    @Column("FaceCustomizationOffset2")
    private Double faceCustomizationOffset2;
    @Column("FaceCustomizationOffset3")
    private Double faceCustomizationOffset3;
    @Column("CustomizeOffset1")
    private Double customizeOffset1;
    @Column("CustomizeOffset2")
    private Double customizeOffset2;
    @Column("CustomizeOffset3")
    private Double customizeOffset3;
    @Column("ID")
    private Integer id;
    @Column("Sex")
    private Integer sex;
    @Column("DisplayID")
    private Integer displayId;
    @Column("CharComponentTextureLayoutID")
    private Integer charComponentTextureLayoutId;
    @Column("Flags")
    private Integer flags;
    @Column("SkeletonFileDataID")
    private Integer skeletonFileDataId;
    @Column("ModelFallbackChrModelID")
    private Integer modelFallbackChrModelId;
    @Column("TextureFallbackChrModelID")
    private Integer textureFallbackChrModelId;
    @Column("HelmVisFallbackChrModelID")
    private Integer helmVisFallbackChrModelId;
    @Column("CustomizeScale")
    private Double customizeScale;
    @Column("CustomizeFacing")
    private Double customizeFacing;
    @Column("CameraDistanceOffset")
    private Double cameraDistanceOffset;
    @Column("BarberShopCameraOffsetScale")
    private Double barberShopCameraOffsetScale;
    @Column("BarberShopCameraRotationOffset")
    private Double barberShopCameraRotationOffset;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrModel> {

        public ChrModel convert(Row row) {
            ChrModel domain = new ChrModel();
            domain.setFaceCustomizationOffset1(row.get("FaceCustomizationOffset1", Double.class));
            domain.setFaceCustomizationOffset2(row.get("FaceCustomizationOffset2", Double.class));
            domain.setFaceCustomizationOffset3(row.get("FaceCustomizationOffset3", Double.class));
            domain.setCustomizeOffset1(row.get("CustomizeOffset1", Double.class));
            domain.setCustomizeOffset2(row.get("CustomizeOffset2", Double.class));
            domain.setCustomizeOffset3(row.get("CustomizeOffset3", Double.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setSex(row.get("Sex", Integer.class));
            domain.setDisplayId(row.get("DisplayID", Integer.class));
            domain.setCharComponentTextureLayoutId(row.get("CharComponentTextureLayoutID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSkeletonFileDataId(row.get("SkeletonFileDataID", Integer.class));
            domain.setModelFallbackChrModelId(row.get("ModelFallbackChrModelID", Integer.class));
            domain.setTextureFallbackChrModelId(row.get("TextureFallbackChrModelID", Integer.class));
            domain.setHelmVisFallbackChrModelId(row.get("HelmVisFallbackChrModelID", Integer.class));
            domain.setCustomizeScale(row.get("CustomizeScale", Double.class));
            domain.setCustomizeFacing(row.get("CustomizeFacing", Double.class));
            domain.setCameraDistanceOffset(row.get("CameraDistanceOffset", Double.class));
            domain.setBarberShopCameraOffsetScale(row.get("BarberShopCameraOffsetScale", Double.class));
            domain.setBarberShopCameraRotationOffset(row.get("BarberShopCameraRotationOffset", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrModel, OutboundRow> {

        public OutboundRow convert(ChrModel source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getFaceCustomizationOffset1()).ifPresent(e -> row.put("FaceCustomizationOffset1", Parameter.from(e)));
            Optional.ofNullable(source.getFaceCustomizationOffset2()).ifPresent(e -> row.put("FaceCustomizationOffset2", Parameter.from(e)));
            Optional.ofNullable(source.getFaceCustomizationOffset3()).ifPresent(e -> row.put("FaceCustomizationOffset3", Parameter.from(e)));
            Optional.ofNullable(source.getCustomizeOffset1()).ifPresent(e -> row.put("CustomizeOffset1", Parameter.from(e)));
            Optional.ofNullable(source.getCustomizeOffset2()).ifPresent(e -> row.put("CustomizeOffset2", Parameter.from(e)));
            Optional.ofNullable(source.getCustomizeOffset3()).ifPresent(e -> row.put("CustomizeOffset3", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSex()).ifPresent(e -> row.put("Sex", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId()).ifPresent(e -> row.put("DisplayID", Parameter.from(e)));
            Optional.ofNullable(source.getCharComponentTextureLayoutId()).ifPresent(e -> row.put("CharComponentTextureLayoutID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSkeletonFileDataId()).ifPresent(e -> row.put("SkeletonFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getModelFallbackChrModelId()).ifPresent(e -> row.put("ModelFallbackChrModelID", Parameter.from(e)));
            Optional.ofNullable(source.getTextureFallbackChrModelId()).ifPresent(e -> row.put("TextureFallbackChrModelID", Parameter.from(e)));
            Optional.ofNullable(source.getHelmVisFallbackChrModelId()).ifPresent(e -> row.put("HelmVisFallbackChrModelID", Parameter.from(e)));
            Optional.ofNullable(source.getCustomizeScale()).ifPresent(e -> row.put("CustomizeScale", Parameter.from(e)));
            Optional.ofNullable(source.getCustomizeFacing()).ifPresent(e -> row.put("CustomizeFacing", Parameter.from(e)));
            Optional.ofNullable(source.getCameraDistanceOffset()).ifPresent(e -> row.put("CameraDistanceOffset", Parameter.from(e)));
            Optional.ofNullable(source.getBarberShopCameraOffsetScale()).ifPresent(e -> row.put("BarberShopCameraOffsetScale", Parameter.from(e)));
            Optional.ofNullable(source.getBarberShopCameraRotationOffset()).ifPresent(e -> row.put("BarberShopCameraRotationOffset", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
