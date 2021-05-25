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
@Table("spell_x_spell_visual")
public class SpellXSpellVisual {

    @Column("ID")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("SpellVisualID")
    private Integer spellVisualId;
    @Column("Probability")
    private Double probability;
    @Column("Priority")
    private Integer priority;
    @Column("SpellIconFileID")
    private Integer spellIconFileId;
    @Column("ActiveIconFileID")
    private Integer activeIconFileId;
    @Column("ViewerUnitConditionID")
    private Integer viewerUnitConditionId;
    @Column("ViewerPlayerConditionID")
    private Integer viewerPlayerConditionId;
    @Column("CasterUnitConditionID")
    private Integer casterUnitConditionId;
    @Column("CasterPlayerConditionID")
    private Integer casterPlayerConditionId;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellXSpellVisual> {

        public SpellXSpellVisual convert(Row row) {
            SpellXSpellVisual domain = new SpellXSpellVisual();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setSpellVisualId(row.get("SpellVisualID", Integer.class));
            domain.setProbability(row.get("Probability", Double.class));
            domain.setPriority(row.get("Priority", Integer.class));
            domain.setSpellIconFileId(row.get("SpellIconFileID", Integer.class));
            domain.setActiveIconFileId(row.get("ActiveIconFileID", Integer.class));
            domain.setViewerUnitConditionId(row.get("ViewerUnitConditionID", Integer.class));
            domain.setViewerPlayerConditionId(row.get("ViewerPlayerConditionID", Integer.class));
            domain.setCasterUnitConditionId(row.get("CasterUnitConditionID", Integer.class));
            domain.setCasterPlayerConditionId(row.get("CasterPlayerConditionID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellXSpellVisual, OutboundRow> {

        public OutboundRow convert(SpellXSpellVisual source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellVisualId()).ifPresent(e -> row.put("SpellVisualID", Parameter.from(e)));
            Optional.ofNullable(source.getProbability()).ifPresent(e -> row.put("Probability", Parameter.from(e)));
            Optional.ofNullable(source.getPriority()).ifPresent(e -> row.put("Priority", Parameter.from(e)));
            Optional.ofNullable(source.getSpellIconFileId()).ifPresent(e -> row.put("SpellIconFileID", Parameter.from(e)));
            Optional.ofNullable(source.getActiveIconFileId()).ifPresent(e -> row.put("ActiveIconFileID", Parameter.from(e)));
            Optional.ofNullable(source.getViewerUnitConditionId()).ifPresent(e -> row.put("ViewerUnitConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getViewerPlayerConditionId()).ifPresent(e -> row.put("ViewerPlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getCasterUnitConditionId()).ifPresent(e -> row.put("CasterUnitConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getCasterPlayerConditionId()).ifPresent(e -> row.put("CasterPlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
