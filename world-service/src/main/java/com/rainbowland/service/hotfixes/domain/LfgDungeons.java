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
@Table("lfg_dungeons")
public class LfgDungeons {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("Description")
    private String description;
    @Column("TypeID")
    private Integer typeId;
    @Column("Subtype")
    private Integer subtype;
    @Column("Faction")
    private Integer faction;
    @Column("IconTextureFileID")
    private Integer iconTextureFileId;
    @Column("RewardsBgTextureFileID")
    private Integer rewardsBgTextureFileId;
    @Column("PopupBgTextureFileID")
    private Integer popupBgTextureFileId;
    @Column("ExpansionLevel")
    private Integer expansionLevel;
    @Column("MapID")
    private Integer mapId;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("MinGear")
    private Double minGear;
    @Column("GroupID")
    private Integer groupId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("RequiredPlayerConditionId")
    private Integer requiredPlayerConditionId;
    @Column("RandomID")
    private Integer randomId;
    @Column("ScenarioID")
    private Integer scenarioId;
    @Column("FinalEncounterID")
    private Integer finalEncounterId;
    @Column("CountTank")
    private Integer countTank;
    @Column("CountHealer")
    private Integer countHealer;
    @Column("CountDamage")
    private Integer countDamage;
    @Column("MinCountTank")
    private Integer minCountTank;
    @Column("MinCountHealer")
    private Integer minCountHealer;
    @Column("MinCountDamage")
    private Integer minCountDamage;
    @Column("BonusReputationAmount")
    private Integer bonusReputationAmount;
    @Column("MentorItemLevel")
    private Integer mentorItemLevel;
    @Column("MentorCharLevel")
    private Integer mentorCharLevel;
    @Column("ContentTuningID")
    private Integer contentTuningId;
    @Column("Flags1")
    private Integer flags1;
    @Column("Flags2")
    private Integer flags2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, LfgDungeons> {

        public LfgDungeons convert(Row row) {
            LfgDungeons domain = new LfgDungeons();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setTypeId(row.get("TypeID", Integer.class));
            domain.setSubtype(row.get("Subtype", Integer.class));
            domain.setFaction(row.get("Faction", Integer.class));
            domain.setIconTextureFileId(row.get("IconTextureFileID", Integer.class));
            domain.setRewardsBgTextureFileId(row.get("RewardsBgTextureFileID", Integer.class));
            domain.setPopupBgTextureFileId(row.get("PopupBgTextureFileID", Integer.class));
            domain.setExpansionLevel(row.get("ExpansionLevel", Integer.class));
            domain.setMapId(row.get("MapID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setMinGear(row.get("MinGear", Double.class));
            domain.setGroupId(row.get("GroupID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setRequiredPlayerConditionId(row.get("RequiredPlayerConditionId", Integer.class));
            domain.setRandomId(row.get("RandomID", Integer.class));
            domain.setScenarioId(row.get("ScenarioID", Integer.class));
            domain.setFinalEncounterId(row.get("FinalEncounterID", Integer.class));
            domain.setCountTank(row.get("CountTank", Integer.class));
            domain.setCountHealer(row.get("CountHealer", Integer.class));
            domain.setCountDamage(row.get("CountDamage", Integer.class));
            domain.setMinCountTank(row.get("MinCountTank", Integer.class));
            domain.setMinCountHealer(row.get("MinCountHealer", Integer.class));
            domain.setMinCountDamage(row.get("MinCountDamage", Integer.class));
            domain.setBonusReputationAmount(row.get("BonusReputationAmount", Integer.class));
            domain.setMentorItemLevel(row.get("MentorItemLevel", Integer.class));
            domain.setMentorCharLevel(row.get("MentorCharLevel", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningID", Integer.class));
            domain.setFlags1(row.get("Flags1", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<LfgDungeons, OutboundRow> {

        public OutboundRow convert(LfgDungeons source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getTypeId()).ifPresent(e -> row.put("TypeID", Parameter.from(e)));
            Optional.ofNullable(source.getSubtype()).ifPresent(e -> row.put("Subtype", Parameter.from(e)));
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("Faction", Parameter.from(e)));
            Optional.ofNullable(source.getIconTextureFileId()).ifPresent(e -> row.put("IconTextureFileID", Parameter.from(e)));
            Optional.ofNullable(source.getRewardsBgTextureFileId()).ifPresent(e -> row.put("RewardsBgTextureFileID", Parameter.from(e)));
            Optional.ofNullable(source.getPopupBgTextureFileId()).ifPresent(e -> row.put("PopupBgTextureFileID", Parameter.from(e)));
            Optional.ofNullable(source.getExpansionLevel()).ifPresent(e -> row.put("ExpansionLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getMinGear()).ifPresent(e -> row.put("MinGear", Parameter.from(e)));
            Optional.ofNullable(source.getGroupId()).ifPresent(e -> row.put("GroupID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredPlayerConditionId()).ifPresent(e -> row.put("RequiredPlayerConditionId", Parameter.from(e)));
            Optional.ofNullable(source.getRandomId()).ifPresent(e -> row.put("RandomID", Parameter.from(e)));
            Optional.ofNullable(source.getScenarioId()).ifPresent(e -> row.put("ScenarioID", Parameter.from(e)));
            Optional.ofNullable(source.getFinalEncounterId()).ifPresent(e -> row.put("FinalEncounterID", Parameter.from(e)));
            Optional.ofNullable(source.getCountTank()).ifPresent(e -> row.put("CountTank", Parameter.from(e)));
            Optional.ofNullable(source.getCountHealer()).ifPresent(e -> row.put("CountHealer", Parameter.from(e)));
            Optional.ofNullable(source.getCountDamage()).ifPresent(e -> row.put("CountDamage", Parameter.from(e)));
            Optional.ofNullable(source.getMinCountTank()).ifPresent(e -> row.put("MinCountTank", Parameter.from(e)));
            Optional.ofNullable(source.getMinCountHealer()).ifPresent(e -> row.put("MinCountHealer", Parameter.from(e)));
            Optional.ofNullable(source.getMinCountDamage()).ifPresent(e -> row.put("MinCountDamage", Parameter.from(e)));
            Optional.ofNullable(source.getBonusReputationAmount()).ifPresent(e -> row.put("BonusReputationAmount", Parameter.from(e)));
            Optional.ofNullable(source.getMentorItemLevel()).ifPresent(e -> row.put("MentorItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMentorCharLevel()).ifPresent(e -> row.put("MentorCharLevel", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags1()).ifPresent(e -> row.put("Flags1", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
