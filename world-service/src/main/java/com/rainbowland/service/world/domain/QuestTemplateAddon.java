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
@Table("quest_template_addon")
public class QuestTemplateAddon {

    @Column("ID")
    private Integer id;
    @Column("MaxLevel")
    private Integer maxLevel;
    @Column("AllowableClasses")
    private Integer allowableClasses;
    @Column("SourceSpellID")
    private Integer sourceSpellId;
    @Column("PrevQuestID")
    private Integer prevQuestId;
    @Column("NextQuestID")
    private Integer nextQuestId;
    @Column("ExclusiveGroup")
    private Integer exclusiveGroup;
    @Column("RewardMailTemplateID")
    private Integer rewardMailTemplateId;
    @Column("RewardMailDelay")
    private Integer rewardMailDelay;
    @Column("RequiredSkillID")
    private Integer requiredSkillId;
    @Column("RequiredSkillPoints")
    private Integer requiredSkillPoints;
    @Column("RequiredMinRepFaction")
    private Integer requiredMinRepFaction;
    @Column("RequiredMaxRepFaction")
    private Integer requiredMaxRepFaction;
    @Column("RequiredMinRepValue")
    private Integer requiredMinRepValue;
    @Column("RequiredMaxRepValue")
    private Integer requiredMaxRepValue;
    @Column("ProvidedItemCount")
    private Integer providedItemCount;
    @Column("SpecialFlags")
    private Integer specialFlags;
    @Column("ScriptName")
    private String scriptName;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestTemplateAddon> {

        public QuestTemplateAddon convert(Row row) {
            QuestTemplateAddon domain = new QuestTemplateAddon();
            domain.setId(row.get("ID", Integer.class));
            domain.setMaxLevel(row.get("MaxLevel", Integer.class));
            domain.setAllowableClasses(row.get("AllowableClasses", Integer.class));
            domain.setSourceSpellId(row.get("SourceSpellID", Integer.class));
            domain.setPrevQuestId(row.get("PrevQuestID", Integer.class));
            domain.setNextQuestId(row.get("NextQuestID", Integer.class));
            domain.setExclusiveGroup(row.get("ExclusiveGroup", Integer.class));
            domain.setRewardMailTemplateId(row.get("RewardMailTemplateID", Integer.class));
            domain.setRewardMailDelay(row.get("RewardMailDelay", Integer.class));
            domain.setRequiredSkillId(row.get("RequiredSkillID", Integer.class));
            domain.setRequiredSkillPoints(row.get("RequiredSkillPoints", Integer.class));
            domain.setRequiredMinRepFaction(row.get("RequiredMinRepFaction", Integer.class));
            domain.setRequiredMaxRepFaction(row.get("RequiredMaxRepFaction", Integer.class));
            domain.setRequiredMinRepValue(row.get("RequiredMinRepValue", Integer.class));
            domain.setRequiredMaxRepValue(row.get("RequiredMaxRepValue", Integer.class));
            domain.setProvidedItemCount(row.get("ProvidedItemCount", Integer.class));
            domain.setSpecialFlags(row.get("SpecialFlags", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestTemplateAddon, OutboundRow> {

        public OutboundRow convert(QuestTemplateAddon source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("MaxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getAllowableClasses()).ifPresent(e -> row.put("AllowableClasses", Parameter.from(e)));
            Optional.ofNullable(source.getSourceSpellId()).ifPresent(e -> row.put("SourceSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getPrevQuestId()).ifPresent(e -> row.put("PrevQuestID", Parameter.from(e)));
            Optional.ofNullable(source.getNextQuestId()).ifPresent(e -> row.put("NextQuestID", Parameter.from(e)));
            Optional.ofNullable(source.getExclusiveGroup()).ifPresent(e -> row.put("ExclusiveGroup", Parameter.from(e)));
            Optional.ofNullable(source.getRewardMailTemplateId()).ifPresent(e -> row.put("RewardMailTemplateID", Parameter.from(e)));
            Optional.ofNullable(source.getRewardMailDelay()).ifPresent(e -> row.put("RewardMailDelay", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkillId()).ifPresent(e -> row.put("RequiredSkillID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkillPoints()).ifPresent(e -> row.put("RequiredSkillPoints", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredMinRepFaction()).ifPresent(e -> row.put("RequiredMinRepFaction", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredMaxRepFaction()).ifPresent(e -> row.put("RequiredMaxRepFaction", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredMinRepValue()).ifPresent(e -> row.put("RequiredMinRepValue", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredMaxRepValue()).ifPresent(e -> row.put("RequiredMaxRepValue", Parameter.from(e)));
            Optional.ofNullable(source.getProvidedItemCount()).ifPresent(e -> row.put("ProvidedItemCount", Parameter.from(e)));
            Optional.ofNullable(source.getSpecialFlags()).ifPresent(e -> row.put("SpecialFlags", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            return row;
        }
    }

}
