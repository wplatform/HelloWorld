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
@Table("scenario_poi_points")
public class ScenarioPoiPoints {

    @Column("CriteriaTreeID")
    private Integer criteriaTreeId;
    @Column("Idx1")
    private Integer idx1;
    @Column("Idx2")
    private Integer idx2;
    @Column("X")
    private Integer X;
    @Column("Y")
    private Integer Y;
    @Column("Z")
    private Integer Z;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ScenarioPoiPoints> {

        public ScenarioPoiPoints convert(Row row) {
            ScenarioPoiPoints domain = new ScenarioPoiPoints();
            domain.setCriteriaTreeId(row.get("CriteriaTreeID", Integer.class));
            domain.setIdx1(row.get("Idx1", Integer.class));
            domain.setIdx2(row.get("Idx2", Integer.class));
            domain.setX(row.get("X", Integer.class));
            domain.setY(row.get("Y", Integer.class));
            domain.setZ(row.get("Z", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ScenarioPoiPoints, OutboundRow> {

        public OutboundRow convert(ScenarioPoiPoints source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCriteriaTreeId()).ifPresent(e -> row.put("CriteriaTreeID", Parameter.from(e)));
            Optional.ofNullable(source.getIdx1()).ifPresent(e -> row.put("Idx1", Parameter.from(e)));
            Optional.ofNullable(source.getIdx2()).ifPresent(e -> row.put("Idx2", Parameter.from(e)));
            Optional.ofNullable(source.getX()).ifPresent(e -> row.put("X", Parameter.from(e)));
            Optional.ofNullable(source.getY()).ifPresent(e -> row.put("Y", Parameter.from(e)));
            Optional.ofNullable(source.getZ()).ifPresent(e -> row.put("Z", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
