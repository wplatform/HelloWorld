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
@Table("map_locale")
public class MapLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("MapName_lang")
    private String mapNameLang;
    @Column("MapDescription0_lang")
    private String mapDescription0Lang;
    @Column("MapDescription1_lang")
    private String mapDescription1Lang;
    @Column("PvpShortDescription_lang")
    private String pvpShortDescriptionLang;
    @Column("PvpLongDescription_lang")
    private String pvpLongDescriptionLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, MapLocale> {

        public MapLocale convert(Row row) {
            MapLocale domain = new MapLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setMapNameLang(row.get("MapName_lang", String.class));
            domain.setMapDescription0Lang(row.get("MapDescription0_lang", String.class));
            domain.setMapDescription1Lang(row.get("MapDescription1_lang", String.class));
            domain.setPvpShortDescriptionLang(row.get("PvpShortDescription_lang", String.class));
            domain.setPvpLongDescriptionLang(row.get("PvpLongDescription_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<MapLocale, OutboundRow> {

        public OutboundRow convert(MapLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getMapNameLang()).ifPresent(e -> row.put("MapName_lang", Parameter.from(e)));
            Optional.ofNullable(source.getMapDescription0Lang()).ifPresent(e -> row.put("MapDescription0_lang", Parameter.from(e)));
            Optional.ofNullable(source.getMapDescription1Lang()).ifPresent(e -> row.put("MapDescription1_lang", Parameter.from(e)));
            Optional.ofNullable(source.getPvpShortDescriptionLang()).ifPresent(e -> row.put("PvpShortDescription_lang", Parameter.from(e)));
            Optional.ofNullable(source.getPvpLongDescriptionLang()).ifPresent(e -> row.put("PvpLongDescription_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
