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
@Table("battlemaster_list_locale")
public class BattlemasterListLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Name_lang")
    private String nameLang;
    @Column("GameType_lang")
    private String gameTypeLang;
    @Column("ShortDescription_lang")
    private String shortDescriptionLang;
    @Column("LongDescription_lang")
    private String longDescriptionLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlemasterListLocale> {

        public BattlemasterListLocale convert(Row row) {
            BattlemasterListLocale domain = new BattlemasterListLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setNameLang(row.get("Name_lang", String.class));
            domain.setGameTypeLang(row.get("GameType_lang", String.class));
            domain.setShortDescriptionLang(row.get("ShortDescription_lang", String.class));
            domain.setLongDescriptionLang(row.get("LongDescription_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlemasterListLocale, OutboundRow> {

        public OutboundRow convert(BattlemasterListLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getNameLang()).ifPresent(e -> row.put("Name_lang", Parameter.from(e)));
            Optional.ofNullable(source.getGameTypeLang()).ifPresent(e -> row.put("GameType_lang", Parameter.from(e)));
            Optional.ofNullable(source.getShortDescriptionLang()).ifPresent(e -> row.put("ShortDescription_lang", Parameter.from(e)));
            Optional.ofNullable(source.getLongDescriptionLang()).ifPresent(e -> row.put("LongDescription_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
