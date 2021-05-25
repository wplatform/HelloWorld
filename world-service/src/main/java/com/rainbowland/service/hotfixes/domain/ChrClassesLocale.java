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
@Table("chr_classes_locale")
public class ChrClassesLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Name_lang")
    private String nameLang;
    @Column("NameMale_lang")
    private String nameMaleLang;
    @Column("NameFemale_lang")
    private String nameFemaleLang;
    @Column("Description_lang")
    private String descriptionLang;
    @Column("RoleInfoString_lang")
    private String roleInfoStringLang;
    @Column("DisabledString_lang")
    private String disabledStringLang;
    @Column("HyphenatedNameMale_lang")
    private String hyphenatedNameMaleLang;
    @Column("HyphenatedNameFemale_lang")
    private String hyphenatedNameFemaleLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrClassesLocale> {

        public ChrClassesLocale convert(Row row) {
            ChrClassesLocale domain = new ChrClassesLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setNameLang(row.get("Name_lang", String.class));
            domain.setNameMaleLang(row.get("NameMale_lang", String.class));
            domain.setNameFemaleLang(row.get("NameFemale_lang", String.class));
            domain.setDescriptionLang(row.get("Description_lang", String.class));
            domain.setRoleInfoStringLang(row.get("RoleInfoString_lang", String.class));
            domain.setDisabledStringLang(row.get("DisabledString_lang", String.class));
            domain.setHyphenatedNameMaleLang(row.get("HyphenatedNameMale_lang", String.class));
            domain.setHyphenatedNameFemaleLang(row.get("HyphenatedNameFemale_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrClassesLocale, OutboundRow> {

        public OutboundRow convert(ChrClassesLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getNameLang()).ifPresent(e -> row.put("Name_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameMaleLang()).ifPresent(e -> row.put("NameMale_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleLang()).ifPresent(e -> row.put("NameFemale_lang", Parameter.from(e)));
            Optional.ofNullable(source.getDescriptionLang()).ifPresent(e -> row.put("Description_lang", Parameter.from(e)));
            Optional.ofNullable(source.getRoleInfoStringLang()).ifPresent(e -> row.put("RoleInfoString_lang", Parameter.from(e)));
            Optional.ofNullable(source.getDisabledStringLang()).ifPresent(e -> row.put("DisabledString_lang", Parameter.from(e)));
            Optional.ofNullable(source.getHyphenatedNameMaleLang()).ifPresent(e -> row.put("HyphenatedNameMale_lang", Parameter.from(e)));
            Optional.ofNullable(source.getHyphenatedNameFemaleLang()).ifPresent(e -> row.put("HyphenatedNameFemale_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
