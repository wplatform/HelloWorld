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
@Table("quest_objectives_locale")
public class QuestObjectivesLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("QuestId")
    private Integer questId;
    @Column("StorageIndex")
    private Integer storageIndex;
    @Column("Description")
    private String description;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestObjectivesLocale> {

        public QuestObjectivesLocale convert(Row row) {
            QuestObjectivesLocale domain = new QuestObjectivesLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setQuestId(row.get("QuestId", Integer.class));
            domain.setStorageIndex(row.get("StorageIndex", Integer.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestObjectivesLocale, OutboundRow> {

        public OutboundRow convert(QuestObjectivesLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("QuestId", Parameter.from(e)));
            Optional.ofNullable(source.getStorageIndex()).ifPresent(e -> row.put("StorageIndex", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
