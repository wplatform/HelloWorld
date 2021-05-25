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
@Table("points_of_interest")
public class PointsOfInterest {

    @Column("ID")
    private Integer id;
    @Column("PositionX")
    private Double positionX;
    @Column("PositionY")
    private Double positionY;
    @Column("Icon")
    private Integer icon;
    @Column("Flags")
    private Integer flags;
    @Column("Importance")
    private Integer importance;
    @Column("Name")
    private String name;
    @Column("Unknown905")
    private Integer unknown905;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PointsOfInterest> {

        public PointsOfInterest convert(Row row) {
            PointsOfInterest domain = new PointsOfInterest();
            domain.setId(row.get("ID", Integer.class));
            domain.setPositionX(row.get("PositionX", Double.class));
            domain.setPositionY(row.get("PositionY", Double.class));
            domain.setIcon(row.get("Icon", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setImportance(row.get("Importance", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setUnknown905(row.get("Unknown905", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PointsOfInterest, OutboundRow> {

        public OutboundRow convert(PointsOfInterest source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("PositionX", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("PositionY", Parameter.from(e)));
            Optional.ofNullable(source.getIcon()).ifPresent(e -> row.put("Icon", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getImportance()).ifPresent(e -> row.put("Importance", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getUnknown905()).ifPresent(e -> row.put("Unknown905", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
