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
@Table("chr_customization_req_choice")
public class ChrCustomizationReqChoice {

    @Column("ID")
    private Integer id;
    @Column("ChrCustomizationChoiceID")
    private Integer chrCustomizationChoiceId;
    @Column("ChrCustomizationReqID")
    private Integer chrCustomizationReqId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrCustomizationReqChoice> {

        public ChrCustomizationReqChoice convert(Row row) {
            ChrCustomizationReqChoice domain = new ChrCustomizationReqChoice();
            domain.setId(row.get("ID", Integer.class));
            domain.setChrCustomizationChoiceId(row.get("ChrCustomizationChoiceID", Integer.class));
            domain.setChrCustomizationReqId(row.get("ChrCustomizationReqID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrCustomizationReqChoice, OutboundRow> {

        public OutboundRow convert(ChrCustomizationReqChoice source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationChoiceId()).ifPresent(e -> row.put("ChrCustomizationChoiceID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationReqId()).ifPresent(e -> row.put("ChrCustomizationReqID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
