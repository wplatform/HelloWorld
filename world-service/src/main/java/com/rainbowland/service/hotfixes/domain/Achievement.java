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
@Table("achievement")
public class Achievement {

    @Column("Description")
    private String description;
    @Column("Title")
    private String title;
    @Column("Reward")
    private String reward;
    @Column("ID")
    private Integer id;
    @Column("InstanceID")
    private Integer instanceId;
    @Column("Faction")
    private Integer faction;
    @Column("Supercedes")
    private Integer supercedes;
    @Column("Category")
    private Integer category;
    @Column("MinimumCriteria")
    private Integer minimumCriteria;
    @Column("Points")
    private Integer points;
    @Column("Flags")
    private Integer flags;
    @Column("UiOrder")
    private Integer uiOrder;
    @Column("IconFileID")
    private Integer iconFileId;
    @Column("RewardItemID")
    private Integer rewardItemId;
    @Column("CriteriaTree")
    private Integer criteriaTree;
    @Column("SharesCriteria")
    private Integer sharesCriteria;
    @Column("CovenantID")
    private Integer covenantId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Achievement> {

        public Achievement convert(Row row) {
            Achievement domain = new Achievement();
            domain.setDescription(row.get("Description", String.class));
            domain.setTitle(row.get("Title", String.class));
            domain.setReward(row.get("Reward", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setInstanceId(row.get("InstanceID", Integer.class));
            domain.setFaction(row.get("Faction", Integer.class));
            domain.setSupercedes(row.get("Supercedes", Integer.class));
            domain.setCategory(row.get("Category", Integer.class));
            domain.setMinimumCriteria(row.get("MinimumCriteria", Integer.class));
            domain.setPoints(row.get("Points", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setUiOrder(row.get("UiOrder", Integer.class));
            domain.setIconFileId(row.get("IconFileID", Integer.class));
            domain.setRewardItemId(row.get("RewardItemID", Integer.class));
            domain.setCriteriaTree(row.get("CriteriaTree", Integer.class));
            domain.setSharesCriteria(row.get("SharesCriteria", Integer.class));
            domain.setCovenantId(row.get("CovenantID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Achievement, OutboundRow> {

        public OutboundRow convert(Achievement source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getTitle()).ifPresent(e -> row.put("Title", Parameter.from(e)));
            Optional.ofNullable(source.getReward()).ifPresent(e -> row.put("Reward", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceId()).ifPresent(e -> row.put("InstanceID", Parameter.from(e)));
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("Faction", Parameter.from(e)));
            Optional.ofNullable(source.getSupercedes()).ifPresent(e -> row.put("Supercedes", Parameter.from(e)));
            Optional.ofNullable(source.getCategory()).ifPresent(e -> row.put("Category", Parameter.from(e)));
            Optional.ofNullable(source.getMinimumCriteria()).ifPresent(e -> row.put("MinimumCriteria", Parameter.from(e)));
            Optional.ofNullable(source.getPoints()).ifPresent(e -> row.put("Points", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getUiOrder()).ifPresent(e -> row.put("UiOrder", Parameter.from(e)));
            Optional.ofNullable(source.getIconFileId()).ifPresent(e -> row.put("IconFileID", Parameter.from(e)));
            Optional.ofNullable(source.getRewardItemId()).ifPresent(e -> row.put("RewardItemID", Parameter.from(e)));
            Optional.ofNullable(source.getCriteriaTree()).ifPresent(e -> row.put("CriteriaTree", Parameter.from(e)));
            Optional.ofNullable(source.getSharesCriteria()).ifPresent(e -> row.put("SharesCriteria", Parameter.from(e)));
            Optional.ofNullable(source.getCovenantId()).ifPresent(e -> row.put("CovenantID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
