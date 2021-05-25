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
@Table("areatrigger_template_polygon_vertices")
public class AreatriggerTemplatePolygonVertices {

    @Column("AreaTriggerId")
    private Integer areaTriggerId;
    @Column("Idx")
    private Integer idx;
    @Column("VerticeX")
    private Double verticeX;
    @Column("VerticeY")
    private Double verticeY;
    @Column("VerticeTargetX")
    private Double verticeTargetX;
    @Column("VerticeTargetY")
    private Double verticeTargetY;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AreatriggerTemplatePolygonVertices> {

        public AreatriggerTemplatePolygonVertices convert(Row row) {
            AreatriggerTemplatePolygonVertices domain = new AreatriggerTemplatePolygonVertices();
            domain.setAreaTriggerId(row.get("AreaTriggerId", Integer.class));
            domain.setIdx(row.get("Idx", Integer.class));
            domain.setVerticeX(row.get("VerticeX", Double.class));
            domain.setVerticeY(row.get("VerticeY", Double.class));
            domain.setVerticeTargetX(row.get("VerticeTargetX", Double.class));
            domain.setVerticeTargetY(row.get("VerticeTargetY", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AreatriggerTemplatePolygonVertices, OutboundRow> {

        public OutboundRow convert(AreatriggerTemplatePolygonVertices source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAreaTriggerId()).ifPresent(e -> row.put("AreaTriggerId", Parameter.from(e)));
            Optional.ofNullable(source.getIdx()).ifPresent(e -> row.put("Idx", Parameter.from(e)));
            Optional.ofNullable(source.getVerticeX()).ifPresent(e -> row.put("VerticeX", Parameter.from(e)));
            Optional.ofNullable(source.getVerticeY()).ifPresent(e -> row.put("VerticeY", Parameter.from(e)));
            Optional.ofNullable(source.getVerticeTargetX()).ifPresent(e -> row.put("VerticeTargetX", Parameter.from(e)));
            Optional.ofNullable(source.getVerticeTargetY()).ifPresent(e -> row.put("VerticeTargetY", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
