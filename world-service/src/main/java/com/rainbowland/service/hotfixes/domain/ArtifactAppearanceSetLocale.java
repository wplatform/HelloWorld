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
@Table("artifact_appearance_set_locale")
public class ArtifactAppearanceSetLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Name_lang")
    private String nameLang;
    @Column("Description_lang")
    private String descriptionLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArtifactAppearanceSetLocale> {

        public ArtifactAppearanceSetLocale convert(Row row) {
            ArtifactAppearanceSetLocale domain = new ArtifactAppearanceSetLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setNameLang(row.get("Name_lang", String.class));
            domain.setDescriptionLang(row.get("Description_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArtifactAppearanceSetLocale, OutboundRow> {

        public OutboundRow convert(ArtifactAppearanceSetLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getNameLang()).ifPresent(e -> row.put("Name_lang", Parameter.from(e)));
            Optional.ofNullable(source.getDescriptionLang()).ifPresent(e -> row.put("Description_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
