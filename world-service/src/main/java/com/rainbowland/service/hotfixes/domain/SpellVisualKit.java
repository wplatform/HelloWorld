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
@Table("spell_visual_kit")
public class SpellVisualKit {

    @Column("ID")
    private Integer id;
    @Column("FallbackPriority")
    private Integer fallbackPriority;
    @Column("FallbackSpellVisualKitId")
    private Integer fallbackSpellVisualKitId;
    @Column("DelayMin")
    private Integer delayMin;
    @Column("DelayMax")
    private Integer delayMax;
    @Column("Flags1")
    private Integer flags1;
    @Column("Flags2")
    private Integer flags2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellVisualKit> {

        public SpellVisualKit convert(Row row) {
            SpellVisualKit domain = new SpellVisualKit();
            domain.setId(row.get("ID", Integer.class));
            domain.setFallbackPriority(row.get("FallbackPriority", Integer.class));
            domain.setFallbackSpellVisualKitId(row.get("FallbackSpellVisualKitId", Integer.class));
            domain.setDelayMin(row.get("DelayMin", Integer.class));
            domain.setDelayMax(row.get("DelayMax", Integer.class));
            domain.setFlags1(row.get("Flags1", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellVisualKit, OutboundRow> {

        public OutboundRow convert(SpellVisualKit source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFallbackPriority()).ifPresent(e -> row.put("FallbackPriority", Parameter.from(e)));
            Optional.ofNullable(source.getFallbackSpellVisualKitId()).ifPresent(e -> row.put("FallbackSpellVisualKitId", Parameter.from(e)));
            Optional.ofNullable(source.getDelayMin()).ifPresent(e -> row.put("DelayMin", Parameter.from(e)));
            Optional.ofNullable(source.getDelayMax()).ifPresent(e -> row.put("DelayMax", Parameter.from(e)));
            Optional.ofNullable(source.getFlags1()).ifPresent(e -> row.put("Flags1", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
