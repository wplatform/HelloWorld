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
@Table("pvp_talent")
public class PvpTalent {

    @Column("Description")
    private String description;
    @Column("ID")
    private Integer id;
    @Column("SpecID")
    private Integer specId;
    @Column("SpellID")
    private Integer spellId;
    @Column("OverridesSpellID")
    private Integer overridesSpellId;
    @Column("Flags")
    private Integer flags;
    @Column("ActionBarSpellID")
    private Integer actionBarSpellId;
    @Column("PvpTalentCategoryID")
    private Integer pvpTalentCategoryId;
    @Column("LevelRequired")
    private Integer levelRequired;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PvpTalent> {

        public PvpTalent convert(Row row) {
            PvpTalent domain = new PvpTalent();
            domain.setDescription(row.get("Description", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setSpecId(row.get("SpecID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setOverridesSpellId(row.get("OverridesSpellID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setActionBarSpellId(row.get("ActionBarSpellID", Integer.class));
            domain.setPvpTalentCategoryId(row.get("PvpTalentCategoryID", Integer.class));
            domain.setLevelRequired(row.get("LevelRequired", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PvpTalent, OutboundRow> {

        public OutboundRow convert(PvpTalent source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpecId()).ifPresent(e -> row.put("SpecID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getOverridesSpellId()).ifPresent(e -> row.put("OverridesSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getActionBarSpellId()).ifPresent(e -> row.put("ActionBarSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getPvpTalentCategoryId()).ifPresent(e -> row.put("PvpTalentCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getLevelRequired()).ifPresent(e -> row.put("LevelRequired", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
