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
@Table("cinematic_camera")
public class CinematicCamera {

    @Column("ID")
    private Integer id;
    @Column("OriginX")
    private Double originX;
    @Column("OriginY")
    private Double originY;
    @Column("OriginZ")
    private Double originZ;
    @Column("SoundID")
    private Integer soundId;
    @Column("OriginFacing")
    private Double originFacing;
    @Column("FileDataID")
    private Integer fileDataId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CinematicCamera> {

        public CinematicCamera convert(Row row) {
            CinematicCamera domain = new CinematicCamera();
            domain.setId(row.get("ID", Integer.class));
            domain.setOriginX(row.get("OriginX", Double.class));
            domain.setOriginY(row.get("OriginY", Double.class));
            domain.setOriginZ(row.get("OriginZ", Double.class));
            domain.setSoundId(row.get("SoundID", Integer.class));
            domain.setOriginFacing(row.get("OriginFacing", Double.class));
            domain.setFileDataId(row.get("FileDataID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CinematicCamera, OutboundRow> {

        public OutboundRow convert(CinematicCamera source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getOriginX()).ifPresent(e -> row.put("OriginX", Parameter.from(e)));
            Optional.ofNullable(source.getOriginY()).ifPresent(e -> row.put("OriginY", Parameter.from(e)));
            Optional.ofNullable(source.getOriginZ()).ifPresent(e -> row.put("OriginZ", Parameter.from(e)));
            Optional.ofNullable(source.getSoundId()).ifPresent(e -> row.put("SoundID", Parameter.from(e)));
            Optional.ofNullable(source.getOriginFacing()).ifPresent(e -> row.put("OriginFacing", Parameter.from(e)));
            Optional.ofNullable(source.getFileDataId()).ifPresent(e -> row.put("FileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
