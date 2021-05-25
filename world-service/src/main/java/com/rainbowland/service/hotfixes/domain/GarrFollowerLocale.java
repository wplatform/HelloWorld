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
@Table("garr_follower_locale")
public class GarrFollowerLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("HordeSourceText_lang")
    private String hordeSourceTextLang;
    @Column("AllianceSourceText_lang")
    private String allianceSourceTextLang;
    @Column("TitleName_lang")
    private String titleNameLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrFollowerLocale> {

        public GarrFollowerLocale convert(Row row) {
            GarrFollowerLocale domain = new GarrFollowerLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setHordeSourceTextLang(row.get("HordeSourceText_lang", String.class));
            domain.setAllianceSourceTextLang(row.get("AllianceSourceText_lang", String.class));
            domain.setTitleNameLang(row.get("TitleName_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrFollowerLocale, OutboundRow> {

        public OutboundRow convert(GarrFollowerLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getHordeSourceTextLang()).ifPresent(e -> row.put("HordeSourceText_lang", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceSourceTextLang()).ifPresent(e -> row.put("AllianceSourceText_lang", Parameter.from(e)));
            Optional.ofNullable(source.getTitleNameLang()).ifPresent(e -> row.put("TitleName_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
