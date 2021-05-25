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
@Table("ui_map_assignment")
public class UiMapAssignment {

    @Column("UiMinX")
    private Double uiMinX;
    @Column("UiMinY")
    private Double uiMinY;
    @Column("UiMaxX")
    private Double uiMaxX;
    @Column("UiMaxY")
    private Double uiMaxY;
    @Column("Region1X")
    private Double region1X;
    @Column("Region1Y")
    private Double region1Y;
    @Column("Region1Z")
    private Double region1Z;
    @Column("Region2X")
    private Double region2X;
    @Column("Region2Y")
    private Double region2Y;
    @Column("Region2Z")
    private Double region2Z;
    @Column("ID")
    private Integer id;
    @Column("UiMapID")
    private Integer uiMapId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("MapID")
    private Integer mapId;
    @Column("AreaID")
    private Integer areaId;
    @Column("WmoDoodadPlacementID")
    private Integer wmoDoodadPlacementId;
    @Column("WmoGroupID")
    private Integer wmoGroupId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, UiMapAssignment> {

        public UiMapAssignment convert(Row row) {
            UiMapAssignment domain = new UiMapAssignment();
            domain.setUiMinX(row.get("UiMinX", Double.class));
            domain.setUiMinY(row.get("UiMinY", Double.class));
            domain.setUiMaxX(row.get("UiMaxX", Double.class));
            domain.setUiMaxY(row.get("UiMaxY", Double.class));
            domain.setRegion1X(row.get("Region1X", Double.class));
            domain.setRegion1Y(row.get("Region1Y", Double.class));
            domain.setRegion1Z(row.get("Region1Z", Double.class));
            domain.setRegion2X(row.get("Region2X", Double.class));
            domain.setRegion2Y(row.get("Region2Y", Double.class));
            domain.setRegion2Z(row.get("Region2Z", Double.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setUiMapId(row.get("UiMapID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setMapId(row.get("MapID", Integer.class));
            domain.setAreaId(row.get("AreaID", Integer.class));
            domain.setWmoDoodadPlacementId(row.get("WmoDoodadPlacementID", Integer.class));
            domain.setWmoGroupId(row.get("WmoGroupID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<UiMapAssignment, OutboundRow> {

        public OutboundRow convert(UiMapAssignment source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getUiMinX()).ifPresent(e -> row.put("UiMinX", Parameter.from(e)));
            Optional.ofNullable(source.getUiMinY()).ifPresent(e -> row.put("UiMinY", Parameter.from(e)));
            Optional.ofNullable(source.getUiMaxX()).ifPresent(e -> row.put("UiMaxX", Parameter.from(e)));
            Optional.ofNullable(source.getUiMaxY()).ifPresent(e -> row.put("UiMaxY", Parameter.from(e)));
            Optional.ofNullable(source.getRegion1X()).ifPresent(e -> row.put("Region1X", Parameter.from(e)));
            Optional.ofNullable(source.getRegion1Y()).ifPresent(e -> row.put("Region1Y", Parameter.from(e)));
            Optional.ofNullable(source.getRegion1Z()).ifPresent(e -> row.put("Region1Z", Parameter.from(e)));
            Optional.ofNullable(source.getRegion2X()).ifPresent(e -> row.put("Region2X", Parameter.from(e)));
            Optional.ofNullable(source.getRegion2Y()).ifPresent(e -> row.put("Region2Y", Parameter.from(e)));
            Optional.ofNullable(source.getRegion2Z()).ifPresent(e -> row.put("Region2Z", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getUiMapId()).ifPresent(e -> row.put("UiMapID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapID", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId()).ifPresent(e -> row.put("AreaID", Parameter.from(e)));
            Optional.ofNullable(source.getWmoDoodadPlacementId()).ifPresent(e -> row.put("WmoDoodadPlacementID", Parameter.from(e)));
            Optional.ofNullable(source.getWmoGroupId()).ifPresent(e -> row.put("WmoGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
