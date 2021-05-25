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
@Table("corruption_effects")
public class CorruptionEffects {

    @Column("ID")
    private Integer id;
    @Column("MinCorruption")
    private Double minCorruption;
    @Column("Aura")
    private Integer aura;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CorruptionEffects> {

        public CorruptionEffects convert(Row row) {
            CorruptionEffects domain = new CorruptionEffects();
            domain.setId(row.get("ID", Integer.class));
            domain.setMinCorruption(row.get("MinCorruption", Double.class));
            domain.setAura(row.get("Aura", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CorruptionEffects, OutboundRow> {

        public OutboundRow convert(CorruptionEffects source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMinCorruption()).ifPresent(e -> row.put("MinCorruption", Parameter.from(e)));
            Optional.ofNullable(source.getAura()).ifPresent(e -> row.put("Aura", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
