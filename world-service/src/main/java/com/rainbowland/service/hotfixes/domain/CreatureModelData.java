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
@Table("creature_model_data")
public class CreatureModelData {

    @Column("ID")
    private Integer id;
    @Column("GeoBox1")
    private Double geoBox1;
    @Column("GeoBox2")
    private Double geoBox2;
    @Column("GeoBox3")
    private Double geoBox3;
    @Column("GeoBox4")
    private Double geoBox4;
    @Column("GeoBox5")
    private Double geoBox5;
    @Column("GeoBox6")
    private Double geoBox6;
    @Column("Flags")
    private Integer flags;
    @Column("FileDataID")
    private Integer fileDataId;
    @Column("BloodID")
    private Integer bloodId;
    @Column("FootprintTextureID")
    private Integer footprintTextureId;
    @Column("FootprintTextureLength")
    private Double footprintTextureLength;
    @Column("FootprintTextureWidth")
    private Double footprintTextureWidth;
    @Column("FootprintParticleScale")
    private Double footprintParticleScale;
    @Column("FoleyMaterialID")
    private Integer foleyMaterialId;
    @Column("FootstepCameraEffectID")
    private Integer footstepCameraEffectId;
    @Column("DeathThudCameraEffectID")
    private Integer deathThudCameraEffectId;
    @Column("SoundID")
    private Integer soundId;
    @Column("SizeClass")
    private Integer sizeClass;
    @Column("CollisionWidth")
    private Double collisionWidth;
    @Column("CollisionHeight")
    private Double collisionHeight;
    @Column("WorldEffectScale")
    private Double worldEffectScale;
    @Column("CreatureGeosetDataID")
    private Integer creatureGeosetDataId;
    @Column("HoverHeight")
    private Double hoverHeight;
    @Column("AttachedEffectScale")
    private Double attachedEffectScale;
    @Column("ModelScale")
    private Double modelScale;
    @Column("MissileCollisionRadius")
    private Double missileCollisionRadius;
    @Column("MissileCollisionPush")
    private Double missileCollisionPush;
    @Column("MissileCollisionRaise")
    private Double missileCollisionRaise;
    @Column("MountHeight")
    private Double mountHeight;
    @Column("OverrideLootEffectScale")
    private Double overrideLootEffectScale;
    @Column("OverrideNameScale")
    private Double overrideNameScale;
    @Column("OverrideSelectionRadius")
    private Double overrideSelectionRadius;
    @Column("TamedPetBaseScale")
    private Double tamedPetBaseScale;
    @Column("Unknown820_1")
    private Integer unknown8201;
    @Column("Unknown820_2")
    private Double unknown8202;
    @Column("Unknown820_31")
    private Double unknown82031;
    @Column("Unknown820_32")
    private Double unknown82032;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureModelData> {

        public CreatureModelData convert(Row row) {
            CreatureModelData domain = new CreatureModelData();
            domain.setId(row.get("ID", Integer.class));
            domain.setGeoBox1(row.get("GeoBox1", Double.class));
            domain.setGeoBox2(row.get("GeoBox2", Double.class));
            domain.setGeoBox3(row.get("GeoBox3", Double.class));
            domain.setGeoBox4(row.get("GeoBox4", Double.class));
            domain.setGeoBox5(row.get("GeoBox5", Double.class));
            domain.setGeoBox6(row.get("GeoBox6", Double.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setFileDataId(row.get("FileDataID", Integer.class));
            domain.setBloodId(row.get("BloodID", Integer.class));
            domain.setFootprintTextureId(row.get("FootprintTextureID", Integer.class));
            domain.setFootprintTextureLength(row.get("FootprintTextureLength", Double.class));
            domain.setFootprintTextureWidth(row.get("FootprintTextureWidth", Double.class));
            domain.setFootprintParticleScale(row.get("FootprintParticleScale", Double.class));
            domain.setFoleyMaterialId(row.get("FoleyMaterialID", Integer.class));
            domain.setFootstepCameraEffectId(row.get("FootstepCameraEffectID", Integer.class));
            domain.setDeathThudCameraEffectId(row.get("DeathThudCameraEffectID", Integer.class));
            domain.setSoundId(row.get("SoundID", Integer.class));
            domain.setSizeClass(row.get("SizeClass", Integer.class));
            domain.setCollisionWidth(row.get("CollisionWidth", Double.class));
            domain.setCollisionHeight(row.get("CollisionHeight", Double.class));
            domain.setWorldEffectScale(row.get("WorldEffectScale", Double.class));
            domain.setCreatureGeosetDataId(row.get("CreatureGeosetDataID", Integer.class));
            domain.setHoverHeight(row.get("HoverHeight", Double.class));
            domain.setAttachedEffectScale(row.get("AttachedEffectScale", Double.class));
            domain.setModelScale(row.get("ModelScale", Double.class));
            domain.setMissileCollisionRadius(row.get("MissileCollisionRadius", Double.class));
            domain.setMissileCollisionPush(row.get("MissileCollisionPush", Double.class));
            domain.setMissileCollisionRaise(row.get("MissileCollisionRaise", Double.class));
            domain.setMountHeight(row.get("MountHeight", Double.class));
            domain.setOverrideLootEffectScale(row.get("OverrideLootEffectScale", Double.class));
            domain.setOverrideNameScale(row.get("OverrideNameScale", Double.class));
            domain.setOverrideSelectionRadius(row.get("OverrideSelectionRadius", Double.class));
            domain.setTamedPetBaseScale(row.get("TamedPetBaseScale", Double.class));
            domain.setUnknown8201(row.get("Unknown820_1", Integer.class));
            domain.setUnknown8202(row.get("Unknown820_2", Double.class));
            domain.setUnknown82031(row.get("Unknown820_31", Double.class));
            domain.setUnknown82032(row.get("Unknown820_32", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureModelData, OutboundRow> {

        public OutboundRow convert(CreatureModelData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBox1()).ifPresent(e -> row.put("GeoBox1", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBox2()).ifPresent(e -> row.put("GeoBox2", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBox3()).ifPresent(e -> row.put("GeoBox3", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBox4()).ifPresent(e -> row.put("GeoBox4", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBox5()).ifPresent(e -> row.put("GeoBox5", Parameter.from(e)));
            Optional.ofNullable(source.getGeoBox6()).ifPresent(e -> row.put("GeoBox6", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getFileDataId()).ifPresent(e -> row.put("FileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getBloodId()).ifPresent(e -> row.put("BloodID", Parameter.from(e)));
            Optional.ofNullable(source.getFootprintTextureId()).ifPresent(e -> row.put("FootprintTextureID", Parameter.from(e)));
            Optional.ofNullable(source.getFootprintTextureLength()).ifPresent(e -> row.put("FootprintTextureLength", Parameter.from(e)));
            Optional.ofNullable(source.getFootprintTextureWidth()).ifPresent(e -> row.put("FootprintTextureWidth", Parameter.from(e)));
            Optional.ofNullable(source.getFootprintParticleScale()).ifPresent(e -> row.put("FootprintParticleScale", Parameter.from(e)));
            Optional.ofNullable(source.getFoleyMaterialId()).ifPresent(e -> row.put("FoleyMaterialID", Parameter.from(e)));
            Optional.ofNullable(source.getFootstepCameraEffectId()).ifPresent(e -> row.put("FootstepCameraEffectID", Parameter.from(e)));
            Optional.ofNullable(source.getDeathThudCameraEffectId()).ifPresent(e -> row.put("DeathThudCameraEffectID", Parameter.from(e)));
            Optional.ofNullable(source.getSoundId()).ifPresent(e -> row.put("SoundID", Parameter.from(e)));
            Optional.ofNullable(source.getSizeClass()).ifPresent(e -> row.put("SizeClass", Parameter.from(e)));
            Optional.ofNullable(source.getCollisionWidth()).ifPresent(e -> row.put("CollisionWidth", Parameter.from(e)));
            Optional.ofNullable(source.getCollisionHeight()).ifPresent(e -> row.put("CollisionHeight", Parameter.from(e)));
            Optional.ofNullable(source.getWorldEffectScale()).ifPresent(e -> row.put("WorldEffectScale", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureGeosetDataId()).ifPresent(e -> row.put("CreatureGeosetDataID", Parameter.from(e)));
            Optional.ofNullable(source.getHoverHeight()).ifPresent(e -> row.put("HoverHeight", Parameter.from(e)));
            Optional.ofNullable(source.getAttachedEffectScale()).ifPresent(e -> row.put("AttachedEffectScale", Parameter.from(e)));
            Optional.ofNullable(source.getModelScale()).ifPresent(e -> row.put("ModelScale", Parameter.from(e)));
            Optional.ofNullable(source.getMissileCollisionRadius()).ifPresent(e -> row.put("MissileCollisionRadius", Parameter.from(e)));
            Optional.ofNullable(source.getMissileCollisionPush()).ifPresent(e -> row.put("MissileCollisionPush", Parameter.from(e)));
            Optional.ofNullable(source.getMissileCollisionRaise()).ifPresent(e -> row.put("MissileCollisionRaise", Parameter.from(e)));
            Optional.ofNullable(source.getMountHeight()).ifPresent(e -> row.put("MountHeight", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideLootEffectScale()).ifPresent(e -> row.put("OverrideLootEffectScale", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideNameScale()).ifPresent(e -> row.put("OverrideNameScale", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideSelectionRadius()).ifPresent(e -> row.put("OverrideSelectionRadius", Parameter.from(e)));
            Optional.ofNullable(source.getTamedPetBaseScale()).ifPresent(e -> row.put("TamedPetBaseScale", Parameter.from(e)));
            Optional.ofNullable(source.getUnknown8201()).ifPresent(e -> row.put("Unknown820_1", Parameter.from(e)));
            Optional.ofNullable(source.getUnknown8202()).ifPresent(e -> row.put("Unknown820_2", Parameter.from(e)));
            Optional.ofNullable(source.getUnknown82031()).ifPresent(e -> row.put("Unknown820_31", Parameter.from(e)));
            Optional.ofNullable(source.getUnknown82032()).ifPresent(e -> row.put("Unknown820_32", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
