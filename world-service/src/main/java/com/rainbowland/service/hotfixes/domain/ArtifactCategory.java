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
@Table("artifact_category")
public class ArtifactCategory {

    @Column("ID")
    private Integer id;
    @Column("XpMultCurrencyID")
    private Integer xpMultCurrencyId;
    @Column("XpMultCurveID")
    private Integer xpMultCurveId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArtifactCategory> {

        public ArtifactCategory convert(Row row) {
            ArtifactCategory domain = new ArtifactCategory();
            domain.setId(row.get("ID", Integer.class));
            domain.setXpMultCurrencyId(row.get("XpMultCurrencyID", Integer.class));
            domain.setXpMultCurveId(row.get("XpMultCurveID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArtifactCategory, OutboundRow> {

        public OutboundRow convert(ArtifactCategory source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getXpMultCurrencyId()).ifPresent(e -> row.put("XpMultCurrencyID", Parameter.from(e)));
            Optional.ofNullable(source.getXpMultCurveId()).ifPresent(e -> row.put("XpMultCurveID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
