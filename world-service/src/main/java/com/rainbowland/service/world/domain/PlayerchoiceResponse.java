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
@Table("playerchoice_response")
public class PlayerchoiceResponse {

    @Column("ChoiceId")
    private Integer choiceId;
    @Column("ResponseId")
    private Integer responseId;
    @Column("ResponseIdentifier")
    private Integer responseIdentifier;
    @Column("Index")
    private Integer index;
    @Column("ChoiceArtFileId")
    private Integer choiceArtFileId;
    @Column("Flags")
    private Integer flags;
    @Column("WidgetSetID")
    private Integer widgetSetId;
    @Column("UiTextureAtlasElementID")
    private Integer uiTextureAtlasElementId;
    @Column("SoundKitID")
    private Integer soundKitId;
    @Column("GroupID")
    private Integer groupId;
    @Column("UiTextureKitID")
    private Integer uiTextureKitId;
    @Column("Header")
    private String header;
    @Column("SubHeader")
    private String subHeader;
    @Column("ButtonTooltip")
    private String buttonTooltip;
    @Column("Answer")
    private String answer;
    @Column("Description")
    private String description;
    @Column("Confirmation")
    private String confirmation;
    @Column("RewardQuestID")
    private Integer rewardQuestId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerchoiceResponse> {

        public PlayerchoiceResponse convert(Row row) {
            PlayerchoiceResponse domain = new PlayerchoiceResponse();
            domain.setChoiceId(row.get("ChoiceId", Integer.class));
            domain.setResponseId(row.get("ResponseId", Integer.class));
            domain.setResponseIdentifier(row.get("ResponseIdentifier", Integer.class));
            domain.setIndex(row.get("Index", Integer.class));
            domain.setChoiceArtFileId(row.get("ChoiceArtFileId", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setWidgetSetId(row.get("WidgetSetID", Integer.class));
            domain.setUiTextureAtlasElementId(row.get("UiTextureAtlasElementID", Integer.class));
            domain.setSoundKitId(row.get("SoundKitID", Integer.class));
            domain.setGroupId(row.get("GroupID", Integer.class));
            domain.setUiTextureKitId(row.get("UiTextureKitID", Integer.class));
            domain.setHeader(row.get("Header", String.class));
            domain.setSubHeader(row.get("SubHeader", String.class));
            domain.setButtonTooltip(row.get("ButtonTooltip", String.class));
            domain.setAnswer(row.get("Answer", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setConfirmation(row.get("Confirmation", String.class));
            domain.setRewardQuestId(row.get("RewardQuestID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerchoiceResponse, OutboundRow> {

        public OutboundRow convert(PlayerchoiceResponse source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getChoiceId()).ifPresent(e -> row.put("ChoiceId", Parameter.from(e)));
            Optional.ofNullable(source.getResponseId()).ifPresent(e -> row.put("ResponseId", Parameter.from(e)));
            Optional.ofNullable(source.getResponseIdentifier()).ifPresent(e -> row.put("ResponseIdentifier", Parameter.from(e)));
            Optional.ofNullable(source.getIndex()).ifPresent(e -> row.put("Index", Parameter.from(e)));
            Optional.ofNullable(source.getChoiceArtFileId()).ifPresent(e -> row.put("ChoiceArtFileId", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getWidgetSetId()).ifPresent(e -> row.put("WidgetSetID", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureAtlasElementId()).ifPresent(e -> row.put("UiTextureAtlasElementID", Parameter.from(e)));
            Optional.ofNullable(source.getSoundKitId()).ifPresent(e -> row.put("SoundKitID", Parameter.from(e)));
            Optional.ofNullable(source.getGroupId()).ifPresent(e -> row.put("GroupID", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureKitId()).ifPresent(e -> row.put("UiTextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getHeader()).ifPresent(e -> row.put("Header", Parameter.from(e)));
            Optional.ofNullable(source.getSubHeader()).ifPresent(e -> row.put("SubHeader", Parameter.from(e)));
            Optional.ofNullable(source.getButtonTooltip()).ifPresent(e -> row.put("ButtonTooltip", Parameter.from(e)));
            Optional.ofNullable(source.getAnswer()).ifPresent(e -> row.put("Answer", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getConfirmation()).ifPresent(e -> row.put("Confirmation", Parameter.from(e)));
            Optional.ofNullable(source.getRewardQuestId()).ifPresent(e -> row.put("RewardQuestID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
