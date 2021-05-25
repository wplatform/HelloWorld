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
@Table("quest_request_items")
public class QuestRequestItems {

    @Column("ID")
    private Integer id;
    @Column("EmoteOnComplete")
    private Integer emoteOnComplete;
    @Column("EmoteOnIncomplete")
    private Integer emoteOnIncomplete;
    @Column("EmoteOnCompleteDelay")
    private Integer emoteOnCompleteDelay;
    @Column("EmoteOnIncompleteDelay")
    private Integer emoteOnIncompleteDelay;
    @Column("CompletionText")
    private String completionText;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestRequestItems> {

        public QuestRequestItems convert(Row row) {
            QuestRequestItems domain = new QuestRequestItems();
            domain.setId(row.get("ID", Integer.class));
            domain.setEmoteOnComplete(row.get("EmoteOnComplete", Integer.class));
            domain.setEmoteOnIncomplete(row.get("EmoteOnIncomplete", Integer.class));
            domain.setEmoteOnCompleteDelay(row.get("EmoteOnCompleteDelay", Integer.class));
            domain.setEmoteOnIncompleteDelay(row.get("EmoteOnIncompleteDelay", Integer.class));
            domain.setCompletionText(row.get("CompletionText", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestRequestItems, OutboundRow> {

        public OutboundRow convert(QuestRequestItems source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteOnComplete()).ifPresent(e -> row.put("EmoteOnComplete", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteOnIncomplete()).ifPresent(e -> row.put("EmoteOnIncomplete", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteOnCompleteDelay()).ifPresent(e -> row.put("EmoteOnCompleteDelay", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteOnIncompleteDelay()).ifPresent(e -> row.put("EmoteOnIncompleteDelay", Parameter.from(e)));
            Optional.ofNullable(source.getCompletionText()).ifPresent(e -> row.put("CompletionText", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
