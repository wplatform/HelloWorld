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
@Table("quest_objectives")
public class QuestObjectives {

    @Column("ID")
    private Integer id;
    @Column("QuestID")
    private Integer questId;
    @Column("Type")
    private Integer type;
    @Column("Order")
    private Integer order;
    @Column("StorageIndex")
    private Integer storageIndex;
    @Column("ObjectID")
    private Integer objectId;
    @Column("Amount")
    private Integer amount;
    @Column("Flags")
    private Integer flags;
    @Column("Flags2")
    private Integer flags2;
    @Column("ProgressBarWeight")
    private Double progressBarWeight;
    @Column("Description")
    private String description;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestObjectives> {

        public QuestObjectives convert(Row row) {
            QuestObjectives domain = new QuestObjectives();
            domain.setId(row.get("ID", Integer.class));
            domain.setQuestId(row.get("QuestID", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setOrder(row.get("Order", Integer.class));
            domain.setStorageIndex(row.get("StorageIndex", Integer.class));
            domain.setObjectId(row.get("ObjectID", Integer.class));
            domain.setAmount(row.get("Amount", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setProgressBarWeight(row.get("ProgressBarWeight", Double.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestObjectives, OutboundRow> {

        public OutboundRow convert(QuestObjectives source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("QuestID", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getOrder()).ifPresent(e -> row.put("Order", Parameter.from(e)));
            Optional.ofNullable(source.getStorageIndex()).ifPresent(e -> row.put("StorageIndex", Parameter.from(e)));
            Optional.ofNullable(source.getObjectId()).ifPresent(e -> row.put("ObjectID", Parameter.from(e)));
            Optional.ofNullable(source.getAmount()).ifPresent(e -> row.put("Amount", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getProgressBarWeight()).ifPresent(e -> row.put("ProgressBarWeight", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
