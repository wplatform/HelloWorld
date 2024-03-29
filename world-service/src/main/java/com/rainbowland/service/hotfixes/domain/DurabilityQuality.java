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
@Table("durability_quality")
public class DurabilityQuality {

    @Column("ID")
    private Integer id;
    @Column("Data")
    private Double data;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, DurabilityQuality> {

        public DurabilityQuality convert(Row row) {
            DurabilityQuality domain = new DurabilityQuality();
            domain.setId(row.get("ID", Integer.class));
            domain.setData(row.get("Data", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<DurabilityQuality, OutboundRow> {

        public OutboundRow convert(DurabilityQuality source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getData()).ifPresent(e -> row.put("Data", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
