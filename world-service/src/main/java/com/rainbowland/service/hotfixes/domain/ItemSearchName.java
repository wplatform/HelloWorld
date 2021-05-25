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
@Table("item_search_name")
public class ItemSearchName {

    @Column("AllowableRace")
    private Long allowableRace;
    @Column("Display")
    private String display;
    @Column("ID")
    private Integer id;
    @Column("OverallQualityID")
    private Integer overallQualityId;
    @Column("ExpansionID")
    private Integer expansionId;
    @Column("MinFactionID")
    private Integer minFactionId;
    @Column("MinReputation")
    private Integer minReputation;
    @Column("AllowableClass")
    private Integer allowableClass;
    @Column("RequiredLevel")
    private Integer requiredLevel;
    @Column("RequiredSkill")
    private Integer requiredSkill;
    @Column("RequiredSkillRank")
    private Integer requiredSkillRank;
    @Column("RequiredAbility")
    private Integer requiredAbility;
    @Column("ItemLevel")
    private Integer itemLevel;
    @Column("Flags1")
    private Integer flags1;
    @Column("Flags2")
    private Integer flags2;
    @Column("Flags3")
    private Integer flags3;
    @Column("Flags4")
    private Integer flags4;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemSearchName> {

        public ItemSearchName convert(Row row) {
            ItemSearchName domain = new ItemSearchName();
            domain.setAllowableRace(row.get("AllowableRace", Long.class));
            domain.setDisplay(row.get("Display", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setOverallQualityId(row.get("OverallQualityID", Integer.class));
            domain.setExpansionId(row.get("ExpansionID", Integer.class));
            domain.setMinFactionId(row.get("MinFactionID", Integer.class));
            domain.setMinReputation(row.get("MinReputation", Integer.class));
            domain.setAllowableClass(row.get("AllowableClass", Integer.class));
            domain.setRequiredLevel(row.get("RequiredLevel", Integer.class));
            domain.setRequiredSkill(row.get("RequiredSkill", Integer.class));
            domain.setRequiredSkillRank(row.get("RequiredSkillRank", Integer.class));
            domain.setRequiredAbility(row.get("RequiredAbility", Integer.class));
            domain.setItemLevel(row.get("ItemLevel", Integer.class));
            domain.setFlags1(row.get("Flags1", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setFlags3(row.get("Flags3", Integer.class));
            domain.setFlags4(row.get("Flags4", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemSearchName, OutboundRow> {

        public OutboundRow convert(ItemSearchName source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAllowableRace()).ifPresent(e -> row.put("AllowableRace", Parameter.from(e)));
            Optional.ofNullable(source.getDisplay()).ifPresent(e -> row.put("Display", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getOverallQualityId()).ifPresent(e -> row.put("OverallQualityID", Parameter.from(e)));
            Optional.ofNullable(source.getExpansionId()).ifPresent(e -> row.put("ExpansionID", Parameter.from(e)));
            Optional.ofNullable(source.getMinFactionId()).ifPresent(e -> row.put("MinFactionID", Parameter.from(e)));
            Optional.ofNullable(source.getMinReputation()).ifPresent(e -> row.put("MinReputation", Parameter.from(e)));
            Optional.ofNullable(source.getAllowableClass()).ifPresent(e -> row.put("AllowableClass", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredLevel()).ifPresent(e -> row.put("RequiredLevel", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkill()).ifPresent(e -> row.put("RequiredSkill", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkillRank()).ifPresent(e -> row.put("RequiredSkillRank", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredAbility()).ifPresent(e -> row.put("RequiredAbility", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevel()).ifPresent(e -> row.put("ItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getFlags1()).ifPresent(e -> row.put("Flags1", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getFlags3()).ifPresent(e -> row.put("Flags3", Parameter.from(e)));
            Optional.ofNullable(source.getFlags4()).ifPresent(e -> row.put("Flags4", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
