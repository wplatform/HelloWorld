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
@Table("garr_plot_building")
public class GarrPlotBuilding {

    @Column("ID")
    private Integer id;
    @Column("GarrPlotID")
    private Integer garrPlotId;
    @Column("GarrBuildingID")
    private Integer garrBuildingId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrPlotBuilding> {

        public GarrPlotBuilding convert(Row row) {
            GarrPlotBuilding domain = new GarrPlotBuilding();
            domain.setId(row.get("ID", Integer.class));
            domain.setGarrPlotId(row.get("GarrPlotID", Integer.class));
            domain.setGarrBuildingId(row.get("GarrBuildingID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrPlotBuilding, OutboundRow> {

        public OutboundRow convert(GarrPlotBuilding source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrPlotId()).ifPresent(e -> row.put("GarrPlotID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrBuildingId()).ifPresent(e -> row.put("GarrBuildingID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
