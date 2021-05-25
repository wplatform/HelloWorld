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
@Table("chr_class_ui_display")
public class ChrClassUiDisplay {

    @Column("ID")
    private Integer id;
    @Column("ChrClassesID")
    private Integer chrClassesId;
    @Column("AdvGuidePlayerConditionID")
    private Integer advGuidePlayerConditionId;
    @Column("SplashPlayerConditionID")
    private Integer splashPlayerConditionId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrClassUiDisplay> {

        public ChrClassUiDisplay convert(Row row) {
            ChrClassUiDisplay domain = new ChrClassUiDisplay();
            domain.setId(row.get("ID", Integer.class));
            domain.setChrClassesId(row.get("ChrClassesID", Integer.class));
            domain.setAdvGuidePlayerConditionId(row.get("AdvGuidePlayerConditionID", Integer.class));
            domain.setSplashPlayerConditionId(row.get("SplashPlayerConditionID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrClassUiDisplay, OutboundRow> {

        public OutboundRow convert(ChrClassUiDisplay source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getChrClassesId()).ifPresent(e -> row.put("ChrClassesID", Parameter.from(e)));
            Optional.ofNullable(source.getAdvGuidePlayerConditionId()).ifPresent(e -> row.put("AdvGuidePlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getSplashPlayerConditionId()).ifPresent(e -> row.put("SplashPlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
