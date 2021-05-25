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
@Table("conversation_line")
public class ConversationLine {

    @Column("ID")
    private Integer id;
    @Column("BroadcastTextID")
    private Integer broadcastTextId;
    @Column("SpellVisualKitID")
    private Integer spellVisualKitId;
    @Column("AdditionalDuration")
    private Integer additionalDuration;
    @Column("NextConversationLineID")
    private Integer nextConversationLineId;
    @Column("AnimKitID")
    private Integer animKitId;
    @Column("SpeechType")
    private Integer speechType;
    @Column("StartAnimation")
    private Integer startAnimation;
    @Column("EndAnimation")
    private Integer endAnimation;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ConversationLine> {

        public ConversationLine convert(Row row) {
            ConversationLine domain = new ConversationLine();
            domain.setId(row.get("ID", Integer.class));
            domain.setBroadcastTextId(row.get("BroadcastTextID", Integer.class));
            domain.setSpellVisualKitId(row.get("SpellVisualKitID", Integer.class));
            domain.setAdditionalDuration(row.get("AdditionalDuration", Integer.class));
            domain.setNextConversationLineId(row.get("NextConversationLineID", Integer.class));
            domain.setAnimKitId(row.get("AnimKitID", Integer.class));
            domain.setSpeechType(row.get("SpeechType", Integer.class));
            domain.setStartAnimation(row.get("StartAnimation", Integer.class));
            domain.setEndAnimation(row.get("EndAnimation", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ConversationLine, OutboundRow> {

        public OutboundRow convert(ConversationLine source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getBroadcastTextId()).ifPresent(e -> row.put("BroadcastTextID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellVisualKitId()).ifPresent(e -> row.put("SpellVisualKitID", Parameter.from(e)));
            Optional.ofNullable(source.getAdditionalDuration()).ifPresent(e -> row.put("AdditionalDuration", Parameter.from(e)));
            Optional.ofNullable(source.getNextConversationLineId()).ifPresent(e -> row.put("NextConversationLineID", Parameter.from(e)));
            Optional.ofNullable(source.getAnimKitId()).ifPresent(e -> row.put("AnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getSpeechType()).ifPresent(e -> row.put("SpeechType", Parameter.from(e)));
            Optional.ofNullable(source.getStartAnimation()).ifPresent(e -> row.put("StartAnimation", Parameter.from(e)));
            Optional.ofNullable(source.getEndAnimation()).ifPresent(e -> row.put("EndAnimation", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
