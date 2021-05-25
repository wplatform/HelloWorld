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
@Table("spell_levels")
public class SpellLevels {

    @Column("ID")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("MaxLevel")
    private Integer maxLevel;
    @Column("MaxPassiveAuraLevel")
    private Integer maxPassiveAuraLevel;
    @Column("BaseLevel")
    private Integer baseLevel;
    @Column("SpellLevel")
    private Integer spellLevel;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellLevels> {

        public SpellLevels convert(Row row) {
            SpellLevels domain = new SpellLevels();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setMaxLevel(row.get("MaxLevel", Integer.class));
            domain.setMaxPassiveAuraLevel(row.get("MaxPassiveAuraLevel", Integer.class));
            domain.setBaseLevel(row.get("BaseLevel", Integer.class));
            domain.setSpellLevel(row.get("SpellLevel", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellLevels, OutboundRow> {

        public OutboundRow convert(SpellLevels source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("MaxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxPassiveAuraLevel()).ifPresent(e -> row.put("MaxPassiveAuraLevel", Parameter.from(e)));
            Optional.ofNullable(source.getBaseLevel()).ifPresent(e -> row.put("BaseLevel", Parameter.from(e)));
            Optional.ofNullable(source.getSpellLevel()).ifPresent(e -> row.put("SpellLevel", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
