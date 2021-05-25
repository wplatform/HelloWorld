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
@Table("skill_line")
public class SkillLine {

    @Column("DisplayName")
    private String displayName;
    @Column("AlternateVerb")
    private String alternateVerb;
    @Column("Description")
    private String description;
    @Column("HordeDisplayName")
    private String hordeDisplayName;
    @Column("OverrideSourceInfoDisplayName")
    private String overrideSourceInfoDisplayName;
    @Column("ID")
    private Integer id;
    @Column("CategoryID")
    private Integer categoryId;
    @Column("SpellIconFileID")
    private Integer spellIconFileId;
    @Column("CanLink")
    private Integer canLink;
    @Column("ParentSkillLineID")
    private Integer parentSkillLineId;
    @Column("ParentTierIndex")
    private Integer parentTierIndex;
    @Column("Flags")
    private Integer flags;
    @Column("SpellBookSpellID")
    private Integer spellBookSpellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SkillLine> {

        public SkillLine convert(Row row) {
            SkillLine domain = new SkillLine();
            domain.setDisplayName(row.get("DisplayName", String.class));
            domain.setAlternateVerb(row.get("AlternateVerb", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setHordeDisplayName(row.get("HordeDisplayName", String.class));
            domain.setOverrideSourceInfoDisplayName(row.get("OverrideSourceInfoDisplayName", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setCategoryId(row.get("CategoryID", Integer.class));
            domain.setSpellIconFileId(row.get("SpellIconFileID", Integer.class));
            domain.setCanLink(row.get("CanLink", Integer.class));
            domain.setParentSkillLineId(row.get("ParentSkillLineID", Integer.class));
            domain.setParentTierIndex(row.get("ParentTierIndex", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSpellBookSpellId(row.get("SpellBookSpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SkillLine, OutboundRow> {

        public OutboundRow convert(SkillLine source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDisplayName()).ifPresent(e -> row.put("DisplayName", Parameter.from(e)));
            Optional.ofNullable(source.getAlternateVerb()).ifPresent(e -> row.put("AlternateVerb", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getHordeDisplayName()).ifPresent(e -> row.put("HordeDisplayName", Parameter.from(e)));
            Optional.ofNullable(source.getOverrideSourceInfoDisplayName()).ifPresent(e -> row.put("OverrideSourceInfoDisplayName", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryId()).ifPresent(e -> row.put("CategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellIconFileId()).ifPresent(e -> row.put("SpellIconFileID", Parameter.from(e)));
            Optional.ofNullable(source.getCanLink()).ifPresent(e -> row.put("CanLink", Parameter.from(e)));
            Optional.ofNullable(source.getParentSkillLineId()).ifPresent(e -> row.put("ParentSkillLineID", Parameter.from(e)));
            Optional.ofNullable(source.getParentTierIndex()).ifPresent(e -> row.put("ParentTierIndex", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSpellBookSpellId()).ifPresent(e -> row.put("SpellBookSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
