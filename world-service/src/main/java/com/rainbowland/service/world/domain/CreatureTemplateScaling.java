package com.rainbowland.service.world.domain;

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
@Table("creature_template_scaling")
public class CreatureTemplateScaling {

    @Column("Entry")
    private Integer entry;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("LevelScalingMin")
    private Integer levelScalingMin;
    @Column("LevelScalingMax")
    private Integer levelScalingMax;
    @Column("LevelScalingDeltaMin")
    private Integer levelScalingDeltaMin;
    @Column("LevelScalingDeltaMax")
    private Integer levelScalingDeltaMax;
    @Column("ContentTuningID")
    private Integer contentTuningId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureTemplateScaling> {

        public CreatureTemplateScaling convert(Row row) {
            CreatureTemplateScaling domain = new CreatureTemplateScaling();
            domain.setEntry(row.get("Entry", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setLevelScalingMin(row.get("LevelScalingMin", Integer.class));
            domain.setLevelScalingMax(row.get("LevelScalingMax", Integer.class));
            domain.setLevelScalingDeltaMin(row.get("LevelScalingDeltaMin", Integer.class));
            domain.setLevelScalingDeltaMax(row.get("LevelScalingDeltaMax", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureTemplateScaling, OutboundRow> {

        public OutboundRow convert(CreatureTemplateScaling source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("Entry", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getLevelScalingMin()).ifPresent(e -> row.put("LevelScalingMin", Parameter.from(e)));
            Optional.ofNullable(source.getLevelScalingMax()).ifPresent(e -> row.put("LevelScalingMax", Parameter.from(e)));
            Optional.ofNullable(source.getLevelScalingDeltaMin()).ifPresent(e -> row.put("LevelScalingDeltaMin", Parameter.from(e)));
            Optional.ofNullable(source.getLevelScalingDeltaMax()).ifPresent(e -> row.put("LevelScalingDeltaMax", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
