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
@Table("script_spline_chain_waypoints")
public class ScriptSplineChainWaypoints {

    @Column("entry")
    private Integer entry;
    @Column("chainId")
    private Integer chainId;
    @Column("splineId")
    private Integer splineId;
    @Column("wpId")
    private Integer wpId;
    @Column("x")
    private Double X;
    @Column("y")
    private Double Y;
    @Column("z")
    private Double Z;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ScriptSplineChainWaypoints> {

        public ScriptSplineChainWaypoints convert(Row row) {
            ScriptSplineChainWaypoints domain = new ScriptSplineChainWaypoints();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setChainId(row.get("chainId", Integer.class));
            domain.setSplineId(row.get("splineId", Integer.class));
            domain.setWpId(row.get("wpId", Integer.class));
            domain.setX(row.get("x", Double.class));
            domain.setY(row.get("y", Double.class));
            domain.setZ(row.get("z", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ScriptSplineChainWaypoints, OutboundRow> {

        public OutboundRow convert(ScriptSplineChainWaypoints source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getChainId()).ifPresent(e -> row.put("chainId", Parameter.from(e)));
            Optional.ofNullable(source.getSplineId()).ifPresent(e -> row.put("splineId", Parameter.from(e)));
            Optional.ofNullable(source.getWpId()).ifPresent(e -> row.put("wpId", Parameter.from(e)));
            Optional.ofNullable(source.getX()).ifPresent(e -> row.put("x", Parameter.from(e)));
            Optional.ofNullable(source.getY()).ifPresent(e -> row.put("y", Parameter.from(e)));
            Optional.ofNullable(source.getZ()).ifPresent(e -> row.put("z", Parameter.from(e)));
            return row;
        }
    }

}
