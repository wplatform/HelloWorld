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
@Table("item_class_locale")
public class ItemClassLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("ClassName_lang")
    private String classNameLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemClassLocale> {

        public ItemClassLocale convert(Row row) {
            ItemClassLocale domain = new ItemClassLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setClassNameLang(row.get("ClassName_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemClassLocale, OutboundRow> {

        public OutboundRow convert(ItemClassLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getClassNameLang()).ifPresent(e -> row.put("ClassName_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
