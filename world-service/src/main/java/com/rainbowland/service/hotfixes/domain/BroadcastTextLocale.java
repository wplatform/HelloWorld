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
@Table("broadcast_text_locale")
public class BroadcastTextLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Text_lang")
    private String textLang;
    @Column("Text1_lang")
    private String text1Lang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BroadcastTextLocale> {

        public BroadcastTextLocale convert(Row row) {
            BroadcastTextLocale domain = new BroadcastTextLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setTextLang(row.get("Text_lang", String.class));
            domain.setText1Lang(row.get("Text1_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BroadcastTextLocale, OutboundRow> {

        public OutboundRow convert(BroadcastTextLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getTextLang()).ifPresent(e -> row.put("Text_lang", Parameter.from(e)));
            Optional.ofNullable(source.getText1Lang()).ifPresent(e -> row.put("Text1_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
