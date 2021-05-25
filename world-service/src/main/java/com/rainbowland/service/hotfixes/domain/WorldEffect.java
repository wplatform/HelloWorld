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
@Table("world_effect")
public class WorldEffect {

    @Column("ID")
    private Integer id;
    @Column("QuestFeedbackEffectID")
    private Integer questFeedbackEffectId;
    @Column("WhenToDisplay")
    private Integer whenToDisplay;
    @Column("TargetType")
    private Integer targetType;
    @Column("TargetAsset")
    private Integer targetAsset;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("CombatConditionID")
    private Integer combatConditionId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, WorldEffect> {

        public WorldEffect convert(Row row) {
            WorldEffect domain = new WorldEffect();
            domain.setId(row.get("ID", Integer.class));
            domain.setQuestFeedbackEffectId(row.get("QuestFeedbackEffectID", Integer.class));
            domain.setWhenToDisplay(row.get("WhenToDisplay", Integer.class));
            domain.setTargetType(row.get("TargetType", Integer.class));
            domain.setTargetAsset(row.get("TargetAsset", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setCombatConditionId(row.get("CombatConditionID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<WorldEffect, OutboundRow> {

        public OutboundRow convert(WorldEffect source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestFeedbackEffectId()).ifPresent(e -> row.put("QuestFeedbackEffectID", Parameter.from(e)));
            Optional.ofNullable(source.getWhenToDisplay()).ifPresent(e -> row.put("WhenToDisplay", Parameter.from(e)));
            Optional.ofNullable(source.getTargetType()).ifPresent(e -> row.put("TargetType", Parameter.from(e)));
            Optional.ofNullable(source.getTargetAsset()).ifPresent(e -> row.put("TargetAsset", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getCombatConditionId()).ifPresent(e -> row.put("CombatConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
