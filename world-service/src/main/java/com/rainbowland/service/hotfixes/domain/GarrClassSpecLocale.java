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
@Table("garr_class_spec_locale")
public class GarrClassSpecLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("ClassSpec_lang")
    private String classSpecLang;
    @Column("ClassSpecMale_lang")
    private String classSpecMaleLang;
    @Column("ClassSpecFemale_lang")
    private String classSpecFemaleLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrClassSpecLocale> {

        public GarrClassSpecLocale convert(Row row) {
            GarrClassSpecLocale domain = new GarrClassSpecLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setClassSpecLang(row.get("ClassSpec_lang", String.class));
            domain.setClassSpecMaleLang(row.get("ClassSpecMale_lang", String.class));
            domain.setClassSpecFemaleLang(row.get("ClassSpecFemale_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrClassSpecLocale, OutboundRow> {

        public OutboundRow convert(GarrClassSpecLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getClassSpecLang()).ifPresent(e -> row.put("ClassSpec_lang", Parameter.from(e)));
            Optional.ofNullable(source.getClassSpecMaleLang()).ifPresent(e -> row.put("ClassSpecMale_lang", Parameter.from(e)));
            Optional.ofNullable(source.getClassSpecFemaleLang()).ifPresent(e -> row.put("ClassSpecFemale_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
