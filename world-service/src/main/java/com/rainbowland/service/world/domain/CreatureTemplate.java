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
@Table("creature_template")
public class CreatureTemplate {

    @Column("entry")
    private Integer entry;
    @Column("difficulty_entry_1")
    private Integer difficultyEntry1;
    @Column("difficulty_entry_2")
    private Integer difficultyEntry2;
    @Column("difficulty_entry_3")
    private Integer difficultyEntry3;
    @Column("KillCredit1")
    private Integer killCredit1;
    @Column("KillCredit2")
    private Integer killCredit2;
    @Column("name")
    private String name;
    @Column("femaleName")
    private String femaleName;
    @Column("subname")
    private String subname;
    @Column("TitleAlt")
    private String titleAlt;
    @Column("IconName")
    private String iconName;
    @Column("gossip_menu_id")
    private Integer gossipMenuId;
    @Column("minlevel")
    private Integer minlevel;
    @Column("maxlevel")
    private Integer maxlevel;
    @Column("HealthScalingExpansion")
    private Integer healthScalingExpansion;
    @Column("RequiredExpansion")
    private Integer requiredExpansion;
    @Column("VignetteID")
    private Integer vignetteId;
    @Column("faction")
    private Integer faction;
    @Column("npcflag")
    private Long npcflag;
    @Column("speed_walk")
    private Double speedWalk;
    @Column("speed_run")
    private Double speedRun;
    @Column("scale")
    private Double scale;
    @Column("rank")
    private Integer rank;
    @Column("dmgschool")
    private Integer dmgschool;
    @Column("BaseAttackTime")
    private Integer baseAttackTime;
    @Column("RangeAttackTime")
    private Integer rangeAttackTime;
    @Column("BaseVariance")
    private Double baseVariance;
    @Column("RangeVariance")
    private Double rangeVariance;
    @Column("unit_class")
    private Integer unitClass;
    @Column("unit_flags")
    private Integer unitFlags;
    @Column("unit_flags2")
    private Integer unitFlags2;
    @Column("unit_flags3")
    private Integer unitFlags3;
    @Column("dynamicflags")
    private Integer dynamicflags;
    @Column("family")
    private Integer family;
    @Column("trainer_class")
    private Integer trainerClass;
    @Column("type")
    private Integer type;
    @Column("type_flags")
    private Integer typeFlags;
    @Column("type_flags2")
    private Integer typeFlags2;
    @Column("lootid")
    private Integer lootid;
    @Column("pickpocketloot")
    private Integer pickpocketloot;
    @Column("skinloot")
    private Integer skinloot;
    @Column("resistance1")
    private Integer resistance1;
    @Column("resistance2")
    private Integer resistance2;
    @Column("resistance3")
    private Integer resistance3;
    @Column("resistance4")
    private Integer resistance4;
    @Column("resistance5")
    private Integer resistance5;
    @Column("resistance6")
    private Integer resistance6;
    @Column("spell1")
    private Integer spell1;
    @Column("spell2")
    private Integer spell2;
    @Column("spell3")
    private Integer spell3;
    @Column("spell4")
    private Integer spell4;
    @Column("spell5")
    private Integer spell5;
    @Column("spell6")
    private Integer spell6;
    @Column("spell7")
    private Integer spell7;
    @Column("spell8")
    private Integer spell8;
    @Column("VehicleId")
    private Integer vehicleId;
    @Column("mingold")
    private Integer mingold;
    @Column("maxgold")
    private Integer maxgold;
    @Column("AIName")
    private String aiName;
    @Column("MovementType")
    private Integer movementType;
    @Column("InhabitType")
    private Integer inhabitType;
    @Column("HoverHeight")
    private Double hoverHeight;
    @Column("HealthModifier")
    private Double healthModifier;
    @Column("HealthModifierExtra")
    private Double healthModifierExtra;
    @Column("ManaModifier")
    private Double manaModifier;
    @Column("ManaModifierExtra")
    private Double manaModifierExtra;
    @Column("ArmorModifier")
    private Double armorModifier;
    @Column("DamageModifier")
    private Double damageModifier;
    @Column("ExperienceModifier")
    private Double experienceModifier;
    @Column("RacialLeader")
    private Integer racialLeader;
    @Column("movementId")
    private Integer movementId;
    @Column("WidgetSetID")
    private Integer widgetSetId;
    @Column("WidgetSetUnitConditionID")
    private Integer widgetSetUnitConditionId;
    @Column("RegenHealth")
    private Integer regenHealth;
    @Column("mechanic_immune_mask")
    private Integer mechanicImmuneMask;
    @Column("spell_school_immune_mask")
    private Integer spellSchoolImmuneMask;
    @Column("flags_extra")
    private Integer flagsExtra;
    @Column("ScriptName")
    private String scriptName;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureTemplate> {

        public CreatureTemplate convert(Row row) {
            CreatureTemplate domain = new CreatureTemplate();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setDifficultyEntry1(row.get("difficulty_entry_1", Integer.class));
            domain.setDifficultyEntry2(row.get("difficulty_entry_2", Integer.class));
            domain.setDifficultyEntry3(row.get("difficulty_entry_3", Integer.class));
            domain.setKillCredit1(row.get("KillCredit1", Integer.class));
            domain.setKillCredit2(row.get("KillCredit2", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setFemaleName(row.get("femaleName", String.class));
            domain.setSubname(row.get("subname", String.class));
            domain.setTitleAlt(row.get("TitleAlt", String.class));
            domain.setIconName(row.get("IconName", String.class));
            domain.setGossipMenuId(row.get("gossip_menu_id", Integer.class));
            domain.setMinlevel(row.get("minlevel", Integer.class));
            domain.setMaxlevel(row.get("maxlevel", Integer.class));
            domain.setHealthScalingExpansion(row.get("HealthScalingExpansion", Integer.class));
            domain.setRequiredExpansion(row.get("RequiredExpansion", Integer.class));
            domain.setVignetteId(row.get("VignetteID", Integer.class));
            domain.setFaction(row.get("faction", Integer.class));
            domain.setNpcflag(row.get("npcflag", Long.class));
            domain.setSpeedWalk(row.get("speed_walk", Double.class));
            domain.setSpeedRun(row.get("speed_run", Double.class));
            domain.setScale(row.get("scale", Double.class));
            domain.setRank(row.get("rank", Integer.class));
            domain.setDmgschool(row.get("dmgschool", Integer.class));
            domain.setBaseAttackTime(row.get("BaseAttackTime", Integer.class));
            domain.setRangeAttackTime(row.get("RangeAttackTime", Integer.class));
            domain.setBaseVariance(row.get("BaseVariance", Double.class));
            domain.setRangeVariance(row.get("RangeVariance", Double.class));
            domain.setUnitClass(row.get("unit_class", Integer.class));
            domain.setUnitFlags(row.get("unit_flags", Integer.class));
            domain.setUnitFlags2(row.get("unit_flags2", Integer.class));
            domain.setUnitFlags3(row.get("unit_flags3", Integer.class));
            domain.setDynamicflags(row.get("dynamicflags", Integer.class));
            domain.setFamily(row.get("family", Integer.class));
            domain.setTrainerClass(row.get("trainer_class", Integer.class));
            domain.setType(row.get("type", Integer.class));
            domain.setTypeFlags(row.get("type_flags", Integer.class));
            domain.setTypeFlags2(row.get("type_flags2", Integer.class));
            domain.setLootid(row.get("lootid", Integer.class));
            domain.setPickpocketloot(row.get("pickpocketloot", Integer.class));
            domain.setSkinloot(row.get("skinloot", Integer.class));
            domain.setResistance1(row.get("resistance1", Integer.class));
            domain.setResistance2(row.get("resistance2", Integer.class));
            domain.setResistance3(row.get("resistance3", Integer.class));
            domain.setResistance4(row.get("resistance4", Integer.class));
            domain.setResistance5(row.get("resistance5", Integer.class));
            domain.setResistance6(row.get("resistance6", Integer.class));
            domain.setSpell1(row.get("spell1", Integer.class));
            domain.setSpell2(row.get("spell2", Integer.class));
            domain.setSpell3(row.get("spell3", Integer.class));
            domain.setSpell4(row.get("spell4", Integer.class));
            domain.setSpell5(row.get("spell5", Integer.class));
            domain.setSpell6(row.get("spell6", Integer.class));
            domain.setSpell7(row.get("spell7", Integer.class));
            domain.setSpell8(row.get("spell8", Integer.class));
            domain.setVehicleId(row.get("VehicleId", Integer.class));
            domain.setMingold(row.get("mingold", Integer.class));
            domain.setMaxgold(row.get("maxgold", Integer.class));
            domain.setAiName(row.get("AIName", String.class));
            domain.setMovementType(row.get("MovementType", Integer.class));
            domain.setInhabitType(row.get("InhabitType", Integer.class));
            domain.setHoverHeight(row.get("HoverHeight", Double.class));
            domain.setHealthModifier(row.get("HealthModifier", Double.class));
            domain.setHealthModifierExtra(row.get("HealthModifierExtra", Double.class));
            domain.setManaModifier(row.get("ManaModifier", Double.class));
            domain.setManaModifierExtra(row.get("ManaModifierExtra", Double.class));
            domain.setArmorModifier(row.get("ArmorModifier", Double.class));
            domain.setDamageModifier(row.get("DamageModifier", Double.class));
            domain.setExperienceModifier(row.get("ExperienceModifier", Double.class));
            domain.setRacialLeader(row.get("RacialLeader", Integer.class));
            domain.setMovementId(row.get("movementId", Integer.class));
            domain.setWidgetSetId(row.get("WidgetSetID", Integer.class));
            domain.setWidgetSetUnitConditionId(row.get("WidgetSetUnitConditionID", Integer.class));
            domain.setRegenHealth(row.get("RegenHealth", Integer.class));
            domain.setMechanicImmuneMask(row.get("mechanic_immune_mask", Integer.class));
            domain.setSpellSchoolImmuneMask(row.get("spell_school_immune_mask", Integer.class));
            domain.setFlagsExtra(row.get("flags_extra", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureTemplate, OutboundRow> {

        public OutboundRow convert(CreatureTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyEntry1()).ifPresent(e -> row.put("difficulty_entry_1", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyEntry2()).ifPresent(e -> row.put("difficulty_entry_2", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyEntry3()).ifPresent(e -> row.put("difficulty_entry_3", Parameter.from(e)));
            Optional.ofNullable(source.getKillCredit1()).ifPresent(e -> row.put("KillCredit1", Parameter.from(e)));
            Optional.ofNullable(source.getKillCredit2()).ifPresent(e -> row.put("KillCredit2", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleName()).ifPresent(e -> row.put("femaleName", Parameter.from(e)));
            Optional.ofNullable(source.getSubname()).ifPresent(e -> row.put("subname", Parameter.from(e)));
            Optional.ofNullable(source.getTitleAlt()).ifPresent(e -> row.put("TitleAlt", Parameter.from(e)));
            Optional.ofNullable(source.getIconName()).ifPresent(e -> row.put("IconName", Parameter.from(e)));
            Optional.ofNullable(source.getGossipMenuId()).ifPresent(e -> row.put("gossip_menu_id", Parameter.from(e)));
            Optional.ofNullable(source.getMinlevel()).ifPresent(e -> row.put("minlevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxlevel()).ifPresent(e -> row.put("maxlevel", Parameter.from(e)));
            Optional.ofNullable(source.getHealthScalingExpansion()).ifPresent(e -> row.put("HealthScalingExpansion", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredExpansion()).ifPresent(e -> row.put("RequiredExpansion", Parameter.from(e)));
            Optional.ofNullable(source.getVignetteId()).ifPresent(e -> row.put("VignetteID", Parameter.from(e)));
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("faction", Parameter.from(e)));
            Optional.ofNullable(source.getNpcflag()).ifPresent(e -> row.put("npcflag", Parameter.from(e)));
            Optional.ofNullable(source.getSpeedWalk()).ifPresent(e -> row.put("speed_walk", Parameter.from(e)));
            Optional.ofNullable(source.getSpeedRun()).ifPresent(e -> row.put("speed_run", Parameter.from(e)));
            Optional.ofNullable(source.getScale()).ifPresent(e -> row.put("scale", Parameter.from(e)));
            Optional.ofNullable(source.getRank()).ifPresent(e -> row.put("rank", Parameter.from(e)));
            Optional.ofNullable(source.getDmgschool()).ifPresent(e -> row.put("dmgschool", Parameter.from(e)));
            Optional.ofNullable(source.getBaseAttackTime()).ifPresent(e -> row.put("BaseAttackTime", Parameter.from(e)));
            Optional.ofNullable(source.getRangeAttackTime()).ifPresent(e -> row.put("RangeAttackTime", Parameter.from(e)));
            Optional.ofNullable(source.getBaseVariance()).ifPresent(e -> row.put("BaseVariance", Parameter.from(e)));
            Optional.ofNullable(source.getRangeVariance()).ifPresent(e -> row.put("RangeVariance", Parameter.from(e)));
            Optional.ofNullable(source.getUnitClass()).ifPresent(e -> row.put("unit_class", Parameter.from(e)));
            Optional.ofNullable(source.getUnitFlags()).ifPresent(e -> row.put("unit_flags", Parameter.from(e)));
            Optional.ofNullable(source.getUnitFlags2()).ifPresent(e -> row.put("unit_flags2", Parameter.from(e)));
            Optional.ofNullable(source.getUnitFlags3()).ifPresent(e -> row.put("unit_flags3", Parameter.from(e)));
            Optional.ofNullable(source.getDynamicflags()).ifPresent(e -> row.put("dynamicflags", Parameter.from(e)));
            Optional.ofNullable(source.getFamily()).ifPresent(e -> row.put("family", Parameter.from(e)));
            Optional.ofNullable(source.getTrainerClass()).ifPresent(e -> row.put("trainer_class", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getTypeFlags()).ifPresent(e -> row.put("type_flags", Parameter.from(e)));
            Optional.ofNullable(source.getTypeFlags2()).ifPresent(e -> row.put("type_flags2", Parameter.from(e)));
            Optional.ofNullable(source.getLootid()).ifPresent(e -> row.put("lootid", Parameter.from(e)));
            Optional.ofNullable(source.getPickpocketloot()).ifPresent(e -> row.put("pickpocketloot", Parameter.from(e)));
            Optional.ofNullable(source.getSkinloot()).ifPresent(e -> row.put("skinloot", Parameter.from(e)));
            Optional.ofNullable(source.getResistance1()).ifPresent(e -> row.put("resistance1", Parameter.from(e)));
            Optional.ofNullable(source.getResistance2()).ifPresent(e -> row.put("resistance2", Parameter.from(e)));
            Optional.ofNullable(source.getResistance3()).ifPresent(e -> row.put("resistance3", Parameter.from(e)));
            Optional.ofNullable(source.getResistance4()).ifPresent(e -> row.put("resistance4", Parameter.from(e)));
            Optional.ofNullable(source.getResistance5()).ifPresent(e -> row.put("resistance5", Parameter.from(e)));
            Optional.ofNullable(source.getResistance6()).ifPresent(e -> row.put("resistance6", Parameter.from(e)));
            Optional.ofNullable(source.getSpell1()).ifPresent(e -> row.put("spell1", Parameter.from(e)));
            Optional.ofNullable(source.getSpell2()).ifPresent(e -> row.put("spell2", Parameter.from(e)));
            Optional.ofNullable(source.getSpell3()).ifPresent(e -> row.put("spell3", Parameter.from(e)));
            Optional.ofNullable(source.getSpell4()).ifPresent(e -> row.put("spell4", Parameter.from(e)));
            Optional.ofNullable(source.getSpell5()).ifPresent(e -> row.put("spell5", Parameter.from(e)));
            Optional.ofNullable(source.getSpell6()).ifPresent(e -> row.put("spell6", Parameter.from(e)));
            Optional.ofNullable(source.getSpell7()).ifPresent(e -> row.put("spell7", Parameter.from(e)));
            Optional.ofNullable(source.getSpell8()).ifPresent(e -> row.put("spell8", Parameter.from(e)));
            Optional.ofNullable(source.getVehicleId()).ifPresent(e -> row.put("VehicleId", Parameter.from(e)));
            Optional.ofNullable(source.getMingold()).ifPresent(e -> row.put("mingold", Parameter.from(e)));
            Optional.ofNullable(source.getMaxgold()).ifPresent(e -> row.put("maxgold", Parameter.from(e)));
            Optional.ofNullable(source.getAiName()).ifPresent(e -> row.put("AIName", Parameter.from(e)));
            Optional.ofNullable(source.getMovementType()).ifPresent(e -> row.put("MovementType", Parameter.from(e)));
            Optional.ofNullable(source.getInhabitType()).ifPresent(e -> row.put("InhabitType", Parameter.from(e)));
            Optional.ofNullable(source.getHoverHeight()).ifPresent(e -> row.put("HoverHeight", Parameter.from(e)));
            Optional.ofNullable(source.getHealthModifier()).ifPresent(e -> row.put("HealthModifier", Parameter.from(e)));
            Optional.ofNullable(source.getHealthModifierExtra()).ifPresent(e -> row.put("HealthModifierExtra", Parameter.from(e)));
            Optional.ofNullable(source.getManaModifier()).ifPresent(e -> row.put("ManaModifier", Parameter.from(e)));
            Optional.ofNullable(source.getManaModifierExtra()).ifPresent(e -> row.put("ManaModifierExtra", Parameter.from(e)));
            Optional.ofNullable(source.getArmorModifier()).ifPresent(e -> row.put("ArmorModifier", Parameter.from(e)));
            Optional.ofNullable(source.getDamageModifier()).ifPresent(e -> row.put("DamageModifier", Parameter.from(e)));
            Optional.ofNullable(source.getExperienceModifier()).ifPresent(e -> row.put("ExperienceModifier", Parameter.from(e)));
            Optional.ofNullable(source.getRacialLeader()).ifPresent(e -> row.put("RacialLeader", Parameter.from(e)));
            Optional.ofNullable(source.getMovementId()).ifPresent(e -> row.put("movementId", Parameter.from(e)));
            Optional.ofNullable(source.getWidgetSetId()).ifPresent(e -> row.put("WidgetSetID", Parameter.from(e)));
            Optional.ofNullable(source.getWidgetSetUnitConditionId()).ifPresent(e -> row.put("WidgetSetUnitConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getRegenHealth()).ifPresent(e -> row.put("RegenHealth", Parameter.from(e)));
            Optional.ofNullable(source.getMechanicImmuneMask()).ifPresent(e -> row.put("mechanic_immune_mask", Parameter.from(e)));
            Optional.ofNullable(source.getSpellSchoolImmuneMask()).ifPresent(e -> row.put("spell_school_immune_mask", Parameter.from(e)));
            Optional.ofNullable(source.getFlagsExtra()).ifPresent(e -> row.put("flags_extra", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
