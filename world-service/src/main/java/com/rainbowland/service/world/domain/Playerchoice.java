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
@Table("playerchoice")
public class Playerchoice {

    @Column("ChoiceId")
    private Integer choiceId;
    @Column("UiTextureKitId")
    private Integer uiTextureKitId;
    @Column("SoundKitId")
    private Integer soundKitId;
    @Column("Question")
    private String question;
    @Column("HideWarboardHeader")
    private Integer hideWarboardHeader;
    @Column("KeepOpenAfterChoice")
    private Integer keepOpenAfterChoice;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Playerchoice> {

        public Playerchoice convert(Row row) {
            Playerchoice domain = new Playerchoice();
            domain.setChoiceId(row.get("ChoiceId", Integer.class));
            domain.setUiTextureKitId(row.get("UiTextureKitId", Integer.class));
            domain.setSoundKitId(row.get("SoundKitId", Integer.class));
            domain.setQuestion(row.get("Question", String.class));
            domain.setHideWarboardHeader(row.get("HideWarboardHeader", Integer.class));
            domain.setKeepOpenAfterChoice(row.get("KeepOpenAfterChoice", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Playerchoice, OutboundRow> {

        public OutboundRow convert(Playerchoice source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getChoiceId()).ifPresent(e -> row.put("ChoiceId", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureKitId()).ifPresent(e -> row.put("UiTextureKitId", Parameter.from(e)));
            Optional.ofNullable(source.getSoundKitId()).ifPresent(e -> row.put("SoundKitId", Parameter.from(e)));
            Optional.ofNullable(source.getQuestion()).ifPresent(e -> row.put("Question", Parameter.from(e)));
            Optional.ofNullable(source.getHideWarboardHeader()).ifPresent(e -> row.put("HideWarboardHeader", Parameter.from(e)));
            Optional.ofNullable(source.getKeepOpenAfterChoice()).ifPresent(e -> row.put("KeepOpenAfterChoice", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
