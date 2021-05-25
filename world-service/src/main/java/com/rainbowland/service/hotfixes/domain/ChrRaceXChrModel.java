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
@Table("chr_race_x_chr_model")
public class ChrRaceXChrModel {

    @Column("ID")
    private Integer id;
    @Column("ChrRacesID")
    private Integer chrRacesId;
    @Column("ChrModelID")
    private Integer chrModelId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrRaceXChrModel> {

        public ChrRaceXChrModel convert(Row row) {
            ChrRaceXChrModel domain = new ChrRaceXChrModel();
            domain.setId(row.get("ID", Integer.class));
            domain.setChrRacesId(row.get("ChrRacesID", Integer.class));
            domain.setChrModelId(row.get("ChrModelID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrRaceXChrModel, OutboundRow> {

        public OutboundRow convert(ChrRaceXChrModel source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getChrRacesId()).ifPresent(e -> row.put("ChrRacesID", Parameter.from(e)));
            Optional.ofNullable(source.getChrModelId()).ifPresent(e -> row.put("ChrModelID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
