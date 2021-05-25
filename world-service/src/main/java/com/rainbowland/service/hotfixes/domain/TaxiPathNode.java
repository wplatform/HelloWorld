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
@Table("taxi_path_node")
public class TaxiPathNode {

    @Column("LocX")
    private Double locX;
    @Column("LocY")
    private Double locY;
    @Column("LocZ")
    private Double locZ;
    @Column("ID")
    private Integer id;
    @Column("PathID")
    private Integer pathId;
    @Column("NodeIndex")
    private Integer nodeIndex;
    @Column("ContinentID")
    private Integer continentId;
    @Column("Flags")
    private Integer flags;
    @Column("Delay")
    private Integer delay;
    @Column("ArrivalEventID")
    private Integer arrivalEventId;
    @Column("DepartureEventID")
    private Integer departureEventId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TaxiPathNode> {

        public TaxiPathNode convert(Row row) {
            TaxiPathNode domain = new TaxiPathNode();
            domain.setLocX(row.get("LocX", Double.class));
            domain.setLocY(row.get("LocY", Double.class));
            domain.setLocZ(row.get("LocZ", Double.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setPathId(row.get("PathID", Integer.class));
            domain.setNodeIndex(row.get("NodeIndex", Integer.class));
            domain.setContinentId(row.get("ContinentID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setDelay(row.get("Delay", Integer.class));
            domain.setArrivalEventId(row.get("ArrivalEventID", Integer.class));
            domain.setDepartureEventId(row.get("DepartureEventID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TaxiPathNode, OutboundRow> {

        public OutboundRow convert(TaxiPathNode source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getLocX()).ifPresent(e -> row.put("LocX", Parameter.from(e)));
            Optional.ofNullable(source.getLocY()).ifPresent(e -> row.put("LocY", Parameter.from(e)));
            Optional.ofNullable(source.getLocZ()).ifPresent(e -> row.put("LocZ", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPathId()).ifPresent(e -> row.put("PathID", Parameter.from(e)));
            Optional.ofNullable(source.getNodeIndex()).ifPresent(e -> row.put("NodeIndex", Parameter.from(e)));
            Optional.ofNullable(source.getContinentId()).ifPresent(e -> row.put("ContinentID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getDelay()).ifPresent(e -> row.put("Delay", Parameter.from(e)));
            Optional.ofNullable(source.getArrivalEventId()).ifPresent(e -> row.put("ArrivalEventID", Parameter.from(e)));
            Optional.ofNullable(source.getDepartureEventId()).ifPresent(e -> row.put("DepartureEventID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
