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
@Table("playerchoice_response_locale")
public class PlayerchoiceResponseLocale {

    @Column("ChoiceId")
    private Integer choiceId;
    @Column("ResponseId")
    private Integer responseId;
    @Column("locale")
    private String locale;
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
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerchoiceResponseLocale> {

        public PlayerchoiceResponseLocale convert(Row row) {
            PlayerchoiceResponseLocale domain = new PlayerchoiceResponseLocale();
            domain.setChoiceId(row.get("ChoiceId", Integer.class));
            domain.setResponseId(row.get("ResponseId", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setHeader(row.get("Header", String.class));
            domain.setSubHeader(row.get("SubHeader", String.class));
            domain.setButtonTooltip(row.get("ButtonTooltip", String.class));
            domain.setAnswer(row.get("Answer", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setConfirmation(row.get("Confirmation", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerchoiceResponseLocale, OutboundRow> {

        public OutboundRow convert(PlayerchoiceResponseLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getChoiceId()).ifPresent(e -> row.put("ChoiceId", Parameter.from(e)));
            Optional.ofNullable(source.getResponseId()).ifPresent(e -> row.put("ResponseId", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getHeader()).ifPresent(e -> row.put("Header", Parameter.from(e)));
            Optional.ofNullable(source.getSubHeader()).ifPresent(e -> row.put("SubHeader", Parameter.from(e)));
            Optional.ofNullable(source.getButtonTooltip()).ifPresent(e -> row.put("ButtonTooltip", Parameter.from(e)));
            Optional.ofNullable(source.getAnswer()).ifPresent(e -> row.put("Answer", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getConfirmation()).ifPresent(e -> row.put("Confirmation", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
