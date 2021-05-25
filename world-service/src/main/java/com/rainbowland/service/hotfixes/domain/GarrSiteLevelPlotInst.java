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
@Table("garr_site_level_plot_inst")
public class GarrSiteLevelPlotInst {

    @Column("ID")
    private Integer id;
    @Column("UiMarkerPosX")
    private Double uiMarkerPosX;
    @Column("UiMarkerPosY")
    private Double uiMarkerPosY;
    @Column("GarrSiteLevelID")
    private Integer garrSiteLevelId;
    @Column("GarrPlotInstanceID")
    private Integer garrPlotInstanceId;
    @Column("UiMarkerSize")
    private Integer uiMarkerSize;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrSiteLevelPlotInst> {

        public GarrSiteLevelPlotInst convert(Row row) {
            GarrSiteLevelPlotInst domain = new GarrSiteLevelPlotInst();
            domain.setId(row.get("ID", Integer.class));
            domain.setUiMarkerPosX(row.get("UiMarkerPosX", Double.class));
            domain.setUiMarkerPosY(row.get("UiMarkerPosY", Double.class));
            domain.setGarrSiteLevelId(row.get("GarrSiteLevelID", Integer.class));
            domain.setGarrPlotInstanceId(row.get("GarrPlotInstanceID", Integer.class));
            domain.setUiMarkerSize(row.get("UiMarkerSize", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrSiteLevelPlotInst, OutboundRow> {

        public OutboundRow convert(GarrSiteLevelPlotInst source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getUiMarkerPosX()).ifPresent(e -> row.put("UiMarkerPosX", Parameter.from(e)));
            Optional.ofNullable(source.getUiMarkerPosY()).ifPresent(e -> row.put("UiMarkerPosY", Parameter.from(e)));
            Optional.ofNullable(source.getGarrSiteLevelId()).ifPresent(e -> row.put("GarrSiteLevelID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrPlotInstanceId()).ifPresent(e -> row.put("GarrPlotInstanceID", Parameter.from(e)));
            Optional.ofNullable(source.getUiMarkerSize()).ifPresent(e -> row.put("UiMarkerSize", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
