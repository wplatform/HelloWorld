package com.rainbowland.service.world.domain;

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
@Table("creature_template_locale")
public class CreatureTemplateLocale {

    @Column("entry")
    private Integer entry;
    @Column("locale")
    private String locale;
    @Column("Name")
    private String name;
    @Column("NameAlt")
    private String nameAlt;
    @Column("Title")
    private String title;
    @Column("TitleAlt")
    private String titleAlt;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureTemplateLocale> {

        public CreatureTemplateLocale convert(Row row) {
            CreatureTemplateLocale domain = new CreatureTemplateLocale();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setName(row.get("Name", String.class));
            domain.setNameAlt(row.get("NameAlt", String.class));
            domain.setTitle(row.get("Title", String.class));
            domain.setTitleAlt(row.get("TitleAlt", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureTemplateLocale, OutboundRow> {

        public OutboundRow convert(CreatureTemplateLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getNameAlt()).ifPresent(e -> row.put("NameAlt", Parameter.from(e)));
            Optional.ofNullable(source.getTitle()).ifPresent(e -> row.put("Title", Parameter.from(e)));
            Optional.ofNullable(source.getTitleAlt()).ifPresent(e -> row.put("TitleAlt", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
