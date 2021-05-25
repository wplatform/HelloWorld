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
@Table("reference_loot_template")
public class ReferenceLootTemplate {

    @Column("Entry")
    private Integer entry;
    @Column("Item")
    private Integer item;
    @Column("Reference")
    private Integer reference;
    @Column("Chance")
    private Double chance;
    @Column("QuestRequired")
    private Integer questRequired;
    @Column("LootMode")
    private Integer lootMode;
    @Column("GroupId")
    private Integer groupId;
    @Column("MinCount")
    private Integer minCount;
    @Column("MaxCount")
    private Integer maxCount;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ReferenceLootTemplate> {

        public ReferenceLootTemplate convert(Row row) {
            ReferenceLootTemplate domain = new ReferenceLootTemplate();
            domain.setEntry(row.get("Entry", Integer.class));
            domain.setItem(row.get("Item", Integer.class));
            domain.setReference(row.get("Reference", Integer.class));
            domain.setChance(row.get("Chance", Double.class));
            domain.setQuestRequired(row.get("QuestRequired", Integer.class));
            domain.setLootMode(row.get("LootMode", Integer.class));
            domain.setGroupId(row.get("GroupId", Integer.class));
            domain.setMinCount(row.get("MinCount", Integer.class));
            domain.setMaxCount(row.get("MaxCount", Integer.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ReferenceLootTemplate, OutboundRow> {

        public OutboundRow convert(ReferenceLootTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("Entry", Parameter.from(e)));
            Optional.ofNullable(source.getItem()).ifPresent(e -> row.put("Item", Parameter.from(e)));
            Optional.ofNullable(source.getReference()).ifPresent(e -> row.put("Reference", Parameter.from(e)));
            Optional.ofNullable(source.getChance()).ifPresent(e -> row.put("Chance", Parameter.from(e)));
            Optional.ofNullable(source.getQuestRequired()).ifPresent(e -> row.put("QuestRequired", Parameter.from(e)));
            Optional.ofNullable(source.getLootMode()).ifPresent(e -> row.put("LootMode", Parameter.from(e)));
            Optional.ofNullable(source.getGroupId()).ifPresent(e -> row.put("GroupId", Parameter.from(e)));
            Optional.ofNullable(source.getMinCount()).ifPresent(e -> row.put("MinCount", Parameter.from(e)));
            Optional.ofNullable(source.getMaxCount()).ifPresent(e -> row.put("MaxCount", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
