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
@Table("chr_classes")
public class ChrClasses {

    @Column("Name")
    private String name;
    @Column("Filename")
    private String filename;
    @Column("NameMale")
    private String nameMale;
    @Column("NameFemale")
    private String nameFemale;
    @Column("PetNameToken")
    private String petNameToken;
    @Column("Description")
    private String description;
    @Column("RoleInfoString")
    private String roleInfoString;
    @Column("DisabledString")
    private String disabledString;
    @Column("HyphenatedNameMale")
    private String hyphenatedNameMale;
    @Column("HyphenatedNameFemale")
    private String hyphenatedNameFemale;
    @Column("ID")
    private Integer id;
    @Column("CreateScreenFileDataID")
    private Integer createScreenFileDataId;
    @Column("SelectScreenFileDataID")
    private Integer selectScreenFileDataId;
    @Column("IconFileDataID")
    private Integer iconFileDataId;
    @Column("LowResScreenFileDataID")
    private Integer lowResScreenFileDataId;
    @Column("Flags")
    private Integer flags;
    @Column("SpellTextureBlobFileDataID")
    private Integer spellTextureBlobFileDataId;
    @Column("RolesMask")
    private Integer rolesMask;
    @Column("ArmorTypeMask")
    private Integer armorTypeMask;
    @Column("CharStartKitUnknown901")
    private Integer charStartKitUnknown901;
    @Column("MaleCharacterCreationVisualFallback")
    private Integer maleCharacterCreationVisualFallback;
    @Column("MaleCharacterCreationIdleVisualFallback")
    private Integer maleCharacterCreationIdleVisualFallback;
    @Column("FemaleCharacterCreationVisualFallback")
    private Integer femaleCharacterCreationVisualFallback;
    @Column("FemaleCharacterCreationIdleVisualFallback")
    private Integer femaleCharacterCreationIdleVisualFallback;
    @Column("CharacterCreationIdleGroundVisualFallback")
    private Integer characterCreationIdleGroundVisualFallback;
    @Column("CharacterCreationGroundVisualFallback")
    private Integer characterCreationGroundVisualFallback;
    @Column("AlteredFormCharacterCreationIdleVisualFallback")
    private Integer alteredFormCharacterCreationIdleVisualFallback;
    @Column("CharacterCreationAnimLoopWaitTimeMsFallback")
    private Integer characterCreationAnimLoopWaitTimeMsFallback;
    @Column("CinematicSequenceID")
    private Integer cinematicSequenceId;
    @Column("DefaultSpec")
    private Integer defaultSpec;
    @Column("PrimaryStatPriority")
    private Integer primaryStatPriority;
    @Column("DisplayPower")
    private Integer displayPower;
    @Column("RangedAttackPowerPerAgility")
    private Integer rangedAttackPowerPerAgility;
    @Column("AttackPowerPerAgility")
    private Integer attackPowerPerAgility;
    @Column("AttackPowerPerStrength")
    private Integer attackPowerPerStrength;
    @Column("SpellClassSet")
    private Integer spellClassSet;
    @Column("ChatColorR")
    private Integer chatColorR;
    @Column("ChatColorG")
    private Integer chatColorG;
    @Column("ChatColorB")
    private Integer chatColorB;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrClasses> {

        public ChrClasses convert(Row row) {
            ChrClasses domain = new ChrClasses();
            domain.setName(row.get("Name", String.class));
            domain.setFilename(row.get("Filename", String.class));
            domain.setNameMale(row.get("NameMale", String.class));
            domain.setNameFemale(row.get("NameFemale", String.class));
            domain.setPetNameToken(row.get("PetNameToken", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setRoleInfoString(row.get("RoleInfoString", String.class));
            domain.setDisabledString(row.get("DisabledString", String.class));
            domain.setHyphenatedNameMale(row.get("HyphenatedNameMale", String.class));
            domain.setHyphenatedNameFemale(row.get("HyphenatedNameFemale", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setCreateScreenFileDataId(row.get("CreateScreenFileDataID", Integer.class));
            domain.setSelectScreenFileDataId(row.get("SelectScreenFileDataID", Integer.class));
            domain.setIconFileDataId(row.get("IconFileDataID", Integer.class));
            domain.setLowResScreenFileDataId(row.get("LowResScreenFileDataID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSpellTextureBlobFileDataId(row.get("SpellTextureBlobFileDataID", Integer.class));
            domain.setRolesMask(row.get("RolesMask", Integer.class));
            domain.setArmorTypeMask(row.get("ArmorTypeMask", Integer.class));
            domain.setCharStartKitUnknown901(row.get("CharStartKitUnknown901", Integer.class));
            domain.setMaleCharacterCreationVisualFallback(row.get("MaleCharacterCreationVisualFallback", Integer.class));
            domain.setMaleCharacterCreationIdleVisualFallback(row.get("MaleCharacterCreationIdleVisualFallback", Integer.class));
            domain.setFemaleCharacterCreationVisualFallback(row.get("FemaleCharacterCreationVisualFallback", Integer.class));
            domain.setFemaleCharacterCreationIdleVisualFallback(row.get("FemaleCharacterCreationIdleVisualFallback", Integer.class));
            domain.setCharacterCreationIdleGroundVisualFallback(row.get("CharacterCreationIdleGroundVisualFallback", Integer.class));
            domain.setCharacterCreationGroundVisualFallback(row.get("CharacterCreationGroundVisualFallback", Integer.class));
            domain.setAlteredFormCharacterCreationIdleVisualFallback(row.get("AlteredFormCharacterCreationIdleVisualFallback", Integer.class));
            domain.setCharacterCreationAnimLoopWaitTimeMsFallback(row.get("CharacterCreationAnimLoopWaitTimeMsFallback", Integer.class));
            domain.setCinematicSequenceId(row.get("CinematicSequenceID", Integer.class));
            domain.setDefaultSpec(row.get("DefaultSpec", Integer.class));
            domain.setPrimaryStatPriority(row.get("PrimaryStatPriority", Integer.class));
            domain.setDisplayPower(row.get("DisplayPower", Integer.class));
            domain.setRangedAttackPowerPerAgility(row.get("RangedAttackPowerPerAgility", Integer.class));
            domain.setAttackPowerPerAgility(row.get("AttackPowerPerAgility", Integer.class));
            domain.setAttackPowerPerStrength(row.get("AttackPowerPerStrength", Integer.class));
            domain.setSpellClassSet(row.get("SpellClassSet", Integer.class));
            domain.setChatColorR(row.get("ChatColorR", Integer.class));
            domain.setChatColorG(row.get("ChatColorG", Integer.class));
            domain.setChatColorB(row.get("ChatColorB", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrClasses, OutboundRow> {

        public OutboundRow convert(ChrClasses source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getFilename()).ifPresent(e -> row.put("Filename", Parameter.from(e)));
            Optional.ofNullable(source.getNameMale()).ifPresent(e -> row.put("NameMale", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemale()).ifPresent(e -> row.put("NameFemale", Parameter.from(e)));
            Optional.ofNullable(source.getPetNameToken()).ifPresent(e -> row.put("PetNameToken", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getRoleInfoString()).ifPresent(e -> row.put("RoleInfoString", Parameter.from(e)));
            Optional.ofNullable(source.getDisabledString()).ifPresent(e -> row.put("DisabledString", Parameter.from(e)));
            Optional.ofNullable(source.getHyphenatedNameMale()).ifPresent(e -> row.put("HyphenatedNameMale", Parameter.from(e)));
            Optional.ofNullable(source.getHyphenatedNameFemale()).ifPresent(e -> row.put("HyphenatedNameFemale", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getCreateScreenFileDataId()).ifPresent(e -> row.put("CreateScreenFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getSelectScreenFileDataId()).ifPresent(e -> row.put("SelectScreenFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getIconFileDataId()).ifPresent(e -> row.put("IconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getLowResScreenFileDataId()).ifPresent(e -> row.put("LowResScreenFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSpellTextureBlobFileDataId()).ifPresent(e -> row.put("SpellTextureBlobFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getRolesMask()).ifPresent(e -> row.put("RolesMask", Parameter.from(e)));
            Optional.ofNullable(source.getArmorTypeMask()).ifPresent(e -> row.put("ArmorTypeMask", Parameter.from(e)));
            Optional.ofNullable(source.getCharStartKitUnknown901()).ifPresent(e -> row.put("CharStartKitUnknown901", Parameter.from(e)));
            Optional.ofNullable(source.getMaleCharacterCreationVisualFallback()).ifPresent(e -> row.put("MaleCharacterCreationVisualFallback", Parameter.from(e)));
            Optional.ofNullable(source.getMaleCharacterCreationIdleVisualFallback()).ifPresent(e -> row.put("MaleCharacterCreationIdleVisualFallback", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleCharacterCreationVisualFallback()).ifPresent(e -> row.put("FemaleCharacterCreationVisualFallback", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleCharacterCreationIdleVisualFallback()).ifPresent(e -> row.put("FemaleCharacterCreationIdleVisualFallback", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterCreationIdleGroundVisualFallback()).ifPresent(e -> row.put("CharacterCreationIdleGroundVisualFallback", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterCreationGroundVisualFallback()).ifPresent(e -> row.put("CharacterCreationGroundVisualFallback", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormCharacterCreationIdleVisualFallback()).ifPresent(e -> row.put("AlteredFormCharacterCreationIdleVisualFallback", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterCreationAnimLoopWaitTimeMsFallback()).ifPresent(e -> row.put("CharacterCreationAnimLoopWaitTimeMsFallback", Parameter.from(e)));
            Optional.ofNullable(source.getCinematicSequenceId()).ifPresent(e -> row.put("CinematicSequenceID", Parameter.from(e)));
            Optional.ofNullable(source.getDefaultSpec()).ifPresent(e -> row.put("DefaultSpec", Parameter.from(e)));
            Optional.ofNullable(source.getPrimaryStatPriority()).ifPresent(e -> row.put("PrimaryStatPriority", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayPower()).ifPresent(e -> row.put("DisplayPower", Parameter.from(e)));
            Optional.ofNullable(source.getRangedAttackPowerPerAgility()).ifPresent(e -> row.put("RangedAttackPowerPerAgility", Parameter.from(e)));
            Optional.ofNullable(source.getAttackPowerPerAgility()).ifPresent(e -> row.put("AttackPowerPerAgility", Parameter.from(e)));
            Optional.ofNullable(source.getAttackPowerPerStrength()).ifPresent(e -> row.put("AttackPowerPerStrength", Parameter.from(e)));
            Optional.ofNullable(source.getSpellClassSet()).ifPresent(e -> row.put("SpellClassSet", Parameter.from(e)));
            Optional.ofNullable(source.getChatColorR()).ifPresent(e -> row.put("ChatColorR", Parameter.from(e)));
            Optional.ofNullable(source.getChatColorG()).ifPresent(e -> row.put("ChatColorG", Parameter.from(e)));
            Optional.ofNullable(source.getChatColorB()).ifPresent(e -> row.put("ChatColorB", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
