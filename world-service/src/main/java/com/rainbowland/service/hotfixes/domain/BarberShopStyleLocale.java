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
@Table("barber_shop_style_locale")
public class BarberShopStyleLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("DisplayName_lang")
    private String displayNameLang;
    @Column("Description_lang")
    private String descriptionLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BarberShopStyleLocale> {

        public BarberShopStyleLocale convert(Row row) {
            BarberShopStyleLocale domain = new BarberShopStyleLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setDisplayNameLang(row.get("DisplayName_lang", String.class));
            domain.setDescriptionLang(row.get("Description_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BarberShopStyleLocale, OutboundRow> {

        public OutboundRow convert(BarberShopStyleLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayNameLang()).ifPresent(e -> row.put("DisplayName_lang", Parameter.from(e)));
            Optional.ofNullable(source.getDescriptionLang()).ifPresent(e -> row.put("Description_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
