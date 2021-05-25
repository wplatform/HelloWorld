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
@Table("chr_races_locale")
public class ChrRacesLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Name_lang")
    private String nameLang;
    @Column("NameFemale_lang")
    private String nameFemaleLang;
    @Column("NameLowercase_lang")
    private String nameLowercaseLang;
    @Column("NameFemaleLowercase_lang")
    private String nameFemaleLowercaseLang;
    @Column("NameS_lang")
    private String nameSLang;
    @Column("NameFemaleS_lang")
    private String nameFemaleSLang;
    @Column("NameLowercaseS_lang")
    private String nameLowercaseSLang;
    @Column("NameFemaleLowercaseS_lang")
    private String nameFemaleLowercaseSLang;
    @Column("RaceFantasyDescription_lang")
    private String raceFantasyDescriptionLang;
    @Column("NameL_lang")
    private String nameLLang;
    @Column("NameFemaleL_lang")
    private String nameFemaleLLang;
    @Column("NameLowercaseL_lang")
    private String nameLowercaseLLang;
    @Column("NameFemaleLowercaseL_lang")
    private String nameFemaleLowercaseLLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrRacesLocale> {

        public ChrRacesLocale convert(Row row) {
            ChrRacesLocale domain = new ChrRacesLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setNameLang(row.get("Name_lang", String.class));
            domain.setNameFemaleLang(row.get("NameFemale_lang", String.class));
            domain.setNameLowercaseLang(row.get("NameLowercase_lang", String.class));
            domain.setNameFemaleLowercaseLang(row.get("NameFemaleLowercase_lang", String.class));
            domain.setNameSLang(row.get("NameS_lang", String.class));
            domain.setNameFemaleSLang(row.get("NameFemaleS_lang", String.class));
            domain.setNameLowercaseSLang(row.get("NameLowercaseS_lang", String.class));
            domain.setNameFemaleLowercaseSLang(row.get("NameFemaleLowercaseS_lang", String.class));
            domain.setRaceFantasyDescriptionLang(row.get("RaceFantasyDescription_lang", String.class));
            domain.setNameLLang(row.get("NameL_lang", String.class));
            domain.setNameFemaleLLang(row.get("NameFemaleL_lang", String.class));
            domain.setNameLowercaseLLang(row.get("NameLowercaseL_lang", String.class));
            domain.setNameFemaleLowercaseLLang(row.get("NameFemaleLowercaseL_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrRacesLocale, OutboundRow> {

        public OutboundRow convert(ChrRacesLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getNameLang()).ifPresent(e -> row.put("Name_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleLang()).ifPresent(e -> row.put("NameFemale_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameLowercaseLang()).ifPresent(e -> row.put("NameLowercase_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleLowercaseLang()).ifPresent(e -> row.put("NameFemaleLowercase_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameSLang()).ifPresent(e -> row.put("NameS_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleSLang()).ifPresent(e -> row.put("NameFemaleS_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameLowercaseSLang()).ifPresent(e -> row.put("NameLowercaseS_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleLowercaseSLang()).ifPresent(e -> row.put("NameFemaleLowercaseS_lang", Parameter.from(e)));
            Optional.ofNullable(source.getRaceFantasyDescriptionLang()).ifPresent(e -> row.put("RaceFantasyDescription_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameLLang()).ifPresent(e -> row.put("NameL_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleLLang()).ifPresent(e -> row.put("NameFemaleL_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameLowercaseLLang()).ifPresent(e -> row.put("NameLowercaseL_lang", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleLowercaseLLang()).ifPresent(e -> row.put("NameFemaleLowercaseL_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
