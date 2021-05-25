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
@Table("sound_kit")
public class SoundKit {

    @Column("ID")
    private Integer id;
    @Column("SoundType")
    private Integer soundType;
    @Column("VolumeFloat")
    private Double volumeFloat;
    @Column("Flags")
    private Integer flags;
    @Column("MinDistance")
    private Double minDistance;
    @Column("DistanceCutoff")
    private Double distanceCutoff;
    @Column("EAXDef")
    private Integer eaxDef;
    @Column("SoundKitAdvancedID")
    private Integer soundKitAdvancedId;
    @Column("VolumeVariationPlus")
    private Double volumeVariationPlus;
    @Column("VolumeVariationMinus")
    private Double volumeVariationMinus;
    @Column("PitchVariationPlus")
    private Double pitchVariationPlus;
    @Column("PitchVariationMinus")
    private Double pitchVariationMinus;
    @Column("DialogType")
    private Integer dialogType;
    @Column("PitchAdjust")
    private Double pitchAdjust;
    @Column("BusOverwriteID")
    private Integer busOverwriteId;
    @Column("MaxInstances")
    private Integer maxInstances;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SoundKit> {

        public SoundKit convert(Row row) {
            SoundKit domain = new SoundKit();
            domain.setId(row.get("ID", Integer.class));
            domain.setSoundType(row.get("SoundType", Integer.class));
            domain.setVolumeFloat(row.get("VolumeFloat", Double.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setMinDistance(row.get("MinDistance", Double.class));
            domain.setDistanceCutoff(row.get("DistanceCutoff", Double.class));
            domain.setEaxDef(row.get("EAXDef", Integer.class));
            domain.setSoundKitAdvancedId(row.get("SoundKitAdvancedID", Integer.class));
            domain.setVolumeVariationPlus(row.get("VolumeVariationPlus", Double.class));
            domain.setVolumeVariationMinus(row.get("VolumeVariationMinus", Double.class));
            domain.setPitchVariationPlus(row.get("PitchVariationPlus", Double.class));
            domain.setPitchVariationMinus(row.get("PitchVariationMinus", Double.class));
            domain.setDialogType(row.get("DialogType", Integer.class));
            domain.setPitchAdjust(row.get("PitchAdjust", Double.class));
            domain.setBusOverwriteId(row.get("BusOverwriteID", Integer.class));
            domain.setMaxInstances(row.get("MaxInstances", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SoundKit, OutboundRow> {

        public OutboundRow convert(SoundKit source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSoundType()).ifPresent(e -> row.put("SoundType", Parameter.from(e)));
            Optional.ofNullable(source.getVolumeFloat()).ifPresent(e -> row.put("VolumeFloat", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getMinDistance()).ifPresent(e -> row.put("MinDistance", Parameter.from(e)));
            Optional.ofNullable(source.getDistanceCutoff()).ifPresent(e -> row.put("DistanceCutoff", Parameter.from(e)));
            Optional.ofNullable(source.getEaxDef()).ifPresent(e -> row.put("EAXDef", Parameter.from(e)));
            Optional.ofNullable(source.getSoundKitAdvancedId()).ifPresent(e -> row.put("SoundKitAdvancedID", Parameter.from(e)));
            Optional.ofNullable(source.getVolumeVariationPlus()).ifPresent(e -> row.put("VolumeVariationPlus", Parameter.from(e)));
            Optional.ofNullable(source.getVolumeVariationMinus()).ifPresent(e -> row.put("VolumeVariationMinus", Parameter.from(e)));
            Optional.ofNullable(source.getPitchVariationPlus()).ifPresent(e -> row.put("PitchVariationPlus", Parameter.from(e)));
            Optional.ofNullable(source.getPitchVariationMinus()).ifPresent(e -> row.put("PitchVariationMinus", Parameter.from(e)));
            Optional.ofNullable(source.getDialogType()).ifPresent(e -> row.put("DialogType", Parameter.from(e)));
            Optional.ofNullable(source.getPitchAdjust()).ifPresent(e -> row.put("PitchAdjust", Parameter.from(e)));
            Optional.ofNullable(source.getBusOverwriteId()).ifPresent(e -> row.put("BusOverwriteID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxInstances()).ifPresent(e -> row.put("MaxInstances", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
