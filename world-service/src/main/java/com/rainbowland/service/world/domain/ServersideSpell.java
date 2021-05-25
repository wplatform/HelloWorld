package com.rainbowland.service.world.domain;

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
@Table("serverside_spell")
public class ServersideSpell {

    @Column("Id")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("CategoryId")
    private Integer categoryId;
    @Column("Dispel")
    private Integer dispel;
    @Column("Mechanic")
    private Integer mechanic;
    @Column("Attributes")
    private Integer attributes;
    @Column("AttributesEx")
    private Integer attributesEx;
    @Column("AttributesEx2")
    private Integer attributesEx2;
    @Column("AttributesEx3")
    private Integer attributesEx3;
    @Column("AttributesEx4")
    private Integer attributesEx4;
    @Column("AttributesEx5")
    private Integer attributesEx5;
    @Column("AttributesEx6")
    private Integer attributesEx6;
    @Column("AttributesEx7")
    private Integer attributesEx7;
    @Column("AttributesEx8")
    private Integer attributesEx8;
    @Column("AttributesEx9")
    private Integer attributesEx9;
    @Column("AttributesEx10")
    private Integer attributesEx10;
    @Column("AttributesEx11")
    private Integer attributesEx11;
    @Column("AttributesEx12")
    private Integer attributesEx12;
    @Column("AttributesEx13")
    private Integer attributesEx13;
    @Column("AttributesEx14")
    private Integer attributesEx14;
    @Column("Stances")
    private Long stances;
    @Column("StancesNot")
    private Long stancesNot;
    @Column("Targets")
    private Integer targets;
    @Column("TargetCreatureType")
    private Integer targetCreatureType;
    @Column("RequiresSpellFocus")
    private Integer requiresSpellFocus;
    @Column("FacingCasterFlags")
    private Integer facingCasterFlags;
    @Column("CasterAuraState")
    private Integer casterAuraState;
    @Column("TargetAuraState")
    private Integer targetAuraState;
    @Column("ExcludeCasterAuraState")
    private Integer excludeCasterAuraState;
    @Column("ExcludeTargetAuraState")
    private Integer excludeTargetAuraState;
    @Column("CasterAuraSpell")
    private Integer casterAuraSpell;
    @Column("TargetAuraSpell")
    private Integer targetAuraSpell;
    @Column("ExcludeCasterAuraSpell")
    private Integer excludeCasterAuraSpell;
    @Column("ExcludeTargetAuraSpell")
    private Integer excludeTargetAuraSpell;
    @Column("CastingTimeIndex")
    private Integer castingTimeIndex;
    @Column("RecoveryTime")
    private Integer recoveryTime;
    @Column("CategoryRecoveryTime")
    private Integer categoryRecoveryTime;
    @Column("StartRecoveryCategory")
    private Integer startRecoveryCategory;
    @Column("StartRecoveryTime")
    private Integer startRecoveryTime;
    @Column("InterruptFlags")
    private Integer interruptFlags;
    @Column("AuraInterruptFlags1")
    private Integer auraInterruptFlags1;
    @Column("AuraInterruptFlags2")
    private Integer auraInterruptFlags2;
    @Column("ChannelInterruptFlags1")
    private Integer channelInterruptFlags1;
    @Column("ChannelInterruptFlags2")
    private Integer channelInterruptFlags2;
    @Column("ProcFlags")
    private Integer procFlags;
    @Column("ProcChance")
    private Integer procChance;
    @Column("ProcCharges")
    private Integer procCharges;
    @Column("ProcCooldown")
    private Integer procCooldown;
    @Column("ProcBasePPM")
    private Double procBasePpm;
    @Column("MaxLevel")
    private Integer maxLevel;
    @Column("BaseLevel")
    private Integer baseLevel;
    @Column("SpellLevel")
    private Integer spellLevel;
    @Column("DurationIndex")
    private Integer durationIndex;
    @Column("RangeIndex")
    private Integer rangeIndex;
    @Column("Speed")
    private Double speed;
    @Column("LaunchDelay")
    private Double launchDelay;
    @Column("StackAmount")
    private Integer stackAmount;
    @Column("EquippedItemClass")
    private Integer equippedItemClass;
    @Column("EquippedItemSubClassMask")
    private Integer equippedItemSubClassMask;
    @Column("EquippedItemInventoryTypeMask")
    private Integer equippedItemInventoryTypeMask;
    @Column("ContentTuningId")
    private Integer contentTuningId;
    @Column("SpellName")
    private String spellName;
    @Column("ConeAngle")
    private Double coneAngle;
    @Column("ConeWidth")
    private Double coneWidth;
    @Column("MaxTargetLevel")
    private Integer maxTargetLevel;
    @Column("MaxAffectedTargets")
    private Integer maxAffectedTargets;
    @Column("SpellFamilyName")
    private Integer spellFamilyName;
    @Column("SpellFamilyFlags1")
    private Integer spellFamilyFlags1;
    @Column("SpellFamilyFlags2")
    private Integer spellFamilyFlags2;
    @Column("SpellFamilyFlags3")
    private Integer spellFamilyFlags3;
    @Column("SpellFamilyFlags4")
    private Integer spellFamilyFlags4;
    @Column("DmgClass")
    private Integer dmgClass;
    @Column("PreventionType")
    private Integer preventionType;
    @Column("AreaGroupId")
    private Integer areaGroupId;
    @Column("SchoolMask")
    private Integer schoolMask;
    @Column("ChargeCategoryId")
    private Integer chargeCategoryId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ServersideSpell> {

        public ServersideSpell convert(Row row) {
            ServersideSpell domain = new ServersideSpell();
            domain.setId(row.get("Id", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setCategoryId(row.get("CategoryId", Integer.class));
            domain.setDispel(row.get("Dispel", Integer.class));
            domain.setMechanic(row.get("Mechanic", Integer.class));
            domain.setAttributes(row.get("Attributes", Integer.class));
            domain.setAttributesEx(row.get("AttributesEx", Integer.class));
            domain.setAttributesEx2(row.get("AttributesEx2", Integer.class));
            domain.setAttributesEx3(row.get("AttributesEx3", Integer.class));
            domain.setAttributesEx4(row.get("AttributesEx4", Integer.class));
            domain.setAttributesEx5(row.get("AttributesEx5", Integer.class));
            domain.setAttributesEx6(row.get("AttributesEx6", Integer.class));
            domain.setAttributesEx7(row.get("AttributesEx7", Integer.class));
            domain.setAttributesEx8(row.get("AttributesEx8", Integer.class));
            domain.setAttributesEx9(row.get("AttributesEx9", Integer.class));
            domain.setAttributesEx10(row.get("AttributesEx10", Integer.class));
            domain.setAttributesEx11(row.get("AttributesEx11", Integer.class));
            domain.setAttributesEx12(row.get("AttributesEx12", Integer.class));
            domain.setAttributesEx13(row.get("AttributesEx13", Integer.class));
            domain.setAttributesEx14(row.get("AttributesEx14", Integer.class));
            domain.setStances(row.get("Stances", Long.class));
            domain.setStancesNot(row.get("StancesNot", Long.class));
            domain.setTargets(row.get("Targets", Integer.class));
            domain.setTargetCreatureType(row.get("TargetCreatureType", Integer.class));
            domain.setRequiresSpellFocus(row.get("RequiresSpellFocus", Integer.class));
            domain.setFacingCasterFlags(row.get("FacingCasterFlags", Integer.class));
            domain.setCasterAuraState(row.get("CasterAuraState", Integer.class));
            domain.setTargetAuraState(row.get("TargetAuraState", Integer.class));
            domain.setExcludeCasterAuraState(row.get("ExcludeCasterAuraState", Integer.class));
            domain.setExcludeTargetAuraState(row.get("ExcludeTargetAuraState", Integer.class));
            domain.setCasterAuraSpell(row.get("CasterAuraSpell", Integer.class));
            domain.setTargetAuraSpell(row.get("TargetAuraSpell", Integer.class));
            domain.setExcludeCasterAuraSpell(row.get("ExcludeCasterAuraSpell", Integer.class));
            domain.setExcludeTargetAuraSpell(row.get("ExcludeTargetAuraSpell", Integer.class));
            domain.setCastingTimeIndex(row.get("CastingTimeIndex", Integer.class));
            domain.setRecoveryTime(row.get("RecoveryTime", Integer.class));
            domain.setCategoryRecoveryTime(row.get("CategoryRecoveryTime", Integer.class));
            domain.setStartRecoveryCategory(row.get("StartRecoveryCategory", Integer.class));
            domain.setStartRecoveryTime(row.get("StartRecoveryTime", Integer.class));
            domain.setInterruptFlags(row.get("InterruptFlags", Integer.class));
            domain.setAuraInterruptFlags1(row.get("AuraInterruptFlags1", Integer.class));
            domain.setAuraInterruptFlags2(row.get("AuraInterruptFlags2", Integer.class));
            domain.setChannelInterruptFlags1(row.get("ChannelInterruptFlags1", Integer.class));
            domain.setChannelInterruptFlags2(row.get("ChannelInterruptFlags2", Integer.class));
            domain.setProcFlags(row.get("ProcFlags", Integer.class));
            domain.setProcChance(row.get("ProcChance", Integer.class));
            domain.setProcCharges(row.get("ProcCharges", Integer.class));
            domain.setProcCooldown(row.get("ProcCooldown", Integer.class));
            domain.setProcBasePpm(row.get("ProcBasePPM", Double.class));
            domain.setMaxLevel(row.get("MaxLevel", Integer.class));
            domain.setBaseLevel(row.get("BaseLevel", Integer.class));
            domain.setSpellLevel(row.get("SpellLevel", Integer.class));
            domain.setDurationIndex(row.get("DurationIndex", Integer.class));
            domain.setRangeIndex(row.get("RangeIndex", Integer.class));
            domain.setSpeed(row.get("Speed", Double.class));
            domain.setLaunchDelay(row.get("LaunchDelay", Double.class));
            domain.setStackAmount(row.get("StackAmount", Integer.class));
            domain.setEquippedItemClass(row.get("EquippedItemClass", Integer.class));
            domain.setEquippedItemSubClassMask(row.get("EquippedItemSubClassMask", Integer.class));
            domain.setEquippedItemInventoryTypeMask(row.get("EquippedItemInventoryTypeMask", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningId", Integer.class));
            domain.setSpellName(row.get("SpellName", String.class));
            domain.setConeAngle(row.get("ConeAngle", Double.class));
            domain.setConeWidth(row.get("ConeWidth", Double.class));
            domain.setMaxTargetLevel(row.get("MaxTargetLevel", Integer.class));
            domain.setMaxAffectedTargets(row.get("MaxAffectedTargets", Integer.class));
            domain.setSpellFamilyName(row.get("SpellFamilyName", Integer.class));
            domain.setSpellFamilyFlags1(row.get("SpellFamilyFlags1", Integer.class));
            domain.setSpellFamilyFlags2(row.get("SpellFamilyFlags2", Integer.class));
            domain.setSpellFamilyFlags3(row.get("SpellFamilyFlags3", Integer.class));
            domain.setSpellFamilyFlags4(row.get("SpellFamilyFlags4", Integer.class));
            domain.setDmgClass(row.get("DmgClass", Integer.class));
            domain.setPreventionType(row.get("PreventionType", Integer.class));
            domain.setAreaGroupId(row.get("AreaGroupId", Integer.class));
            domain.setSchoolMask(row.get("SchoolMask", Integer.class));
            domain.setChargeCategoryId(row.get("ChargeCategoryId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ServersideSpell, OutboundRow> {

        public OutboundRow convert(ServersideSpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryId()).ifPresent(e -> row.put("CategoryId", Parameter.from(e)));
            Optional.ofNullable(source.getDispel()).ifPresent(e -> row.put("Dispel", Parameter.from(e)));
            Optional.ofNullable(source.getMechanic()).ifPresent(e -> row.put("Mechanic", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes()).ifPresent(e -> row.put("Attributes", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx()).ifPresent(e -> row.put("AttributesEx", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx2()).ifPresent(e -> row.put("AttributesEx2", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx3()).ifPresent(e -> row.put("AttributesEx3", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx4()).ifPresent(e -> row.put("AttributesEx4", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx5()).ifPresent(e -> row.put("AttributesEx5", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx6()).ifPresent(e -> row.put("AttributesEx6", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx7()).ifPresent(e -> row.put("AttributesEx7", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx8()).ifPresent(e -> row.put("AttributesEx8", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx9()).ifPresent(e -> row.put("AttributesEx9", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx10()).ifPresent(e -> row.put("AttributesEx10", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx11()).ifPresent(e -> row.put("AttributesEx11", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx12()).ifPresent(e -> row.put("AttributesEx12", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx13()).ifPresent(e -> row.put("AttributesEx13", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesEx14()).ifPresent(e -> row.put("AttributesEx14", Parameter.from(e)));
            Optional.ofNullable(source.getStances()).ifPresent(e -> row.put("Stances", Parameter.from(e)));
            Optional.ofNullable(source.getStancesNot()).ifPresent(e -> row.put("StancesNot", Parameter.from(e)));
            Optional.ofNullable(source.getTargets()).ifPresent(e -> row.put("Targets", Parameter.from(e)));
            Optional.ofNullable(source.getTargetCreatureType()).ifPresent(e -> row.put("TargetCreatureType", Parameter.from(e)));
            Optional.ofNullable(source.getRequiresSpellFocus()).ifPresent(e -> row.put("RequiresSpellFocus", Parameter.from(e)));
            Optional.ofNullable(source.getFacingCasterFlags()).ifPresent(e -> row.put("FacingCasterFlags", Parameter.from(e)));
            Optional.ofNullable(source.getCasterAuraState()).ifPresent(e -> row.put("CasterAuraState", Parameter.from(e)));
            Optional.ofNullable(source.getTargetAuraState()).ifPresent(e -> row.put("TargetAuraState", Parameter.from(e)));
            Optional.ofNullable(source.getExcludeCasterAuraState()).ifPresent(e -> row.put("ExcludeCasterAuraState", Parameter.from(e)));
            Optional.ofNullable(source.getExcludeTargetAuraState()).ifPresent(e -> row.put("ExcludeTargetAuraState", Parameter.from(e)));
            Optional.ofNullable(source.getCasterAuraSpell()).ifPresent(e -> row.put("CasterAuraSpell", Parameter.from(e)));
            Optional.ofNullable(source.getTargetAuraSpell()).ifPresent(e -> row.put("TargetAuraSpell", Parameter.from(e)));
            Optional.ofNullable(source.getExcludeCasterAuraSpell()).ifPresent(e -> row.put("ExcludeCasterAuraSpell", Parameter.from(e)));
            Optional.ofNullable(source.getExcludeTargetAuraSpell()).ifPresent(e -> row.put("ExcludeTargetAuraSpell", Parameter.from(e)));
            Optional.ofNullable(source.getCastingTimeIndex()).ifPresent(e -> row.put("CastingTimeIndex", Parameter.from(e)));
            Optional.ofNullable(source.getRecoveryTime()).ifPresent(e -> row.put("RecoveryTime", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryRecoveryTime()).ifPresent(e -> row.put("CategoryRecoveryTime", Parameter.from(e)));
            Optional.ofNullable(source.getStartRecoveryCategory()).ifPresent(e -> row.put("StartRecoveryCategory", Parameter.from(e)));
            Optional.ofNullable(source.getStartRecoveryTime()).ifPresent(e -> row.put("StartRecoveryTime", Parameter.from(e)));
            Optional.ofNullable(source.getInterruptFlags()).ifPresent(e -> row.put("InterruptFlags", Parameter.from(e)));
            Optional.ofNullable(source.getAuraInterruptFlags1()).ifPresent(e -> row.put("AuraInterruptFlags1", Parameter.from(e)));
            Optional.ofNullable(source.getAuraInterruptFlags2()).ifPresent(e -> row.put("AuraInterruptFlags2", Parameter.from(e)));
            Optional.ofNullable(source.getChannelInterruptFlags1()).ifPresent(e -> row.put("ChannelInterruptFlags1", Parameter.from(e)));
            Optional.ofNullable(source.getChannelInterruptFlags2()).ifPresent(e -> row.put("ChannelInterruptFlags2", Parameter.from(e)));
            Optional.ofNullable(source.getProcFlags()).ifPresent(e -> row.put("ProcFlags", Parameter.from(e)));
            Optional.ofNullable(source.getProcChance()).ifPresent(e -> row.put("ProcChance", Parameter.from(e)));
            Optional.ofNullable(source.getProcCharges()).ifPresent(e -> row.put("ProcCharges", Parameter.from(e)));
            Optional.ofNullable(source.getProcCooldown()).ifPresent(e -> row.put("ProcCooldown", Parameter.from(e)));
            Optional.ofNullable(source.getProcBasePpm()).ifPresent(e -> row.put("ProcBasePPM", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("MaxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getBaseLevel()).ifPresent(e -> row.put("BaseLevel", Parameter.from(e)));
            Optional.ofNullable(source.getSpellLevel()).ifPresent(e -> row.put("SpellLevel", Parameter.from(e)));
            Optional.ofNullable(source.getDurationIndex()).ifPresent(e -> row.put("DurationIndex", Parameter.from(e)));
            Optional.ofNullable(source.getRangeIndex()).ifPresent(e -> row.put("RangeIndex", Parameter.from(e)));
            Optional.ofNullable(source.getSpeed()).ifPresent(e -> row.put("Speed", Parameter.from(e)));
            Optional.ofNullable(source.getLaunchDelay()).ifPresent(e -> row.put("LaunchDelay", Parameter.from(e)));
            Optional.ofNullable(source.getStackAmount()).ifPresent(e -> row.put("StackAmount", Parameter.from(e)));
            Optional.ofNullable(source.getEquippedItemClass()).ifPresent(e -> row.put("EquippedItemClass", Parameter.from(e)));
            Optional.ofNullable(source.getEquippedItemSubClassMask()).ifPresent(e -> row.put("EquippedItemSubClassMask", Parameter.from(e)));
            Optional.ofNullable(source.getEquippedItemInventoryTypeMask()).ifPresent(e -> row.put("EquippedItemInventoryTypeMask", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningId", Parameter.from(e)));
            Optional.ofNullable(source.getSpellName()).ifPresent(e -> row.put("SpellName", Parameter.from(e)));
            Optional.ofNullable(source.getConeAngle()).ifPresent(e -> row.put("ConeAngle", Parameter.from(e)));
            Optional.ofNullable(source.getConeWidth()).ifPresent(e -> row.put("ConeWidth", Parameter.from(e)));
            Optional.ofNullable(source.getMaxTargetLevel()).ifPresent(e -> row.put("MaxTargetLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxAffectedTargets()).ifPresent(e -> row.put("MaxAffectedTargets", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyName()).ifPresent(e -> row.put("SpellFamilyName", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyFlags1()).ifPresent(e -> row.put("SpellFamilyFlags1", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyFlags2()).ifPresent(e -> row.put("SpellFamilyFlags2", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyFlags3()).ifPresent(e -> row.put("SpellFamilyFlags3", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyFlags4()).ifPresent(e -> row.put("SpellFamilyFlags4", Parameter.from(e)));
            Optional.ofNullable(source.getDmgClass()).ifPresent(e -> row.put("DmgClass", Parameter.from(e)));
            Optional.ofNullable(source.getPreventionType()).ifPresent(e -> row.put("PreventionType", Parameter.from(e)));
            Optional.ofNullable(source.getAreaGroupId()).ifPresent(e -> row.put("AreaGroupId", Parameter.from(e)));
            Optional.ofNullable(source.getSchoolMask()).ifPresent(e -> row.put("SchoolMask", Parameter.from(e)));
            Optional.ofNullable(source.getChargeCategoryId()).ifPresent(e -> row.put("ChargeCategoryId", Parameter.from(e)));
            return row;
        }
    }

}
