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
@Table("taxi_path")
public class TaxiPath {

    @Column("ID")
    private Integer id;
    @Column("FromTaxiNode")
    private Integer fromTaxiNode;
    @Column("ToTaxiNode")
    private Integer toTaxiNode;
    @Column("Cost")
    private Integer cost;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TaxiPath> {

        public TaxiPath convert(Row row) {
            TaxiPath domain = new TaxiPath();
            domain.setId(row.get("ID", Integer.class));
            domain.setFromTaxiNode(row.get("FromTaxiNode", Integer.class));
            domain.setToTaxiNode(row.get("ToTaxiNode", Integer.class));
            domain.setCost(row.get("Cost", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TaxiPath, OutboundRow> {

        public OutboundRow convert(TaxiPath source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFromTaxiNode()).ifPresent(e -> row.put("FromTaxiNode", Parameter.from(e)));
            Optional.ofNullable(source.getToTaxiNode()).ifPresent(e -> row.put("ToTaxiNode", Parameter.from(e)));
            Optional.ofNullable(source.getCost()).ifPresent(e -> row.put("Cost", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
