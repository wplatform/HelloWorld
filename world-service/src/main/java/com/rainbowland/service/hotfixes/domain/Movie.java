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
@Table("movie")
public class Movie {

    @Column("ID")
    private Integer id;
    @Column("Volume")
    private Integer volume;
    @Column("KeyID")
    private Integer keyId;
    @Column("AudioFileDataID")
    private Integer audioFileDataId;
    @Column("SubtitleFileDataID")
    private Integer subtitleFileDataId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Movie> {

        public Movie convert(Row row) {
            Movie domain = new Movie();
            domain.setId(row.get("ID", Integer.class));
            domain.setVolume(row.get("Volume", Integer.class));
            domain.setKeyId(row.get("KeyID", Integer.class));
            domain.setAudioFileDataId(row.get("AudioFileDataID", Integer.class));
            domain.setSubtitleFileDataId(row.get("SubtitleFileDataID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Movie, OutboundRow> {

        public OutboundRow convert(Movie source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getVolume()).ifPresent(e -> row.put("Volume", Parameter.from(e)));
            Optional.ofNullable(source.getKeyId()).ifPresent(e -> row.put("KeyID", Parameter.from(e)));
            Optional.ofNullable(source.getAudioFileDataId()).ifPresent(e -> row.put("AudioFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getSubtitleFileDataId()).ifPresent(e -> row.put("SubtitleFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
