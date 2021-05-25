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
@Table("item_sparse_locale")
public class ItemSparseLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Description_lang")
    private String descriptionLang;
    @Column("Display3_lang")
    private String display3Lang;
    @Column("Display2_lang")
    private String display2Lang;
    @Column("Display1_lang")
    private String display1Lang;
    @Column("Display_lang")
    private String displayLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemSparseLocale> {

        public ItemSparseLocale convert(Row row) {
            ItemSparseLocale domain = new ItemSparseLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setDescriptionLang(row.get("Description_lang", String.class));
            domain.setDisplay3Lang(row.get("Display3_lang", String.class));
            domain.setDisplay2Lang(row.get("Display2_lang", String.class));
            domain.setDisplay1Lang(row.get("Display1_lang", String.class));
            domain.setDisplayLang(row.get("Display_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemSparseLocale, OutboundRow> {

        public OutboundRow convert(ItemSparseLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getDescriptionLang()).ifPresent(e -> row.put("Description_lang", Parameter.from(e)));
            Optional.ofNullable(source.getDisplay3Lang()).ifPresent(e -> row.put("Display3_lang", Parameter.from(e)));
            Optional.ofNullable(source.getDisplay2Lang()).ifPresent(e -> row.put("Display2_lang", Parameter.from(e)));
            Optional.ofNullable(source.getDisplay1Lang()).ifPresent(e -> row.put("Display1_lang", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayLang()).ifPresent(e -> row.put("Display_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
