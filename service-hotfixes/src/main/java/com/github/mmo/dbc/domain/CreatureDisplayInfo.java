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


@Table(name = "creature_display_info")
@Db2DataBind(name = "CreatureDisplayInfo.db2", layoutHash = 0x406268DF, indexField = 0, fields = {
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "creatureModelScale", type = Db2Type.FLOAT),
        @Db2Field(name = "modelID", type = Db2Type.SHORT),
        @Db2Field(name = "nPCSoundID", type = Db2Type.SHORT),
        @Db2Field(name = "sizeClass", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "gender", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "extendedDisplayInfoID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "portraitTextureFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "creatureModelAlpha", type = Db2Type.BYTE),
        @Db2Field(name = "soundID", type = Db2Type.SHORT),
        @Db2Field(name = "playerOverrideScale", type = Db2Type.FLOAT),
        @Db2Field(name = "portraitCreatureDisplayInfoID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "bloodID", type = Db2Type.BYTE),
        @Db2Field(name = "particleColorID", type = Db2Type.SHORT),
        @Db2Field(name = "creatureGeosetData", type = Db2Type.INT),
        @Db2Field(name = "objectEffectPackageID", type = Db2Type.SHORT),
        @Db2Field(name = "animReplacementSetID", type = Db2Type.SHORT),
        @Db2Field(name = "unarmedWeaponType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "stateSpellVisualKitID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "petInstanceScale", type = Db2Type.FLOAT),
        @Db2Field(name = "mountPoofSpellVisualKitID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"textureVariationFileDataID1", "textureVariationFileDataID2", "textureVariationFileDataID3"}, type = Db2Type.INT, signed = true)
})
public class CreatureDisplayInfo implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("CreatureModelScale")
    private Float creatureModelScale;

    @Column("ModelID")
    private Short modelID;

    @Column("NPCSoundID")
    private Short nPCSoundID;

    @Column("SizeClass")
    private Byte sizeClass;

    @Column("Flags")
    private Byte flags;

    @Column("Gender")
    private Byte gender;

    @Column("ExtendedDisplayInfoID")
    private Integer extendedDisplayInfoID;

    @Column("PortraitTextureFileDataID")
    private Integer portraitTextureFileDataID;

    @Column("CreatureModelAlpha")
    private Short creatureModelAlpha;

    @Column("SoundID")
    private Short soundID;

    @Column("PlayerOverrideScale")
    private Float playerOverrideScale;

    @Column("PortraitCreatureDisplayInfoID")
    private Integer portraitCreatureDisplayInfoID;

    @Column("BloodID")
    private Byte bloodID;

    @Column("ParticleColorID")
    private Short particleColorID;

    @Column("CreatureGeosetData")
    private Integer creatureGeosetData;

    @Column("ObjectEffectPackageID")
    private Short objectEffectPackageID;

    @Column("AnimReplacementSetID")
    private Short animReplacementSetID;

    @Column("UnarmedWeaponType")
    private Byte unarmedWeaponType;

    @Column("StateSpellVisualKitID")
    private Integer stateSpellVisualKitID;

    @Column("PetInstanceScale")
    private Float petInstanceScale;

    @Column("MountPoofSpellVisualKitID")
    private Integer mountPoofSpellVisualKitID;

    @Column("TextureVariationFileDataID1")
    private Integer textureVariationFileDataID1;

    @Column("TextureVariationFileDataID2")
    private Integer textureVariationFileDataID2;

    @Column("TextureVariationFileDataID3")
    private Integer textureVariationFileDataID3;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
