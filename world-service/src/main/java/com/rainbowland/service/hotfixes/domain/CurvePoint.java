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
@Table("curve_point")
public class CurvePoint {

    @Column("ID")
    private Integer id;
    @Column("PosX")
    private Double posX;
    @Column("PosY")
    private Double posY;
    @Column("PosPreSquishX")
    private Double posPreSquishX;
    @Column("PosPreSquishY")
    private Double posPreSquishY;
    @Column("CurveID")
    private Integer curveId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CurvePoint> {

        public CurvePoint convert(Row row) {
            CurvePoint domain = new CurvePoint();
            domain.setId(row.get("ID", Integer.class));
            domain.setPosX(row.get("PosX", Double.class));
            domain.setPosY(row.get("PosY", Double.class));
            domain.setPosPreSquishX(row.get("PosPreSquishX", Double.class));
            domain.setPosPreSquishY(row.get("PosPreSquishY", Double.class));
            domain.setCurveId(row.get("CurveID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CurvePoint, OutboundRow> {

        public OutboundRow convert(CurvePoint source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPosX()).ifPresent(e -> row.put("PosX", Parameter.from(e)));
            Optional.ofNullable(source.getPosY()).ifPresent(e -> row.put("PosY", Parameter.from(e)));
            Optional.ofNullable(source.getPosPreSquishX()).ifPresent(e -> row.put("PosPreSquishX", Parameter.from(e)));
            Optional.ofNullable(source.getPosPreSquishY()).ifPresent(e -> row.put("PosPreSquishY", Parameter.from(e)));
            Optional.ofNullable(source.getCurveId()).ifPresent(e -> row.put("CurveID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
