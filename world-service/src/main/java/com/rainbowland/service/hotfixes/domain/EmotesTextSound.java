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
@Table("emotes_text_sound")
public class EmotesTextSound {

    @Column("ID")
    private Integer id;
    @Column("RaceID")
    private Integer raceId;
    @Column("ClassID")
    private Integer classId;
    @Column("SexID")
    private Integer sexId;
    @Column("SoundID")
    private Integer soundId;
    @Column("EmotesTextID")
    private Integer emotesTextId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, EmotesTextSound> {

        public EmotesTextSound convert(Row row) {
            EmotesTextSound domain = new EmotesTextSound();
            domain.setId(row.get("ID", Integer.class));
            domain.setRaceId(row.get("RaceID", Integer.class));
            domain.setClassId(row.get("ClassID", Integer.class));
            domain.setSexId(row.get("SexID", Integer.class));
            domain.setSoundId(row.get("SoundID", Integer.class));
            domain.setEmotesTextId(row.get("EmotesTextID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<EmotesTextSound, OutboundRow> {

        public OutboundRow convert(EmotesTextSound source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRaceId()).ifPresent(e -> row.put("RaceID", Parameter.from(e)));
            Optional.ofNullable(source.getClassId()).ifPresent(e -> row.put("ClassID", Parameter.from(e)));
            Optional.ofNullable(source.getSexId()).ifPresent(e -> row.put("SexID", Parameter.from(e)));
            Optional.ofNullable(source.getSoundId()).ifPresent(e -> row.put("SoundID", Parameter.from(e)));
            Optional.ofNullable(source.getEmotesTextId()).ifPresent(e -> row.put("EmotesTextID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
