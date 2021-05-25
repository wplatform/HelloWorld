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
@Table("spell_misc")
public class SpellMisc {

    @Column("ID")
    private Integer id;
    @Column("Attributes1")
    private Integer attributes1;
    @Column("Attributes2")
    private Integer attributes2;
    @Column("Attributes3")
    private Integer attributes3;
    @Column("Attributes4")
    private Integer attributes4;
    @Column("Attributes5")
    private Integer attributes5;
    @Column("Attributes6")
    private Integer attributes6;
    @Column("Attributes7")
    private Integer attributes7;
    @Column("Attributes8")
    private Integer attributes8;
    @Column("Attributes9")
    private Integer attributes9;
    @Column("Attributes10")
    private Integer attributes10;
    @Column("Attributes11")
    private Integer attributes11;
    @Column("Attributes12")
    private Integer attributes12;
    @Column("Attributes13")
    private Integer attributes13;
    @Column("Attributes14")
    private Integer attributes14;
    @Column("Attributes15")
    private Integer attributes15;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("CastingTimeIndex")
    private Integer castingTimeIndex;
    @Column("DurationIndex")
    private Integer durationIndex;
    @Column("RangeIndex")
    private Integer rangeIndex;
    @Column("SchoolMask")
    private Integer schoolMask;
    @Column("Speed")
    private Double speed;
    @Column("LaunchDelay")
    private Double launchDelay;
    @Column("MinDuration")
    private Double minDuration;
    @Column("SpellIconFileDataID")
    private Integer spellIconFileDataId;
    @Column("ActiveIconFileDataID")
    private Integer activeIconFileDataId;
    @Column("ContentTuningID")
    private Integer contentTuningId;
    @Column("ShowFutureSpellPlayerConditionID")
    private Integer showFutureSpellPlayerConditionId;
    @Column("SpellVisualScript")
    private Integer spellVisualScript;
    @Column("ActiveSpellVisualScript")
    private Integer activeSpellVisualScript;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellMisc> {

        public SpellMisc convert(Row row) {
            SpellMisc domain = new SpellMisc();
            domain.setId(row.get("ID", Integer.class));
            domain.setAttributes1(row.get("Attributes1", Integer.class));
            domain.setAttributes2(row.get("Attributes2", Integer.class));
            domain.setAttributes3(row.get("Attributes3", Integer.class));
            domain.setAttributes4(row.get("Attributes4", Integer.class));
            domain.setAttributes5(row.get("Attributes5", Integer.class));
            domain.setAttributes6(row.get("Attributes6", Integer.class));
            domain.setAttributes7(row.get("Attributes7", Integer.class));
            domain.setAttributes8(row.get("Attributes8", Integer.class));
            domain.setAttributes9(row.get("Attributes9", Integer.class));
            domain.setAttributes10(row.get("Attributes10", Integer.class));
            domain.setAttributes11(row.get("Attributes11", Integer.class));
            domain.setAttributes12(row.get("Attributes12", Integer.class));
            domain.setAttributes13(row.get("Attributes13", Integer.class));
            domain.setAttributes14(row.get("Attributes14", Integer.class));
            domain.setAttributes15(row.get("Attributes15", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setCastingTimeIndex(row.get("CastingTimeIndex", Integer.class));
            domain.setDurationIndex(row.get("DurationIndex", Integer.class));
            domain.setRangeIndex(row.get("RangeIndex", Integer.class));
            domain.setSchoolMask(row.get("SchoolMask", Integer.class));
            domain.setSpeed(row.get("Speed", Double.class));
            domain.setLaunchDelay(row.get("LaunchDelay", Double.class));
            domain.setMinDuration(row.get("MinDuration", Double.class));
            domain.setSpellIconFileDataId(row.get("SpellIconFileDataID", Integer.class));
            domain.setActiveIconFileDataId(row.get("ActiveIconFileDataID", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningID", Integer.class));
            domain.setShowFutureSpellPlayerConditionId(row.get("ShowFutureSpellPlayerConditionID", Integer.class));
            domain.setSpellVisualScript(row.get("SpellVisualScript", Integer.class));
            domain.setActiveSpellVisualScript(row.get("ActiveSpellVisualScript", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellMisc, OutboundRow> {

        public OutboundRow convert(SpellMisc source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes1()).ifPresent(e -> row.put("Attributes1", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes2()).ifPresent(e -> row.put("Attributes2", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes3()).ifPresent(e -> row.put("Attributes3", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes4()).ifPresent(e -> row.put("Attributes4", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes5()).ifPresent(e -> row.put("Attributes5", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes6()).ifPresent(e -> row.put("Attributes6", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes7()).ifPresent(e -> row.put("Attributes7", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes8()).ifPresent(e -> row.put("Attributes8", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes9()).ifPresent(e -> row.put("Attributes9", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes10()).ifPresent(e -> row.put("Attributes10", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes11()).ifPresent(e -> row.put("Attributes11", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes12()).ifPresent(e -> row.put("Attributes12", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes13()).ifPresent(e -> row.put("Attributes13", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes14()).ifPresent(e -> row.put("Attributes14", Parameter.from(e)));
            Optional.ofNullable(source.getAttributes15()).ifPresent(e -> row.put("Attributes15", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getCastingTimeIndex()).ifPresent(e -> row.put("CastingTimeIndex", Parameter.from(e)));
            Optional.ofNullable(source.getDurationIndex()).ifPresent(e -> row.put("DurationIndex", Parameter.from(e)));
            Optional.ofNullable(source.getRangeIndex()).ifPresent(e -> row.put("RangeIndex", Parameter.from(e)));
            Optional.ofNullable(source.getSchoolMask()).ifPresent(e -> row.put("SchoolMask", Parameter.from(e)));
            Optional.ofNullable(source.getSpeed()).ifPresent(e -> row.put("Speed", Parameter.from(e)));
            Optional.ofNullable(source.getLaunchDelay()).ifPresent(e -> row.put("LaunchDelay", Parameter.from(e)));
            Optional.ofNullable(source.getMinDuration()).ifPresent(e -> row.put("MinDuration", Parameter.from(e)));
            Optional.ofNullable(source.getSpellIconFileDataId()).ifPresent(e -> row.put("SpellIconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getActiveIconFileDataId()).ifPresent(e -> row.put("ActiveIconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningID", Parameter.from(e)));
            Optional.ofNullable(source.getShowFutureSpellPlayerConditionId()).ifPresent(e -> row.put("ShowFutureSpellPlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellVisualScript()).ifPresent(e -> row.put("SpellVisualScript", Parameter.from(e)));
            Optional.ofNullable(source.getActiveSpellVisualScript()).ifPresent(e -> row.put("ActiveSpellVisualScript", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
