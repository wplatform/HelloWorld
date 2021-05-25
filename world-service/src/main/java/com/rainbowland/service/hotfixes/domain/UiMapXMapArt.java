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
@Table("ui_map_x_map_art")
public class UiMapXMapArt {

    @Column("ID")
    private Integer id;
    @Column("PhaseID")
    private Integer phaseId;
    @Column("UiMapArtID")
    private Integer uiMapArtId;
    @Column("UiMapID")
    private Integer uiMapId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, UiMapXMapArt> {

        public UiMapXMapArt convert(Row row) {
            UiMapXMapArt domain = new UiMapXMapArt();
            domain.setId(row.get("ID", Integer.class));
            domain.setPhaseId(row.get("PhaseID", Integer.class));
            domain.setUiMapArtId(row.get("UiMapArtID", Integer.class));
            domain.setUiMapId(row.get("UiMapID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<UiMapXMapArt, OutboundRow> {

        public OutboundRow convert(UiMapXMapArt source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseId()).ifPresent(e -> row.put("PhaseID", Parameter.from(e)));
            Optional.ofNullable(source.getUiMapArtId()).ifPresent(e -> row.put("UiMapArtID", Parameter.from(e)));
            Optional.ofNullable(source.getUiMapId()).ifPresent(e -> row.put("UiMapID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
