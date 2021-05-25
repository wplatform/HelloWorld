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
@Table("unit_power_bar_locale")
public class UnitPowerBarLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Name_lang")
    private String nameLang;
    @Column("Cost_lang")
    private String costLang;
    @Column("OutOfError_lang")
    private String outOfErrorLang;
    @Column("ToolTip_lang")
    private String toolTipLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, UnitPowerBarLocale> {

        public UnitPowerBarLocale convert(Row row) {
            UnitPowerBarLocale domain = new UnitPowerBarLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setNameLang(row.get("Name_lang", String.class));
            domain.setCostLang(row.get("Cost_lang", String.class));
            domain.setOutOfErrorLang(row.get("OutOfError_lang", String.class));
            domain.setToolTipLang(row.get("ToolTip_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<UnitPowerBarLocale, OutboundRow> {

        public OutboundRow convert(UnitPowerBarLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getNameLang()).ifPresent(e -> row.put("Name_lang", Parameter.from(e)));
            Optional.ofNullable(source.getCostLang()).ifPresent(e -> row.put("Cost_lang", Parameter.from(e)));
            Optional.ofNullable(source.getOutOfErrorLang()).ifPresent(e -> row.put("OutOfError_lang", Parameter.from(e)));
            Optional.ofNullable(source.getToolTipLang()).ifPresent(e -> row.put("ToolTip_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
