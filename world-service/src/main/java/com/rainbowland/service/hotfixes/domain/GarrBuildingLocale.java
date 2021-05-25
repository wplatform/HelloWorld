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
@Table("garr_building_locale")
public class GarrBuildingLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("HordeName_lang")
    private String hordeNameLang;
    @Column("AllianceName_lang")
    private String allianceNameLang;
    @Column("Description_lang")
    private String descriptionLang;
    @Column("Tooltip_lang")
    private String tooltipLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrBuildingLocale> {

        public GarrBuildingLocale convert(Row row) {
            GarrBuildingLocale domain = new GarrBuildingLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setHordeNameLang(row.get("HordeName_lang", String.class));
            domain.setAllianceNameLang(row.get("AllianceName_lang", String.class));
            domain.setDescriptionLang(row.get("Description_lang", String.class));
            domain.setTooltipLang(row.get("Tooltip_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrBuildingLocale, OutboundRow> {

        public OutboundRow convert(GarrBuildingLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getHordeNameLang()).ifPresent(e -> row.put("HordeName_lang", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceNameLang()).ifPresent(e -> row.put("AllianceName_lang", Parameter.from(e)));
            Optional.ofNullable(source.getDescriptionLang()).ifPresent(e -> row.put("Description_lang", Parameter.from(e)));
            Optional.ofNullable(source.getTooltipLang()).ifPresent(e -> row.put("Tooltip_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
