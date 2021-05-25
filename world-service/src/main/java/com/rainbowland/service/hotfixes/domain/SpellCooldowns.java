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
@Table("spell_cooldowns")
public class SpellCooldowns {

    @Column("ID")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("CategoryRecoveryTime")
    private Integer categoryRecoveryTime;
    @Column("RecoveryTime")
    private Integer recoveryTime;
    @Column("StartRecoveryTime")
    private Integer startRecoveryTime;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellCooldowns> {

        public SpellCooldowns convert(Row row) {
            SpellCooldowns domain = new SpellCooldowns();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setCategoryRecoveryTime(row.get("CategoryRecoveryTime", Integer.class));
            domain.setRecoveryTime(row.get("RecoveryTime", Integer.class));
            domain.setStartRecoveryTime(row.get("StartRecoveryTime", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellCooldowns, OutboundRow> {

        public OutboundRow convert(SpellCooldowns source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryRecoveryTime()).ifPresent(e -> row.put("CategoryRecoveryTime", Parameter.from(e)));
            Optional.ofNullable(source.getRecoveryTime()).ifPresent(e -> row.put("RecoveryTime", Parameter.from(e)));
            Optional.ofNullable(source.getStartRecoveryTime()).ifPresent(e -> row.put("StartRecoveryTime", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
