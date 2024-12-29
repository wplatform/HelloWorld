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

    @Column("ID")
    private int id;

    @Column("ModelScale")
    private Float modelScale;

    @Column("FootprintTextureLength")
    private Float footprintTextureLength;

    @Column("FootprintTextureWidth")
    private Float footprintTextureWidth;

    @Column("FootprintParticleScale")
    private Float footprintParticleScale;

    @Column("CollisionWidth")
    private Float collisionWidth;

    @Column("CollisionHeight")
    private Float collisionHeight;

    @Column("MountHeight")
    private Float mountHeight;

    @Column("GeoBox1")
    private Float geoBox1;

    @Column("GeoBox2")
    private Float geoBox2;

    @Column("GeoBox3")
    private Float geoBox3;

    @Column("GeoBox4")
    private Float geoBox4;

    @Column("GeoBox5")
    private Float geoBox5;

    @Column("GeoBox6")
    private Float geoBox6;

    @Column("WorldEffectScale")
    private Float worldEffectScale;

    @Column("AttachedEffectScale")
    private Float attachedEffectScale;

    @Column("MissileCollisionRadius")
    private Float missileCollisionRadius;

    @Column("MissileCollisionPush")
    private Float missileCollisionPush;

    @Column("MissileCollisionRaise")
    private Float missileCollisionRaise;

    @Column("OverrideLootEffectScale")
    private Float overrideLootEffectScale;

    @Column("OverrideNameScale")
    private Float overrideNameScale;

    @Column("OverrideSelectionRadius")
    private Float overrideSelectionRadius;

    @Column("TamedPetBaseScale")
    private Float tamedPetBaseScale;

    @Column("HoverHeight")
    private Float hoverHeight;

    @Column("Flags")
    private Integer flags;

    @Column("FileDataID")
    private Integer fileDataID;

    @Column("SizeClass")
    private Integer sizeClass;

    @Column("BloodID")
    private Integer bloodID;

    @Column("FootprintTextureID")
    private Integer footprintTextureID;

    @Column("FoleyMaterialID")
    private Integer foleyMaterialID;

    @Column("FootstepCameraEffectID")
    private Integer footstepCameraEffectID;

    @Column("DeathThudCameraEffectID")
    private Integer deathThudCameraEffectID;

    @Column("SoundID")
    private Integer soundID;

    @Column("CreatureGeosetDataID")
    private Integer creatureGeosetDataID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
