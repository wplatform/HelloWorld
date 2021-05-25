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
@Table("creature_display_info")
public class CreatureDisplayInfo {

    @Column("ID")
    private Integer id;
    @Column("ModelID")
    private Integer modelId;
    @Column("SoundID")
    private Integer soundId;
    @Column("SizeClass")
    private Integer sizeClass;
    @Column("CreatureModelScale")
    private Double creatureModelScale;
    @Column("CreatureModelAlpha")
    private Integer creatureModelAlpha;
    @Column("BloodID")
    private Integer bloodId;
    @Column("ExtendedDisplayInfoID")
    private Integer extendedDisplayInfoId;
    @Column("NPCSoundID")
    private Integer npcSoundId;
    @Column("ParticleColorID")
    private Integer particleColorId;
    @Column("PortraitCreatureDisplayInfoID")
    private Integer portraitCreatureDisplayInfoId;
    @Column("PortraitTextureFileDataID")
    private Integer portraitTextureFileDataId;
    @Column("ObjectEffectPackageID")
    private Integer objectEffectPackageId;
    @Column("AnimReplacementSetID")
    private Integer animReplacementSetId;
    @Column("Flags")
    private Integer flags;
    @Column("StateSpellVisualKitID")
    private Integer stateSpellVisualKitId;
    @Column("PlayerOverrideScale")
    private Double playerOverrideScale;
    @Column("PetInstanceScale")
    private Double petInstanceScale;
    @Column("UnarmedWeaponType")
    private Integer unarmedWeaponType;
    @Column("MountPoofSpellVisualKitID")
    private Integer mountPoofSpellVisualKitId;
    @Column("DissolveEffectID")
    private Integer dissolveEffectId;
    @Column("Gender")
    private Integer gender;
    @Column("DissolveOutEffectID")
    private Integer dissolveOutEffectId;
    @Column("CreatureModelMinLod")
    private Integer creatureModelMinLod;
    @Column("TextureVariationFileDataID1")
    private Integer textureVariationFileDataId1;
    @Column("TextureVariationFileDataID2")
    private Integer textureVariationFileDataId2;
    @Column("TextureVariationFileDataID3")
    private Integer textureVariationFileDataId3;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureDisplayInfo> {

        public CreatureDisplayInfo convert(Row row) {
            CreatureDisplayInfo domain = new CreatureDisplayInfo();
            domain.setId(row.get("ID", Integer.class));
            domain.setModelId(row.get("ModelID", Integer.class));
            domain.setSoundId(row.get("SoundID", Integer.class));
            domain.setSizeClass(row.get("SizeClass", Integer.class));
            domain.setCreatureModelScale(row.get("CreatureModelScale", Double.class));
            domain.setCreatureModelAlpha(row.get("CreatureModelAlpha", Integer.class));
            domain.setBloodId(row.get("BloodID", Integer.class));
            domain.setExtendedDisplayInfoId(row.get("ExtendedDisplayInfoID", Integer.class));
            domain.setNpcSoundId(row.get("NPCSoundID", Integer.class));
            domain.setParticleColorId(row.get("ParticleColorID", Integer.class));
            domain.setPortraitCreatureDisplayInfoId(row.get("PortraitCreatureDisplayInfoID", Integer.class));
            domain.setPortraitTextureFileDataId(row.get("PortraitTextureFileDataID", Integer.class));
            domain.setObjectEffectPackageId(row.get("ObjectEffectPackageID", Integer.class));
            domain.setAnimReplacementSetId(row.get("AnimReplacementSetID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setStateSpellVisualKitId(row.get("StateSpellVisualKitID", Integer.class));
            domain.setPlayerOverrideScale(row.get("PlayerOverrideScale", Double.class));
            domain.setPetInstanceScale(row.get("PetInstanceScale", Double.class));
            domain.setUnarmedWeaponType(row.get("UnarmedWeaponType", Integer.class));
            domain.setMountPoofSpellVisualKitId(row.get("MountPoofSpellVisualKitID", Integer.class));
            domain.setDissolveEffectId(row.get("DissolveEffectID", Integer.class));
            domain.setGender(row.get("Gender", Integer.class));
            domain.setDissolveOutEffectId(row.get("DissolveOutEffectID", Integer.class));
            domain.setCreatureModelMinLod(row.get("CreatureModelMinLod", Integer.class));
            domain.setTextureVariationFileDataId1(row.get("TextureVariationFileDataID1", Integer.class));
            domain.setTextureVariationFileDataId2(row.get("TextureVariationFileDataID2", Integer.class));
            domain.setTextureVariationFileDataId3(row.get("TextureVariationFileDataID3", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureDisplayInfo, OutboundRow> {

        public OutboundRow convert(CreatureDisplayInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getModelId()).ifPresent(e -> row.put("ModelID", Parameter.from(e)));
            Optional.ofNullable(source.getSoundId()).ifPresent(e -> row.put("SoundID", Parameter.from(e)));
            Optional.ofNullable(source.getSizeClass()).ifPresent(e -> row.put("SizeClass", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureModelScale()).ifPresent(e -> row.put("CreatureModelScale", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureModelAlpha()).ifPresent(e -> row.put("CreatureModelAlpha", Parameter.from(e)));
            Optional.ofNullable(source.getBloodId()).ifPresent(e -> row.put("BloodID", Parameter.from(e)));
            Optional.ofNullable(source.getExtendedDisplayInfoId()).ifPresent(e -> row.put("ExtendedDisplayInfoID", Parameter.from(e)));
            Optional.ofNullable(source.getNpcSoundId()).ifPresent(e -> row.put("NPCSoundID", Parameter.from(e)));
            Optional.ofNullable(source.getParticleColorId()).ifPresent(e -> row.put("ParticleColorID", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitCreatureDisplayInfoId()).ifPresent(e -> row.put("PortraitCreatureDisplayInfoID", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitTextureFileDataId()).ifPresent(e -> row.put("PortraitTextureFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getObjectEffectPackageId()).ifPresent(e -> row.put("ObjectEffectPackageID", Parameter.from(e)));
            Optional.ofNullable(source.getAnimReplacementSetId()).ifPresent(e -> row.put("AnimReplacementSetID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getStateSpellVisualKitId()).ifPresent(e -> row.put("StateSpellVisualKitID", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerOverrideScale()).ifPresent(e -> row.put("PlayerOverrideScale", Parameter.from(e)));
            Optional.ofNullable(source.getPetInstanceScale()).ifPresent(e -> row.put("PetInstanceScale", Parameter.from(e)));
            Optional.ofNullable(source.getUnarmedWeaponType()).ifPresent(e -> row.put("UnarmedWeaponType", Parameter.from(e)));
            Optional.ofNullable(source.getMountPoofSpellVisualKitId()).ifPresent(e -> row.put("MountPoofSpellVisualKitID", Parameter.from(e)));
            Optional.ofNullable(source.getDissolveEffectId()).ifPresent(e -> row.put("DissolveEffectID", Parameter.from(e)));
            Optional.ofNullable(source.getGender()).ifPresent(e -> row.put("Gender", Parameter.from(e)));
            Optional.ofNullable(source.getDissolveOutEffectId()).ifPresent(e -> row.put("DissolveOutEffectID", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureModelMinLod()).ifPresent(e -> row.put("CreatureModelMinLod", Parameter.from(e)));
            Optional.ofNullable(source.getTextureVariationFileDataId1()).ifPresent(e -> row.put("TextureVariationFileDataID1", Parameter.from(e)));
            Optional.ofNullable(source.getTextureVariationFileDataId2()).ifPresent(e -> row.put("TextureVariationFileDataID2", Parameter.from(e)));
            Optional.ofNullable(source.getTextureVariationFileDataId3()).ifPresent(e -> row.put("TextureVariationFileDataID3", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
