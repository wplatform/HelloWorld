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
@Table(name = "creature_model_data")
@Db2DataBind(name = "CreatureModelData.db2", layoutHash = 0x983BD312, fields = {
        @Db2Field(name = "modelScale", type = Db2Type.FLOAT),
        @Db2Field(name = "footprintTextureLength", type = Db2Type.FLOAT),
        @Db2Field(name = "footprintTextureWidth", type = Db2Type.FLOAT),
        @Db2Field(name = "footprintParticleScale", type = Db2Type.FLOAT),
        @Db2Field(name = "collisionWidth", type = Db2Type.FLOAT),
        @Db2Field(name = "collisionHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "mountHeight", type = Db2Type.FLOAT),
        @Db2Field(name = {"geoBox1", "geoBox2", "geoBox3", "geoBox4", "geoBox5", "geoBox6"}, type = Db2Type.FLOAT),
        @Db2Field(name = "worldEffectScale", type = Db2Type.FLOAT),
        @Db2Field(name = "attachedEffectScale", type = Db2Type.FLOAT),
        @Db2Field(name = "missileCollisionRadius", type = Db2Type.FLOAT),
        @Db2Field(name = "missileCollisionPush", type = Db2Type.FLOAT),
        @Db2Field(name = "missileCollisionRaise", type = Db2Type.FLOAT),
        @Db2Field(name = "overrideLootEffectScale", type = Db2Type.FLOAT),
        @Db2Field(name = "overrideNameScale", type = Db2Type.FLOAT),
        @Db2Field(name = "overrideSelectionRadius", type = Db2Type.FLOAT),
        @Db2Field(name = "tamedPetBaseScale", type = Db2Type.FLOAT),
        @Db2Field(name = "hoverHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "flags", type = Db2Type.INT),
        @Db2Field(name = "fileDataID", type = Db2Type.INT),
        @Db2Field(name = "sizeClass", type = Db2Type.INT),
        @Db2Field(name = "bloodID", type = Db2Type.INT),
        @Db2Field(name = "footprintTextureID", type = Db2Type.INT),
        @Db2Field(name = "foleyMaterialID", type = Db2Type.INT),
        @Db2Field(name = "footstepCameraEffectID", type = Db2Type.INT),
        @Db2Field(name = "deathThudCameraEffectID", type = Db2Type.INT),
        @Db2Field(name = "soundID", type = Db2Type.INT),
        @Db2Field(name = "creatureGeosetDataID", type = Db2Type.INT)
})
public class CreatureModelData implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ModelScale")
    private Float modelScale;

    @Column(name = "FootprintTextureLength")
    private Float footprintTextureLength;

    @Column(name = "FootprintTextureWidth")
    private Float footprintTextureWidth;

    @Column(name = "FootprintParticleScale")
    private Float footprintParticleScale;

    @Column(name = "CollisionWidth")
    private Float collisionWidth;

    @Column(name = "CollisionHeight")
    private Float collisionHeight;

    @Column(name = "MountHeight")
    private Float mountHeight;

    @Column(name = "GeoBox1")
    private Float geoBox1;

    @Column(name = "GeoBox2")
    private Float geoBox2;

    @Column(name = "GeoBox3")
    private Float geoBox3;

    @Column(name = "GeoBox4")
    private Float geoBox4;

    @Column(name = "GeoBox5")
    private Float geoBox5;

    @Column(name = "GeoBox6")
    private Float geoBox6;

    @Column(name = "WorldEffectScale")
    private Float worldEffectScale;

    @Column(name = "AttachedEffectScale")
    private Float attachedEffectScale;

    @Column(name = "MissileCollisionRadius")
    private Float missileCollisionRadius;

    @Column(name = "MissileCollisionPush")
    private Float missileCollisionPush;

    @Column(name = "MissileCollisionRaise")
    private Float missileCollisionRaise;

    @Column(name = "OverrideLootEffectScale")
    private Float overrideLootEffectScale;

    @Column(name = "OverrideNameScale")
    private Float overrideNameScale;

    @Column(name = "OverrideSelectionRadius")
    private Float overrideSelectionRadius;

    @Column(name = "TamedPetBaseScale")
    private Float tamedPetBaseScale;

    @Column(name = "HoverHeight")
    private Float hoverHeight;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "FileDataID")
    private Integer fileDataID;

    @Column(name = "SizeClass")
    private Integer sizeClass;

    @Column(name = "BloodID")
    private Integer bloodID;

    @Column(name = "FootprintTextureID")
    private Integer footprintTextureID;

    @Column(name = "FoleyMaterialID")
    private Integer foleyMaterialID;

    @Column(name = "FootstepCameraEffectID")
    private Integer footstepCameraEffectID;

    @Column(name = "DeathThudCameraEffectID")
    private Integer deathThudCameraEffectID;

    @Column(name = "SoundID")
    private Integer soundID;

    @Column(name = "CreatureGeosetDataID")
    private Integer creatureGeosetDataID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
