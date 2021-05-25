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
@Table("broadcast_text")
public class BroadcastText {

    @Column("Text")
    private String text;
    @Column("Text1")
    private String text1;
    @Column("ID")
    private Integer id;
    @Column("LanguageID")
    private Integer languageId;
    @Column("ConditionID")
    private Integer conditionId;
    @Column("EmotesID")
    private Integer emotesId;
    @Column("Flags")
    private Integer flags;
    @Column("ChatBubbleDurationMs")
    private Integer chatBubbleDurationMs;
    @Column("SoundEntriesID1")
    private Integer soundEntriesId1;
    @Column("SoundEntriesID2")
    private Integer soundEntriesId2;
    @Column("EmoteID1")
    private Integer emoteId1;
    @Column("EmoteID2")
    private Integer emoteId2;
    @Column("EmoteID3")
    private Integer emoteId3;
    @Column("EmoteDelay1")
    private Integer emoteDelay1;
    @Column("EmoteDelay2")
    private Integer emoteDelay2;
    @Column("EmoteDelay3")
    private Integer emoteDelay3;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BroadcastText> {

        public BroadcastText convert(Row row) {
            BroadcastText domain = new BroadcastText();
            domain.setText(row.get("Text", String.class));
            domain.setText1(row.get("Text1", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setLanguageId(row.get("LanguageID", Integer.class));
            domain.setConditionId(row.get("ConditionID", Integer.class));
            domain.setEmotesId(row.get("EmotesID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setChatBubbleDurationMs(row.get("ChatBubbleDurationMs", Integer.class));
            domain.setSoundEntriesId1(row.get("SoundEntriesID1", Integer.class));
            domain.setSoundEntriesId2(row.get("SoundEntriesID2", Integer.class));
            domain.setEmoteId1(row.get("EmoteID1", Integer.class));
            domain.setEmoteId2(row.get("EmoteID2", Integer.class));
            domain.setEmoteId3(row.get("EmoteID3", Integer.class));
            domain.setEmoteDelay1(row.get("EmoteDelay1", Integer.class));
            domain.setEmoteDelay2(row.get("EmoteDelay2", Integer.class));
            domain.setEmoteDelay3(row.get("EmoteDelay3", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BroadcastText, OutboundRow> {

        public OutboundRow convert(BroadcastText source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getText()).ifPresent(e -> row.put("Text", Parameter.from(e)));
            Optional.ofNullable(source.getText1()).ifPresent(e -> row.put("Text1", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLanguageId()).ifPresent(e -> row.put("LanguageID", Parameter.from(e)));
            Optional.ofNullable(source.getConditionId()).ifPresent(e -> row.put("ConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getEmotesId()).ifPresent(e -> row.put("EmotesID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getChatBubbleDurationMs()).ifPresent(e -> row.put("ChatBubbleDurationMs", Parameter.from(e)));
            Optional.ofNullable(source.getSoundEntriesId1()).ifPresent(e -> row.put("SoundEntriesID1", Parameter.from(e)));
            Optional.ofNullable(source.getSoundEntriesId2()).ifPresent(e -> row.put("SoundEntriesID2", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteId1()).ifPresent(e -> row.put("EmoteID1", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteId2()).ifPresent(e -> row.put("EmoteID2", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteId3()).ifPresent(e -> row.put("EmoteID3", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteDelay1()).ifPresent(e -> row.put("EmoteDelay1", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteDelay2()).ifPresent(e -> row.put("EmoteDelay2", Parameter.from(e)));
            Optional.ofNullable(source.getEmoteDelay3()).ifPresent(e -> row.put("EmoteDelay3", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
