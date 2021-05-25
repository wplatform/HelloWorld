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
@Table("spell_categories")
public class SpellCategories {

    @Column("ID")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("Category")
    private Integer category;
    @Column("DefenseType")
    private Integer defenseType;
    @Column("DispelType")
    private Integer dispelType;
    @Column("Mechanic")
    private Integer mechanic;
    @Column("PreventionType")
    private Integer preventionType;
    @Column("StartRecoveryCategory")
    private Integer startRecoveryCategory;
    @Column("ChargeCategory")
    private Integer chargeCategory;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellCategories> {

        public SpellCategories convert(Row row) {
            SpellCategories domain = new SpellCategories();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setCategory(row.get("Category", Integer.class));
            domain.setDefenseType(row.get("DefenseType", Integer.class));
            domain.setDispelType(row.get("DispelType", Integer.class));
            domain.setMechanic(row.get("Mechanic", Integer.class));
            domain.setPreventionType(row.get("PreventionType", Integer.class));
            domain.setStartRecoveryCategory(row.get("StartRecoveryCategory", Integer.class));
            domain.setChargeCategory(row.get("ChargeCategory", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellCategories, OutboundRow> {

        public OutboundRow convert(SpellCategories source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getCategory()).ifPresent(e -> row.put("Category", Parameter.from(e)));
            Optional.ofNullable(source.getDefenseType()).ifPresent(e -> row.put("DefenseType", Parameter.from(e)));
            Optional.ofNullable(source.getDispelType()).ifPresent(e -> row.put("DispelType", Parameter.from(e)));
            Optional.ofNullable(source.getMechanic()).ifPresent(e -> row.put("Mechanic", Parameter.from(e)));
            Optional.ofNullable(source.getPreventionType()).ifPresent(e -> row.put("PreventionType", Parameter.from(e)));
            Optional.ofNullable(source.getStartRecoveryCategory()).ifPresent(e -> row.put("StartRecoveryCategory", Parameter.from(e)));
            Optional.ofNullable(source.getChargeCategory()).ifPresent(e -> row.put("ChargeCategory", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
