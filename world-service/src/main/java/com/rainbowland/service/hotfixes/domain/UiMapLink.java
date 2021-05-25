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
@Table("ui_map_link")
public class UiMapLink {

    @Column("UiMinX")
    private Double uiMinX;
    @Column("UiMinY")
    private Double uiMinY;
    @Column("UiMaxX")
    private Double uiMaxX;
    @Column("UiMaxY")
    private Double uiMaxY;
    @Column("ID")
    private Integer id;
    @Column("ParentUiMapID")
    private Integer parentUiMapId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("ChildUiMapID")
    private Integer childUiMapId;
    @Column("OverrideHighlightFileDataID")
    private Integer overrideHighlightFileDataId;
    @Column("OverrideHighlightAtlasID")
    private Integer overrideHighlightAtlasId;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, UiMapLink> {

        public UiMapLink convert(Row row) {
            UiMapLink domain = new UiMapLink();
            domain.setUiMinX(row.get("UiMinX", Double.class));
            domain.setUiMinY(row.get("UiMinY", Double.class));
            domain.setUiMaxX(row.get("UiMaxX", Double.class));
            domain.setUiMaxY(row.get("UiMaxY", Double.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setParentUiMapId(row.get("ParentUiMapID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setChildUiMapId(row.get("ChildUiMapID", Integer.class));
            domain.setOverrideHighlightFileDataId(row.get("OverrideHighlightFileDataID", Integer.class));
            domain.setOverrideHighlightAtlasId(row.get("OverrideHighlightAtlasID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<UiMapLink, OutboundRow> {

        public OutboundRow convert(UiMapLink source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getUiMinX()).ifPresent(e -> row.put("UiMinX", Parameter.from(e)));
            Optional.ofNullable(source.getUiMinY()).ifPresent(e -> row.put("UiMinY", Parameter.from(e)));
            Optional.ofNullable(source.getUiMaxX()).ifPresent(e -> row.put("UiMaxX", Parameter.from(e)));
            Optional.ofNullable(source.getUiMaxY()).ifPresent(e -> row.put("UiMaxY", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getParentUiMapId()).ifPresent(e -> row.put("ParentUiMapID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getChildUiMapId()).ifPresent(e -> row.put("ChildUiMapID", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideHighlightFileDataId()).ifPresent(e -> row.put("OverrideHighlightFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideHighlightAtlasId()).ifPresent(e -> row.put("OverrideHighlightAtlasID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
