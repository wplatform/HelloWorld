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
@Table("azerite_essence_power")
public class AzeriteEssencePower {

    @Column("ID")
    private Integer id;
    @Column("SourceAlliance")
    private String sourceAlliance;
    @Column("SourceHorde")
    private String sourceHorde;
    @Column("AzeriteEssenceID")
    private Integer azeriteEssenceId;
    @Column("Tier")
    private Integer tier;
    @Column("MajorPowerDescription")
    private Integer majorPowerDescription;
    @Column("MinorPowerDescription")
    private Integer minorPowerDescription;
    @Column("MajorPowerActual")
    private Integer majorPowerActual;
    @Column("MinorPowerActual")
    private Integer minorPowerActual;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeriteEssencePower> {

        public AzeriteEssencePower convert(Row row) {
            AzeriteEssencePower domain = new AzeriteEssencePower();
            domain.setId(row.get("ID", Integer.class));
            domain.setSourceAlliance(row.get("SourceAlliance", String.class));
            domain.setSourceHorde(row.get("SourceHorde", String.class));
            domain.setAzeriteEssenceId(row.get("AzeriteEssenceID", Integer.class));
            domain.setTier(row.get("Tier", Integer.class));
            domain.setMajorPowerDescription(row.get("MajorPowerDescription", Integer.class));
            domain.setMinorPowerDescription(row.get("MinorPowerDescription", Integer.class));
            domain.setMajorPowerActual(row.get("MajorPowerActual", Integer.class));
            domain.setMinorPowerActual(row.get("MinorPowerActual", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeriteEssencePower, OutboundRow> {

        public OutboundRow convert(AzeriteEssencePower source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSourceAlliance()).ifPresent(e -> row.put("SourceAlliance", Parameter.from(e)));
            Optional.ofNullable(source.getSourceHorde()).ifPresent(e -> row.put("SourceHorde", Parameter.from(e)));
            Optional.ofNullable(source.getAzeriteEssenceId()).ifPresent(e -> row.put("AzeriteEssenceID", Parameter.from(e)));
            Optional.ofNullable(source.getTier()).ifPresent(e -> row.put("Tier", Parameter.from(e)));
            Optional.ofNullable(source.getMajorPowerDescription()).ifPresent(e -> row.put("MajorPowerDescription", Parameter.from(e)));
            Optional.ofNullable(source.getMinorPowerDescription()).ifPresent(e -> row.put("MinorPowerDescription", Parameter.from(e)));
            Optional.ofNullable(source.getMajorPowerActual()).ifPresent(e -> row.put("MajorPowerActual", Parameter.from(e)));
            Optional.ofNullable(source.getMinorPowerActual()).ifPresent(e -> row.put("MinorPowerActual", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
