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
@Table("battle_pet_species_locale")
public class BattlePetSpeciesLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("Description_lang")
    private String descriptionLang;
    @Column("SourceText_lang")
    private String sourceTextLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlePetSpeciesLocale> {

        public BattlePetSpeciesLocale convert(Row row) {
            BattlePetSpeciesLocale domain = new BattlePetSpeciesLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setDescriptionLang(row.get("Description_lang", String.class));
            domain.setSourceTextLang(row.get("SourceText_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlePetSpeciesLocale, OutboundRow> {

        public OutboundRow convert(BattlePetSpeciesLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getDescriptionLang()).ifPresent(e -> row.put("Description_lang", Parameter.from(e)));
            Optional.ofNullable(source.getSourceTextLang()).ifPresent(e -> row.put("SourceText_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
