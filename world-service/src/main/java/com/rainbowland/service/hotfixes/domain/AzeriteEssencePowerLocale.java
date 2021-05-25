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
@Table("azerite_essence_power_locale")
public class AzeriteEssencePowerLocale {

    @Column("ID")
    private Integer id;
    @Column("locale")
    private String locale;
    @Column("SourceAlliance_lang")
    private String sourceAllianceLang;
    @Column("SourceHorde_lang")
    private String sourceHordeLang;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeriteEssencePowerLocale> {

        public AzeriteEssencePowerLocale convert(Row row) {
            AzeriteEssencePowerLocale domain = new AzeriteEssencePowerLocale();
            domain.setId(row.get("ID", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setSourceAllianceLang(row.get("SourceAlliance_lang", String.class));
            domain.setSourceHordeLang(row.get("SourceHorde_lang", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeriteEssencePowerLocale, OutboundRow> {

        public OutboundRow convert(AzeriteEssencePowerLocale source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getSourceAllianceLang()).ifPresent(e -> row.put("SourceAlliance_lang", Parameter.from(e)));
            Optional.ofNullable(source.getSourceHordeLang()).ifPresent(e -> row.put("SourceHorde_lang", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
