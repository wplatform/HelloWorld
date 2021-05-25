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
@Table("garr_building_plot_inst")
public class GarrBuildingPlotInst {

    @Column("MapOffsetX")
    private Double mapOffsetX;
    @Column("MapOffsetY")
    private Double mapOffsetY;
    @Column("ID")
    private Integer id;
    @Column("GarrBuildingID")
    private Integer garrBuildingId;
    @Column("GarrSiteLevelPlotInstID")
    private Integer garrSiteLevelPlotInstId;
    @Column("UiTextureAtlasMemberID")
    private Integer uiTextureAtlasMemberId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrBuildingPlotInst> {

        public GarrBuildingPlotInst convert(Row row) {
            GarrBuildingPlotInst domain = new GarrBuildingPlotInst();
            domain.setMapOffsetX(row.get("MapOffsetX", Double.class));
            domain.setMapOffsetY(row.get("MapOffsetY", Double.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setGarrBuildingId(row.get("GarrBuildingID", Integer.class));
            domain.setGarrSiteLevelPlotInstId(row.get("GarrSiteLevelPlotInstID", Integer.class));
            domain.setUiTextureAtlasMemberId(row.get("UiTextureAtlasMemberID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrBuildingPlotInst, OutboundRow> {

        public OutboundRow convert(GarrBuildingPlotInst source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMapOffsetX()).ifPresent(e -> row.put("MapOffsetX", Parameter.from(e)));
            Optional.ofNullable(source.getMapOffsetY()).ifPresent(e -> row.put("MapOffsetY", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrBuildingId()).ifPresent(e -> row.put("GarrBuildingID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrSiteLevelPlotInstId()).ifPresent(e -> row.put("GarrSiteLevelPlotInstID", Parameter.from(e)));
            Optional.ofNullable(source.getUiTextureAtlasMemberId()).ifPresent(e -> row.put("UiTextureAtlasMemberID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
