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
@Table("scenario_step")
public class ScenarioStep {

    @Column("ID")
    private Integer id;
    @Column("Description")
    private String description;
    @Column("Title")
    private String title;
    @Column("ScenarioID")
    private Integer scenarioId;
    @Column("Criteriatreeid")
    private Integer criteriatreeid;
    @Column("RewardQuestID")
    private Integer rewardQuestId;
    @Column("RelatedStep")
    private Integer relatedStep;
    @Column("Supersedes")
    private Integer supersedes;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("Flags")
    private Integer flags;
    @Column("VisibilityPlayerConditionID")
    private Integer visibilityPlayerConditionId;
    @Column("WidgetSetID")
    private Integer widgetSetId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ScenarioStep> {

        public ScenarioStep convert(Row row) {
            ScenarioStep domain = new ScenarioStep();
            domain.setId(row.get("ID", Integer.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setTitle(row.get("Title", String.class));
            domain.setScenarioId(row.get("ScenarioID", Integer.class));
            domain.setCriteriatreeid(row.get("Criteriatreeid", Integer.class));
            domain.setRewardQuestId(row.get("RewardQuestID", Integer.class));
            domain.setRelatedStep(row.get("RelatedStep", Integer.class));
            domain.setSupersedes(row.get("Supersedes", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVisibilityPlayerConditionId(row.get("VisibilityPlayerConditionID", Integer.class));
            domain.setWidgetSetId(row.get("WidgetSetID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ScenarioStep, OutboundRow> {

        public OutboundRow convert(ScenarioStep source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getTitle()).ifPresent(e -> row.put("Title", Parameter.from(e)));
            Optional.ofNullable(source.getScenarioId()).ifPresent(e -> row.put("ScenarioID", Parameter.from(e)));
            Optional.ofNullable(source.getCriteriatreeid()).ifPresent(e -> row.put("Criteriatreeid", Parameter.from(e)));
            Optional.ofNullable(source.getRewardQuestId()).ifPresent(e -> row.put("RewardQuestID", Parameter.from(e)));
            Optional.ofNullable(source.getRelatedStep()).ifPresent(e -> row.put("RelatedStep", Parameter.from(e)));
            Optional.ofNullable(source.getSupersedes()).ifPresent(e -> row.put("Supersedes", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVisibilityPlayerConditionId()).ifPresent(e -> row.put("VisibilityPlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getWidgetSetId()).ifPresent(e -> row.put("WidgetSetID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
