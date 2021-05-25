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
@Table("cinematic_sequences")
public class CinematicSequences {

    @Column("ID")
    private Integer id;
    @Column("SoundID")
    private Integer soundId;
    @Column("Camera1")
    private Integer camera1;
    @Column("Camera2")
    private Integer camera2;
    @Column("Camera3")
    private Integer camera3;
    @Column("Camera4")
    private Integer camera4;
    @Column("Camera5")
    private Integer camera5;
    @Column("Camera6")
    private Integer camera6;
    @Column("Camera7")
    private Integer camera7;
    @Column("Camera8")
    private Integer camera8;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CinematicSequences> {

        public CinematicSequences convert(Row row) {
            CinematicSequences domain = new CinematicSequences();
            domain.setId(row.get("ID", Integer.class));
            domain.setSoundId(row.get("SoundID", Integer.class));
            domain.setCamera1(row.get("Camera1", Integer.class));
            domain.setCamera2(row.get("Camera2", Integer.class));
            domain.setCamera3(row.get("Camera3", Integer.class));
            domain.setCamera4(row.get("Camera4", Integer.class));
            domain.setCamera5(row.get("Camera5", Integer.class));
            domain.setCamera6(row.get("Camera6", Integer.class));
            domain.setCamera7(row.get("Camera7", Integer.class));
            domain.setCamera8(row.get("Camera8", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CinematicSequences, OutboundRow> {

        public OutboundRow convert(CinematicSequences source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSoundId()).ifPresent(e -> row.put("SoundID", Parameter.from(e)));
            Optional.ofNullable(source.getCamera1()).ifPresent(e -> row.put("Camera1", Parameter.from(e)));
            Optional.ofNullable(source.getCamera2()).ifPresent(e -> row.put("Camera2", Parameter.from(e)));
            Optional.ofNullable(source.getCamera3()).ifPresent(e -> row.put("Camera3", Parameter.from(e)));
            Optional.ofNullable(source.getCamera4()).ifPresent(e -> row.put("Camera4", Parameter.from(e)));
            Optional.ofNullable(source.getCamera5()).ifPresent(e -> row.put("Camera5", Parameter.from(e)));
            Optional.ofNullable(source.getCamera6()).ifPresent(e -> row.put("Camera6", Parameter.from(e)));
            Optional.ofNullable(source.getCamera7()).ifPresent(e -> row.put("Camera7", Parameter.from(e)));
            Optional.ofNullable(source.getCamera8()).ifPresent(e -> row.put("Camera8", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
