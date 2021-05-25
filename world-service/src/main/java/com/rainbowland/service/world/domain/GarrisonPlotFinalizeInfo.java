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
@Table("garrison_plot_finalize_info")
public class GarrisonPlotFinalizeInfo {

    @Column("garrPlotInstanceId")
    private Integer garrPlotInstanceId;
    @Column("hordeGameObjectId")
    private Integer hordeGameObjectId;
    @Column("hordeX")
    private Double hordeX;
    @Column("hordeY")
    private Double hordeY;
    @Column("hordeZ")
    private Double hordeZ;
    @Column("hordeO")
    private Double hordeO;
    @Column("hordeAnimKitId")
    private Integer hordeAnimKitId;
    @Column("allianceGameObjectId")
    private Integer allianceGameObjectId;
    @Column("allianceX")
    private Double allianceX;
    @Column("allianceY")
    private Double allianceY;
    @Column("allianceZ")
    private Double allianceZ;
    @Column("allianceO")
    private Double allianceO;
    @Column("allianceAnimKitId")
    private Integer allianceAnimKitId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrisonPlotFinalizeInfo> {

        public GarrisonPlotFinalizeInfo convert(Row row) {
            GarrisonPlotFinalizeInfo domain = new GarrisonPlotFinalizeInfo();
            domain.setGarrPlotInstanceId(row.get("garrPlotInstanceId", Integer.class));
            domain.setHordeGameObjectId(row.get("hordeGameObjectId", Integer.class));
            domain.setHordeX(row.get("hordeX", Double.class));
            domain.setHordeY(row.get("hordeY", Double.class));
            domain.setHordeZ(row.get("hordeZ", Double.class));
            domain.setHordeO(row.get("hordeO", Double.class));
            domain.setHordeAnimKitId(row.get("hordeAnimKitId", Integer.class));
            domain.setAllianceGameObjectId(row.get("allianceGameObjectId", Integer.class));
            domain.setAllianceX(row.get("allianceX", Double.class));
            domain.setAllianceY(row.get("allianceY", Double.class));
            domain.setAllianceZ(row.get("allianceZ", Double.class));
            domain.setAllianceO(row.get("allianceO", Double.class));
            domain.setAllianceAnimKitId(row.get("allianceAnimKitId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrisonPlotFinalizeInfo, OutboundRow> {

        public OutboundRow convert(GarrisonPlotFinalizeInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGarrPlotInstanceId()).ifPresent(e -> row.put("garrPlotInstanceId", Parameter.from(e)));
            Optional.ofNullable(source.getHordeGameObjectId()).ifPresent(e -> row.put("hordeGameObjectId", Parameter.from(e)));
            Optional.ofNullable(source.getHordeX()).ifPresent(e -> row.put("hordeX", Parameter.from(e)));
            Optional.ofNullable(source.getHordeY()).ifPresent(e -> row.put("hordeY", Parameter.from(e)));
            Optional.ofNullable(source.getHordeZ()).ifPresent(e -> row.put("hordeZ", Parameter.from(e)));
            Optional.ofNullable(source.getHordeO()).ifPresent(e -> row.put("hordeO", Parameter.from(e)));
            Optional.ofNullable(source.getHordeAnimKitId()).ifPresent(e -> row.put("hordeAnimKitId", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceGameObjectId()).ifPresent(e -> row.put("allianceGameObjectId", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceX()).ifPresent(e -> row.put("allianceX", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceY()).ifPresent(e -> row.put("allianceY", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceZ()).ifPresent(e -> row.put("allianceZ", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceO()).ifPresent(e -> row.put("allianceO", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceAnimKitId()).ifPresent(e -> row.put("allianceAnimKitId", Parameter.from(e)));
            return row;
        }
    }

}
