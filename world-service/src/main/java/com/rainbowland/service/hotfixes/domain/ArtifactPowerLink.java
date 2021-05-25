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
@Table("artifact_power_link")
public class ArtifactPowerLink {

    @Column("ID")
    private Integer id;
    @Column("PowerA")
    private Integer powerA;
    @Column("PowerB")
    private Integer powerB;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArtifactPowerLink> {

        public ArtifactPowerLink convert(Row row) {
            ArtifactPowerLink domain = new ArtifactPowerLink();
            domain.setId(row.get("ID", Integer.class));
            domain.setPowerA(row.get("PowerA", Integer.class));
            domain.setPowerB(row.get("PowerB", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArtifactPowerLink, OutboundRow> {

        public OutboundRow convert(ArtifactPowerLink source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPowerA()).ifPresent(e -> row.put("PowerA", Parameter.from(e)));
            Optional.ofNullable(source.getPowerB()).ifPresent(e -> row.put("PowerB", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
