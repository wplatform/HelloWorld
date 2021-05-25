package com.rainbowland.service.characters.domain;

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
@Table("quest_tracker")
public class QuestTracker {

    @Column("id")
    private Integer id;
    @Column("character_guid")
    private Long characterGuid;
    @Column("quest_accept_time")
    private java.time.LocalDateTime questAcceptTime;
    @Column("quest_complete_time")
    private java.time.LocalDateTime questCompleteTime;
    @Column("quest_abandon_time")
    private java.time.LocalDateTime questAbandonTime;
    @Column("completed_by_gm")
    private Integer completedByGm;
    @Column("core_hash")
    private String coreHash;
    @Column("core_revision")
    private String coreRevision;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestTracker> {

        public QuestTracker convert(Row row) {
            QuestTracker domain = new QuestTracker();
            domain.setId(row.get("id", Integer.class));
            domain.setCharacterGuid(row.get("character_guid", Long.class));
            domain.setQuestAcceptTime(row.get("quest_accept_time", java.time.LocalDateTime.class));
            domain.setQuestCompleteTime(row.get("quest_complete_time", java.time.LocalDateTime.class));
            domain.setQuestAbandonTime(row.get("quest_abandon_time", java.time.LocalDateTime.class));
            domain.setCompletedByGm(row.get("completed_by_gm", Integer.class));
            domain.setCoreHash(row.get("core_hash", String.class));
            domain.setCoreRevision(row.get("core_revision", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestTracker, OutboundRow> {

        public OutboundRow convert(QuestTracker source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterGuid()).ifPresent(e -> row.put("character_guid", Parameter.from(e)));
            Optional.ofNullable(source.getQuestAcceptTime()).ifPresent(e -> row.put("quest_accept_time", Parameter.from(e)));
            Optional.ofNullable(source.getQuestCompleteTime()).ifPresent(e -> row.put("quest_complete_time", Parameter.from(e)));
            Optional.ofNullable(source.getQuestAbandonTime()).ifPresent(e -> row.put("quest_abandon_time", Parameter.from(e)));
            Optional.ofNullable(source.getCompletedByGm()).ifPresent(e -> row.put("completed_by_gm", Parameter.from(e)));
            Optional.ofNullable(source.getCoreHash()).ifPresent(e -> row.put("core_hash", Parameter.from(e)));
            Optional.ofNullable(source.getCoreRevision()).ifPresent(e -> row.put("core_revision", Parameter.from(e)));
            return row;
        }
    }

}
