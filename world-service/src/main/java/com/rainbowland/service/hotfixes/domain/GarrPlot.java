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
@Table("garr_plot")
public class GarrPlot {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("PlotType")
    private Integer plotType;
    @Column("HordeConstructObjID")
    private Integer hordeConstructObjId;
    @Column("AllianceConstructObjID")
    private Integer allianceConstructObjId;
    @Column("Flags")
    private Integer flags;
    @Column("UiCategoryID")
    private Integer uiCategoryId;
    @Column("UpgradeRequirement1")
    private Integer upgradeRequirement1;
    @Column("UpgradeRequirement2")
    private Integer upgradeRequirement2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrPlot> {

        public GarrPlot convert(Row row) {
            GarrPlot domain = new GarrPlot();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setPlotType(row.get("PlotType", Integer.class));
            domain.setHordeConstructObjId(row.get("HordeConstructObjID", Integer.class));
            domain.setAllianceConstructObjId(row.get("AllianceConstructObjID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setUiCategoryId(row.get("UiCategoryID", Integer.class));
            domain.setUpgradeRequirement1(row.get("UpgradeRequirement1", Integer.class));
            domain.setUpgradeRequirement2(row.get("UpgradeRequirement2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrPlot, OutboundRow> {

        public OutboundRow convert(GarrPlot source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getPlotType()).ifPresent(e -> row.put("PlotType", Parameter.from(e)));
            Optional.ofNullable(source.getHordeConstructObjId()).ifPresent(e -> row.put("HordeConstructObjID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceConstructObjId()).ifPresent(e -> row.put("AllianceConstructObjID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getUiCategoryId()).ifPresent(e -> row.put("UiCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeRequirement1()).ifPresent(e -> row.put("UpgradeRequirement1", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeRequirement2()).ifPresent(e -> row.put("UpgradeRequirement2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
