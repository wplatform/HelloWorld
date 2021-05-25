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
@Table("gameobject_template_locale")
public class GameobjectTemplateLocale {

    @Column("entry")
    private Integer entry;
    @Column("locale")
    private String locale;
    @Column("name")
    private String name;
    @Column("castBarCaption")
    private String castBarCaption;
    @Column("unk1")
    private String unk1;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameobjectTemplateLocale> {

        public GameobjectTemplateLocale convert(Row row) {
            GameobjectTemplateLocale domain = new GameobjectTemplateLocale();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setName(row.get("name", String.class));
            domain.setCastBarCaption(row.get("castBarCaption", String.class));
            domain.setUnk1(row.get("unk1", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameobjectTemplateLocale, OutboundRow> {

        public OutboundRow convert(GameobjectTemplateLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getCastBarCaption()).ifPresent(e -> row.put("castBarCaption", Parameter.from(e)));
            Optional.ofNullable(source.getUnk1()).ifPresent(e -> row.put("unk1", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
