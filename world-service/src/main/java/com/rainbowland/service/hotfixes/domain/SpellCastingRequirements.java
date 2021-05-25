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
@Table("spell_casting_requirements")
public class SpellCastingRequirements {

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
    @Column("FacingCasterFlags")
    private Integer facingCasterFlags;
    @Column("MinFactionID")
    private Integer minFactionId;
    @Column("MinReputation")
    private Integer minReputation;
    @Column("RequiredAreasID")
    private Integer requiredAreasId;
    @Column("RequiredAuraVision")
    private Integer requiredAuraVision;
    @Column("RequiresSpellFocus")
    private Integer requiresSpellFocus;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellCastingRequirements> {

        public SpellCastingRequirements convert(Row row) {
            SpellCastingRequirements domain = new SpellCastingRequirements();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setFacingCasterFlags(row.get("FacingCasterFlags", Integer.class));
            domain.setMinFactionId(row.get("MinFactionID", Integer.class));
            domain.setMinReputation(row.get("MinReputation", Integer.class));
            domain.setRequiredAreasId(row.get("RequiredAreasID", Integer.class));
            domain.setRequiredAuraVision(row.get("RequiredAuraVision", Integer.class));
            domain.setRequiresSpellFocus(row.get("RequiresSpellFocus", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellCastingRequirements, OutboundRow> {

        public OutboundRow convert(SpellCastingRequirements source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getFacingCasterFlags()).ifPresent(e -> row.put("FacingCasterFlags", Parameter.from(e)));
            Optional.ofNullable(source.getMinFactionId()).ifPresent(e -> row.put("MinFactionID", Parameter.from(e)));
            Optional.ofNullable(source.getMinReputation()).ifPresent(e -> row.put("MinReputation", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredAreasId()).ifPresent(e -> row.put("RequiredAreasID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredAuraVision()).ifPresent(e -> row.put("RequiredAuraVision", Parameter.from(e)));
            Optional.ofNullable(source.getRequiresSpellFocus()).ifPresent(e -> row.put("RequiresSpellFocus", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
