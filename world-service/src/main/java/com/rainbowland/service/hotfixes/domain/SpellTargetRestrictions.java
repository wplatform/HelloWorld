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
@Table("spell_target_restrictions")
public class SpellTargetRestrictions {

    @Column("ID")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("ConeDegrees")
    private Double coneDegrees;
    @Column("MaxTargets")
    private Integer maxTargets;
    @Column("MaxTargetLevel")
    private Integer maxTargetLevel;
    @Column("TargetCreatureType")
    private Integer targetCreatureType;
    @Column("Targets")
    private Integer targets;
    @Column("Width")
    private Double width;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellTargetRestrictions> {

        public SpellTargetRestrictions convert(Row row) {
            SpellTargetRestrictions domain = new SpellTargetRestrictions();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setConeDegrees(row.get("ConeDegrees", Double.class));
            domain.setMaxTargets(row.get("MaxTargets", Integer.class));
            domain.setMaxTargetLevel(row.get("MaxTargetLevel", Integer.class));
            domain.setTargetCreatureType(row.get("TargetCreatureType", Integer.class));
            domain.setTargets(row.get("Targets", Integer.class));
            domain.setWidth(row.get("Width", Double.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellTargetRestrictions, OutboundRow> {

        public OutboundRow convert(SpellTargetRestrictions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getConeDegrees()).ifPresent(e -> row.put("ConeDegrees", Parameter.from(e)));
            Optional.ofNullable(source.getMaxTargets()).ifPresent(e -> row.put("MaxTargets", Parameter.from(e)));
            Optional.ofNullable(source.getMaxTargetLevel()).ifPresent(e -> row.put("MaxTargetLevel", Parameter.from(e)));
            Optional.ofNullable(source.getTargetCreatureType()).ifPresent(e -> row.put("TargetCreatureType", Parameter.from(e)));
            Optional.ofNullable(source.getTargets()).ifPresent(e -> row.put("Targets", Parameter.from(e)));
            Optional.ofNullable(source.getWidth()).ifPresent(e -> row.put("Width", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
